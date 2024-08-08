namespace CodingClass.Entity
{
    public class Course
    {
        public int Id { get; set; }
        public string CourseName { get; }
        public ICollection<StudentCourse> StudentCourse { get; set; }
    }
}
