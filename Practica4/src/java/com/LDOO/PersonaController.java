/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LDOO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

@Controller
public class PersonaController {
    @RequestMapping(value = "/persona", method = RequestMethod.GET)
   public ModelAndView persona() {
      return new ModelAndView("persona", "command", new Persona());
   }
   
   @RequestMapping(value = "/addPersona", method = RequestMethod.POST)
   public String addPersona(@ModelAttribute("SpringWeb")Persona persona, 
   ModelMap model) {
      model.addAttribute("email", persona.getEmail());
      model.addAttribute("date", persona.getDate());
      model.addAttribute("name", persona.getName());
      model.addAttribute("password", persona.getPassword());
      
      return "result";
   }
   
   @RequestMapping("/persona")
   public ModelAndView irPersona(){
       return new ModelAndView("persona","command", new Persona());
    } 
  
    @RequestMapping(value = "/addPersona", method = RequestMethod.POST)
    public String agregar(Persona per,ModelMap model){
        model.addAttribute("name", per.getName());
        model.addAttribute("email", per.getEmail());
        model.addAttribute("password", per.getPassword());
        model.addAttribute("date", per.getDate());
        return "result";
    }
   
}
