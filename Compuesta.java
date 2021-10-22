import java.util.Vector;

public class Compuesta extends Sustancia{
    private Vector<Simple> composicion;

    public Compuesta(String nombre, String compo, float pureza) {
        super(nombre, compo, pureza);
        this.composicion = new Vector<Simple>();
    }

    public Compuesta(String nombre, String compo, float pureza, Vector<Simple> composicion) {
        super(nombre, compo, pureza);
        this.composicion = composicion;
    }

    public Compuesta componer(Simple simple) {
        this.composicion.add(simple);
        return this;
    }

    public Vector<Simple> descomponer() {
        Vector<Simple> temp = this.composicion;
        composicion.clear();
        return temp;
    }

    public void descomponer(Simple simple) {
        for(Simple temporal: this.composicion) {
            if(temporal.getFormula().equals(simple.getFormula())) {
                this.composicion.remove(temporal);
                break;
            }
        }
    }

    public void descomponer(Vector<Simple> simples) {
        for(Simple simple: simples) {
            this.descomponer(simple);
        }
    }    
}
