<?php

namespace SoftUniBlogBundle\Controller;

use SoftUniBlogBundle\Entity\User;
use SoftUniBlogBundle\Form\UserType;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;


class UserController extends Controller
{
    /**
     * @Route("/user/register", name="user_register")
     * @param Request $request
     * @return \Symfony\Component\HttpFoundation\Response
     */
    function register (Request $request)
    {
        $user = new User ();
        $form = $this->createForm(UserType::class, $user);
        $form->handleRequest($request);

        if($form->isSubmitted() && $form->isValid()){
            $password =$this->get('security.password_encoder')
                ->encodePassword($user, $user->getPassword());
            $user->setPassword($password);
            $entityManager = $this
                ->getDoctrine()
                ->getManager();
            $entityManager->persist($user);
            $entityManager->flush();

            return $this->redirectToRoute('security_login');
        }
        return $this->render('user/register.html.twig',
        [
            "form" => $form->createView()
        ]);
    }

    /**
     * @Route("/user/profile", name="user_profile")
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function showProfile()
    {
        $user = $this->getUser();

        return $this->render('user/profile.html.twig',
        [
            "user" => $user
        ]);
    }

}
