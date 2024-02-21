package org.pspr.entrega_formula.controller;

import org.pspr.entrega_formula.model.Circuitos;
import org.pspr.entrega_formula.model.Piloto;
import org.pspr.entrega_formula.model.Resultado;
import org.pspr.entrega_formula.service.CircuitosService;
import org.pspr.entrega_formula.service.PilotosService;
import org.pspr.entrega_formula.service.ResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class ResultadoController {

    @Autowired
    private ResultadoService resultadoService;

    @Autowired
    private PilotosService pilotosService;

    @Autowired
    private CircuitosService circuitosService;



    @GetMapping("/resultados")
    private String getResultados(Model model){
        List<Resultado> resultados=resultadoService.findAllResultados();
        model.addAttribute("resultados", resultados);
        return "resultados/resultados";
    }

    @GetMapping("/resultados/buscar")
    public String buscar(@RequestParam String cadena, Model model){
        List<Resultado> resultados=resultadoService.findAllResultados();
        List<Resultado> filtrado=new ArrayList<>();
        Resultado resultado;
        Iterator<Resultado> it=resultados.iterator();
        while (it.hasNext()){
            Resultado r=it.next();
            if(r.getPiloto().getNombre().equalsIgnoreCase(cadena)||r.getCircuitos().getNombre().equalsIgnoreCase(cadena)||r.getPiloto().getEquipo().equalsIgnoreCase(cadena)){
                resultado=r;
                filtrado.add(resultado);
                model.addAttribute("cadena", filtrado);
            }
        }
        return "resultados/resultados";
    }

    @GetMapping("/resultado/pilotos")
    public String clasificarByPilotos(Model model){
        return "resultados/clasificacionPilotos";
    }


}
