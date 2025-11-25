package com.example.demo;

public class Mascota {
    private String nombre;
    private int hambre;
    private int felicidad;
    
    public Mascota(String nombre) {
        this.nombre = nombre;
        this.hambre = 50;
        this.felicidad = 50;
    }

    // Lógica del juego
    public void alimentar() {
        this.hambre = Math.max(0, this.hambre - 20);
        this.felicidad = Math.min(100, this.felicidad + 5);
    }

    public void jugar() {
        this.hambre = Math.min(100, this.hambre + 10);
        this.felicidad = Math.min(100, this.felicidad + 20);
    }

    // Getters necesarios para que Thymeleaf lea los datos
    public String getNombre() { return nombre; }
    public int getHambre() { return hambre; }
    public int getFelicidad() { return felicidad; }
}