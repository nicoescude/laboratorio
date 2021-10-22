import java.util.ArrayList;

public class App {
    
    
    public static void main(String[] args) throws Exception {



        Productor  p1 = new Productor("Lopez", "19-10-2021", "10-23456789-2", "123");
        Productor  p2 = new Productor("Ramirez", "19-10-2021", "10-23456789-2", "345");
        Auditor    a1 = new Auditor("Suarez", "19-10-2021", "10-14658965-3", "456");
        Consumidor c1 = new Consumidor("Fernandez", "19-10-2021", "20-48963456", "321");
        
        Sustancia  s1 = new Simple("Agua", "H2O", 0.5f, "Incoloro");
        Sustancia  s2 = new Simple("Cloro", "F", 0.15f, "Blanco");
        /** Queria probar las llamadas encadenadas, no es necesario */
        Sustancia  s3 = (new Compuesta("Nitrogeno", "NO2", 0.65f)).componer((Simple)s1).componer((Simple)s2);
        Sustancia  s4 = new Simple("Random", "RN", 0.88f, "Gris");

        /* El productor registra s1 y s2 como sustancias de su creación */
        p1.registrarSustancia(s1,2000); p1.registrarSustancia(s2,1500);
        p1.registrarSustancia(s3, 1800); p1.registrarSustancia(s4, 3);

        /* El auditor habilita s1 y s2 para ser usadas en el sistema */
        a1.habilitarSustancia(s1);
        a1.habilitarSustancia(s3);
        a1.habilitarSustancia(s4);
       
        /* El consumidor pide 5 sustancias  */
        c1.solicitarSustancia(200, s1, p1);     //Tramite correcto Agua
        c1.solicitarSustancia(150, s2, p1);     //Sustancia no habilitada
        c1.solicitarSustancia(80, s3, p1);      //Tramite correcto Nitrogeno
        c1.solicitarSustancia(80, s3, p2);      //Productor equivocado
        c1.solicitarSustancia(200, s4, p1);     //Stock insuficiente

        c1.showTramites();
    }

    public static void print(String mensaje) {
        System.out.println(mensaje);
    }
}
