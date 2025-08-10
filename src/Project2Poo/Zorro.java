package Project2Poo;

public class Zorro extends Carnivoro {
    public Zorro(Cell c) { super(Species.ZORRO, c); }
    @Override
    public Animal spawn(Cell c) { return new Zorro(c); }
}
