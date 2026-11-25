import java.util.Arrays;

/**
 * objeto rutina
 */
public class Rutina {
    /**
     * lista de los ejercicios de la rutina
     */
    String[] ejercicios;
    /**
     * lista de los estiramientos de la rutina
     */
    String[] estiramientos;
    /**
     * nombre de la rutina
     */
    String nombre;
    /**
     * numero de ejercicios que hay actualmente en la rutina
     */
    int numEjercicios;
    /**
     * numero de estiramientos que hay actualmente en la rutina
     */
    int numEstiramientos;

    /**
     * Inicialización de la rutina
     * @param nombre nombre de la rutina
     * @param maxEjercicios tamaño de la lista de ejercicios
     * @param maxEstiramientos tamaño de la lista de estiramientos
     */
    public Rutina(String nombre, int maxEjercicios, int maxEstiramientos) {
        this.nombre = nombre;
        ejercicios = new String[maxEjercicios];
        estiramientos = new String[maxEstiramientos];
        numEjercicios = 0;
        numEstiramientos = 0;
    }

    /**
     * @return Devuelve el nombre de la rutina
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return Devuelve los ejercicios de la rutina (array de longitud igual al número de ejercicios actuales)
     */
    public String[] getEjercicios() {
        return Arrays.copyOf(ejercicios, numEjercicios);
    }

    /**
     * @return Devuelve los estiramientos de la rutina (array de longitud igual al número de estiramientos actuales)
     */
    public String[] getEstiramientos() {
        return Arrays.copyOf(estiramientos, numEstiramientos);
    }

    /**
     * Añade un ejercicio a la rutina (si está completa, muestra un mensaje de error)
     * @param ejercicio ejercicio a añadir
     * @return true si se ha añadido el ejercicio y false si no se ha añadido
     */
    public boolean agregarEjercicio(String ejercicio) {
        boolean anadido = false;
        if (numEjercicios < ejercicios.length){
            ejercicios[numEjercicios] = ejercicio;
            numEjercicios++;
            anadido = true;
        }
        else {
            System.out.print("No se pueden añadir más ejercicios.\n");
        }
        return anadido;
    }

    /**
     * Añade un estiramiento a la rutina (si está completa, muestra un mensaje de error)
     * @param estiramiento estiramiento a añadir
     * @return true si se ha añadido el estiramiento y false si no se ha añadido
     */
    public boolean agregarEstiramiento(String estiramiento) {
        boolean anadido = false;
        if (numEstiramientos < estiramientos.length){
            estiramientos[numEstiramientos] = estiramiento;
            numEstiramientos++;
            anadido = true;
        }
        else {
            System.out.print("No se pueden añadir más estiramientos.\n");
        }
        return anadido;
    }

    /**
     * Comprueba si la rutina tiene el máximo de ejercicios
     * @return true si la lista ejercicios tiene todas las posiciones ocupadas
     */
    public boolean ejerciciosCompletos() {
        return numEjercicios == ejercicios.length;
    }

    /**
     * Comprueba si la rutina tiene el máximo de estiramientos
     * @return true si la lista estiramientos tiene todas las posiciones ocupadas
     */
    public boolean estiramientosCompletos() {
        return numEstiramientos == estiramientos.length;
    }

    /**
     * @return Devuelve el número de ejercicios de la rutina
     */
    public int numEjercicios() {
        return numEjercicios;
    }

    /**
     * @return Devuelve el número de estiramientos de la rutina
     */
    public int numEstiramientos() {
        return numEstiramientos;
    }

    /**
     * @return Devuelve una representación en forma de cadena de la rutina, para mostrar por pantalla
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Rutina: ").append(nombre).append("\n");
        stringBuilder.append("Ejercicios:").append("\n");
        for (int i = 0; i < numEjercicios; i++){
            stringBuilder.append("- ").append(ejercicios[i]).append("\n");
        }
        stringBuilder.append("Estiramientos:").append("\n");
        for (int i = 0; i < numEstiramientos; i++){
            stringBuilder.append(i + 1).append(". ").append(estiramientos[i]).append("\n");
        }
        return stringBuilder.toString();
    }

    /**
     * @return Devuelve una representación en forma de cadena de la rutina sin formato, para guardar en archivo
     */
    public String toRawString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(nombre).append("\n");
        for (int i = 0; i < numEjercicios; i++){
            stringBuilder.append(ejercicios[i]).append("\n");
        }
        stringBuilder.append("ESTIRAMIENTOS").append("\n");
        for (int i = 0; i < numEstiramientos; i++){
            stringBuilder.append(estiramientos[i]).append("\n");
        }
        stringBuilder.append("=====").append("\n");
        return stringBuilder.toString();
    }

    /**
     * @return Devuelve el máximo de ejercicios permitidos en la rutina
     */
    public int getMaxEjercicios() {
        return ejercicios.length;
    }

    /**
     * @return Devuelve el máximo de estiramientos permitidos en la rutina
     */
    public int getMaxEstiramientos() {
        return estiramientos.length;
    }
}
