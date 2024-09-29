package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import modelo.mdlBarbero;
import vistas.jfrBarbero;

public class ctrlBarbero implements MouseListener, KeyListener {

    //////////////////////////2- Parámetros
    private mdlBarbero modelo;
    private jfrBarbero vista;

    //////////////////////////3- Constructor de la clase
    public ctrlBarbero(mdlBarbero modelo, jfrBarbero vista) {
        this.modelo = modelo;
        this.vista = vista;

        // Siempre poner todos los botones que vamos a detectar
        vista.btnGuardar.addMouseListener(this);
        vista.btnEliminar.addMouseListener(this);
        vista.btnActualizar.addMouseListener(this);
        vista.btnLimpiar.addMouseListener(this);
        vista.txtBuscar.addKeyListener(this);
        vista.tbBarbero.addMouseListener(this);

        modelo.Mostrar(vista.tbBarbero);
    }

    ///////////////////////////////////////// Eventos
    @Override
    public void mouseClicked(MouseEvent e) {
        //////////////////////////4- Detección de clics en la vista
        if (e.getSource() == vista.btnGuardar) {
            if (vista.txtNombre.getText().isEmpty() || vista.txtEdad.getText().isEmpty() || vista.txtPeso.getText().isEmpty() || vista.txtCorreo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    // Asignar lo de la vista al modelo
                    modelo.setNombre(vista.txtNombre.getText());
                    modelo.setEdad(Integer.parseInt(vista.txtEdad.getText()));
                    modelo.setPeso(Double.parseDouble(vista.txtPeso.getText())); // Cambiado a Double para Peso
                    modelo.setCorreo(vista.txtCorreo.getText());
                    // Ejecutar el método 
                    modelo.Guardar();
                    modelo.Mostrar(vista.tbBarbero);
                    modelo.limpiar(vista);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(vista, "La edad debe ser un número", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        if (e.getSource() == vista.btnEliminar) {
            if (vista.tbBarbero.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(vista, "Debes seleccionar un registro para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                modelo.Eliminar(vista.tbBarbero);
                modelo.Mostrar(vista.tbBarbero);
                modelo.limpiar(vista);
            }
        }

        if (e.getSource() == vista.btnActualizar) {
            if (vista.tbBarbero.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(vista, "Debes seleccionar un registro para actualizar", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    // Asignar lo de la vista al modelo al momento de darle clic a actualizar
                    modelo.setNombre(vista.txtNombre.getText());
                    modelo.setEdad(Integer.parseInt(vista.txtEdad.getText()));
                    modelo.setPeso(Double.parseDouble(vista.txtPeso.getText())); // Cambiado a Double para Peso
                    modelo.setCorreo(vista.txtCorreo.getText());

                    // Ejecutar el método    
                    modelo.Actualizar(vista.tbBarbero);
                    modelo.Mostrar(vista.tbBarbero);
                    modelo.limpiar(vista);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(vista, "La edad debe ser un número", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        if (e.getSource() == vista.btnLimpiar) {
            modelo.limpiar(vista);
        }

        if (e.getSource() == vista.tbBarbero) {
            modelo.cargarDatosTabla(vista);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vista.txtBuscar) {
            modelo.Buscar(vista.tbBarbero, vista.txtBuscar);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }
}

