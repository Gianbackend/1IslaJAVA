package Project2Poo.animals.carnivoros;import Project2Poo.config.Species;
import Project2Poo.core.Animal;
import Project2Poo.core.Carnivoro;
import Project2Poo.world.Cell;

public class Boa extends Carnivoro {
    public Boa(Cell c) { super(Species.BOA, c); }
    @Override
    public Animal spawn(Cell c) { return new Boa(c); }
}