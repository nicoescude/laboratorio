//import java.util.HashMap;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Tramite {
    private static final AtomicInteger count = new AtomicInteger();
    private int cantidad, nTramite;
    private Date fecha;
    private Sustancia sustancia;
    private Productor productor;
    private String observacion;

    public static final String ACEPTADOS = "ACEPTADOS";
    public static final String RECHAZADOS = "RECHAZADOS";

    public Tramite(int cantidad, Sustancia sustancia, Productor productor) {
        this.fecha = new Date();
        this.cantidad = cantidad;
        this.sustancia = sustancia;
        this.productor = productor;
        this.observacion = null;
        nTramite = count.incrementAndGet();
    }

    public int getCantidad() {
        return cantidad;
    }
    
    public Sustancia getSustancia() {
        return sustancia;
    }

    public int getnTramite() {
        return nTramite;
    }

    public Productor getProductor() {
        return productor;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public boolean isRechazado(){
        return this.observacion!=null;
    }
}
