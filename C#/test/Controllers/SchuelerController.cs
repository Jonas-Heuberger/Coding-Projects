using Microsoft.AspNetCore.OData.Routing.Controllers;
using test.Helpers;
using test.Models;

namespace test.Controllers
   
{
    [Authorize()]
     [EnableQuery(Pagesize = 10)]
    public class SchuelerController : ODataController
    {
        private DbApiContext _dbApiContext;

        public SchuelerController(DbApiContext dbApiContext)
        {
            _dbApiContext = dbApiContext;
        }

        public IQueryable<Schueler> Get(){
            return _dbApiContext.Schueler.AsQueryable();
        }

        // post = create, patch = update (edit), delete = delete, get = read
        public SingleResult<Schueler> Get([FromODataUri] Guid key)
        {
            var result = _dbApiContext.Schueler.Where(s => s.rowguid == key);
            return SingleResult.Create(result);
        }

        // public async Task<IActionResult> Delete([FromODataUri] Guid key)
        // {
        //   var schueler = await _dbApiContext.Schueler.FindAsync(key);
        //   if (schueler == null)
        //   {
        //     return NotFound();
        //   }
        //   var sql = "exec dbo.usp_DeleteSchueler";

        //   var result = _dbApiContext.Database.ExecuteSqlRaw(sql);

        //   return Ok(result);
        // }
}
}