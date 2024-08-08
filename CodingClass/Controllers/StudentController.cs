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

    public StudentController(ApplicationContext context)
    {
        _context = context;
    }

    [HttpPost]
    public async Task<IActionResult> AddStudent([FromBody] Student student)
    {
        if (student == null)
        {
            return BadRequest("Student cannot be null");
        }

        _context.Students.Add(student);
        await _context.SaveChangesAsync();

        // Return 201 Created status code with the student object
        return CreatedAtAction(nameof(AddStudent), new { id = student.Id }, student);
    }

    [HttpPost("{id}/courses")]
    public async Task<IActionResult> AssignCourse(int id, [FromBody] List<int> courseIds)
    {
        var student = await _context.Students.Include(s => s.StudentCourse).FirstOrDefaultAsync(s => s.Id == id);
        if (student == null)
        {
            return NotFound("Student not found");
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
