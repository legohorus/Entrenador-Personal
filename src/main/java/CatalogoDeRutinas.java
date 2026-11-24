import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CatalogoDeRutinas {
    private int numRutinas;
    private Rutina[] rutinas;

    public CatalogoDeRutinas(int maxRutinasEnCatalogo) {
        // Inicialización del catálogo de rutinas
        rutinas = new Rutina[maxRutinasEnCatalogo];
        numRutinas = 0;
    }

    public boolean agregarRutina(Rutina rutina) {
        // Añade una rutina al catálogo (si está completo, muestra un mensaje de error)
        if (rutina == null) {
            return true;
        }
        else if (catalogoCompleto()) {
            System.out.print("No se pueden añadir más rutinas.");
            return false;
        }
        else {
            rutinas [numRutinas] = rutina;
            numRutinas++;
            return true;
        }

        // @todo MODIFICAR PARA DEVOLVER SI SE HA AÑADIDO LA RUTINA
    }

    public Rutina[] buscarRutinaPorNombre(String texto) {
        // Busca rutinas cuyo nombre contenga el texto (sin distinguir mayúsculas) y devuelve todas las encontradas
        // @todo MODIFICAR PARA DEVOLVER LAS RUTINAS ENCONTRADAS
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

    public void guardarRutinasEnArchivo(String nombreArchivo) throws IOException {
        // Guarda las rutinas en un archivo de texto
    }

    public void cargarRutinasDeArchivo(String nombreArchivo, int maxEjercicios, int maxEstiramientos) throws IOException {
        // Carga las rutinas desde un archivo de texto y las añade al catálogo
        try(FileWriter fw = new FileWriter(nombreArchivo, StandardCharsets.UTF_8)) {
            for(int i = 0; i < numRutinas; i++) {
                fw.write(rutinas[i].toRawString());
            }
        }
    }

    public boolean catalogoCompleto() {
        // Comprueba si el catálogo de rutinas está completo
        if(numRutinas==rutinas.length){
            return true;
        }
        else{
            return false;
        }
        // @todo MODIFICAR PARA DEVOLVER SI ESTÁ COMPLETO
    }

    public int numRutinas() {
        // Devuelve el número de rutinas en el catálogo
        return numRutinas; // @todo MODIFICAR PARA DEVOLVER EL NÚMERO DE RUTINAS
    }

    public void eliminarRutina(Rutina seleccionada) {
        // Elimina una rutina del catálogo
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
