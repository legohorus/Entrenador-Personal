import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * objeto catatogo de rutinas
 */
public class CatalogoDeRutinas {
    /**
     * numero de rutinas
     */
    private int numRutinas;
    /**
     * lista de las rutinas del catalogo
     */
    private Rutina[] rutinas;

    /**
     * Inicialización del catálogo de rutinas
     * @param maxRutinasEnCatalogo capacidad maxima del catalogo
     */
    public CatalogoDeRutinas(int maxRutinasEnCatalogo) {
        rutinas = new Rutina[maxRutinasEnCatalogo];
        numRutinas = 0;
    }

    /**
     * Añade una rutina al catálogo (si está completo, muestra un mensaje de error)
     * @param rutina rutina a añadir
     * @return true si se ha añadido la rutina, false si el catalogo esta lleno o la rutina era null
     */
    public boolean agregarRutina(Rutina rutina) {
        boolean agregado = false;
        if (catalogoCompleto()) {
            System.out.print("No se pueden añadir más rutinas.");
        }
        else if (rutina != null){
            rutinas [numRutinas] = rutina;
            numRutinas++;
            agregado = true;
        }
        return agregado;
    }

    /**
     * Busca rutinas cuyo nombre contenga el texto (sin distinguir mayúsculas) y devuelve todas las encontradas
     * @param texto texto a buscar en las rutinas
     * @return un array de rutinas que contienen en el nombre el texto buscado
     */
    public Rutina[] buscarRutinaPorNombre(String texto) {
        int cuenta = 0;
        for (int i = 0; i < numRutinas; i++) {
            if (rutinas[i].getNombre().toLowerCase().contains(texto.toLowerCase())) {
                cuenta++;
            }
        }
        Rutina[] resultado = new Rutina[cuenta];
        int pos = 0;
        for (int i = 0; i < numRutinas; i++) {
            if (rutinas[i].getNombre().toLowerCase().contains(texto.toLowerCase())) {
                resultado[pos] = rutinas[i];
                pos++;
            }
        }
        return resultado;
    }

    /**
     * Guarda las rutinas en un archivo de texto
     * @param nombreArchivo nombre del archivo donde se va aguardar el catalogo
     * @throws IOException devuelve IOException cuando no se puede escribir
     */
    public void guardarRutinasEnArchivo(String nombreArchivo) throws IOException {
        try (FileWriter fileWriter = new FileWriter(nombreArchivo, StandardCharsets.UTF_8)) {
            for (int i = 0; i < numRutinas; i++) {
                fileWriter.write(rutinas[i].toRawString());
            }
        }
    }

    public void cargarRutinasDeArchivo(String nombreArchivo, int maxEjercicios, int maxEstiramientos) throws IOException {
        // Carga las rutinas desde un archivo de texto y las añade al catálogo
        try(FileWriter fw = new FileWriter(nombreArchivo, StandardCharsets.UTF_8)) {
            for(int i = 0; i < numRutinas; i++) {
                fw.write(rutinas[i].toRawString());
            }
        }
    }

    /**
     * Comprueba si el catálogo de rutinas está completo
     * @return true si el catalogo tiene todas sus posiciones ocupadas
     */
    public boolean catalogoCompleto() {
        return numRutinas == rutinas.length;
    }

    /**
     * @return Devuelve el número de rutinas en el catálogo
     */
    public int numRutinas() {
        return numRutinas;
    }

    /**
     * Elimina una rutina del catálogo
     * @param seleccionada rutina que se desea eliminar
     */
    public void eliminarRutina(Rutina seleccionada) {
        int pos = -1;
        for (int i = 0; i < numRutinas; i++) {
            if (rutinas[i] == seleccionada) {
                pos = i;
            }
        }
        if (pos != -1) {
            for (int i = pos; i < numRutinas - 1; i++) {
                rutinas[i] = rutinas[i + 1];
            }
            numRutinas--;
            }
        }
    }
