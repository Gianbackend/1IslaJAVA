package Project2Poo.config;


import Project2Poo.core.Animal;
import Project2Poo.animals.carnivoros.*;
import Project2Poo.animals.hervivoros.*;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class PredationTable {
    private static final Map<Class<? extends Animal>, Map<Class<? extends Animal>, Integer>> TABLE = new HashMap<>();

    static {
        // Lobo -> Caballo(10), Ciervo(15), Conejo(60)
        put(Lobo.class, Caballo.class, 10);
        put(Lobo.class, Ciervo.class,  15);
        put(Lobo.class, Conejo.class,  60);

        // Boa -> Zorro(15), Conejo(20)
        put(Boa.class, Zorro.class,   15);
        put(Boa.class, Conejo.class,  20);

        // Zorro -> Conejo(70)
        put(Zorro.class, Conejo.class, 70);

        // Oso -> Boa(80), Caballo(40), Ciervo(80), Conejo(80)
        put(Oso.class, Boa.class,     80);
        put(Oso.class, Caballo.class, 40);
        put(Oso.class, Ciervo.class,  80);
        put(Oso.class, Conejo.class,  80);

        // Águila -> Zorro(10), Conejo(90)
        put(Aguila.class, Zorro.class, 10);
        put(Aguila.class, Conejo.class,90);
        // El resto por defecto 0
    }
    public static Map<Class<? extends Animal>, Integer> forPredator(Class<? extends Animal> predator) {
        return TABLE.getOrDefault(predator, Collections.emptyMap());
    }

    private static void put(Class<? extends Animal> predator,
                            Class<? extends Animal> prey,
                            int chance) {
        TABLE.computeIfAbsent(predator, k -> new HashMap<>()).put(prey, chance);
    }

    private PredationTable() {}
}