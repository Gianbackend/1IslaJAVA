package Project2Poo;

import java.util.List;

abstract class Herbivoro extends Animal {
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
