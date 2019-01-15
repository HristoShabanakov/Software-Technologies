using System.Collections.Generic;
using System.Linq;
using Microsoft.AspNetCore.Mvc;
using SoftUniLabs.Data;
using SoftUniLabs.Models;

namespace SoftUniLabs.Controllers
{
    public class LabController : Controller
    {
        private readonly LabDbContext context;

        public LabController(LabDbContext context)
        {
            this.context = context;
        }

        [HttpGet]
        [Route("/")]
        public IActionResult Index()
        {
            List<Lab> labs = this.context.Labs.ToList();
            return View(labs);

        }

        [HttpGet]
        [Route("/create")]
        public IActionResult Create()
        {
            return View();
        }

        [HttpPost]
        [Route("/create")]
        public IActionResult Create(Lab lab)
        {
            this.context.Labs.Add(lab);
            this.context.SaveChanges();
            return RedirectToAction(nameof(Index));
        }

        [HttpGet]
        [Route("/edit/{id}")]
        public IActionResult Edit(int id)
        {
            Lab lab = this.context.Labs.Find(id);
            return View(lab);
        }

        [HttpPost]
        [Route("/edit/{id}")]
        public IActionResult Edit(Lab lab)
        {
            this.context.Labs.Update(lab);
            this.context.SaveChanges();
            return RedirectToAction(nameof(Index));
        }

        [HttpGet]
        [Route("/delete/{id}")]
        public IActionResult Delete(int id)
        {
            Lab lab = context
            .Labs
            .FirstOrDefault(p => p.Id == id);
            return View(lab);

        }

        [HttpPost]
        [Route("/delete/{id}")]
        public IActionResult Delete(Lab lab)
        {
            this.context.Labs.Remove(lab);
            this.context.SaveChanges();
            return RedirectToAction(nameof(Index));
        }
    }
}
