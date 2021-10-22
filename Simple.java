public class Simple extends Sustancia{
    private String color;

    public Simple(String nombre, String compo, float pureza, String color) {
        super(nombre, compo, pureza);
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
