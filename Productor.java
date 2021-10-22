import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Calendar;

public class Productor extends Usuario implements IRenovable{
    private Date fechaRenovacion;
    private ArrayList<Sustancia>    sustanciasProducidas;
    private HashMap<String,Integer> stockSustancias;
    private ArrayList<Tramite>      tramitesAceptados;
    private ArrayList<Tramite>      tramitesRechazados;

    public Productor(String apellido, String fechaAlta, String cuil, String pass) {
        super(apellido, fechaAlta, cuil, pass);
        this.fechaRenovacion = new Date();
        this.sustanciasProducidas = new ArrayList<Sustancia>();
        this.stockSustancias = new HashMap<>();
        this.tramitesAceptados = new ArrayList<Tramite>();
        this.tramitesRechazados = new ArrayList<Tramite>();
    }

    public void registrarSustancia(Sustancia sustancia, int cantidad) {
        if (sustancia != null){
            this.sustanciasProducidas.add(sustancia);
            this.stockSustancias.put(sustancia.getFormula(), cantidad);
        }
        else{
            App.print("El productor no puede crear esta sustancia");
        }
    }

    public void quitarSustancia(Sustancia sustancia){
        if (sustancia!=null){
            if (this.sustanciasProducidas.contains(sustancia)){
                this.sustanciasProducidas.remove(sustancia);
                this.stockSustancias.remove(sustancia.getFormula());
            }
            else{
                App.print("No existe esta sustancia");
            }
        }
        else App.print("El productor no puede quitar esta sustancia");
    }

    public void quitarSustancia(ArrayList<Sustancia> sustancias){
        for (Sustancia sustancia : sustancias){
            this.quitarSustancia(sustancia);
        }
    }

    public String procesarTramite(Tramite t) {
        if (t!=null){
            if (this.getSustanciasProducidas().contains(t.getSustancia())){
                if (!this.checkStock(t.getSustancia(), t.getCantidad()))
                    return "Rechazado: Stock insuficiente";
                tramitesAceptados.add(t);
            }
            else{
                tramitesRechazados.add(t);
                return "Rechazado: Sustancia no disponible";
            }
        }
        else{
            App.print("Tramite invalido");
        }
        return null;
    }

    @Override
    public void renovarDatos(String dni) {
        String[] sp = this.getCuil().split("-");
        if(!sp[1].equals(dni)) {
            this.setCuil(sp[0] + "-" + dni + "-" + sp[2]);
        }
        this.renovarFecha();
    }

    @Override
    public void renovarFecha() {
        //obtengo la fecha y hora de este momento
        this.fechaRenovacion = Calendar.getInstance().getTime();
    }

    public ArrayList<Sustancia> getSustanciasProducidas() {
        return sustanciasProducidas;
    }

    private boolean checkStock(String formula, int cantidad){
        if (!this.stockSustancias.containsKey(formula)){
            App.print("Error, la sustancia no tiene stock registrado.");
            return false;
        }
        else{
            int resto = this.stockSustancias.get(formula) - cantidad;
            if (resto > 0){
                this.stockSustancias.put(formula, resto);
                return true;
            }
            else return false;
        }
    }
    
    private boolean checkStock(Sustancia sustancia,int cantidad){
        return this.checkStock(sustancia.getFormula(), cantidad);
    }
}
