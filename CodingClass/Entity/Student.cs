namespace CodingClass.Entity;

public class Student
{
    public int Id { get; set; }
    public string? Name;
    public string? Email;
    public string Phone;
    public ICollection<StudentCourse> StudentCourse { get; set; }
}
