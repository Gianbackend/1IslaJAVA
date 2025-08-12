package Project2Poo.animals.hervivoros;

import Project2Poo.config.Species;
import Project2Poo.core.Animal;
import Project2Poo.core.Herbivoro;
import Project2Poo.world.Cell;

public class Oveja extends Herbivoro {
    public Oveja(Cell c) { super(Species.OVEJA, c); }
    @Override
    public Animal spawn(Cell c) { return new Oveja(c); }
}