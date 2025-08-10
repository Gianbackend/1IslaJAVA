package Project2Poo;

public class Oso extends Carnivoro {
    public Oso(Cell c) { super(Species.OSO, c); }
    @Override
    public Animal spawn(Cell c) { return new Oso(c); }
}