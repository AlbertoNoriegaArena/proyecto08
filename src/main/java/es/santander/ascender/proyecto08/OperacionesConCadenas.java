package es.santander.ascender.proyecto08;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class OperacionesConCadenas {
    public static String obtenerFechaHoraUniversal() {
        // Crear una instancia de Calendar con la fecha y hora actuales
        Calendar calendarioActual = Calendar.getInstance();

        // Definir el formato universal deseado (YYYY-MM-DD HH:MM:SS)
        SimpleDateFormat formatoUniversal = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // Formatear la fecha en el formato deseado usando la fecha de Calendar
        return formatoUniversal.format(calendarioActual.getTime());
    }

    // Metodo de Jose obtener fecha
    public static String obtenerFecha(String zonaHoraria) {

        // Obtengo la fecha actual

        Date fechaActual = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sszXXX");
        TimeZone tz = TimeZone.getTimeZone(zonaHoraria);

        sdf.setTimeZone(tz);

        return sdf.format(fechaActual);
    }
    //Metodo de Jose mostrar dia de la semana actual
    public static String diaDeSemanaActual() {
        Date fecha = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(fecha);
        int diaDeLaSemana = calendar.get(Calendar.DAY_OF_WEEK);
        String[] diasSemana = {"Domingo",  "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado" };
        return diasSemana[diaDeLaSemana - 1];

    }
}
