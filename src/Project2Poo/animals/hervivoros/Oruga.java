package Project2Poo.animals.hervivoros;

import Project2Poo.config.Species;
import Project2Poo.core.Animal;
import Project2Poo.core.Herbivoro;
import Project2Poo.world.Cell;

public class Oruga extends Herbivoro {
    public Oruga(Cell c) { super(Species.ORUGA, c); }
    @Override
    public Animal spawn(Cell c) { return new Oruga(c); }
}
