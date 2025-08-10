package Project2Poo;

public class Cabra extends Herbivoro {
    public Cabra(Cell c) { super(Species.CABRA, c); }
    @Override
    public Animal spawn(Cell c) { return new Cabra(c); }
}