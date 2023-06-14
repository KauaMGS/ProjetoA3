package factory;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
    public static Connection conector(){
        java.sql.Connection conn = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://aws.connect.psdb.cloud/db-loja-tenis?sslMode=VERIFY_IDENTITY";
        String user = "cz8zmqft73qjkvvuqcvt";
        String password = "pscale_pw_SBFqYJn69ZmkRAF0Rrd3IMP3Dv8ZFwgp6IUB2GTTmaA";
                        
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }      
        
        return conn;    
    }
     
}
