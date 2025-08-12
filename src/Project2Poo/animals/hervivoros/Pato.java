package Project2Poo.animals.hervivoros;

import Project2Poo.config.Species;
import Project2Poo.core.Animal;
import Project2Poo.core.Herbivoro;
import Project2Poo.world.Cell;

public class Pato extends Herbivoro {
    public Pato(Cell c) { super(Species.PATO, c); }
    @Override
    public Animal spawn(Cell c) { return new Pato(c); }
}