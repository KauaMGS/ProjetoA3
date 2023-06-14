package utils;

import com.br.main.Tenis;
import com.br.telas.Menu;
import factory.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class globalMethods {

    public static Connection conectDatabase(Connection conn){
        conn = Conexao.conector();        
        return conn;
    }
    
    public static ArrayList<Tenis> fillMyArray(ArrayList<Tenis> tenisList, ResultSet rs){
        tenisList.clear();
        Connection conn = null;
        Statement st = null;
        
        try {
            conn = conectDatabase(conn);
            st = conn.createStatement();
            String dados = "SELECT * FROM tenis";
            
            rs = st.executeQuery(dados);
            
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String tamanho = String.valueOf(rs.getInt("tamanho"));
                String cor = rs.getString("cor");
                String preco = String.valueOf(rs.getDouble("preco"));

                Tenis tenis = new Tenis(id, marca, modelo, tamanho, cor, preco);
                tenisList.add(tenis);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
        return tenisList;
    }   
    
}
