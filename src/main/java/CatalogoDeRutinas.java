import java.io.FileNotFoundException;
import java.io.*;
import java.io.PrintWriter;
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
        boolean agregado = false;
        if (catalogoCompleto()) {
            System.out.println("No se pueden añadir más rutinas.");
        }
        else if (rutina != null){
            rutinas [numRutinas] = rutina;
            numRutinas++;
            agregado = true;
        }
        return agregado;
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
        try (FileWriter fileWriter = new FileWriter(nombreArchivo, StandardCharsets.UTF_8)) {
            for (int i = 0; i < numRutinas; i++) {
                fileWriter.write(rutinas[i].toRawString());
            }
        }
        // Guarda las rutinas en un archivo de texto
    }

    public void cargarRutinasDeArchivo(String nombreArchivo, int maxEjercicios, int maxEstiramientos) throws IOException {
        // Carga las rutinas desde un archivo de texto y las añade al catálogo
       try (BufferedReader bw = new BufferedReader(new InputStreamReader(new FileInputStream(nombreArchivo), StandardCharsets.UTF_8))) {
           String linea = bw.readLine();
           while (linea != null && !catalogoCompleto()) {
               if(!linea.isEmpty()){
                   Rutina nueva = new Rutina(linea, maxEjercicios, maxEstiramientos);
                   linea = bw.readLine();
                   while(linea != null && !linea.equals("ESTIRAMIENTOS")){
                       nueva.agregarEjercicio(linea);
                       linea = bw.readLine();
                   }
                   linea = bw.readLine();
                   while(linea != null && !linea.equals("=====")){
                       nueva.agregarEstiramiento(linea);
                       linea = bw.readLine();
                   }
                   agregarRutina(nueva);
               }
               linea = bw.readLine();
           }
       }
    }

    public boolean catalogoCompleto() {
        // Comprueba si el catálogo de rutinas está completo
        return numRutinas == rutinas.length;
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
