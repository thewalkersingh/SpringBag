using System.ComponentModel.DataAnnotations;

namespace CodingClass.Entity;

public class Student
{
    public int Id { get; set; }
    [Required]
    public string? Name;
    [Required]
    public string? Email;
    public string Phone;
    public ICollection<StudentCourse> StudentCourse { get; set; }
}
