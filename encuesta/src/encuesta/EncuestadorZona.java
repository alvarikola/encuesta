package encuesta;

import java.util.Random;

public class EncuestadorZona implements Runnable {
    // Atributos
    private final String idZona;
    private final ResultadosEncuesta resultados;
    
    //Métodos
    //Constructor
    public EncuestadorZona(String idZona, ResultadosEncuesta resultados) {
        this.idZona = idZona;
        this.resultados = resultados;
    }
    // Run
    @Override
    public void run() {
        System.out.println(">> Comienza el encuestador para la zona " + this.idZona);
        Random r = new Random();
        int numRespuestas = 100 + r.nextInt(200 - 100) + 1;
        for (int i=0; i < numRespuestas; i++) {
            int numRespuesta = r.nextInt(10); // Respuesta de 0 a 9. El 0 es No sabe/ No contesta
            String respuesta = null;
            if (numRespuesta > 0) {
                respuesta = "respuesta_" + numRespuesta;
            }
            this.resultados.anotarRespuesta(this.idZona, respuesta);
        }
        System.out.println("## Termina el encuestador para la zona " + this.idZona);
    }
}
