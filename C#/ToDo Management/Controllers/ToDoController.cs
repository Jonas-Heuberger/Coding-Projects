using Microsoft.AspNetCore.Mvc;

namespace ToDo_Management.Controllers
{
    public class ToDoController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
    }
}
