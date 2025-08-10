package Project2Poo;

public class Oveja extends Herbivoro {
    public Oveja(Cell c) { super(Species.OVEJA, c); }
    @Override
    public Animal spawn(Cell c) { return new Oveja(c); }
}