import java.util.Arrays;

public class Rutina {
    String[] ejercicios;
    String[] estiramientos;
    String nombre;
    int numEjercicios = 0;
    int numEstiramientos = 0;
    public Rutina(String nombre, int maxEjercicios, int maxEstiramientos) {
        this.nombre = nombre;
        ejercicios = new String[maxEjercicios];
        estiramientos = new String[maxEstiramientos];
        // Inicialización de la rutina
    }

    public String getNombre() {
        // Devuelve el nombre de la rutina
        return nombre; // @todo MODIFICAR PARA DEVOLVER EL NOMBRE DE LA RUTINA
    }

    public String[] getEjercicios() {
        // Devuelve los ejercicios de la rutina (array de longitud igual al número de ejercicios actuales)
        return Arrays.copyOf(ejercicios, numEjercicios); // @todo MODIFICAR PARA DEVOLVER LOS EJERCICIOS DE LA RUTINA
    }

    public String[] getEstiramientos() {
        // Devuelve los estiramientos de la rutina (array de longitud igual al número de estiramientos actuales)
        return Arrays.copyOf(estiramientos, numEstiramientos); // @todo MODIFICAR PARA DEVOLVER LOS ESTIRAMIENTOS DE LA RUTINA
    }

    public boolean agregarEjercicio(String ejercicio) {
        boolean anadido = false;
        if (numEjercicios < ejercicios.length){
            ejercicios[numEjercicios] = ejercicio;
            anadido = true;
        }
        else {
            System.out.println("La lista de ejercicios ya está completa");
        }
        // Añade un ejercicio a la rutina (si está completa, muestra un mensaje de error)
        return anadido; // @todo MODIFICAR PARA DEVOLVER SI SE HA AÑADIDO EL EJERCICIO
    }

    public boolean agregarEstiramiento(String estiramiento) {
        boolean anadido = false;
        if (numEstiramientos < estiramientos.length){
            estiramientos[numEstiramientos] = estiramiento;
            anadido = true;
        }
        else {
            System.out.println("La lista de estiramientos ya está completa");
        }
        // Añade un estiramiento a la rutina (si está completa, muestra un mensaje de error)
        return anadido; // @todo MODIFICAR PARA DEVOLVER SI SE HA AÑADIDO EL ESTIRAMIENTO
    }

    public boolean ejerciciosCompletos() {
        // Comprueba si la rutina tiene el máximo de ejercicios
        return numEjercicios == (ejercicios.length -1); // @todo MODIFICAR PARA DEVOLVER SI ESTÁN COMPLETOS LOS EJERCICIOS
    }

    public boolean estiramientosCompletos() {
        // Comprueba si la rutina tiene el máximo de estiramientos
        return numEstiramientos == (estiramientos.length -1); // @todo MODIFICAR PARA DEVOLVER SI ESTÁN COMPLETOS LOS ESTIRAMIENTOS
    }

    public int numEjercicios() {
        // Devuelve el número de ejercicios de la rutina
        return numEjercicios; // @todo MODIFICAR PARA DEVOLVER EL NÚMERO DE EJERCICIOS
    }

    public int numEstiramientos() {
        // Devuelve el número de estiramientos de la rutina
        return numEstiramientos; // @todo MODIFICAR PARA DEVOLVER EL NÚMERO DE ESTIRAMIENTOS
    }

    @Override
    public String toString() {
        // Devuelve una representación en forma de cadena de la rutina, para mostrar por pantalla
        return null; // @todo MODIFICAR PARA DEVOLVER LA CADENA CORRECTA
    }

    public String toRawString() {
        // Devuelve una representación en forma de cadena de la rutina sin formato, para guardar en archivo
        return null; // @todo MODIFICAR PARA DEVOLVER LA CADENA CORRECTA
    }

    public int getMaxEjercicios() {
        // Devuelve el máximo de ejercicios permitidos en la rutina
        return 0; // @todo MODIFICAR PARA DEVOLVER EL MÁXIMO DE EJERCICIOS
    }

    public int getMaxEstiramientos() {
        // Devuelve el máximo de estiramientos permitidos en la rutina
        return 0; // @todo MODIFICAR PARA DEVOLVER EL MÁXIMO DE ESTIRAMIENTOS
    }
}
