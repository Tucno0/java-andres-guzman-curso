package org.tucno.java.tarea;

import org.tucno.java.tarea.models.Usuario;
import org.tucno.java.tarea.repository.Repositorio;
import org.tucno.java.tarea.repository.UsuarioRepositorioImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tarea37 {
    public static void main(String[] args) {
        int opcionIndice = 0;

        Map<String, Integer> operaciones = new HashMap<>();
        operaciones.put("Actualizar", 1);
        operaciones.put("Eliminar", 2);
        operaciones.put("Agregar", 3);
        operaciones.put("Listar", 4);
        operaciones.put("Salir", 5);

        Object[] opArreglo = operaciones.keySet().toArray();

        Repositorio<Usuario> repositorio = new UsuarioRepositorioImpl();

        do {
            Object opcion = JOptionPane.showInputDialog(null,
                    "Seleccione un Operación",
                    "Mantenedor de Usuarios",
                    JOptionPane.INFORMATION_MESSAGE, null, opArreglo, opArreglo[0]);

            if (opcion == null) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una operación");
            } else {
                opcionIndice = operaciones.get(opcion.toString());

                switch (opcionIndice) {
                    case 1:
                        // Crea un formulario para actualizar un usuario
                        String userId = JOptionPane.showInputDialog("Ingrese el ID del usuario que desea actualizar");
                        Usuario usuarioActual = repositorio.porId(Long.parseLong(userId));

                        if (usuarioActual != null) {
                            JPanel panel = new JPanel(new GridLayout(0, 1));
                            JTextField usernameField = new JTextField(usuarioActual.getUsername());
                            JTextField passwordField = new JTextField(usuarioActual.getPassword());
                            JTextField emailField = new JTextField(usuarioActual.getEmail());

                            panel.add(new JLabel("Nombre de usuario:"));
                            panel.add(usernameField);
                            panel.add(new JLabel("Contraseña:"));
                            panel.add(passwordField);
                            panel.add(new JLabel("Correo electrónico:"));
                            panel.add(emailField);

                            int result = JOptionPane.showConfirmDialog(null, panel, "Actualizar usuario",
                                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                            if (result == JOptionPane.OK_OPTION) {
                                usuarioActual.setUsername(usernameField.getText());
                                usuarioActual.setPassword(passwordField.getText());
                                usuarioActual.setEmail(emailField.getText());

                                repositorio.actualizar(usuarioActual);
                                JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente");
                            } else {
                                System.out.println("Operación cancelada");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró un usuario con el ID proporcionado");
                        }
                        break;

                    case 2:
                        // Crea un formulario para eliminar un usuario
                        String userIdEliminar = JOptionPane.showInputDialog("Ingrese el ID del usuario que desea eliminar");
                        Usuario usuarioEliminar = repositorio.porId(Long.parseLong(userIdEliminar));

                        if (usuarioEliminar != null) {
                            int result = JOptionPane.showConfirmDialog(null,
                                    "¿Está seguro de que desea eliminar el usuario con ID " + userIdEliminar + "?",
                                    "Eliminar usuario", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

                            if (result == JOptionPane.OK_OPTION) {
                                repositorio.eliminar(usuarioEliminar.getId());
                                JOptionPane.showMessageDialog(null, "Usuario " + usuarioEliminar.getUsername() + " eliminado correctamente");
                            } else {
                                System.out.println("Operación cancelada");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró un usuario con el ID proporcionado");
                        }
                        break;

                    case 3:
                        // Crea un formulario para agregar un nuevo usuario
                        JPanel panel = new JPanel(new GridLayout(0, 1));
                        JTextField usernameField = new JTextField();
                        JTextField passwordField = new JTextField();
                        JTextField emailField = new JTextField();

                        panel.add(new JLabel("Nombre de usuario:"));
                        panel.add(usernameField);
                        panel.add(new JLabel("Contraseña:"));
                        panel.add(passwordField);
                        panel.add(new JLabel("Correo electrónico:"));
                        panel.add(emailField);

                        int result = JOptionPane.showConfirmDialog(null, panel, "Agregar un nuevo usuario",
                                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                        if (result == JOptionPane.OK_OPTION) {
                            Usuario nuevoUsuario = new Usuario();
                            nuevoUsuario.setUsername(usernameField.getText());
                            nuevoUsuario.setPassword(passwordField.getText());
                            nuevoUsuario.setEmail(emailField.getText());

                            repositorio.crear(nuevoUsuario);
                            JOptionPane.showMessageDialog(null, "Usuario agregado correctamente");
                        } else {
                            System.out.println("Operación cancelada");
                        }
                        break;

                    case 4:
                        // Ajusta esto a los campos de tu clase Usuario
                        String[] columnNames = {"ID", "Username", "Password", "Email"};

                        // Obtén los usuarios del repositorio
                        List<Usuario> usuarios = repositorio.listar();

                        // Crea una matriz para los datos de la tabla
                        Object[][] data = new Object[usuarios.size()][columnNames.length];
                        for (int i = 0; i < usuarios.size(); i++) {
                            Usuario usuario = usuarios.get(i);

                            data[i][0] = usuario.getId(); // Ajusta esto a los getters de tu clase Usuario
                            data[i][1] = usuario.getUsername();
                            data[i][2] = usuario.getPassword();
                            data[i][3] = usuario.getEmail();
                        }

                        // Crea el modelo de la tabla
                        DefaultTableModel model = new DefaultTableModel(data, columnNames);

                        // Crea la tabla y configúrala
                        JTable table = new JTable(model);
                        table.setFillsViewportHeight(true);

                        // Crea el JScrollPane y añade la tabla
                        JScrollPane scrollPane = new JScrollPane(table);

                        // Muestra la tabla en un JOptionPane
                        JOptionPane.showMessageDialog(null, scrollPane, "Usuarios", JOptionPane.PLAIN_MESSAGE);
                        break;

                    case 5:
                        JOptionPane.showMessageDialog(null, "Fin del programa");
                        break;
                }
            }
        } while (opcionIndice != 5);
    }
}
