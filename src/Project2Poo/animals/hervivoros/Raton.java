package Project2Poo.animals.hervivoros;

import Project2Poo.config.Species;
import Project2Poo.core.Animal;
import Project2Poo.core.Herbivoro;
import Project2Poo.world.Cell;

public class Raton extends Herbivoro {
    public Raton(Cell c) { super(Species.RATON, c); }
    @Override
    public Animal spawn(Cell c) { return new Raton(c); }
}
