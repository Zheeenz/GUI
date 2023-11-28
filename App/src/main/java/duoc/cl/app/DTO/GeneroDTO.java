/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duoc.cl.app.DTO;

/**
 *
 * @author Usuario
 */
public class GeneroDTO {
    private int id;
    private String descripcion;

    public GeneroDTO(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
    
    public GeneroDTO() {
        this.id = 0;
        this.descripcion = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "generoDTO{" + "id=" + id + ", descripcion=" + descripcion + '}';
    }   
}
