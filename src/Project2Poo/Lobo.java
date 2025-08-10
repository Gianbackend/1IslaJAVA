package Project2Poo;

import java.util.List;

// Subclase concreta: Lobo (Carnívoro)
public class Lobo extends Carnivoro {
    public Lobo(Cell c) { super(Species.LOBO, c); }
    @Override
    public Animal spawn(Cell c) { return new Lobo(c); }
}

