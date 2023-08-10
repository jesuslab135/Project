package Rest;
import static Scan.MyScan.*;

import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class pagos {
    
     //UPDATES
     public static void pagosUpdate(String url, String username, String password, int numero){
        int ans;
        int anss;
        String ansss;
        do{
            System.out.println("Ingresa el campo que deseas actualizar: \n"
                            + "1. numero\n"
                            + "2. fechaPago\n"
                            + "3. cantidad\n"
                            + "4. concepto\n"
                            + "5. estadias\n"
                            + "6. Salir");
                            ans = scanInt();
                            scanLine();
        switch(ans){
        case 1:
            System.out.println("¿Estás seguro de que deseas esta opción?: (1. Si / 2. No)");
            anss = scanInt();
            scanLine();
            if(anss == 1){
                System.out.println("Ingresa el numero actual del pago: ");
                numero = scanInt();
                scanLine();
                System.out.println("Ingresa el nuevo numero: ");
                ansss = scanLine();
                try{
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String query = "UPDATE pagos SET numero = ? WHERE numero = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, ansss);
                    statement.setInt(2, numero);
                    int rowsAffected = statement.executeUpdate();
                    statement.close();
                    connection.close();

                    if(rowsAffected>0){
                        System.out.println("El nuevo numero fue actualizado.");
                    }else {
                        System.out.println("No se encontró el numero.");
                    }
                } catch (SQLException e){
                    System.out.println("Error al actualizar el numero: " + e.getMessage());
                }
                
            }
            break;
        case 2:
            System.out.println("¿Estás seguro de que deseas esta opción?: (1. Si / 2. No)");
            anss = scanInt();
            scanLine();
            if(anss == 1){
                System.out.println("Ingresa el numero: ");
                numero = scanInt();
                scanLine();
                System.out.println("Ingresa la nueva fecha de pago: ");
                ansss = scanLine();
                try{
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String query = "UPDATE pagos SET fechaPago = ? WHERE numero = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, ansss);
                    statement.setInt(2, numero);
                    int rowsAffected = statement.executeUpdate();
                    statement.close();
                    connection.close();

                    if(rowsAffected>0){
                        System.out.println("La fecha de pago fue actualizada.");
                    }else {
                        System.out.println("No se encontró el registro con relación con el numero.");
                    }
                } catch (SQLException e){
                    System.out.println("Error al actualizar la fecha de pago: " + e.getMessage());
                }
                
            }
            break;
        case 3:
            System.out.println("¿Estás seguro de que deseas esta opción?: (1. Si / 2. No)");
            anss = scanInt();
            scanLine();
            if(anss == 1){
                System.out.println("Ingresa el numero: ");
                numero = scanInt();
                scanLine();
                System.out.println("Ingresa la cantidad: ");
                ansss = scanLine();
                try{
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String query = "UPDATE pago SET cantidad = ? WHERE  numero = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, ansss);
                    statement.setInt(2, numero);
                    int rowsAffected = statement.executeUpdate();
                    statement.close();
                    connection.close();

                    if(rowsAffected>0){
                        System.out.println("La cantidad fue actualizada.");
                    }else {
                        System.out.println("No se encontró el registro con relación con el numero.");
                    }
                } catch (SQLException e){
                    System.out.println("Error al actualizar la cantidad: " + e.getMessage());
                }
                
            }
            break;
        case 4:
            System.out.println("¿Estás seguro de que deseas esta opción?: (1. Si / 2. No)");
            anss = scanInt();
            scanLine();
            if(anss == 1){
                System.out.println("Ingresa el numero: ");
                numero = scanInt();
                scanLine();
                System.out.println("Ingresa el nuevo concepto: ");
                ansss = scanLine();
                try{
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String query = "UPDATE pago SET concepto = ? WHERE numero = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, ansss);
                    statement.setInt(2, numero);
                    int rowsAffected = statement.executeUpdate();
                    statement.close();
                    connection.close();

                    if(rowsAffected>0){
                        System.out.println("El concepto fue actualizado.");
                    }else {
                        System.out.println("No se encontró el registro con relación con el numero.");
                    }
                } catch (SQLException e){
                    System.out.println("Error al actualizar el concepto: " + e.getMessage());
                }
                
            }
            break;
        case 5:
            System.out.println("¿Estás seguro de que deseas esta opción?: (1. Si / 2. No)");
            anss = scanInt();
            scanLine();
            if(anss == 1){
                System.out.println("Ingresa el numero: ");
                numero = scanInt();
                scanLine();
                System.out.println("Ingresa el nuevo codigo de la estadia: ");
                ansss = scanLine();
                try{
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String query = "UPDATE pagos SET estadias = ? WHERE numero = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, ansss);
                    statement.setInt(2, numero);
                    int rowsAffected = statement.executeUpdate();
                    statement.close();
                    connection.close();

                    if(rowsAffected>0){
                        System.out.println("El codigo de la estadia fue actualizada.");
                    }else {
                        System.out.println("No se encontró el registro con relación al numero.");
                    }
                } catch (SQLException e){
                    System.out.println("Error al actualizar el codigo de la estadia: " + e.getMessage());
                }
                
            }
            break;
        case 6:
            System.out.println("Regresando al menú anterior!");
            break;
        default:
            System.out.println("Opción inválida!, intenta de nuevo.");
            break;
        }
    }while(ans != 6);
    }

    public static void pagosInsert(String url, String username, String password, int numero, String fechaPago, String cantidad, String concepto, String Estadia){
        
        String ans;
        String anss;
        boolean Correcta = false;

        System.out.println("Ingresa el numero del pago: ");
        numero = scanInt();
        scanLine();
        System.out.println("Ingresa la fecha de pago: ");
        fechaPago = scanLine();
        System.out.println("Ingresa la cantidad: ");
        cantidad = scanLine();
        System.out.println("Ingresa el concepto: ");
        concepto = scanLine();
        System.out.println("Ingresa el codigo de la estadia: ");
        Estadia = scanLine();

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO pagos (numero, fechaPago, cantidad, concepto, Estadia) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, numero);
            statement.setString(2, fechaPago);
            statement.setString(3, cantidad);
            statement.setString(4, concepto);
            statement.setString(5, Estadia);
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
        String ansss;
        //DELETE//
        public static void pagosDelete(String url, String username, String password, String PK){
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
}
 