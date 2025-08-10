package Project2Poo;

import java.util.Collections;
import java.util.List;
import java.util.Map;

abstract class Carnivoro extends Animal {
    private static final long serialVersionUID = 1L;
    protected Carnivoro(Species s, Cell c) { super(s, c); }
    @Override public boolean esHerbivoro() { return false; }
    @Override public void comer() {
        Map<Class<? extends Animal>, Integer> mapa =
                PredationTable.P.getOrDefault(this.getClass(), Collections.emptyMap());
        boolean comio = false;
        for (Map.Entry<Class<? extends Animal>, Integer> e : mapa.entrySet()) {
            List<Animal> presas = ubicacionActual.obtenerAnimales(e.getKey());
            if (!presas.isEmpty()) {
                int chance = e.getValue();
                if (Math.random() * 100 < chance) {
                    presas.get(0).morir();
                    comio = true;
                    break;
                }
            }
        }
        if (!comio && Math.random() < 0.7) morir(); // 70% morir de hambre
    }
}
