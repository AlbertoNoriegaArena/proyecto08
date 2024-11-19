package es.santander.ascender.proyecto08;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    
}
