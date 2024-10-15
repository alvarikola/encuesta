package encuesta;

import java.util.HashMap;
import java.util.Set;

public class ResultadosEncuesta {
    private final HashMap<String, Integer> totalPorRespuesta = new HashMap<>();
    private final HashMap<String, Integer> totalPorZona = new HashMap<>();
    
    // Métodos
    // Anotar la respuesta en el diccionario de xzonas y en el diccionario de respuestas.
    synchronized public void anotarRespuesta(String idZona, String respuesta) {
        Integer numRespZona = this.totalPorZona.get(idZona);
        this.totalPorZona.put(idZona, numRespZona == null ? 1 : numRespZona + 1);
        
        Integer numRespValor = this.totalPorRespuesta.get(respuesta);
        this.totalPorRespuesta.put(respuesta, numRespValor == null ? 1 : numRespValor + 1);
    }
    
    // Obtener las zonas
    synchronized public Set<String> obtenZonas() {
        return this.totalPorZona.keySet();
    }
    
    // Obtener las respuestas
    synchronized public Set<String> obtenRespuestas() {
        return this.totalPorRespuesta.keySet();
    }
    
    // Obtener el número de respuestas en cada zona 
    synchronized public int obtenNumRespuestasZona(String zona) {
        return this.totalPorZona.get(zona);
    }
    
    // Obtener el número de respuestas de cada respuesta 
    synchronized public int obtenNumRespuestas(String respuesta) {
        return this.totalPorRespuesta.get(respuesta);
    }
}
