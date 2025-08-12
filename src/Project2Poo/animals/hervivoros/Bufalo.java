package Project2Poo.animals.hervivoros;

import Project2Poo.config.Species;
import Project2Poo.core.Animal;
import Project2Poo.core.Herbivoro;
import Project2Poo.world.Cell;

public class Bufalo extends Herbivoro {
    public Bufalo(Cell c) { super(Species.BUFALO, c); }
    @Override
    public Animal spawn(Cell c) { return new Bufalo(c); }
}