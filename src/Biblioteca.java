import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Biblioteca {

    ArrayList<Libro> libros = new ArrayList<>();
    ArrayList<Usuario> usuarios = new ArrayList<>();

    public void registrarLibro(Libro libro) {
        libros.add(libro);
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Libro buscarLibro(String titulo) {
        for (Libro l : libros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                return l;
            }
        }
        return null;
    }

    public Usuario buscarUsuario(String id) {
        for (Usuario u : usuarios) {
            if (u.getIdentificacion().equals(id)) {
                return u;
            }
        }
        return null;
    }

    public void prestarLibro(String titulo, String idUsuario) {

        Libro libro = buscarLibro(titulo);
        Usuario usuario = buscarUsuario(idUsuario);

        if (libro == null || usuario == null) {
            System.out.println("Libro o usuario no encontrado");
            return;
        }

        if (!libro.isDisponible()) {
            System.out.println("El libro ya esta prestado");
            return;
        }

        libro.setDisponible(false);
        usuario.prestarLibro(libro);

        System.out.println("Prestamo realizado");
    }

    public void devolverLibro(String titulo, String idUsuario) {

        Usuario usuario = buscarUsuario(idUsuario);

        if (usuario == null) {
            System.out.println("Usuario no encontrado");
            return;
        }

        for (Libro l : usuario.getLibrosPrestados()) {

            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                l.setDisponible(true);
                usuario.devolverLibro(l);
                System.out.println("Libro devuelto");
                return;
            }
        }

        System.out.println("El usuario no tiene ese libro");
    }

    public void listarLibros() {
        for (Libro l : libros) {
            System.out.println(l);
        }

    }
    public void listarPorGenero(String genero) {
        for (Libro l : libros) {
            if (l.getGenero().equalsIgnoreCase(genero)) {
                System.out.println(l);
            }
        }
    }
    public void listarPorAutor(String autor) {
        for (Libro l : libros) {
            if (l.getAutor().equalsIgnoreCase(autor)) {
                System.out.println(l);
            }
        }
    }
    public void listarDisponibles() {
        for (Libro l : libros) {
            if (l.isDisponible()) {
                System.out.println(l);
            }
        }
    }
    public void guardarLibros() {

        try {
            FileWriter fw = new FileWriter("libros.txt");

            for (Libro l : libros) {
                fw.write(l.getTitulo() + "," + l.getAutor() + "," + l.getAnioPublicacion() + "," + l.getGenero() + "," + l.isDisponible() + "\n");
            }

            fw.close();

        } catch (Exception e) {
            System.out.println("Error al guardar");
        }
    }
    public void cargarLibros() {

        try {
            BufferedReader br = new BufferedReader(new FileReader("libros.txt"));
            String linea;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");

                Libro libro = new Libro(datos[0], datos[1], Integer.parseInt(datos[2]), datos[3]);
                libro.setDisponible(Boolean.parseBoolean(datos[4]));

                libros.add(libro);
            }

            br.close();

        } catch (Exception e) {
            System.out.println("No hay archivo guardado");
        }
    }
}