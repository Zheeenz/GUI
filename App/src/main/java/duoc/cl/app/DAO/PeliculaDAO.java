/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duoc.cl.app.DAO;

import duoc.cl.app.DTO.GeneroDTO;
import duoc.cl.app.DTO.PeliculaDTO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class PeliculaDAO {
    private final Conexion conexion;
    
    public PeliculaDAO(Conexion conexion) {
        this.conexion = conexion;
    }
    
    public ArrayList<PeliculaDTO> listarPelicula(){
        ArrayList<PeliculaDTO> listaPelicula = new ArrayList<>();
        
        String consulta = "SELECT * FROM MOVIE; ";   
        
        try{
            PreparedStatement ps = conexion.conectarMySQL().prepareStatement(consulta);
            ps.executeQuery(consulta);

            while (ps.getResultSet().next()){
                int valorColumna1 = ps.getResultSet().getInt("ID");
                String valorColumna2 = ps.getResultSet().getString("TITULO");
                String valorColumna3 = ps.getResultSet().getString("DIRECTOR");
                int valorColumna4 = ps.getResultSet().getInt("ANIO");
                int valorColumna5 = ps.getResultSet().getInt("DURACION");
                int valorColumnaf = ps.getResultSet().getInt("ID_GENERO");
   
                PeliculaDTO pelicula = new PeliculaDTO(valorColumna1, valorColumna2, valorColumna3, valorColumna4, valorColumna5, valorColumnaf);
                
                listaPelicula.add(pelicula);
                
                System.out.println("ID: " + valorColumna1 + "Titulo: " + valorColumna2 +"Director: "+ valorColumna3+"año: "+valorColumna4+"Duracion: "+valorColumna5+"Forean: "+valorColumnaf );
            }
            
        }catch(SQLException e){
            System.out.println("mala");
        }
        
    return listaPelicula;
}
}