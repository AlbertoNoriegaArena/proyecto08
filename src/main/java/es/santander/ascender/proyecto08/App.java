package es.santander.ascender.proyecto08;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        FechaHora fh = new OperacionesConCadenas();
        System.out.println("Hello World!");
        System.out.println(fh.obtenerFechaBis("Europe/Moscow"));
        System.out.println(fh.obtenerFecha("Europe/Paris"));
    }
}
