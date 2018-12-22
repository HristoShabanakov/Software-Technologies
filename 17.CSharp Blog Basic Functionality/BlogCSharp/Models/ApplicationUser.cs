using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using Microsoft.AspNetCore.Identity;

namespace BlogCSharp.Models
{
    // Add profile data for application users by adding properties to the ApplicationUser class
    public class ApplicationUser : IdentityUser
    {
        [Required]
        [MinLength(5),MaxLength(100)]
        public string FullName { get; set; }

        public List<Article> Articles { get; set; }
    }
}
