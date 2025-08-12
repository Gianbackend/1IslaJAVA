package Project2Poo.animals.hervivoros;

import Project2Poo.config.Species;
import Project2Poo.core.Animal;
import Project2Poo.core.Herbivoro;
import Project2Poo.world.Cell;

// Subclase concreta: Conejo (Herbívoro)
public class Conejo extends Herbivoro {
    public Conejo(Cell c) { super(Species.CONEJO, c); }
    @Override
    public Animal spawn(Cell c) { return new Conejo(c); }
}
