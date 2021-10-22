import java.util.ArrayList;

public class Auditor extends Usuario{

    public Auditor(String apellido, String fechaAlta, String cuil, String pass) {
        super(apellido, fechaAlta, cuil, pass);
    }

    public void habilitarSustancia(Sustancia sustancia){
        if (!TransactionCore.getSustanciasPermitidas().contains(sustancia)){
            TransactionCore.getSustanciasPermitidas().add(sustancia);
            this.emailProducers();
        }
        else
            App.print("Error, sustancia ya ingresada");
    }

    public void bajarSustancia(String nombre){
        for(Sustancia sustancia : TransactionCore.getSustanciasPermitidas()){
            if (sustancia.getNombre().toUpperCase().equals(nombre.toUpperCase())){
                TransactionCore.getSustanciasPermitidas().remove(sustancia);
                break;
            }      
        }
        this.emailProducers();
    }

    public void emailProducers(){
        App.print("Los productores han sido avisados de este cambio");
    }
}
