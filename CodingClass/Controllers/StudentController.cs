using CodingClass.Data;
using CodingClass.Entity;

using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace CodingClass.Controllers;

[Route("api/[controller]")]
[ApiController]
public class StudentController : ControllerBase
{
    private readonly ApplicationContext _context;
    private readonly ILogger<StudentController> _logger;
    public StudentController(ApplicationContext context, ILogger<StudentController> logger)
    {
        _context = context;
        _logger = logger;
    }

    [HttpPost]
    public async Task<IActionResult> AddStudent([FromBody] Student student)
    {
        if (student == null)
        {
            return BadRequest("Student cannot be null");
        }
        if (string.IsNullOrWhiteSpace(student.Email))
        {
            // it's a demo if email is not provided
            return BadRequest("Student cannot be null");
        }
        // demo of try catch, we can use try catch in other end point also
        try
        {
            _context.Students.Add(student);
            await _context.SaveChangesAsync();
            return CreatedAtAction(nameof(AddStudent), new { id = student.Id }, student);
        }
        catch (Exception ex)
        {
            _logger.LogError(ex, "Error occurred while adding a student.");
            return StatusCode(StatusCodes.Status500InternalServerError, "An error occurred while processing your request.");
        }
    }

    [HttpPost("{id}/courses")]
    public async Task<IActionResult> AssignCourse(int id, [FromBody] List<int> courseIds)
    {
        var student = await _context.Students.Include(s => s.StudentCourse).FirstOrDefaultAsync(s => s.Id == id);
        if (student == null)
        {
            return NotFound($"Student with ID {id} not found.");
        }

        foreach (var courseId in courseIds)
        {
            var course = await _context.Courses.FindAsync(courseId);
            if (course == null)
            {
                return NotFound($"Course with ID {courseId} not found");
            }
            student.StudentCourse.Add(new StudentCourse { StudentId = student.Id, CourseId = course.Id });
        }

        await _context.SaveChangesAsync();
        return Ok(student);
    }

    [HttpGet]
    public async Task<IActionResult> ListStudents()
    {
        var students = await _context.Students
            .Include(s => s.StudentCourse)
            .ThenInclude(sc => sc.Course)
            .Select(s => new
            {
                s.Name,
                s.Phone,
                s.Email,
                Courses = string.Join(",", s.StudentCourse.Select(sc => sc.Course.CourseName))
            })
            .ToListAsync();

        if (students == null || !students.Any())
        {
            return NotFound("No students found");
        }

        return Ok(students);
    }
}
