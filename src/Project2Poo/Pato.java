package Project2Poo;

public class Pato extends Herbivoro {
    public Pato(Cell c) { super(Species.PATO, c); }
    @Override
    public Animal spawn(Cell c) { return new Pato(c); }
}