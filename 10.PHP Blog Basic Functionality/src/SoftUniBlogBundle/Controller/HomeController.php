<?php

namespace SoftUniBlogBundle\Controller;

use SoftUniBlogBundle\Entity\Article;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class HomeController extends Controller
{
    /**
     * @Route("/", name="blog_index")
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function index()
    {
        $repository = $this
            ->getDoctrine()
            ->getRepository(Article::class);
        $articles = $repository->findAll();
        return $this->render('home/index.html.twig',
            [
                "articles" => $articles
            ]);
    }
}
