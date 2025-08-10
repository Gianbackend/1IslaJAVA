package Project2Poo;

public class Jabali extends Herbivoro {
    public Jabali(Cell c) { super(Species.JABALI, c); }
    @Override
    public Animal spawn(Cell c) { return new Jabali(c); }
}