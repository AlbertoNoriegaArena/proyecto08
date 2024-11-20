package es.santander.ascender.proyecto08;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class OperacionesConCadenas implements FechaHora {
    @Override
    public String obtenerFechaHoraUniversal() { // Crear una instancia de Calendar con la fecha y hora actuales
        Calendar calendarioActual = Calendar.getInstance();

        // Definir el formato universal deseado (YYYY-MM-DD HH:MM:SS)
        SimpleDateFormat formatoUniversal = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // Formatear la fecha en el formato deseado usando la fecha de Calendar
        return formatoUniversal.format(calendarioActual.getTime());
    }

    // Metodo de Jose obtener fecha con java/util
    @Override
    public String obtenerFecha(String zonaHoraria) {

        // Obtengo la fecha actual
        Date fechaActual = new Date();
        // Creo el formato de salida deseado
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sszXXX");
        // Creo la zonaHoraria deseada
        TimeZone tz = TimeZone.getTimeZone(zonaHoraria);
        sdf.setTimeZone(tz);
        return sdf.format(fechaActual);
    }

    // Obtener Fecha con la libreria java/time
    @Override
    public String obtenerFechaBis(String zonaHoraria) {
        // Obtengo la fecha y hora actual en la zona horaria indicada por el parámetro
        ZonedDateTime fechaHoraZona = ZonedDateTime.now(ZoneId.of(zonaHoraria));
        // Creo el formato de salida deseado en el formato: "yyyy-MM-dd'T'HH:mm:ssXXX"
        // Las 3 X incluye la zona horaria en el formato ±hh:mm
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:sszXXX");
        // Formateo la fecha con el formato y la zona horaria configurada, luego
        // devuelvo el resultado
        return fechaHoraZona.format(formatter);
    }

    // Metodo de Jose mostrar dia de la semana actual
    @Override
    public String obtenerDiaDeSemanaActual() {
        Date fecha = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(fecha);
        int diaDeLaSemana = calendar.get(Calendar.DAY_OF_WEEK);
        String[] diasSemana = { "Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado" };
        return diasSemana[diaDeLaSemana - 1];

    }

    @Override
    public String obtenerDiaSemanaActualBis() {
        LocalDate ld = LocalDate.now();
        int dia = ld.getDayOfWeek().getValue();
        return ld.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
    }

    

}
