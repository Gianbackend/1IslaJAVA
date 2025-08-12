package Project2Poo.animals.carnivoros;
import Project2Poo.config.Species;
import Project2Poo.core.Animal;
import Project2Poo.core.Carnivoro;
import Project2Poo.world.Cell;
public class Zorro extends Carnivoro {
    public Zorro(Cell c) { super(Species.ZORRO, c); }
    @Override
    public Animal spawn(Cell c) { return new Zorro(c); }
}
