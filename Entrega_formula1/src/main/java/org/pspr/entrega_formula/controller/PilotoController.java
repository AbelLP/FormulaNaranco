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

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Controller
public class PilotoController /*implements Comparator<Piloto>*/ {

    @Autowired
    private PilotosService pilotosService;

    @GetMapping("/")
    public String getPilotosAleatorios(Model model){
        List<Piloto> pilotos=pilotosService.pilotosAleatorios();
        model.addAttribute("pilotos", pilotos);
        return "index";
    }

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

    public int obtenerPuntos(int posicion){
        int puntos=0;
        switch (posicion){
            case 1->puntos=25;
            case 2->puntos=18;
            case 3->puntos=15;
            case 4->puntos=12;
            case 5->puntos=10;
            case 6->puntos=8;
            case 7->puntos=6;
            case 8->puntos=4;
            case 9->puntos=2;
            case 10->puntos=1;
        }
        return puntos;
    }





}
