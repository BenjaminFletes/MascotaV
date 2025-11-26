package com.example.demo;

public class Mascota {
    private String nombre;
    // Stats: 100 es lo mejor, 0 es lo peor.
    private int hambre;    // 100 = lleno
    private int felicidad; // 100 = feliz
    private int energia;   // 100 = descansado
    private int higiene;   // 100 = limpio
    private boolean viva;

    public Mascota(String nombre) {
        this.nombre = nombre;
        this.hambre = 80;
        this.felicidad = 80;
        this.energia = 80;
        this.higiene = 80;
        this.viva = true;
    }

    // --- ACCIONES ---
    public void alimentar() {
        if (!viva) return;
        this.hambre = Math.min(100, this.hambre + 20);
        this.higiene = Math.max(0, this.higiene - 5); // Comer ensucia un poco
    }

    public void jugar() {
        if (!viva) return;
        this.felicidad = Math.min(100, this.felicidad + 20);
        this.energia = Math.max(0, this.energia - 15); // Jugar cansa
        this.higiene = Math.max(0, this.higiene - 10); // Jugar ensucia
        this.hambre = Math.max(0, this.hambre - 10); // Jugar da hambre
    }

    public void dormir() {
        if (!viva) return;
        this.energia = 100; // Recarga total
        this.hambre = Math.max(0, this.hambre - 20); // Despierta con hambre
    }

    public void limpiar() {
        if (!viva) return;
        this.higiene = 100; // Baño completo
        this.felicidad = Math.max(0, this.felicidad - 10); // No le gusta bañarse
    }

    // --- LÓGICA VISUAL ---
    // Este método decide qué nombre de imagen devolver basado en los stats
    public String getImagenEstado() {
        if (hambre <= 0 || felicidad <= 0 || energia <= 0) {
            this.viva = false;
            return "ballena-muerta.png";
        }
        if (higiene < 40) return "ballena-sucia.png"; // La suciedad es prioridad visual
        if (hambre < 40) return "ballena-hambrienta.png";
        if (energia < 40) return "ballena-cansada.png";
        if (felicidad > 90 && hambre > 90) return "ballena-feliz.png";
        
        return "ballena-normal.png"; // Estado por defecto
    }

    // --- GETTERS ---
    public String getNombre() { return nombre; }
    public int getHambre() { return hambre; }
    public int getFelicidad() { return felicidad; }
    public int getEnergia() { return energia; }
    public int getHigiene() { return higiene; }
    public boolean isViva() { return viva; }
}