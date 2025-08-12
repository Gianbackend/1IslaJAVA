package Project2Poo.animals.hervivoros;

import Project2Poo.config.Species;
import Project2Poo.core.Animal;
import Project2Poo.core.Herbivoro;
import Project2Poo.world.Cell;

public class Jabali extends Herbivoro {
    public Jabali(Cell c) { super(Species.JABALI, c); }
    @Override
    public Animal spawn(Cell c) { return new Jabali(c); }
}