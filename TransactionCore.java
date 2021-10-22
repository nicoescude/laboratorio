import java.util.ArrayList;

public class TransactionCore {

    private static ArrayList<Sustancia> sustanciasPermitidas;
    
    static{
        sustanciasPermitidas = new ArrayList<>();
    }

    public static Tramite abrirTramite(int cantidad,Sustancia sustancia, Productor productor){
        if (sustanciasPermitidas.contains(sustancia)){

            Tramite t = new Tramite(cantidad, sustancia, productor);
            String respuesta = t.getProductor().procesarTramite(t);
            if (respuesta != null){
                t.setObservacion(respuesta); 
            }
            return t;
        }
        else{
            System.out.println("Error, Sustancia no habilitada: "+sustancia.getNombre());
            return null;
        }        
    }

    public static ArrayList<Sustancia> getSustanciasPermitidas() {
        return sustanciasPermitidas;
    }
}
