package Project2Poo;

public class Boa extends Carnivoro {
    public Boa(Cell c) { super(Species.BOA, c); }
    @Override
    public Animal spawn(Cell c) { return new Boa(c); }
}