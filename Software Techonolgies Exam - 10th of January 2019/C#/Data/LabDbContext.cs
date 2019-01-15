using Microsoft.EntityFrameworkCore;
using SoftUniLabs.Models;

namespace SoftUniLabs.Data
{
    public class LabDbContext : DbContext
    {
        public LabDbContext()
        {
            this.Database.EnsureCreated();
        }

        public DbSet<Lab> Labs { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
                optionsBuilder.UseMySQL("server=localhost;database=softuni_labs_csharp;user=root;Sslmode=none");
            }
        }
    }
}
