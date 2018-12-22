using BlogCSharp.Data;
using BlogCSharp.Models;
using BlogCSharp.Models.ArticlesViewModels;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;
using System.Linq;

namespace BlogCSharp.Controllers
{
    public class ArticlesController : Controller
    {
        private readonly ApplicationDbContext dbContext;
        private readonly UserManager<ApplicationUser> userManager;



        public ArticlesController(ApplicationDbContext dbContext,
            UserManager<ApplicationUser> userManager)
        {
            this.dbContext = dbContext;
            this.userManager = userManager;
        }

        [HttpGet]
        public IActionResult Index()
        {
            List<ArticlesIndexViewModel> articles = this.dbContext
                .Articles
                .Select(a => new ArticlesIndexViewModel
                {
                    Id = a.Id,
                    Title = a.Title,
                    Summary = a.Summary,
                    AuthorFullName = a.Author.FullName
                })
                .ToList();

            return View(articles);
        }

        [HttpGet]
        [Authorize]
        public IActionResult Create()
        {
            return View();

        }

        [HttpPost]
        [Authorize]
        public IActionResult Create(Article article)
        {
            string userId = this.userManager.GetUserId(this.User);
            article.AuthorId = userId;

            if (ModelState.IsValid)
            {
                this.dbContext.Articles.Add(article);
                this.dbContext.SaveChanges();

                return RedirectToAction(nameof(Index));
            }

            return View(article);
        }

        [HttpGet]
        public IActionResult Details(int id)
        {
            Article article = this.dbContext
                .Articles
                .Include(a => a.Author)
                .FirstOrDefault(a => a.Id == id);

            if (article == null)
            {
                return NotFound();
            }

            return View(article);
        }

        [HttpGet]
        [Authorize]
        public IActionResult Edit(int id)
        {
            Article article = this.dbContext
                 .Articles
                 .Find(id);

            string currentUserId = this.userManager.GetUserId(this.User);

            if (article == null)
            {
                return NotFound();
            }

            if(article.AuthorId !=currentUserId)
            {
                return Forbid();
            }

            return View(article);
        }

        [HttpPost]
        [Authorize]
        [Route("/articles/edit/{id}")]
        public IActionResult Edit(Article article)
        {
            string currentUserId = this.userManager.GetUserId(this.User);

            if (article.AuthorId != currentUserId)
            {
                return Forbid();
            }


            if (ModelState.IsValid)
            {
                this.dbContext.Articles.Update(article);
                this.dbContext.SaveChanges();

                return RedirectToAction("Index");
            }

            return View(article);
           
        }

        [HttpGet]
        [Authorize]
        public IActionResult Delete(int id)
        {
            Article article = this.dbContext
                 .Articles
                 .Find(id);

            if (article == null)
            {
                return NotFound();
            }

            string currentUserId = this.userManager.GetUserId(this.User);

            if (article.AuthorId != currentUserId)
            {
                return Forbid();
            }


            return View(article);
        }

        [HttpPost]
        [Authorize]
        public IActionResult Delete(Article article)
        {
            bool isArticleExisting = this.dbContext
                .Articles
                .Any(a => a.Id == article.Id);

            if(!isArticleExisting)
            {
                return NotFound();
            }

            string currentUserId = this.userManager.GetUserId(this.User);

            if (article.AuthorId != currentUserId)
            {
                return Forbid();
            }

            this.dbContext.Articles.Remove(article);
            this.dbContext.SaveChanges();

            return RedirectToAction("Index");
        }
    }
}