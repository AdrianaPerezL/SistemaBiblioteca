public class Libro {
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private String genero;
    private boolean disponible;

    public Libro(String titulo, String autor, int anioPublicacion, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.genero = genero;
        this.disponible = true;
    }

    //getters y setters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public String getGenero() {
        return genero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Título: " + titulo +
                ", Autor: " + autor +
                ", Año: " + anioPublicacion +
                ", Género: " + genero +
                ", Disponible: " + (disponible ? "Sí" : "No");
    }

}

