package Model.DBaccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Data.Informe3Data;
import Util.JDBCUtilities;

public class Informe3DBaccess {
    public List<Informe3Data> listar() throws SQLException {
        ArrayList<Informe3Data> respuesta = new ArrayList<Informe3Data>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String consulta = "SELECT ID_Compra, Constructora, Banco_Vinculado FROM Compra c JOIN Proyecto p ON c.ID_Proyecto = p.ID_Proyecto WHERE c.Proveedor = 'Homecenter' AND p.Ciudad = 'Salento'";
        try{
            stm = conn.createStatement();
            rs = stm.executeQuery(consulta);
            while(rs.next()){
                Informe3Data date = new Informe3Data();
                date.setIdCompra(rs.getInt("ID_Compra"));
                date.setConstructora(rs.getString("Constructora"));
                date.setBancoVinculado(rs.getString("Banco_Vinculado"));
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
