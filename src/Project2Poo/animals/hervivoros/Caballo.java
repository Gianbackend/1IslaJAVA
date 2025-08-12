package Project2Poo.animals.hervivoros;
import Project2Poo.config.Species;
import Project2Poo.core.Animal;
import Project2Poo.core.Herbivoro;
import Project2Poo.world.Cell;


public class Caballo extends Herbivoro {
    public Caballo(Cell c) { super(Species.CABALLO, c); }
    @Override
    public Animal spawn(Cell c) { return new Caballo(c); }
}
