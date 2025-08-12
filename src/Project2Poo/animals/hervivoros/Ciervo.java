package Project2Poo.animals.hervivoros;

import Project2Poo.config.Species;
import Project2Poo.core.Animal;
import Project2Poo.core.Herbivoro;
import Project2Poo.world.Cell;

public class Ciervo extends Herbivoro {
    public Ciervo(Cell c) { super(Species.CIERVO, c); }
    @Override
    public Animal spawn(Cell c) { return new Ciervo(c); }
}