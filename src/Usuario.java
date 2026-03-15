import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private String identificacion;
    private ArrayList<Libro> librosPrestados;

    public Usuario(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.librosPrestados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public ArrayList<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    public void prestarLibro(Libro libro) {
        librosPrestados.add(libro);
    }

    public void devolverLibro(Libro libro) {
        librosPrestados.remove(libro);
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                ", ID: " + identificacion +
                ", Libros prestados: " + librosPrestados.size();
    }
}
