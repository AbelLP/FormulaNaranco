package org.pspr.entrega_formula.controller;

import org.pspr.entrega_formula.model.Piloto;
import org.pspr.entrega_formula.service.PilotosService;
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
public class PilotoController {

    @Autowired
    private PilotosService pilotosService;

    @GetMapping("/piloto")
    public String getPilotos(Model model){
        List<Piloto> pilotos=pilotosService.findAllPilotos();
        model.addAttribute("pilotos", pilotos);
        return "piloto/pilotos";
    }

    @GetMapping("/piloto/{id}")
    public String getPilotoById(@PathVariable Long id, Model model){
        Optional<Piloto> piloto=pilotosService.findPilotoById(id);
        if(piloto.isPresent()){
            model.addAttribute("piloto", piloto.get());
        }else{
            model.addAttribute("msg", "Sin pilotos con ese id");
        }
        return "piloto/piloto";
    }

    @GetMapping("/piloto/add")
    public String addPiloto(Model model){
        Piloto piloto=new Piloto();
        model.addAttribute("piloto", piloto);
        model.addAttribute("nuevo",true);
        return "piloto/pilotoForm";
    }

    @PostMapping("/piloto/save")
    public String savePiloto(@ModelAttribute(value="piloto") Piloto piloto){
        pilotosService.savePiloto(piloto);
        return "redirect:/piloto";
    }

    @GetMapping("/piloto/update/{id}")
    public String updatePiloto(@PathVariable Long id, Model model){
        Optional<Piloto> piloto=pilotosService.findPilotoById(id);
        if(piloto.isPresent()){
            model.addAttribute("piloto", piloto.get());
            model.addAttribute("nuevo", false);
            return "piloto/pilotoForm";
        }else{
            return "redirect:/piloto";
        }
    }

    @GetMapping("piloto/delete/{id}")
    public String deletePiloto(@PathVariable Long id){
        pilotosService.deletePilto(id);
        return "redirect:/piloto";
    }


}
