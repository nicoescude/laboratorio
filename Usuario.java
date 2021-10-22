public abstract class Usuario {
    private String nombre, apellido, fechaAlta, cuil, pass;
    private int edad;

    public Usuario(String nombre, String apellido, String fechaAlta, String cuil,
                    String pass, int edad) {
                        this.nombre = nombre;
                        this.apellido = apellido;
                        this.fechaAlta = fechaAlta;
                        this.cuil = cuil;
                        this.edad = edad;
                    }

    //constructor minimo
    public Usuario(String apellido, String fechaAlta, String cuil,
                    String pass) {
                        this.apellido = apellido;
                        this.fechaAlta = cuil;
                        this.cuil = cuil;
                    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCuil() {
        return cuil;
    }

    public int getEdad() {
        return edad;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    private String getPass() {
        return pass;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }
}
