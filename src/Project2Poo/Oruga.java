package Project2Poo;

public class Oruga extends Herbivoro {
    public Oruga(Cell c) { super(Species.ORUGA, c); }
    @Override
    public Animal spawn(Cell c) { return new Oruga(c); }
}
