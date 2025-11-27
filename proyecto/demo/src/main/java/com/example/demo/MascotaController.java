package com.example.demo; // ¡REVISA EL PAQUETE!

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MascotaController {

    private Mascota miMascota = new Mascota("Wally"); // Nuestra ballena

    @GetMapping("/")
    public String verMascota(Model model) {
        model.addAttribute("mascota", miMascota);
        return "index";
    }

    @PostMapping("/accion")
    public String realizarAccion(@RequestParam String tipo) {
        switch (tipo) {
            case "alimentar": miMascota.alimentar(); break;
            case "jugar":    miMascota.jugar(); break;
            case "dormir":   miMascota.dormir(); break;
            case "limpiar":  miMascota.limpiar(); break;
        }
        return "redirect:/";
    }
}