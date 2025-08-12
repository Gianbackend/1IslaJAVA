package Project2Poo._A_app;


import Project2Poo.animals.carnivoros.*;
import Project2Poo.config.Config;
import Project2Poo.config.Species;
import Project2Poo.core.Animal;
import Project2Poo.util.AnimalFactory;
import Project2Poo.world.Cell;
import Project2Poo.world.Plant;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import Project2Poo.animals.carnivoros.*;
import Project2Poo.animals.hervivoros.*;

public class Main {
    static final int R = Config.ROWS;
    static final int C = Config.COLS;

    static Cell[][] isla = new Cell[R][C];
    static Random rand = new Random();
    static ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    static int turno = 0; // ← contador de turnos (0 = estado inicial)

    public static void main(String[] args) {
        File archivo = new File("isla.ser");
        boolean loaded = false;

        // Cargar estado previo solo si SAVE_STATE es true
        if (Config.SAVE_STATE && archivo.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
                Cell[][] cargada = (Cell[][]) in.readObject();
                if (cargada.length == R && cargada[0].length == C) {
                    isla = cargada;
                    loaded = true;
                    System.out.println("🌍 Isla cargada desde archivo.");
                    // Reparar referencias transient
                    for (int i = 0; i < R; i++) {
                        for (int j = 0; j < C; j++) {
                            Cell celda = isla[i][j];
                            for (List<Animal> grupo : new ArrayList<>(celda.obtenerTodosLosAnimales())) {
                                for (Animal a : grupo) {
                                    a.setUbicacionActual(celda);
                                    a.rand = new Random();
                                }
                            }
                        }
                    }
                } else {
                    System.out.println("⚠️ Tamaño guardado no coincide. Se reinicia la isla (" + R + "x" + C + ").");
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("⚠️ No se pudo cargar isla.ser. Se reinicia la isla.");
            }
        }

        // Inicializar mundo si no se cargó
        if (!loaded) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    isla[i][j] = new Cell(i, j);
                    if (rand.nextDouble() < Config.PLANT_REGEN_PROB) {
                        isla[i][j].getPlantas().add(new Plant());
                    }
                }
            }
            // Población inicial desde Config
            for (Species s : Species.values()) {
                int count = Config.initialCount(s);
                if (count <= 0) continue;
                Class<? extends Animal> clazz = switch (s) {
                    case LOBO -> Lobo.class; case BOA -> Boa.class; case ZORRO -> Zorro.class;
                    case OSO -> Oso.class; case AGUILA -> Aguila.class; case CABALLO -> Caballo.class;
                    case CIERVO -> Ciervo.class; case CONEJO -> Conejo.class; case RATON -> Raton.class;
                    case CABRA -> Cabra.class; case OVEJA -> Oveja.class; case JABALI -> Jabali.class;
                    case BUFALO -> Bufalo.class; case PATO -> Pato.class; case ORUGA -> Oruga.class;
                };
                for (int k = 0; k < count; k++) {
                    int x = rand.nextInt(R), y = rand.nextInt(C);
                    isla[x][y].agregarAnimal(AnimalFactory.create(clazz, isla[x][y]));
                }
            }
        }

        // Iniciar scheduler: el turno 0 solo imprime (sin mover/comer), luego turnos normales
        scheduler.scheduleAtFixedRate(Main::ejecutarTurno, 0, Config.TICK_SECONDS, TimeUnit.SECONDS);
    }

    public static void ejecutarTurno() {
        if (turno == 0) {
            // Solo imprimir estado inicial y estadísticas
            imprimirMapaYEstadisticas();
            turno++;
            return;
        }

        // Migración configurable por especie (favorece herbívoros según Config)
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                for (Species s : Species.values()) {
                    double p = Config.migrationProb(s);
                    if (p > 0 && rand.nextDouble() < p) {
                        // crear 1 individuo de esa especie en esta celda (si hay espacio)
                        Class<? extends Animal> clazz = switch (s) {
                            case LOBO -> Lobo.class; case BOA -> Boa.class; case ZORRO -> Zorro.class;
                            case OSO -> Oso.class; case AGUILA -> Aguila.class; case CABALLO -> Caballo.class;
                            case CIERVO -> Ciervo.class; case CONEJO -> Conejo.class; case RATON -> Raton.class;
                            case CABRA -> Cabra.class; case OVEJA -> Oveja.class; case JABALI -> Jabali.class;
                            case BUFALO -> Bufalo.class; case PATO -> Pato.class; case ORUGA -> Oruga.class;
                        };
                        isla[i][j].agregarAnimal(AnimalFactory.create(clazz, isla[i][j]));
                    }
                }
            }
        }

        // --- Secuencial por especie: mover -> comer + reproducirse ---
        actuaPorEspecie(Conejo.class);
        actuaPorEspecie(Lobo.class);
        actuaPorEspecie(Caballo.class);
        actuaPorEspecie(Ciervo.class);
        actuaPorEspecie(Raton.class);
        actuaPorEspecie(Oveja.class);
        actuaPorEspecie(Cabra.class);
        actuaPorEspecie(Pato.class);
        actuaPorEspecie(Oruga.class);

        actuaPorEspecie(Boa.class);
        actuaPorEspecie(Zorro.class);
        actuaPorEspecie(Oso.class);
        actuaPorEspecie(Aguila.class);
        actuaPorEspecie(Bufalo.class);
        actuaPorEspecie(Jabali.class);

        // Regeneración de plantas por celda
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (rand.nextDouble() < Config.PLANT_REGEN_PROB) {
                    isla[i][j].getPlantas().add(new Plant());
                }
            }
        }

        // Mostrar mapa y estadísticas
        imprimirMapaYEstadisticas();

        // Guardar estado solo si está activado en Config
        if (Config.SAVE_STATE) {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("isla.ser"))) {
                out.writeObject(isla);
                System.out.println("💾 Estado de la isla guardado.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Parada configurable
        if (Config.STOP_WHEN_NO_ANIMALS) {
            Map<Species, Integer> conteo = contarPorSpecies();
            int totalAnimales = conteo.values().stream().mapToInt(Integer::intValue).sum();
            if (totalAnimales == 0) {
                System.out.println("☠️ Fin de la simulación: no quedan animales.");
                scheduler.shutdown();
            }
        }

        turno++;
    }

    // -------- utilidades --------

    static <T extends Animal> void actuaPorEspecie(Class<T> clazz) {
        // mover
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                for (Animal a : new ArrayList<>(isla[i][j].obtenerAnimales(clazz)))
                    if (a.estaVivo()) a.mover(isla);

        // comer + reproducirse
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                for (Animal a : new ArrayList<>(isla[i][j].obtenerAnimales(clazz)))
                    if (a.estaVivo()) { a.comer(); a.reproducirse(); }
    }

    private static void imprimirMapaYEstadisticas() {
        System.out.println("\n📍 Estado de la isla (turno " + turno + "):");
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print("[" + isla[i][j].toString() + "] ");
            }
            System.out.println();
        }

        Map<Species, Integer> conteo = contarPorSpecies();
        int plantas = contarPlantas();
        System.out.print("\n📊 Estadísticas: ");
        System.out.print("🐃:" + conteo.getOrDefault(Species.BUFALO, 0) + " ");
        System.out.print("🐻:" + conteo.getOrDefault(Species.OSO, 0) + " ");
        System.out.print("🐎:" + conteo.getOrDefault(Species.CABALLO, 0) + " ");
        System.out.print("🦌:" + conteo.getOrDefault(Species.CIERVO, 0) + " ");
        System.out.print("🐗:" + conteo.getOrDefault(Species.JABALI, 0) + " ");
        System.out.print("🐑:" + conteo.getOrDefault(Species.OVEJA, 0) + " ");
        System.out.print("🐐:" + conteo.getOrDefault(Species.CABRA, 0) + " ");
        System.out.print("🐺:" + conteo.getOrDefault(Species.LOBO, 0) + " ");
        System.out.print("🐍:" + conteo.getOrDefault(Species.BOA, 0) + " ");
        System.out.print("🦊:" + conteo.getOrDefault(Species.ZORRO, 0) + " ");
        System.out.print("🦅:" + conteo.getOrDefault(Species.AGUILA, 0) + " ");
        System.out.print("🐇:" + conteo.getOrDefault(Species.CONEJO, 0) + " ");
        System.out.print("🦆:" + conteo.getOrDefault(Species.PATO, 0) + " ");
        System.out.print("🐁:" + conteo.getOrDefault(Species.RATON, 0) + " ");
        System.out.print("🐛:" + conteo.getOrDefault(Species.ORUGA, 0) + " ");
        System.out.println("🌿:" + plantas);
    }

    static Map<Species, Integer> contarPorSpecies() {
        Map<Species, Integer> m = new EnumMap<>(Species.class);
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                for (List<Animal> grupo : isla[i][j].obtenerTodosLosAnimales())
                    for (Animal a : grupo)
                        m.merge(a.getSpecies(), 1, Integer::sum);
        return m;
    }

    static int contarPlantas() {
        int p = 0;
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                p += isla[i][j].getPlantas().size();
        return p;
    }
}