using Microsoft.EntityFrameworkCore;

namespace ToDoList.Models
{
    public class TaskDbContext : DbContext
    {
        public DbSet<Task> Tasks { get; set;}

        public TaskDbContext()
        {
            this.Database.EnsureCreated();
        }
        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseMySQL("server=localhost;database=todo;user=root;");
        }
    }
}
