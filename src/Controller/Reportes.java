package Controller;

import java.sql.SQLException;
import java.util.List;

import Model.DBaccess.Informe1DBaccess;
import Model.DBaccess.Informe2DBaccess;
import Model.DBaccess.Informe3DBaccess;
import Model.Data.Informe1Data;
import Model.Data.Informe2Data;
import Model.Data.Informe3Data;

public class Reportes {

    // Atributos

    private Informe1DBaccess Informe1;
    private Informe2DBaccess Informe2;
    private Informe3DBaccess Informe3;

    // Constructor

    public Reportes() {
        Informe1 = new Informe1DBaccess();
        Informe2 = new Informe2DBaccess();
        Informe3 = new Informe3DBaccess();
    }

    // Metodos

    public List<Informe1Data> listarInforme1() throws SQLException{
        return Informe1.listar();
    }

    public List<Informe2Data> listarInforme2() throws SQLException{
        return Informe2.listar();
    }

    public List<Informe3Data> listarInforme3() throws SQLException{
        return Informe3.listar();
    }
}
