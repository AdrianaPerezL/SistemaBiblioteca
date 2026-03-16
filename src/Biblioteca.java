import java.util.ArrayList;

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
}