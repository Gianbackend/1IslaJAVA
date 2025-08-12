package Project2Poo.world;

import java.io.Serializable;

// Clase Plant
public class Plant implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean viva = true;
    public boolean estaViva() { return viva; }
    public void morir() { viva = false; }
    public void crecer() { viva = true; }
}