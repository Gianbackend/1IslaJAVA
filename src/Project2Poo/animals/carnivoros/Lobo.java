package Project2Poo.animals.carnivoros;

import Project2Poo.config.Species;
import Project2Poo.core.Animal;
import Project2Poo.core.Carnivoro;
import Project2Poo.world.Cell;

public class Lobo extends Carnivoro {
    public Lobo(Cell c) { super(Species.LOBO, c); }
    @Override public Animal spawn(Cell c) { return new Lobo(c); }
}

