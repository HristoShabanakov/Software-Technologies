using Microsoft.AspNetCore.Mvc;

namespace BlogCSharp.Controllers
{
    public class HomeController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }

    }
}
