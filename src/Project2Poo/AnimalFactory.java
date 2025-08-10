package Project2Poo;

class AnimalFactory {
    static Animal create(Class<? extends Animal> clazz, Cell c) {
        if (clazz == Lobo.class)    return new Lobo(c);
        if (clazz == Boa.class)     return new Boa(c);
        if (clazz == Zorro.class)   return new Zorro(c);
        if (clazz == Oso.class)     return new Oso(c);
        if (clazz == Aguila.class)  return new Aguila(c);
        if (clazz == Caballo.class) return new Caballo(c);
        if (clazz == Ciervo.class)  return new Ciervo(c);
        if (clazz == Conejo.class)  return new Conejo(c);
        if (clazz == Raton.class)   return new Raton(c);
        if (clazz == Cabra.class)   return new Cabra(c);
        if (clazz == Oveja.class)   return new Oveja(c);
        if (clazz == Jabali.class)  return new Jabali(c);
        if (clazz == Bufalo.class)  return new Bufalo(c);
        if (clazz == Pato.class)    return new Pato(c);
        if (clazz == Oruga.class)   return new Oruga(c);
        throw new IllegalArgumentException("Clase no soportada: " + clazz);
    }
}
