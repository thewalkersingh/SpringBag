using System.ComponentModel.DataAnnotations;

namespace CodingClass.Entity
{
    public class Course
    {
        public int Id { get; set; }
        [Required]
        public string CourseName { get; set; }
        public ICollection<StudentCourse> StudentCourse { get; set; }
    }
}
