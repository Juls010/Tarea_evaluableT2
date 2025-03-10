package ae_t2;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class main {

    private static final String ARCHIVO = "contactos.txt";
    private static ArrayList<Contacto> contactos = new ArrayList<>();

    public static void main(String[] args) {
        cargarContactos();
        
        while (true) {
            String[] opciones = {"Añadir", "Listar", "Buscar", "Salir"};
            int opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Contactos",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            switch (opcion) {
                case 0: 
                	añadirContacto();
                	break;
                case 1:
                	listarContactos(); 
                	break;
                case 2: 
                	buscarContacto(); 
                	break;
                case 3:
                	guardarContactos();
                	return;
                default: JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private static void cargarContactos() {
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 2) contactos.add(new Contacto(datos[0], datos[1]));
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar: " + e.getMessage());
        }
    }

    private static void guardarContactos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Contacto c : contactos) bw.write(c.getNombre() + "," + c.getTelefono() + "\n");
            JOptionPane.showMessageDialog(null, "Contactos guardados.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar: " + e.getMessage());
        }
    }

    private static void añadirContacto() {
        String nombre = JOptionPane.showInputDialog("Nombre:");
        String telefono = JOptionPane.showInputDialog("Teléfono:");
        if (nombre != null && !nombre.trim().isEmpty() && telefono != null && !telefono.trim().isEmpty()) {
            contactos.add(new Contacto(nombre.trim(), telefono.trim()));
            JOptionPane.showMessageDialog(null, "Contacto añadido.");
        } else {
            JOptionPane.showMessageDialog(null, "Nombre y teléfono no pueden estar vacíos.");
        }
    }

    private static void listarContactos() {
        if (contactos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay contactos.");
        } else {
            StringBuilder lista = new StringBuilder();
            for (Contacto c : contactos) {
                lista.append(c.getNombre()).append(" - ").append(c.getTelefono()).append("\n");
            }
            JOptionPane.showMessageDialog(null, lista.toString());
        }
    }

    private static void buscarContacto() {
        String nombre = JOptionPane.showInputDialog("Nombre a buscar:");
        if (nombre != null && !nombre.trim().isEmpty()) {
            StringBuilder resultado = new StringBuilder();
            for (Contacto c : contactos) {
                if (c.getNombre().toLowerCase().contains(nombre.toLowerCase().trim())) {
                    resultado.append(c.getNombre()).append(" - ").append(c.getTelefono()).append("\n");
                }
            }
            if (resultado.length() == 0) {
                JOptionPane.showMessageDialog(null, "No se encontraron contactos.");
            } else {
                JOptionPane.showMessageDialog(null, resultado.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nombre de búsqueda no puede estar vacío.");
        }
    }
}



