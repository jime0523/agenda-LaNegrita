/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agenda_web.controller;

/**
 *
 * @author Jime
 */

import agenda_web.model.Evento;
import agenda_web.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AgendaController {
    
    @Autowired
    private EventoRepository eventoRepository;

    @GetMapping("/")
    public String verAgenda(Model model) {
        model.addAttribute("eventos", eventoRepository.findAll());
        model.addAttribute("evento", new Evento());
        return "index";
    }

    @PostMapping("/guardar")
    public String guardarEvento(@ModelAttribute Evento evento) {
        eventoRepository.save(evento);
        return "redirect:/";
    }
}
