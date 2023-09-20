package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.ServiceSorteador;

import org.springframework.ui.Model;

@Controller
public class ControllerSorteador {

    @GetMapping("/")
    public String pagInicial() {
        return "index";
    }

    @GetMapping("/result")
    public String getResultPage(){
        return "result";
    }

    @PostMapping("/result")
    public String drawNumbers(@RequestParam("quantidade") int quantidade,
                              @RequestParam("numeroMinimo") int min,
                              @RequestParam("numeroMaximo") int max,
                              @RequestParam("cbordenar") boolean cbordenar,
                              @RequestParam("cbrepetir") boolean cbrepetir,
                              Model model){


        model.addAttribute("qtdSorteada", quantidade);
        model.addAttribute("numerosSorteados", ServiceSorteador.geraNumeros(min, max, quantidade, cbordenar, cbrepetir));
        model.addAttribute("numeroMinimo", min);
        model.addAttribute("numeroMaximo", max);

        return "result";
    }
}
