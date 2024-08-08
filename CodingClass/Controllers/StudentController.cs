using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;

using CodingClass.Data;
using CodingClass.Entity;

using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Identity.UI.V4.Pages.Account.Internal;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Microsoft.IdentityModel.Tokens;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace CodingClass.Controllers;

[Route("api/[controller]")]
[ApiController]
public class StudentController : ControllerBase
{
    public readonly ApplicationContext _context;
    public StudentController(ApplicationContext context)
    {
        _context = context;
    }
    [HttpGet("api/student")]
    public async Task<IActionResult> AddStudent([FromBody] Student student)
    {
        _context.Students.Add(student);
        await _context.SaveChangesAsync();
        return Ok(student);
    }


    [HttpPost("api/students/{id}/courses")]
    public async Task<IActionResult> AssignCourse(int id, [FromBody] List<int> courseIds)
    {

        var student = await _context.Students.FindAsync(id);
        if (student == null)
            return NotFound();
        foreach (var courseId in courseIds)
        {
            var course = await _context.Courses.FindAsync(courseId);
            if (course == null)
                continue;
            student.StudentCourse.Add(new StudentCourse { StudentId = student.Id, CourseId = course.Id });
        }
        await _context.SaveChangesAsync();
        return Ok(student);
    }

    [HttpGet("api/students")]
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
                Course = string.Join(",", s.StudentCourse.Select(sc => sc.Course.CourseName))
            })
            .ToListAsync();
        return Ok(students);
    }
   

}

