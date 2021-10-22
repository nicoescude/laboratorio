public abstract class Sustancia {
    private String nombre, formula;
    private float pureza;

    public Sustancia(String nombre, String compo, float pureza) {
        this.nombre = nombre;
        this.formula = compo;
        this.pureza = pureza;
    }

    public String getFormula() {
        return formula;
    }

    public String getNombre() {
        return nombre;
    }
}
