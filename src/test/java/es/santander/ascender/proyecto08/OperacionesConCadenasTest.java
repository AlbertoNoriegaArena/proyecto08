package es.santander.ascender.proyecto08;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

public class OperacionesConCadenasTest {
    @Test
    public void testObtenerFechaHoraUniversal() throws ParseException {
        // Obtener la fecha y hora formateada
        String fechaHoraFormateada = OperacionesConCadenas.obtenerFechaHoraUniversal();
        
        // Verificar que la fecha y hora devuelta tiene el formato esperado (yyyy-MM-dd HH:mm:ss)
        SimpleDateFormat formatoEsperado = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        formatoEsperado.setLenient(false); // Asegurarse de que la fecha sea válida
        
        // Intentar parsear la fecha y verificar que no hay excepción
        Date fecha = formatoEsperado.parse(fechaHoraFormateada);
        
        // Comprobar que la fecha es válida
        assertNotNull(fecha, "La fecha obtenida no debe ser nula");
        
        // Verificar que el formato tiene el tamaño esperado
        assertEquals(19, fechaHoraFormateada.length(), "La longitud del formato debe ser 19 caracteres.");
        
        // Opcional: puedes verificar que el formato de la fecha esté en el rango esperado (actual)
        Date fechaActual = new Date();
        assertTrue(fecha.before(fechaActual) || fecha.equals(fechaActual), "La fecha generada debe ser antes o igual a la fecha actual.");
    }

    @Test

    public void testDiaDeSemanaAcutal (){

         Date fechaActual = new Date();                 // Obtiene la fecha actual del sistema
        Calendar calendar = new GregorianCalendar();   // Crea una instancia de GregorianCalendar
        calendar.setTime(fechaActual);                 // Establece la fecha actual en el calendario
        
        int diaDeLaSemana = calendar.get(Calendar.DAY_OF_WEEK); // Obtiene el número del día de la semana (1=Domingo, 2=Lunes, etc.)
        
        // Define un array con los nombres de los días de la semana en orden
        String[] diasSemana = {"Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
        
        String diaEsperado = diasSemana[diaDeLaSemana - 1];
        
        // Llamar al método y verificar el resultado
        String diaActual = OperacionesConCadenas.diaDeSemanaActual();
        
        assertEquals(diaEsperado, diaActual, "El día de la semana no coincide con el valor esperado.");
    }

    
}
