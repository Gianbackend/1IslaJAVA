package Project2Poo.config;

import java.util.EnumMap;
import java.util.Map;

public final class Config {
    private Config() {}

    // ----- Tamaño de la isla -----
    public static final int ROWS = 20;
    public static final int COLS = 20;

    public static final boolean SAVE_STATE = false; // guardar isla.ser? (true/false)

    // ----- Duración del ciclo (scheduler) -----
    public static final int TICK_SECONDS = 3;

    // ----- Probabilidades globales -----
    // Probabilidad de morir por hambre si no come en el turno
    public static final double HUNGER_DEATH_PROB = 0.70;

    // Regeneración de plantas por celda y turno
    public static final double PLANT_REGEN_PROB = 0.05;

    // Migración (aparición aleatoria por celda y turno) por especie.
    // Si una especie no está, se asume 0.
    private static final Map<Species, Double> MIGRATION_PROB = new EnumMap<>(Species.class);
    static {
        // Herbívoros (más alta)
        MIGRATION_PROB.put(Species.ORUGA,   0.03); // orugas recolonizan mucho
        MIGRATION_PROB.put(Species.RATON,   0.01);
        MIGRATION_PROB.put(Species.CONEJO,  0.01);
        MIGRATION_PROB.put(Species.PATO,    0.005);
        MIGRATION_PROB.put(Species.OVEJA,   0.005);
        MIGRATION_PROB.put(Species.CABRA,   0.005);
        MIGRATION_PROB.put(Species.CIERVO,  0.005);
        MIGRATION_PROB.put(Species.CABALLO, 0.005);
        MIGRATION_PROB.put(Species.JABALI,  0.003);
        MIGRATION_PROB.put(Species.BUFALO,  0.003);

// Carnívoros (muy baja o 0)
        MIGRATION_PROB.put(Species.ZORRO,   0.002);
        MIGRATION_PROB.put(Species.LOBO,    0.001);
        MIGRATION_PROB.put(Species.AGUILA,  0.0);
        MIGRATION_PROB.put(Species.BOA,     0.0);
        MIGRATION_PROB.put(Species.OSO,     0.0);
    }
    public static double migrationProb(Species s) {
        return MIGRATION_PROB.getOrDefault(s, 0.0);
    }

    // ----- N° de animales inicial por especie -----
    private static final Map<Species, Integer> INITIAL_COUNTS = new EnumMap<>(Species.class);
    static {
        INITIAL_COUNTS.put(Species.CONEJO, 30);
        INITIAL_COUNTS.put(Species.LOBO,   10);
        INITIAL_COUNTS.put(Species.CABALLO, 6);
        INITIAL_COUNTS.put(Species.CIERVO,  8);
        INITIAL_COUNTS.put(Species.RATON,  20);
        INITIAL_COUNTS.put(Species.OVEJA,   8);
        INITIAL_COUNTS.put(Species.CABRA,   8);
        INITIAL_COUNTS.put(Species.PATO,    8);
        INITIAL_COUNTS.put(Species.BOA,     5);
        INITIAL_COUNTS.put(Species.ZORRO,   6);
        INITIAL_COUNTS.put(Species.OSO,     2);
        INITIAL_COUNTS.put(Species.AGUILA,  3);
        INITIAL_COUNTS.put(Species.BUFALO,  2);
        INITIAL_COUNTS.put(Species.JABALI,  3);
        INITIAL_COUNTS.put(Species.ORUGA,  30);
    }
    public static int initialCount(Species s) {
        return INITIAL_COUNTS.getOrDefault(s, 0);
    }

    // ----- N° de crías por tipo (por reproducción) -----
    // Si no está, se asume 1.
    private static final Map<Species, Integer> LITTER_SIZE = new EnumMap<>(Species.class);
    static {
        // valores ejemplo; ajusta a gusto
        LITTER_SIZE.put(Species.CONEJO, 2);
        LITTER_SIZE.put(Species.RATON,  2);
        LITTER_SIZE.put(Species.PATO,   2);

        LITTER_SIZE.put(Species.LOBO,   1);
        LITTER_SIZE.put(Species.ZORRO,  1);
        LITTER_SIZE.put(Species.BOA,    1);
        LITTER_SIZE.put(Species.OSO,    1);
        LITTER_SIZE.put(Species.AGUILA, 1);

        LITTER_SIZE.put(Species.CABALLO,1);
        LITTER_SIZE.put(Species.CIERVO, 1);
        LITTER_SIZE.put(Species.CABRA,  1);
        LITTER_SIZE.put(Species.OVEJA,  1);
        LITTER_SIZE.put(Species.JABALI, 1);
        LITTER_SIZE.put(Species.BUFALO, 1);
        LITTER_SIZE.put(Species.ORUGA,  1);
    }
    public static int litterSize(Species s) {
        return LITTER_SIZE.getOrDefault(s, 1);
    }

    // ----- Condición de parada -----
    // true: detener cuando no queda ningún animal (todas las especies)
    // false: puedes cambiar la lógica a “sin conejos ni lobos”, etc.
    public static final boolean STOP_WHEN_NO_ANIMALS = true;
}