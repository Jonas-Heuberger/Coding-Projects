using Microsoft.AspNetCore.OData.Routing.Controllers;
using test.Helpers;
using test.Models;

namespace test.Controllers
   
{
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

        public SingleResult<Schueler> Get([FromODataUri] Guid key)
        {
            var result = _dbApiContext.Schueler.Where(s => s.rowguid == key);
            return SingleResult.Create(result);
        }
}
}