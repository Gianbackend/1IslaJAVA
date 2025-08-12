package Project2Poo.animals.hervivoros;

import Project2Poo.config.Species;
import Project2Poo.core.Animal;
import Project2Poo.core.Herbivoro;
import Project2Poo.world.Cell;

public class Cabra extends Herbivoro {
    public Cabra(Cell c) { super(Species.CABRA, c); }
    @Override
    public Animal spawn(Cell c) { return new Cabra(c); }
}