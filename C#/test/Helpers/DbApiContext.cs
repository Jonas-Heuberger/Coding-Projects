using Microsoft.EntityFrameworkCore;

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
     }
   }

