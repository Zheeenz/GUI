/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duoc.cl.app.DTO;

/**
 *
 * @author Zhnz
 */
public class PeliculaDTO {
    private int id;
    private String titulo;
    private String director;
    private int anio;
    private int duracion;
    private int genero;

    public PeliculaDTO(int id, String titulo, String director, int anio, int duracion, int genero) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.anio = anio;
        this.duracion = duracion;
        this.genero = genero;
    }
   
    public PeliculaDTO() {
        this.id = 0;
        this.titulo = "";
        this.director = "";
        this.anio = 0;
        this.duracion = 0;
        this.genero = 0;
    } 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Tu pelicula es: "+ titulo
                + ",Director: " +director
                +", Del anio " + anio 
                +", Duracion"+duracion
                +",Genero"+ genero;
    }
  

    
}
