package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MascotaController {

    // Instanciamos la mascota aquí (en una app real usaríamos una Base de Datos)
    private Mascota miMascota = new Mascota("Pixel");

    @GetMapping("/")
    public String verMascota(Model model) {
        // Pasamos el objeto Java a la vista (HTML)
        model.addAttribute("mascota", miMascota);
        return "index"; // Buscará index.html
    }

    @PostMapping("/accion")
    public String realizarAccion(@RequestParam String tipo) {
        if (tipo.equals("alimentar")) {
            miMascota.alimentar();
        } else if (tipo.equals("jugar")) {
            miMascota.jugar();
        }
        return "redirect:/"; // Recarga la página para ver cambios
    }
}