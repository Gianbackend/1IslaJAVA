package Project2Poo;

public class Ciervo extends Herbivoro {
    public Ciervo(Cell c) { super(Species.CIERVO, c); }
    @Override
    public Animal spawn(Cell c) { return new Ciervo(c); }
}