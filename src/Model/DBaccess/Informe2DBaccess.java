package Model.DBaccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Data.Informe2Data;
import Util.JDBCUtilities;

public class Informe2DBaccess {
    public List<Informe2Data> listar() throws SQLException {
        ArrayList<Informe2Data> respuesta = new ArrayList<Informe2Data>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String consulta = "SELECT ID_Proyecto, Constructora, Numero_Habitaciones, Ciudad FROM Proyecto p WHERE Clasificacion = 'Casa Campestre' AND (Ciudad = 'Santa Marta' OR Ciudad = 'Barranquilla' OR Ciudad = 'Cartagena')";
        try{
            stm = conn.createStatement();
            rs = stm.executeQuery(consulta);
            while(rs.next()){
                Informe2Data date = new Informe2Data();
                date.setIdProyecto(rs.getInt("ID_Proyecto"));
                date.setConstructora(rs.getString("Constructora"));
                date.setNumero_habitaciones(rs.getInt("Numero_Habitaciones"));
                date.setCiudad(rs.getString("Ciudad"));
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
