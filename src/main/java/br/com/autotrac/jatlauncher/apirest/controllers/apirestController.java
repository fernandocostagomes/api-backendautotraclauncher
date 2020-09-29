package br.com.autotrac.jatlauncher.apirest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping( "/" )
public class apirestController
{
   @RequestMapping( method = RequestMethod.GET )
   ModelAndView
      index()
   {
      ModelAndView mav = new ModelAndView( "index" );
      mav.addObject( "version", "0.1" );
      return mav;
   }

}
