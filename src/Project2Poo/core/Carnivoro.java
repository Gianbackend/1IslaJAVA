package Project2Poo.core;

import Project2Poo.config.Config;
import Project2Poo.config.PredationTable;
import Project2Poo.config.Species;
import Project2Poo.world.Cell;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class Carnivoro extends Animal {
    private static final long serialVersionUID = 1L;
    protected Carnivoro(Species s, Cell c) { super(s, c); }
    @Override public boolean esHerbivoro() { return false; }
    @Override
    public void comer() {
        Map<Class<? extends Animal>, Integer> mapa =
                PredationTable.forPredator(this.getClass());

        boolean comio = false;
        for (Map.Entry<Class<? extends Animal>, Integer> e : mapa.entrySet()) {
            Class<? extends Animal> presa = e.getKey();
            int chance = e.getValue();
            List<Animal> presas = ubicacionActual.obtenerAnimales(presa);
            if (!presas.isEmpty()) {
                if (Math.random() * 100 < chance) {
                    presas.get(0).morir();
                    comio = true;
                    break;
                }
            }
        }
        if (!comio && Math.random() < Config.HUNGER_DEATH_PROB) morir();
    }
}
