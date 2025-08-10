package Project2Poo;

import java.io.Serializable;
import java.util.*;


class Cell implements Serializable {
    private static final long serialVersionUID = 1L;

    private final int x, y;
    private final List<Plant> plantas = new ArrayList<>();
    private final Map<Class<? extends Animal>, List<Animal>> animales = new HashMap<>();

    public Cell(int x, int y) { this.x = x; this.y = y; }

    public void agregarAnimal(Animal animal) {
        if (!hayEspacioPara(animal.getClass(), animal.getSpecies().maxPorCelda)) return;
        animal.setUbicacionActual(this);
        animales.computeIfAbsent(animal.getClass(), k -> new ArrayList<>()).add(animal);
    }
    public void removerAnimal(Animal animal) {
        List<Animal> lista = animales.get(animal.getClass());
        if (lista != null) lista.remove(animal);
    }
    public boolean hayEspacioPara(Class<? extends Animal> tipo, int max) {
        return obtenerAnimales(tipo).size() < max;
    }
    public List<Animal> obtenerAnimales(Class<? extends Animal> tipo) {
        return animales.getOrDefault(tipo, new ArrayList<>());
    }
    public Collection<List<Animal>> obtenerTodosLosAnimales() { return animales.values(); }
    public List<Plant> getPlantas() { return plantas; }
    public int getX() { return x; }
    public int getY() { return y; }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        for (List<Animal> grupo : animales.values()) {
            for (Animal a : grupo) {
                switch (a.getSpecies()) {
                    case BUFALO -> sb.append("🐃");
                    case OSO    -> sb.append("🐻");
                    case CABALLO-> sb.append("🐎");
                    case CIERVO -> sb.append("🦌");
                    case JABALI -> sb.append("🐗");
                    case OVEJA  -> sb.append("🐑");
                    case CABRA  -> sb.append("🐐");
                    case LOBO   -> sb.append("🐺");
                    case BOA    -> sb.append("🐍");
                    case ZORRO  -> sb.append("🦊");
                    case AGUILA -> sb.append("🦅");
                    case CONEJO -> sb.append("🐇");
                    case PATO   -> sb.append("🦆");
                    case RATON  -> sb.append("🐁");
                    case ORUGA  -> sb.append("🐛");
                }
            }
        }
        if (!plantas.isEmpty()) sb.append("🌿");
        return sb.length() == 0 ? "  " : sb.toString();
    }
}