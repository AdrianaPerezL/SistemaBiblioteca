import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.cargarLibros();

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 10) {

            System.out.println("\n--- MENU BIBLIOTECA ---");
            System.out.println("1. Registrar libro");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Listar libros");
            System.out.println("6. Filtrar por genero");
            System.out.println("7. Filtrar por autor");
            System.out.println("8. Mostrar libros disponibles");
            System.out.println("9. Mostrar todos los libros");
            System.out.println("10. Salir del sistema");

            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion < 1 || opcion > 10) {
                System.out.println("Opcion invalida");
                continue;
            }

            if (opcion == 1) {

                System.out.print("Titulo: ");
                String titulo = sc.nextLine();

                if (titulo.isEmpty()) {
                    System.out.println("El titulo no puede estar vacio");
                    continue;
                }

                System.out.print("Autor: ");
                String autor = sc.nextLine();

                System.out.print("Año: ");
                int anio = sc.nextInt();
                sc.nextLine();

                System.out.print("Genero: ");
                String genero = sc.nextLine();

                biblioteca.registrarLibro(new Libro(titulo, autor, anio, genero));
                System.out.println("Libro registrado");

            } else if (opcion == 2) {

                System.out.print("Nombre: ");
                String nombre = sc.nextLine();

                System.out.print("ID: ");
                String id = sc.nextLine();

                biblioteca.registrarUsuario(new Usuario(nombre, id));
                System.out.println("Usuario registrado");

            } else if (opcion == 3) {

                System.out.print("Titulo del libro: ");
                String titulo = sc.nextLine();

                if (titulo.isEmpty()) {
                    System.out.println("El titulo no puede estar vacio");
                    continue;
                }

                System.out.print("ID usuario: ");
                String id = sc.nextLine();

                biblioteca.prestarLibro(titulo, id);

            } else if (opcion == 4) {

                System.out.print("Titulo del libro: ");
                String titulo = sc.nextLine();

                if (titulo.isEmpty()) {
                    System.out.println("El titulo no puede estar vacio");
                    continue;
                }

                System.out.print("ID usuario: ");
                String id = sc.nextLine();

                biblioteca.devolverLibro(titulo, id);

            } else if (opcion == 5) {

                biblioteca.listarLibros();

            } else if (opcion == 6) {

                System.out.print("Genero: ");
                String genero = sc.nextLine();
                biblioteca.listarPorGenero(genero);

            } else if (opcion == 7) {

                System.out.print("Autor: ");
                String autor = sc.nextLine();
                biblioteca.listarPorAutor(autor);

            } else if (opcion == 8) {

                biblioteca.listarDisponibles();

            } else if (opcion == 9) {

                biblioteca.listarLibros();

            } else if (opcion == 10) {

                biblioteca.guardarLibros();
                System.out.println("Saliendo del sistema...");
            }
        }

        sc.close();
    }
}