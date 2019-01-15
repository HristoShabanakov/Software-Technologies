<?php

namespace AppBundle\Controller;

use AppBundle\Entity\Lab;
use AppBundle\Form\LabType;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\Routing\Annotation\Route;

class LabController extends Controller
{
    /**
     * @Route("/", name="index")
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function index()
    {
        $labs = $this->getDoctrine()->getRepository(Lab::class)->findAll();
        return $this->render("lab/index.html.twig",
            ['labs' => $labs]);
    }

    /**
     * @param Request $request
     * @Route("/create", name="create")
     * @return \Symfony\Component\HttpFoundation\RedirectResponse|\Symfony\Component\HttpFoundation\Response
     */
    public function create(Request $request)
    {
       $lab = new Lab();
        $form =$this->createForm(LabType::class,$lab);
        $form->handleRequest($request);

        if($form->isSubmitted()){
            $em = $this->getDoctrine()->getManager();
            $em->persist($lab);
            $em->flush();

    }
        return $this->render("lab/create.html.twig", array('form'=>$form->createView()));

    }

    /**
     * @Route("/edit/{id}", name="edit")
     * @param $id
     * @param Request $request
     * @return \Symfony\Component\HttpFoundation\RedirectResponse|\Symfony\Component\HttpFoundation\Response
     */
    public function edit($id, Request $request)
    {
        $lab = $this->getDoctrine()->getRepository(Lab::class)->find($id);
        $form =$this->createForm(LabType::class,$lab);
        $form->handleRequest($request);

        if($form->isSubmitted()){
            $em = $this->getDoctrine()->getManager();
            $em->merge($lab);
            $em->flush();
            return $this->redirect("/");
        }
        return $this->render("lab/edit.html.twig",
            ['form' =>$form->createView(),"lab" => $lab]);
    }

    /**
     * @Route("/delete/{id}", name="delete")
     *
     * @param $id
     * @param Request $request
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function delete($id, Request $request)
    {
        $lab = $this->getDoctrine()->getRepository(Lab::class)->find($id);
        $form =$this->createForm(LabType::class,$lab);
        $form->handleRequest($request);

        if($form->isSubmitted()){
            $em = $this->getDoctrine()->getManager();
            $em->remove($lab);
            $em->flush();

            return $this->redirect("/");
        }


        return $this->render("lab/delete.html.twig",
            ['form' =>$form->createView(),'lab' => $lab]);
    }
}
