package Project2Poo.animals.carnivoros;
import Project2Poo.config.Species;
import Project2Poo.core.Animal;
import Project2Poo.core.Carnivoro;
import Project2Poo.world.Cell;

public class Aguila extends Carnivoro {
    public Aguila(Cell c) { super(Species.AGUILA, c); }
    @Override
    public Animal spawn(Cell c) { return new Aguila(c); }
}
