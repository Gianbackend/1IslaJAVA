package Project2Poo;

public class Caballo extends Herbivoro {
    public Caballo(Cell c) { super(Species.CABALLO, c); }
    @Override
    public Animal spawn(Cell c) { return new Caballo(c); }
}
