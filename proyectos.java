package Rest;
import static Scan.MyScan.*;

import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class proyectos {
     //UPDATES
     public static void proyectosUpdate(String url, String username, String password, String codigo, String nombre, String descripcion){
        int ans;
        int anss;
        int other;
        String ansss;

        do{
            System.out.println("Ingresa el campo que deseas actualizar: \n"
                            + "1. codigo\n"
                            + "2. nombre\n"
                            + "3. descripcion\n"
                            + "4. salir");
                            ans = scanInt();
        switch(ans){
        case 1:
        System.out.println("¿Estás seguro de que deseas esta opción?: (1. Si / 2. No)");
        anss = scanInt();
        scanLine();
        if(anss == 1){
                System.out.println("Ingresa el codigo actual: ");
                codigo = scanLine();
                System.out.println("Ingresa el nuevo codigo: ");
                ansss = scanLine();
                try{
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String query = "UPDATE proyectos SET codigo = ? WHERE codigo = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, ansss);
                    statement.setString(2, codigo);
                    int rowsAffected = statement.executeUpdate();
                    statement.close();
                    connection.close();

                    if(rowsAffected>0){
                        System.out.println("El codigo fue actualizado.");
                    }else {
                        System.out.println("No se encontró el codigo.");
                    }
                } catch (SQLException e){
                    System.out.println("Error al actualizar el codigo: " + e.getMessage());
                }
            }
            System.out.println("¿Desearías actualizar otro campo? (1. Si / 2. No)");
            other = scanInt();
        if(other == 1){
            break;
        } else {
            return;
        }
        case 2:
        System.out.println("¿Estás seguro de que deseas esta opción?: (1. Si / 2. No)");
        anss = scanInt();
        scanLine();
        if(anss == 1){
                System.out.println("Ingresa el codigo: ");
                codigo = scanLine();
                System.out.println("Ingresa el nuevo nombre: ");
                ansss = scanLine();
                try{
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String query = "UPDATE proyectos SET nombre = ? WHERE codigo = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, ansss);
                    statement.setString(2, codigo);
                    int rowsAffected = statement.executeUpdate();
                    statement.close();
                    connection.close();

                    if(rowsAffected>0){
                        System.out.println("El nombre fue actualizado.");
                    }else {
                        System.out.println("No se encontró el registro con relación al codigo.");
                    }
                } catch (SQLException e){
                    System.out.println("Error al actualizar el nombre: " + e.getMessage());
                }
            }
            System.out.println("¿Desearías actualizar otro campo? (1. Si / 2. No)");
            other = scanInt();
        if(other == 1){
            break;
        } else {
            return;
        }
        case 3:
        System.out.println("¿Estás seguro de que deseas esta opción?: (1. Si / 2. No)");
        anss = scanInt();
        scanLine();
        if(anss == 1){
                System.out.println("Ingresa el codigo: ");
                codigo = scanLine();
                System.out.println("Ingresa la nueva descripcion: ");
                ansss = scanLine();
                try{
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String query = "UPDATE proyectos SET descripcion = ? WHERE codigo = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, ansss);
                    statement.setString(2, codigo);
                    int rowsAffected = statement.executeUpdate();
                    statement.close();
                    connection.close();

                    if(rowsAffected>0){
                        System.out.println("La descripcion fue actualizada.");
                    }else {
                        System.out.println("No se encontró el registro con relación al codigo.");
                    }
                } catch (SQLException e){
                    System.out.println("Error al actualizar la descripcion: " + e.getMessage());
                }
            }
            System.out.println("¿Desearías actualizar otro campo? (1. Si / 2. No)");
            other = scanInt();
        if(other == 1){
            break;
        } else {
            return;
        }
        case 4:
            System.out.println("Regresando al menu principal.");
            break;
        default:
            System.out.println("Opción inválida!, intenta de nuevo.");
            break;
        }
        
    }while(ans != 4);
    }

    //DELETES
    public static void proyectosDelete(String url, String username, String password, String PK/*, String codigo, String nombre, String descripcion */){
        boolean Correct = false;
        do{
            System.out.print("Ingrese el nombre de la tabla para borrar registros: \n"
            + "codigo\n"
            + "nombre\n"
            + "descripcion\n"
             );
            String tabla = scanLine();


            if(tabla.equalsIgnoreCase("alumnos") || tabla.equalsIgnoreCase("asesores") || tabla.equalsIgnoreCase("carreras") || tabla.equalsIgnoreCase("estadias") || tabla.equalsIgnoreCase("pagos") || tabla.equalsIgnoreCase("proyectos") || tabla.equalsIgnoreCase("universidades")){
                
                String pkColumn = getCol(tabla, scan);

                System.out.println("Ingrese la llave primaria del registro a borrar: ");
                PK = scanLine();
                try {
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String query = "DELETE FROM " + tabla + " WHERE " + pkColumn + " = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, PK);

                    int filasAfectadas = statement.executeUpdate();

                    statement.close();
                    connection.close();

                    if (filasAfectadas > 0) {
                        System.out.println("El registro se ha borrado correctamente de la tabla " + tabla + ".");
                    } else {
                        System.out.println("No se encontró un registro con el valor de la clave primaria especificado en la tabla " + tabla + ".");
                    }
                } catch (SQLException e) {
                    System.out.println("Error al borrar el registro: " + e.getMessage());
                }
            } else {
                System.out.println("Tabla no válida.");
            }
            System.out.println("¿Deseas eliminar otro registro de otra tabla? (S/N)");
            String ans = scanLine();
            if(!ans.equalsIgnoreCase("S")){
                break;
            }
        }while(!Correct);
    }

    private static String getCol(String tabla, Scanner scan) {
        Map<String, String> columnasPK = new HashMap<>();
        columnasPK.put("alumnos", "matricula");
        columnasPK.put("asesores", "numero");
        columnasPK.put("carreras", "clave"); // Reemplazar "nombre_de_la_columna_pk" con el nombre correcto
        columnasPK.put("estadias", "codigo");
        columnasPK.put("pagos", "numero");
        columnasPK.put("proyectos", "codigo");
        columnasPK.put("universidades", "clave");

        return columnasPK.get(tabla);
    }

    //INSERTS
    public static void proyectosInsert(String url, String username, String password, String codigo, String nombre, String descripcion){
        
        int ans;
        int anss;

        System.out.println("Ingresa el codigo del proyecto: ");
        codigo = scanLine();
        System.out.println("Ingresa el nombre del proyecto: ");
        nombre = scanLine();
        System.out.println("Ingresa la descripcion del proyecto: ");
        descripcion = scanLine();
        
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO proyectos (codigo, nombre, descripcion) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, codigo);
            statement.setString(2, nombre);
            statement.setString(3, descripcion);
            int rowsAffected = statement.executeUpdate();
            statement.close();
            connection.close();

            if(rowsAffected>0){
                System.out.println("Se registró correctamente.");
            } else {
                System.out.println("No se pudo registrar la información.");
            }
        } catch (SQLException e){
            System.out.println("Error al insertar el registro.");
        }

}
}