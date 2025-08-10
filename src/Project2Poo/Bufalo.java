package Project2Poo;

public class Bufalo extends Herbivoro {
    public Bufalo(Cell c) { super(Species.BUFALO, c); }
    @Override
    public Animal spawn(Cell c) { return new Bufalo(c); }
}