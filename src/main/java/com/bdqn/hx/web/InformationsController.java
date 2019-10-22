package com.bdqn.hx.web;

import com.bdqn.hx.pojo.Informations;
import com.bdqn.hx.service.InformationsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("info")
public class InformationsController {

    @Resource
    InformationsService informationsService;

    @GetMapping("queryAll")
    public ResponseEntity<List<Informations>> queryAll(){
        List<Informations> list = informationsService.queryAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}.html")
    public String queryInformations(@PathVariable("id") Long id, Model model){
        Informations informations = informationsService.queryInformationsById(id);
        model.addAttribute("informations",informations);
        System.out.println("informations = " + informations);
        return "reply";
    }



}
