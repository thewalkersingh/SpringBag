namespace CodingClass.Entity
{
    public class Course
    {
        public int Id { get; set; }
        public string CourseName { get; set; }
        public ICollection<StudentCourse> StudentCourse { get; set; }
    }
}
