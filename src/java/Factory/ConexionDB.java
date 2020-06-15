package Factory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 

public abstract class ConexionDB {
    protected String[] parametros;//Array que recive los parámetros de la conexión 
    protected Connection conexion;
    
    abstract Connection open();
    
    //crear metodo para las consultas
    public ResultSet consultaSQL(String consulta){
        Statement st;
        ResultSet rs = null;
    try{
        st = conexion.createStatement();
        rs = st.executeQuery(consulta);
        }catch(SQLException ex){
             ex.printStackTrace();
        }
    return rs;
    }
    //crear método para ejecutar
    public boolean ejecutarSQL(String consulta){
        Statement st;
        boolean guardar = true;
        try{
            st = conexion.createStatement();
            st.executeUpdate(consulta);
        }catch(SQLException ex){
            guardar = false;
            ex.printStackTrace();
        }
        return guardar;
    }
    
    //métdodo para cerrar conexion 
    public boolean cerrarConexion(){
        boolean ok = true;
        try{
            conexion.close();
           }catch(Exception ex){
            ok = false;
            ex.printStackTrace();
        }
        return ok;
    }
    
}