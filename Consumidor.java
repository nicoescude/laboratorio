import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Consumidor extends Usuario implements IRenovable{
    private Date fechaRenovacion;
    private ArrayList<Tramite> tramitesAceptados;
    private ArrayList<Tramite> tramitesRechazados;

    public Consumidor(String apellido, String fechaAlta, String cuit, String pass) {
        super(apellido, fechaAlta, cuit, pass);
        this.fechaRenovacion = new Date();
        this.tramitesAceptados = new ArrayList<>();
        this.tramitesRechazados = new ArrayList<>();
    }

    private void iniciarTramite(int cantidad,Sustancia sustancia, Productor productor) {

        Tramite t = TransactionCore.abrirTramite(cantidad, sustancia, productor);
        if (t!=null){
            if (t.isRechazado()){
                this.tramitesRechazados.add(t);
            }
            else{
                this.tramitesAceptados.add(t);
            }
        }
    }


    /* Metodo poco optimizado, para mostrar los tramites del consumidor */
    public void showTramites(String tipo){
        if (tipo != null){
            switch(tipo.toUpperCase()){
                case Tramite.ACEPTADOS:
                    for(Tramite t : this.tramitesAceptados){
                        System.out.println("Tramite Aceptado:  "+t.getnTramite()+" - "+t.getSustancia().getNombre());
                    }break;
                case Tramite.RECHAZADOS:
                    for(Tramite t : this.tramitesRechazados){
                        System.out.println("Tramite Rechazado: "+t.getnTramite()+" : "+t.getObservacion());
                    }break;
                default:
                for(Tramite t : this.tramitesAceptados){
                    System.out.println("Tramite Aceptado:  "+t.getnTramite()+" - "+t.getSustancia().getNombre());
                }
                for(Tramite t : this.tramitesRechazados){
                    System.out.println("Tramite Rechazado: "+t.getnTramite()+" : "+t.getObservacion());
                }
            }
        }else{
            for(Tramite t : this.tramitesAceptados){
                System.out.println("Tramite Aceptado:  "+t.getnTramite()+" - "+t.getSustancia().getNombre());
            }
            for(Tramite t : this.tramitesRechazados){
                System.out.println("Tramite Rechazado: "+t.getnTramite()+" : "+t.getObservacion());
            }
        }
    }

    public void showTramites(){
        this.showTramites(null);
    }

    public void solicitarSustancia(int cantidad,Sustancia sustancia, Productor productor) {
        this.iniciarTramite(cantidad, sustancia, productor);
    }

    public Date getFechaRenovacion() {
        return fechaRenovacion;
    }

    @Override
    public void renovarDatos(String dni) {
        
    }

    @Override
    public void renovarFecha() {
        //obtengo la fecha y hora de este momento
        this.fechaRenovacion = Calendar.getInstance().getTime();
    }
}
