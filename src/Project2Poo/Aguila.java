package Project2Poo;

public class Aguila extends Carnivoro {
    public Aguila(Cell c) { super(Species.AGUILA, c); }
    @Override
    public Animal spawn(Cell c) { return new Aguila(c); }
}
