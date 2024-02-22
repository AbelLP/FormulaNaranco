package org.pspr.entrega_formula.controller;

import org.pspr.entrega_formula.dto.PilotoDTO;
import org.pspr.entrega_formula.model.Circuitos;
import org.pspr.entrega_formula.model.Equipo;
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
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Controller
public class ResultadoController {

    @Autowired
    private ResultadoService resultadoService;

    @Autowired
    private PilotoController pilotosController;

    @Autowired
    private PilotosService pilotosService;


    @GetMapping("/resultados")
    private String getResultados(Model model){
        List<Resultado> resultados=resultadoService.findAllResultados();
        model.addAttribute("resultados", resultados);
        return "resultados/resultados";
    }

    @GetMapping( "/resultados/buscar")
    public String buscar(@RequestParam String cadena, Model model){
        List<Resultado> filtrado=resultadoService.findResultadoByCadena(cadena);
        model.addAttribute("resultados", filtrado);
        return "resultados/resultados";
    }

    @GetMapping("/resultado/pilotos")
    public String clasificarByPilotos(Model model){
        List<Piloto> pi=pilotosService.findAllPilotos();
        PilotoDTO pilotoDTO=pilotosService.findPilotoByVictorias();
        List<Piloto> pilotos=new ArrayList<>();
        List<String> re=new ArrayList<>();
        Iterator<Piloto> it=pi.iterator();
        while (it.hasNext()){
            Piloto p=it.next();
            if(!re.contains(p.getNombre())){
                List<Resultado> resultados=resultadoService.findResultadoByNombre(p.getNombre());
                Iterator<Resultado> res= resultados.iterator();
                while(res.hasNext()){
                    Resultado r=res.next();
                    p.setPuntos(p.getPuntos()+pilotosController.obtenerPuntos(r.getPosicionLlegada()));
                }
                re.add(p.getNombre());
            }
            pilotos.add(p);
        }
        Collections.sort(pilotos);
        model.addAttribute("pilotos", pilotos);
        model.addAttribute("pilotoDTO", pilotoDTO);
        return "resultados/clasificacionPilotos";
    }

    @GetMapping("/resultado/equipos")
    public String clasificarByEquipos(Model model){
        List<Resultado> resultados=resultadoService.findAllResultados();
        List<Equipo> equipos=new ArrayList<>();
        List<String> re=new ArrayList<>();
        Iterator<Resultado> it=resultados.iterator();
        while(it.hasNext()){
            Resultado r=it.next();
            String nombre=r.getPiloto().getEquipo();
            if(!re.contains(nombre)){
                Equipo equipo=new Equipo(nombre, 0);
                equipo.setPuntos(equipo.getPuntos()+equipo.addPuntos(r.getPosicionLlegada()));
                equipos.add(equipo);
                re.add(nombre);
            }else{
                int i=re.indexOf(nombre);
                Equipo equipo=equipos.get(i);
                equipo.setPuntos(equipo.getPuntos()+equipo.addPuntos(r.getPosicionLlegada()));
            }
        }
        Collections.sort(equipos);
        model.addAttribute("equipos", equipos);
        return "resultados/clasificacionEquipos";
    }




}
