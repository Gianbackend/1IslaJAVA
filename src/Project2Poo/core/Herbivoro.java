package Project2Poo.core;

import Project2Poo.config.Species;
import Project2Poo.core.Animal;
import Project2Poo.world.Cell;
import Project2Poo.world.Plant;

import java.util.List;

public abstract class Herbivoro extends Animal {
    private static final long serialVersionUID = 1L;
    protected Herbivoro(Species s, Cell c) { super(s, c); }
    @Override public boolean esHerbivoro() { return true; }
    @Override public void comer() {
        List<Plant> plantas = ubicacionActual.getPlantas();
        if (!plantas.isEmpty()) {
            plantas.remove(0);
        } else {
            if (Math.random() < 0.7) morir(); // 70% morir de hambre si no come
        }
    }
}
