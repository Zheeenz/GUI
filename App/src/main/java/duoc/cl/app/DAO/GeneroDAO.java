/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duoc.cl.app.DAO;

import duoc.cl.app.DTO.GeneroDTO;
import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class GeneroDAO {
    private final Conexion conexion ;
    
    public GeneroDAO(Conexion conexion) {
        this.conexion = conexion;
    }
    
    public GeneroDTO mostrarGenero(int id)
    {
        String consulta = "SELECT * FROM GENERO WHERE id = ?; ";

        try{
            PreparedStatement ps = conexion.conectarMySQL().prepareStatement(consulta);
            ps.setInt(1, id);
            ps.executeQuery(consulta);

            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int valorColumna1 = rs.getInt("ID");
                String valorColumna2 = rs.getString("DESCRIPCION");

                System.out.println("Columna1: " + valorColumna1 + ", Columna2: " + valorColumna2);

                return new GeneroDTO(valorColumna1, valorColumna2);
            }
            
        }catch(SQLException e){
            System.out.println("mala");
        }
        return null;
    }
    
    public ArrayList<GeneroDTO> listarGeneros(){
        
        ArrayList<GeneroDTO> listaGeneros = new ArrayList<>();
        
        String consulta = " SELECT * FROM GENERO; ";
        
        try{
            PreparedStatement ps = conexion.conectarMySQL().prepareStatement(consulta);
            ps.executeQuery(consulta);

            while (ps.getResultSet().next()){
                int valorColumna1 = ps.getResultSet().getInt("ID");
                String valorColumna2 = ps.getResultSet().getString("DESCRIPCION");
   
                GeneroDTO genero = new GeneroDTO(valorColumna1, valorColumna2);
                
                listaGeneros.add(genero);
                
                System.out.println("Columna1: " + valorColumna1 + ", Columna2: " + valorColumna2 );
            }
            
        }catch(SQLException e){
            System.out.println("mala");
        }
        
        return listaGeneros;
    }
    
    public boolean modificarGenero(GeneroDTO genero){
        boolean resultado = false;
        
        try{
            String query = "UPDATE GENERO SET DESCRIPCION=? WHERE ID =?";
            PreparedStatement ps = conexion.conectarMySQL().prepareStatement(query);
            ps.setString(1, genero.getDescripcion());
            ps.setInt(2, genero.getId());
            resultado = !ps.execute();
            ps.close();
        }catch(SQLException e){
            System.out.println("");
        }
        return resultado;
    }
    
    public boolean eliminarGenero(int id){
        boolean resultado = false;
        
        try{
            String query = "DELETE FROM GENERO WHERE ID = ?;";
            PreparedStatement ps = conexion.conectarMySQL().prepareStatement(query);
            ps.setInt(1, id);
            resultado = !ps.execute();
            ps.close();
        }catch(SQLException e){
            System.out.println("");
        }
        return resultado;
    }
    
    public boolean agregarGenero(GeneroDTO genero){
        boolean resultado = false;
        
        try{
            String query = "INSERT INTO GENERO (DESCRIPCION) VALUES (?);";
            PreparedStatement ps = conexion.conectarMySQL().prepareStatement(query);
            ps.setString(1, genero.getDescripcion());
            resultado = !ps.execute();
            ps.close();
        }catch(SQLException e){
            System.out.println("");
        }
        return resultado;
    }
}
