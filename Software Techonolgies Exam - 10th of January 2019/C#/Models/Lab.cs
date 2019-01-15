using System.ComponentModel.DataAnnotations;

namespace SoftUniLabs.Models
{
    public class Lab
    {
        [Key]
        public int Id { get; set; }

        [Required]
        public string Name { get; set; }

        [Required]
        public int Capacity { get; set; }

        [Required]
        public string Status { get; set; }
    }
}
