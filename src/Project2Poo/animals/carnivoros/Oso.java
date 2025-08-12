package Project2Poo.animals.carnivoros;import Project2Poo.config.Species;
import Project2Poo.core.Animal;
import Project2Poo.core.Carnivoro;
import Project2Poo.world.Cell;

public class Oso extends Carnivoro {
    public Oso(Cell c) { super(Species.OSO, c); }
    @Override
    public Animal spawn(Cell c) { return new Oso(c); }
}