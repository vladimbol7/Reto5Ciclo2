package Model.Data;

public class Informe2Data {

    // Atributos
    
    private int IdProyecto;
    private String Constructora;
    private int Numero_habitaciones;
    private String Ciudad;

    // Encapsulados

    public int getIdProyecto() {
        return IdProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        IdProyecto = idProyecto;
    }

    public String getConstructora() {
        return Constructora;
    }

    public void setConstructora(String constructora) {
        Constructora = constructora;
    }

    public int getNumero_habitaciones() {
        return Numero_habitaciones;
    }

    public void setNumero_habitaciones(int numero_habitaciones) {
        Numero_habitaciones = numero_habitaciones;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }


}
