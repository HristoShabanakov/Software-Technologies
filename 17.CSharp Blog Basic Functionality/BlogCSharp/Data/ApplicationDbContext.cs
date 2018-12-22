using Microsoft.AspNetCore.Identity.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore;
using BlogCSharp.Models;

namespace BlogCSharp.Data
{
    public class ApplicationDbContext : IdentityDbContext<ApplicationUser>
    {
        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options)
            : base(options)
        {
        }

        public DbSet<Article> Articles { get; set; }


        protected override void OnModelCreating(ModelBuilder builder)
        {
            builder
                 .Entity<Article>()
                 .HasOne(a => a.Author)
                 .WithMany(u => u.Articles)
                 .HasForeignKey(a => a.AuthorId);

            base.OnModelCreating(builder);
        }

    }
}
