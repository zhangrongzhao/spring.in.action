package com.spittr.web;

import com.spittr.data.SpittleRepository;
import com.spittr.model.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private static final String MAX_LONG_AS_STRING = Long.toString(Long.MAX_VALUE);
    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository){
        this.spittleRepository=spittleRepository;
    }

    @RequestMapping(value="/index",method = RequestMethod.GET)
    public String spittles(Model model){
        model.addAttribute("spittleList",spittleRepository.findSpittles(Long.MAX_VALUE,20));
        return "spittles";
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(@RequestParam(value="max",defaultValue = "9999") long max,
                                  @RequestParam(value="count",defaultValue = "20") int count){
        return spittleRepository.findSpittles(max,count);
    }


    @RequestMapping(value="/show",method=RequestMethod.GET)
    public String showSpittle(@RequestParam("spittle_id") long spittleId,Model model){
        model.addAttribute("spittle",spittleRepository.findOne(spittleId));
        return "spittle";
    }

    @RequestMapping(value="/{spittleId}",method=RequestMethod.GET)
    public String spittle(@PathVariable("spittleId")long spittleId,Model model){
        model.addAttribute("spittle",spittleRepository.findOne(spittleId));
        return "spittle";
    }
}
