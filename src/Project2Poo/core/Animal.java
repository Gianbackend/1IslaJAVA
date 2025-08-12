package Project2Poo.core;

import Project2Poo.config.Species;
import Project2Poo.world.Cell;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

public abstract class Animal implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    protected final Species species;
    protected double peso;
    protected int velocidadMaxima;
    protected double comidaNecesaria;

    protected transient Cell ubicacionActual;
    protected boolean estaVivo = true;
    public transient Random rand = new Random();

    protected Animal(Species species, Cell ubicacionActual) {
        this.species = species;
        this.peso = species.peso;
        this.velocidadMaxima = species.velocidadMaxima;
        this.comidaNecesaria = species.comidaNecesaria;
        this.ubicacionActual = ubicacionActual;
    }

    public abstract boolean esHerbivoro();
    public abstract Animal spawn(Cell c); // crear hijo de la misma especie

    public void mover(Cell[][] isla) {
        int x = ubicacionActual.getX();
        int y = ubicacionActual.getY();
        int newX = x, newY = y;
        if (velocidadMaxima > 0) {
            do {
                newX = Math.max(0, Math.min(isla.length - 1,
                        x + rand.nextInt(velocidadMaxima * 2 + 1) - velocidadMaxima));
                newY = Math.max(0, Math.min(isla[0].length - 1,
                        y + rand.nextInt(velocidadMaxima * 2 + 1) - velocidadMaxima));
            } while (newX == x && newY == y);
        }
        ubicacionActual.removerAnimal(this);
        ubicacionActual = isla[newX][newY];
        ubicacionActual.agregarAnimal(this);
    }

    public void reproducirse() {
        List<Animal> mismos = ubicacionActual.obtenerAnimales(this.getClass());
        if (mismos.size() >= 2 && ubicacionActual.hayEspacioPara(this.getClass(), species.maxPorCelda)) {
            ubicacionActual.agregarAnimal(this.spawn(ubicacionActual));
        }
    }

    public void comer() { /* en subclases */ }

    public void morir() {
        estaVivo = false;
        if (ubicacionActual != null) ubicacionActual.removerAnimal(this);
    }

    public boolean estaVivo() { return estaVivo; }
    public void setUbicacionActual(Cell cell) { this.ubicacionActual = cell; }
    public Species getSpecies() { return species; }
}






