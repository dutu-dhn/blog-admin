package com.dutu.admin.controller;

import com.dutu.admin.bean.Blable;
import com.dutu.admin.service.BlableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author dutu
 * @date 2021-04-25 20:57
 */
@Controller
public class BlableController {
    @Autowired
    BlableService blableService;

    @GetMapping("/blableList")
    public String toBlableList(Model model){
        List<Blable> list = blableService.list();
        model.addAttribute("blables",list);
        return "blable";
    }

    @ResponseBody
    @GetMapping("/blable/delete/{blid}")
    public String deleteBlable(@PathVariable("blid") Long blid,
                             RedirectAttributes rd){
        blableService.removeById(blid);
        return "success";
    }

    @ResponseBody
    @PostMapping("/blable/addorupd")
    public String addBlable(Blable blable){
        if (blable.getBlname().trim().isEmpty()){
            return "failed";
        }

        boolean saveorupd = blableService.saveOrUpdate(blable);
        if(saveorupd) {return "success";}
        return "failed";
    }


    @GetMapping("/addBlable")
    public String toaddBlablet(Model model){


        return "addBlable";
    }

}
