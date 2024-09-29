package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.UUID;
import javax.swing.JTable;
import javax.swing.JTextField;
import vistas.jfrBarbero;


public class mdlBarbero {
    
    ////////////////////////1- Parametros
    private String Nombre;
    private int Edad;
    private double Peso;
    private String Correo;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public double getPeso() {
        return Peso;
    }

    public void setPeso(double Peso) {
        this.Peso = Peso;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    
    ///////////////////////// Métodos
public void Guardar() {
    // Creamos una variable igual a ejecutar el método de la clase de conexión
    Connection conexion = ClaseConexion.getConexion();
    try {
        // Variable que contiene la Query a ejecutar
        String sql = "INSERT INTO tbBarbero(UUID_Barbero, Nombre_Barbero, Edad_Barbero, Peso_Barbero, Correo_Barbero) VALUES (?, ?, ?, ?, ?)";
        
        // Creamos el PreparedStatement que ejecutará la Query
        PreparedStatement pstmt = conexion.prepareStatement(sql);
        
        // Establecer valores de la consulta SQL
        pstmt.setString(1, UUID.randomUUID().toString());  // UUID_Barbero
        pstmt.setString(2, getNombre());  // Nombre_Barbero
        pstmt.setInt(3, getEdad());  // Edad_Barbero
        pstmt.setDouble(4, getPeso());  // Peso_Barbero 
        pstmt.setString(5, getCorreo());  // Correo_Barbero

        // Ejecutar la consulta
        pstmt.executeUpdate();

    } catch (SQLException ex) {
        System.out.println("Este es el error en el modelo: método Guardar " + ex);
    }
}

public void Mostrar(JTable tabla) { 
    // Creamos una variable de la clase de conexión
    Connection conexion = ClaseConexion.getConexion();
    
    // Definimos el modelo de la tabla
    DefaultTableModel modelo = new DefaultTableModel();
    
    // Establecemos las columnas del modelo de la tabla
    modelo.setColumnIdentifiers(new Object[]{"UUID_Barbero", "Nombre_Barbero", "Edad_Barbero", "Peso_Barbero", "Correo_Barbero"});
    
    try {
        // Consulta a ejecutar
        String query = "SELECT * FROM tbBarbero";
        
        // Creamos un Statement
        Statement statement = conexion.createStatement();
        
        // Ejecutamos el Statement con la consulta y lo asignamos a una variable de tipo ResultSet
        ResultSet rs = statement.executeQuery(query);
        
        // Recorremos el ResultSet
        while (rs.next()) {
            // Llenamos el modelo por cada vez que recorremos el ResultSet
            modelo.addRow(new Object[]{
                rs.getString("UUID_Barbero"), 
                rs.getString("Nombre_Barbero"), 
                rs.getInt("Edad_Barbero"), 
                rs.getDouble("Peso_Barbero"), 
                rs.getString("Correo_Barbero")
            });
        }
        
        // Asignamos el nuevo modelo lleno a la tabla
        tabla.setModel(modelo);
        
        // Ajustamos la primera columna (UUID_Barbero) para que no sea visible
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(0).setWidth(0);
        
    } catch (Exception e) {
        System.out.println("Este es el error en el modelo, método Mostrar: " + e);
    }
}

     public void Eliminar(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();

        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();
        //Obtenemos el id de la fila seleccionada

        String miId = tabla.getValueAt(filaSeleccionada, 0).toString();
        //borramos 
        try {
            String sql = "delete from tbBarbero where UUID_Barbero = ?";
            PreparedStatement deleteBarbero = conexion.prepareStatement(sql);
            deleteBarbero.setString(1, miId);
            deleteBarbero.executeUpdate();
        } catch (Exception e) {
            System.out.println("este es el error metodo de eliminar" + e);
        }
    }
     
     public void Actualizar(JTable tabla) {
    // Creamos una variable igual a ejecutar el método de la clase de conexión
    Connection conexion = ClaseConexion.getConexion();

    // Obtenemos qué fila seleccionó el usuario
    int filaSeleccionada = tabla.getSelectedRow();

    if (filaSeleccionada != -1) {
        // Obtenemos el UUID_Barbero de la fila seleccionada
        String miUUID = tabla.getValueAt(filaSeleccionada, 0).toString();

        try {
            // Ejecutamos la Query para actualizar los datos
            String sql = "UPDATE tbBarbero SET Nombre_Barbero = ?, Edad_Barbero = ?, Peso_Barbero = ?, Correo_Barbero = ? WHERE UUID_Barbero = ?";
            PreparedStatement updateBarbero = conexion.prepareStatement(sql);

            // Establecemos los valores que se van a actualizar
            updateBarbero.setString(1, getNombre());        // Nombre_Barbero
            updateBarbero.setInt(2, getEdad());             // Edad_Barbero
            updateBarbero.setDouble(3, getPeso());          // Peso_Barbero 
            updateBarbero.setString(4, getCorreo());        // Correo_Barbero 
            updateBarbero.setString(5, miUUID);             // UUID_Barbero

            // Ejecutamos la actualización
            updateBarbero.executeUpdate();

            // Mensaje de confirmación
            System.out.println("Registro actualizado con éxito");

        } catch (Exception e) {
            System.out.println("Este es el error en el método de actualizar: " + e);
        }
    } else {
        System.out.println("No se ha seleccionado ninguna fila");
    }
}
     
     public void Buscar(JTable tabla, JTextField miTextField) {
    // Creamos una variable igual a ejecutar el método de la clase de conexión
    Connection conexion = ClaseConexion.getConexion();

    // Definimos el modelo de la tabla
    DefaultTableModel modelo = new DefaultTableModel();
    
    // Establecemos las columnas que tendrá el modelo de la tabla
    modelo.setColumnIdentifiers(new Object[]{"UUID_Barbero", "Nombre_Barbero", "Edad_Barbero", "Peso_Barbero", "Correo_Barbero"});
    
    try {
        // Consulta SQL para buscar por nombre usando LIKE
        String sql = "SELECT * FROM tbBarbero WHERE Nombre_Barbero LIKE ? || '%'";
        
        // Preparamos la consulta
        PreparedStatement buscarBarbero = conexion.prepareStatement(sql);
        
        // Establecemos el valor del parámetro de búsqueda (el texto ingresado en miTextField)
        buscarBarbero.setString(1, miTextField.getText());
        
        // Ejecutamos la consulta
        ResultSet rs = buscarBarbero.executeQuery();

        // Recorremos el ResultSet
        while (rs.next()) {
            // Llenamos el modelo por cada registro que encontramos
            modelo.addRow(new Object[]{
                rs.getString("UUID_Barbero"), 
                rs.getString("Nombre_Barbero"), 
                rs.getInt("Edad_Barbero"), 
                rs.getDouble("Peso_Barbero"), 
                rs.getString("Correo_Barbero")
            });
        }

        // Asignamos el nuevo modelo lleno a la tabla
        tabla.setModel(modelo);
        
        // Ocultamos la columna del UUID_Barbero
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(0).setWidth(0);
        
    } catch (Exception e) {
        System.out.println("Este es el error en el modelo, método Buscar: " + e);
    }
}
     
     public void limpiar(jfrBarbero vista) {
        vista.txtNombre.setText("");
        vista.txtEdad.setText("");
        vista.txtPeso.setText("");
        vista.txtCorreo.setText("");
    }

     
     public void cargarDatosTabla(jfrBarbero vista) {
    // Obtén la fila seleccionada
    int filaSeleccionada = vista.tbBarbero.getSelectedRow();

    // Debemos asegurarnos que haya una fila seleccionada antes de acceder a sus valores
    if (filaSeleccionada != -1) {
        // Obtener los valores de la fila seleccionada
        String UUIDDeTb = vista.tbBarbero.getValueAt(filaSeleccionada, 0).toString();
        String NombreDeTB = vista.tbBarbero.getValueAt(filaSeleccionada, 1).toString();
        String EdadDeTb = vista.tbBarbero.getValueAt(filaSeleccionada, 2).toString();
        String PesoDeTB = vista.tbBarbero.getValueAt(filaSeleccionada, 3).toString();
        String CorreoDeTB = vista.tbBarbero.getValueAt(filaSeleccionada, 4).toString();

        // Establecer los valores en los campos de texto de la vista
        vista.txtNombre.setText(NombreDeTB);
        vista.txtEdad.setText(EdadDeTb);
        vista.txtPeso.setText(PesoDeTB);
        vista.txtCorreo.setText(CorreoDeTB);
    }
}
}


