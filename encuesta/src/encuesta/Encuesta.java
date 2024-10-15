package encuesta;

import java.util.Set;


public class Encuesta {
    private static final int NUM_ZONAS = 20;
    
    public static void main(String[] args) {
        // Dónde guardo los resultados
        ResultadosEncuesta resultados = new ResultadosEncuesta();
        
        //Creo los hilos
        Thread[] encuestadores = new Thread[NUM_ZONAS];
        for (int i=0; i < NUM_ZONAS; i++) {
            Thread encuestador = new Thread(new EncuestadorZona("Zona " + i, resultados));
            encuestadores[i] = encuestador;
        }
        
        // Lanzar los hilos
        for (Thread encuestador : encuestadores) {
            encuestador.start();
        }
        
        // Esperar que terminen los hilos
        for (Thread encuestador : encuestadores) {
            try {
                encuestador.join();
            } catch (InterruptedException e) {
            
            }
        }
        
        // Mostrar los resultados
        System.out.println("Encuestados por zona:");
        Set<String> zonas = resultados.obtenZonas();
        int totalPorZonas = 0;
        for (String zona : zonas) {
            int subtotalZona = resultados.obtenNumRespuestasZona(zona);
            System.out.println(zona + ": " + subtotalZona);
            totalPorZonas += subtotalZona;
        }
        System.out.println("Total: " + totalPorZonas);
        
        // Resultados por respuestas
        System.out.println("Resultados por respuesta:");
        Set<String> respuestas = resultados.obtenRespuestas();
        int totalRespuestas = 0;
        for (String respuesta : respuestas) {
            int subtotalRespuesta = resultados.obtenNumRespuestas(respuesta);
            System.out.println(respuesta + ": " + subtotalRespuesta);
            totalRespuestas += subtotalRespuesta;
        }
        System.out.println("Total: " + totalRespuestas);
    }
    
}
