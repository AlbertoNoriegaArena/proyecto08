package es.santander.ascender.proyecto08;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class OperacionesConCadenas {
       public static String obtenerFechaHoraUniversal() {
        // Crear una instancia de Calendar con la fecha y hora actuales
        Calendar calendarioActual = Calendar.getInstance();
        
        // Definir el formato universal deseado (YYYY-MM-DD HH:MM:SS)
        SimpleDateFormat formatoUniversal = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        // Formatear la fecha en el formato deseado usando la fecha de Calendar
        return formatoUniversal.format(calendarioActual.getTime());
    }
}
