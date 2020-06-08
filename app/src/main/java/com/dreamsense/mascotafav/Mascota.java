package com.dreamsense.mascotafav;

/**
 * Created by Gabriel on 06/07/2016.
 */
public class Mascota {
    private int foto;
    private String nombre;
    private String likes;

    public Mascota(int foto, String nombre, String likes) {
        this.foto = foto;
        this.nombre = nombre;
        this.likes = likes;
    }

    public int getFoto() {

        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }
}
