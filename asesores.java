package Rest;
import static Scan.MyScan.*;

import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class asesores {
    /**
     * 
     */
    

    public static void asesoreUpdate(String url, String username, String password, int numero){
        int ans;
        int anss;
        int other;
        String ansss;

        do{
            System.out.println("Ingresa el campo que deseas actualizar: \n"
                            + "1. número\n"
                            + "2. nombre\n"
                            + "3. apPaterno\n"
                            + "4. apMaterno\n"
                            + "5. correoElect\n"
                            + "6. numTel\n"
                            + "7. Salir");
                            ans = scanInt();
                            scanLine();
        switch(ans){
            case 1:
            System.out.println("¿Estás seguro de que deseas esta opción?: (1. Si / 2. No)");
            anss = scanInt();
            scanLine();
            if(anss == 1){
                System.out.println("Ingresa el número actual: ");
                numero = scanInt();
                scanLine();
                System.out.println("Ingresa el nuevo número: ");
                ansss = scanLine();
                try{
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String query = "UPDATE asesor SET número = ? WHERE número = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, ansss);
                    statement.setInt(2, numero);
                    int rowsAffected = statement.executeUpdate();
                    statement.close();
                    connection.close();

                    if(rowsAffected>0){
                        System.out.println("El número fue actualizada.");
                    }else {
                        System.out.println("No se encontró el número.");
                    }
                } catch (SQLException e){
                    System.out.println("Error al actualizar el número: " + e.getMessage());
                }
                
            }
            System.out.println("¿Desearías actualizar otro campo? (1. Si / 2. No)");
            other = scanInt();
            scanLine();
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
                System.out.println("Ingresa el número: ");
                numero = scanInt();
                scanLine();
                System.out.println("Ingresa el nuevo nombre: ");
                ansss = scanLine();
                try{
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String query = "UPDATE asesor SET nombre = ? WHERE número = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, ansss);
                    statement.setInt(2, numero);
                    int rowsAffected = statement.executeUpdate();
                    statement.close();
                    connection.close();

                    if(rowsAffected>0){
                        System.out.println("El nombre fue actualizado.");
                    }else {
                        System.out.println("No se encontró el registro con relación a el número.");
                    }
                } catch (SQLException e){
                    System.out.println("Error al actualizar el nombre: " + e.getMessage());
                }
                
            }
            System.out.println("¿Desearías actualizar otro campo? (1. Si / 2. No)");
            other = scanInt();
            scanLine();
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
                System.out.println("Ingresa el número: ");
                numero = scanInt();
                scanLine();
                System.out.println("Ingresa el nuevo apellido paterno: ");
                ansss = scanLine();
                try{
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String query = "UPDATE asesor SET apPaterno = ? WHERE número = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, ansss);
                    statement.setInt(2, numero);
                    int rowsAffected = statement.executeUpdate();
                    statement.close();
                    connection.close();

                    if(rowsAffected>0){
                        System.out.println("El apellido paterno fue actualizado.");
                    }else {
                        System.out.println("No se encontró el registro con relación a el número.");
                    }
                } catch (SQLException e){
                    System.out.println("Error al actualizar el apellido paterno: " + e.getMessage());
                }
                
            }
            System.out.println("¿Desearías actualizar otro campo? (1. Si / 2. No)");
            other = scanInt();
            scanLine();
        if(other == 1){
            break;
        } else {
            return;
        }
        case 4:
        System.out.println("¿Estás seguro de que deseas esta opción?: (1. Si / 2. No)");
        anss = scanInt();
        scanLine();
            if(anss == 1){
                System.out.println("Ingresa el número: ");
                numero = scanInt();
                scanLine();
                System.out.println("Ingresa el nuevo apellido materno: ");
                ansss = scanLine();
                try{
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String query = "UPDATE asesor SET apMaterno = ? WHERE número = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, ansss);
                    statement.setInt(2, numero);
                    int rowsAffected = statement.executeUpdate();
                    statement.close();
                    connection.close();

                    if(rowsAffected>0){
                        System.out.println("El apellido materno fue actualizado.");
                    }else {
                        System.out.println("No se encontró el registro con relación a el número.");
                    }
                } catch (SQLException e){
                    System.out.println("Error al actualizar el apellido materno: " + e.getMessage());
                }
                
            }
            System.out.println("¿Desearías actualizar otro campo? (1. Si / 2. No)");
            other = scanInt();
        if(other == 1){
            scanLine();
            break;
        } else {
            return;
        }
        case 5:
        System.out.println("¿Estás seguro de que deseas esta opción?: (1. Si / 2. No)");
        anss = scanInt();
        scanLine();
            if(anss == 1){
                System.out.println("Ingresa el número: ");
                numero = scanInt();
                scanLine();
                System.out.println("Ingresa el nuevo correo electrónico: ");
                ansss = scanLine();
                try{
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String query = "UPDATE asesor SET correoElect = ? WHERE número = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, ansss);
                    statement.setInt(2, numero);
                    int rowsAffected = statement.executeUpdate();
                    statement.close();
                    connection.close();

                    if(rowsAffected>0){
                        System.out.println("El correo electrónico fue actualizado.");
                    }else {
                        System.out.println("No se encontró el registro con relación a el numero.");
                    }
                } catch (SQLException e){
                    System.out.println("Error al actualizar el correo electrónico: " + e.getMessage());
                }
                
            }
            System.out.println("¿Desearías actualizar otro campo? (1. Si / 2. No)");
            other = scanInt();
            scanLine();
        if(other == 1){
            break;
        } else {
            return;
        }
        case 6:
        System.out.println("¿Estás seguro de que deseas esta opción?: (1. Si / 2. No)");
        anss = scanInt();
        scanLine();
            if(anss == 1){
                System.out.println("Ingresa el número: ");
                numero = scanInt();
                scanLine();
                System.out.println("Ingresa el nuevo número de teléfono: ");
                ansss = scanLine();
                try{
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String query = "UPDATE asesor SET numTel = ? WHERE número = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, ansss);
                    statement.setInt(2, numero);
                    int rowsAffected = statement.executeUpdate();
                    statement.close();
                    connection.close();

                    if(rowsAffected>0){
                        System.out.println("El número de teléfono fue actualizado.");
                    }else {
                        System.out.println("No se encontró el registro con relación a el número.");
                    }
                } catch (SQLException e){
                    System.out.println("Error al actualizar el número de teléfono: " + e.getMessage());
                }
                
            }
            System.out.println("¿Desearías actualizar otro campo? (1. Si / 2. No)");
            other = scanInt();
            scanLine();
        if(other == 1){
            break;
        } else {
            return;
        }
        case 7:
            System.out.println("Regresando al menú anterior!");
            break;
        default:
            System.out.println("Opción inválida, intente de nuevo!");
            break;
        }
    }while(ans != 7);
   }
   //DELETES
   public static void asesoresDelete(String url, String username, String password, String PK){
    boolean Correct = false;
    do{
        System.out.print("Ingrese el nombre de la tabla para borrar registros: \n"
        + "alumnos\n"
        + "asesores\n"
        + "carreras\n"
        + "estadias\n"
        + "pagos\n"
        + "proyectos\n"
        + "universidades\n");
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
public static void asesoresInsert(String url, String username, String password, int numero, String nombre, String apPaterno, String apMaterno, String correoElect, String numTel){

    System.out.println("Ingresa el número del asesor: ");
    numero = scanInt();
    scanLine();
    System.out.println("Ingresa el nombre de pila: ");
    nombre = scanLine();
    System.out.println("Ingresa el apellido paterno: ");
    apPaterno = scanLine();
    System.out.println("Ingresa el apellido materno: ");
    apMaterno = scanLine();
    System.out.println("Ingresa el correo electrónico: ");
    correoElect = scanLine();
    System.out.println("Ingresa el número de teléfono en el formato '(999) 999-99-99': ");
    numTel = scanLine();
    try {
        Connection connection = DriverManager.getConnection(url, username, password);
        String query = "INSERT INTO asesores (numero, nombre, apPaterno, apMaterno, correoElect, numTel) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, numero);
        statement.setString(2, nombre);
        statement.setString(3, apPaterno);
        statement.setString(4, apMaterno);
        statement.setString(5, correoElect);
        statement.setString(6, numTel);
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