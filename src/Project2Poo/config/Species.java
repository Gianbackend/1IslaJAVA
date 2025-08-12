package Project2Poo.config;

public enum Species {
    // Carnívoros
    LOBO   (50,   30, 3,   8,  false, true),
    BOA    (15,   30, 1,   3,  false, true),
    ZORRO  (8,    30, 2,   2,  false, true),
    OSO    (500,   5, 2,  80,  false, true),
    AGUILA (6,    20, 3,   1,  false, true),

    // Herbívoros
    CABALLO(400,  20, 4,  60,  true,  false),
    CIERVO (300,  20, 4,  50,  true,  false),
    CONEJO (2,   150, 2, 0.45, true,  false),
    RATON  (0.05,500, 1, 0.01, true,  false),
    CABRA  (60,  140, 3,  10,  true,  false),
    OVEJA  (70,  140, 3,  15,  true,  false),
    JABALI (400,  50, 2,  50,  true,  false),
    BUFALO (700,  10, 3, 100,  true,  false),
    PATO   (1,   200, 4, 0.15, true,  false),
    ORUGA  (0.01,1000, 1,   0,  true,  false);

    public final double peso;
    public final int maxPorCelda;
    public final int velocidadMaxima;
    public final double comidaNecesaria;
    public final boolean herbivoro;
    public final boolean carnivoro;

    Species(double peso, int maxPorCelda, int velocidadMaxima, double comidaNecesaria,
            boolean herbivoro, boolean carnivoro) {
        this.peso = peso;
        this.maxPorCelda = maxPorCelda;
        this.velocidadMaxima = velocidadMaxima;
        this.comidaNecesaria = comidaNecesaria;
        this.herbivoro = herbivoro;
        this.carnivoro = carnivoro;
    }
}
