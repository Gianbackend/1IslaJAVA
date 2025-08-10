package Project2Poo;

public class Raton extends Herbivoro {
    public Raton(Cell c) { super(Species.RATON, c); }
    @Override
    public Animal spawn(Cell c) { return new Raton(c); }
}
