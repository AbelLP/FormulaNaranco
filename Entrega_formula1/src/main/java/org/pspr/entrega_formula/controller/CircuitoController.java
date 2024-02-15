package org.pspr.entrega_formula.controller;

import org.pspr.entrega_formula.model.Circuitos;
import org.pspr.entrega_formula.service.CircuitosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class CircuitoController {

    @Autowired
    private CircuitosService circuitosService;

    @GetMapping("/circuito")
    public String getCircuitos(Model model){
        List<Circuitos> circuitos=circuitosService.findAllCircuitos();
        model.addAttribute("circuitos",circuitos);
        return "circuito/circuitos";
    }

    @GetMapping("/circuito/{id}")
    public String getCircuitosById(@PathVariable Long id, Model model){
        Optional<Circuitos> circuito=circuitosService.findCircuitoById(id);
        if(circuito.isPresent()){
            model.addAttribute("circuito",circuito.get());
        }else{
            model.addAttribute("msg","Sin circuitos con ese id");
        }
        return "circuito/circuito";
    }

    @GetMapping("/circuito/add")
    public String addCircuito(Model model){
        Circuitos circuito=new Circuitos();
        model.addAttribute("circuito",circuito);
        model.addAttribute("nuevo", true);
        return "circuito/circuitoForm";
    }

    @PostMapping("/circuito/save")
    public String saveCircuito(@ModelAttribute(value = "circuito") Circuitos circuito){
        circuitosService.saveCircuito(circuito);
        return "redirect:/circuito";
    }

    @GetMapping("/circuito/update/{id}")
    public String updateCircuito(@PathVariable Long id, Model model){
        Optional<Circuitos> circuito=circuitosService.findCircuitoById(id);
        if(circuito.isPresent()){
            model.addAttribute("circuito", circuito.get());
            model.addAttribute("nuevo", false);
            return "circuito/circuitoForm";
        }else{
            return "redirect:/circuito";
        }
    }

    @GetMapping("/circuito/delete/{id}")
    public String deleteCircuito(@PathVariable Long id){
        circuitosService.deleteCircuito(id);
        return "redirect:/circuito";
    }




}
