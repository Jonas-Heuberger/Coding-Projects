using Microsoft.AspNetCore.Identity.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore;
using ToDoManagement.Models;

namespace ToDo_Management.Data
{
    public class ApplicationDbContext : IdentityDbContext
    {

        public DbSet<ToDo> ToDos { get; set; }
        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options)
            : base(options)
        {
        }
    }
}