package Model.DBaccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Data.Informe1Data;
import Util.JDBCUtilities;

public class Informe1DBaccess {

    public List<Informe1Data> listar() throws SQLException {
        ArrayList<Informe1Data> respuesta = new ArrayList<Informe1Data>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String consulta = "SELECT ID_Lider, Nombre, Primer_Apellido, Ciudad_Residencia FROM Lider l GROUP BY Ciudad_Residencia";
        try{
            stm = conn.createStatement();
            rs = stm.executeQuery(consulta);
            while(rs.next()){
                Informe1Data date = new Informe1Data();
                date.setIdLider(rs.getInt("ID_Lider"));
                date.setNombre(rs.getString("Nombre"));
                date.setPrimer_Apellido(rs.getString("Primer_Apellido"));
                date.setCiudad_Residencia(rs.getString("Ciudad_Residencia"));
                respuesta.add(date);
            }
        }
        finally{
            if (rs != null){
                rs.close();
            }
            if (stm != null){
                stm.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return respuesta;
    }
}