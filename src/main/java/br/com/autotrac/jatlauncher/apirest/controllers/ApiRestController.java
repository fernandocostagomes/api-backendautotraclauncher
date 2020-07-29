package br.com.autotrac.jatlauncher.apirest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApiRestController
{
   @RequestMapping( "/" )
   public String restApi( Model model )
   {
      model.addAttribute( "mensagem", "Olá Spring Boot com Thymeleaf" );
      return "index";

   }

}
