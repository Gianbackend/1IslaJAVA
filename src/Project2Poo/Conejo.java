package Project2Poo;

import java.util.List;

// Subclase concreta: Conejo (Herbívoro)
public class Conejo extends Herbivoro {
    public Conejo(Cell c) { super(Species.CONEJO, c); }
    @Override
    public Animal spawn(Cell c) { return new Conejo(c); }
}
