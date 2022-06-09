using Microsoft.EntityFrameworkCore;
using test.Models;


namespace test.Helpers
{
    public class DbApiContext : DbContext
    {
        public DbApiContext()
        {
        }
        public DbApiContext(DbContextOptions<DbApiContext> options)
        : base(options)
        {
        }

        public virtual DbSet<Schueler> Schueler { get; set; }
     }
   }

