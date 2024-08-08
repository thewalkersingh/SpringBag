using System;

using CodingClass.Entity;

using Microsoft.EntityFrameworkCore;

namespace CodingClass.Data
{
    public class ApplicationContext : DbContext
    {
        public DbSet<Student> Students { get; set; }
        public DbSet<Course> Courses { get; set; }
        public DbSet<StudentCourse> StudentCourses { get; set; }
        public ApplicationContext(DbContextOptions<ApplicationContext> options) : base(options) { }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<StudentCourse>()
                .HasKey(sc => new { sc.StudentId, sc.CourseId });

            modelBuilder.Entity<StudentCourse>()
                .HasOne(sc => sc.Student)
                .WithMany(s => s.StudentCourse)
                .HasForeignKey(sc => sc.StudentId);

            modelBuilder.Entity<StudentCourse>()
                .HasOne(sc => sc.Course)
                .WithMany(c => c.StudentCourse)
                .HasForeignKey(sc => sc.CourseId);

            modelBuilder.Entity<Course>().HasData(
                new Course { Id = 1, CourseName = "Math" },
                new Course { Id = 2, CourseName = "Science" }
            );

            modelBuilder.Entity<Student>().HasData(
                new Student { Id = 1, Name = "John", Email = "john@gmail.com", Phone = "123" },
                new Student { Id = 2, Name = "Jane", Email = "jane@gmail.com", Phone = "456" }
            );

            modelBuilder.Entity<StudentCourse>().HasData(
                new StudentCourse { StudentId = 1, CourseId = 1 },
                new StudentCourse { StudentId = 1, CourseId = 2 },
                new StudentCourse { StudentId = 2, CourseId = 2 }
            );

        }
    }
}
