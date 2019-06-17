package com.spittr.web;


import com.spittr.data.SpitterRepository;
import com.spittr.model.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/spitter")
public class SpitterController  {

    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository){
        this.spitterRepository=spitterRepository;
    }

    @RequestMapping(value="/register",method= RequestMethod.GET)
    public String showRegistrationForm(Model model){
        model.addAttribute(new Spitter());
        return "registerForm";
    }

    @RequestMapping(value="/register",method=RequestMethod.POST)
    public String processRegistration(@Valid Spitter spitter, Errors erros){
        if(erros.hasErrors()){
            return "registerForm";
        }
        spitterRepository.save(spitter);
        return "redirect:/spitter/"+spitter.getUserName();
    }

    @RequestMapping(value="{userName}",method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable("userName")String username, Model model){
        Spitter spitter=spitterRepository.findByUserName(username);
        model.addAttribute("spitter",spitter);
        return "profile";
    }
}
