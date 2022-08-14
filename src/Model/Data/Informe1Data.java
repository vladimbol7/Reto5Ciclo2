package Model.Data;

public class Informe1Data {
    
    // Atributos

    private int IdLider;
    private String Nombre;
    private String Primer_Apellido;
    private String Ciudad_Residencia;

    // Encapsulados

    public int getIdLider() {
        return IdLider;
    }

    public void setIdLider(int idLider) {
        IdLider = idLider;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getPrimer_Apellido() {
        return Primer_Apellido;
    }

    public void setPrimer_Apellido(String primer_Apellido) {
        Primer_Apellido = primer_Apellido;
    }

    public String getCiudad_Residencia() {
        return Ciudad_Residencia;
    }

    public void setCiudad_Residencia(String ciudad_Residencia) {
        Ciudad_Residencia = ciudad_Residencia;
    }
    
}
