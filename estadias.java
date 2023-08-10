package Rest;
import static Scan.MyScan.*;

import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class estadias {
    
     //UPDATES
     public static void estadiasUpdate(String url, String username, String password, String codigo, String fechaInicio, String FechaFin, String Proyecto, String Alumno, int Asesor){
        int ans;
        int anss;
        int other;
        String ansss;

        do{
            System.out.println("Ingresa el campo que deseas actualizar: \n"
                            + "1. codigo\n"
                            + "2. fechaInicio\n"
                            + "3. FechaFin\n"
                            + "4. Proyectos\n"
                            + "5. Alumnos\n"
                            + "6. Asesores\n"
                            + "7. Salir");
                            ans = scanInt();
                            scanLine();

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
                                            String query = "UPDATE estadias SET codigo = ? WHERE codigo = ?";
                                            PreparedStatement statement = connection.prepareStatement(query);
                                            statement.setString(1, ansss);
                                            statement.setString(2, codigo);
                                            int rowsAffected = statement.executeUpdate();
                                            statement.close();
                                            connection.close();
                        
                                            if(rowsAffected>0){
                                                System.out.println("El codigo fue actualizado.");
                                            }else {
                                                System.out.println("No se encontro el codigo.");
                                            }
                                        } catch (SQLException e){
                                            System.out.println("Error al actualizar el codigo: " + e.getMessage());
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
                                        System.out.println("Ingresa el codigo: ");
                                        codigo = scanLine();
                                        System.out.println("Ingresa la nueva fecha de inicio: DD/MM/YYYY");
                                        ansss = scanLine();
                                        try{
                                            Connection connection = DriverManager.getConnection(url, username, password);
                                            String query = "UPDATE estadias SET fechaInicio = ? WHERE codigo = ?";
                                            PreparedStatement statement = connection.prepareStatement(query);
                                            statement.setString(1, ansss);
                                            statement.setString(2, codigo);
                                            int rowsAffected = statement.executeUpdate();
                                            statement.close();
                                            connection.close();
                        
                                            if(rowsAffected>0){
                                                System.out.println("La fecha de inicio fue actualizada.");
                                            }else {
                                                System.out.println("No se encontró el registro con relación al codigo.");
                                            }
                                        } catch (SQLException e){
                                            System.out.println("Error al actualizar la fecha de inicio: " + e.getMessage());
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
                                        System.out.println("Ingresa el codigo: ");
                                        codigo = scanLine();
                                        System.out.println("Ingresa la fecha de finalizacion: ");
                                        ansss = scanLine();
                                        try{
                                            Connection connection = DriverManager.getConnection(url, username, password);
                                            String query = "UPDATE estadias SET fechaFin = ? WHERE codigo = ?";
                                            PreparedStatement statement = connection.prepareStatement(query);
                                            statement.setString(1, ansss);
                                            statement.setString(2, codigo);
                                            int rowsAffected = statement.executeUpdate();
                                            statement.close();
                                            connection.close();
                        
                                            if(rowsAffected>0){
                                                System.out.println("La fecha de fin fue actualizada.");
                                            }else {
                                                System.out.println("No se encontró el registro con relación con el codigo.");
                                            }
                                        } catch (SQLException e){
                                            System.out.println("Error al actualizar la fecha de finalizacion: " + e.getMessage());
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
                                        System.out.println("Ingresa el codigo: ");
                                        codigo = scanLine();
                                        System.out.println("Ingresa el codigo del proyecto: ");
                                        ansss = scanLine();
                                        try{
                                            Connection connection = DriverManager.getConnection(url, username, password);
                                            String query = "UPDATE estadias SET Proyecto = ? WHERE codigo = ?";
                                            PreparedStatement statement = connection.prepareStatement(query);
                                            statement.setString(1, ansss);
                                            statement.setString(2, codigo);
                                            int rowsAffected = statement.executeUpdate();
                                            statement.close();
                                            connection.close();
                        
                                            if(rowsAffected>0){
                                                System.out.println("El codigo del proyecto fue actualizado.");
                                            }else {
                                                System.out.println("No se encontró el registro con relación el codigo.");
                                            }
                                        } catch (SQLException e){
                                            System.out.println("Error el codigo del proyecto: " + e.getMessage());
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
                                case 5:
                                    System.out.println("¿Estás seguro de que deseas esta opción?: (1. Si / 2. No)");
                                    anss = scanInt();
                                    scanLine();
                                    if(anss == 1){
                                        System.out.println("Ingresa el codigo: ");
                                        codigo = scanLine();
                                        System.out.println("Ingresa la nueva matricula del alumno: ");
                                        ansss = scanLine();
                                        try{
                                            Connection connection = DriverManager.getConnection(url, username, password);
                                            String query = "UPDATE estadias SET Alumno = ? WHERE codigo = ?";
                                            PreparedStatement statement = connection.prepareStatement(query);
                                            statement.setString(1, ansss);
                                            statement.setString(2, codigo);
                                            int rowsAffected = statement.executeUpdate();
                                            statement.close();
                                            connection.close();
                        
                                            if(rowsAffected>0){
                                                System.out.println("La matricula del alumno fue actualizado.");
                                            }else {
                                                System.out.println("No se encontró el registro con relación al codigo.");
                                            }
                                        } catch (SQLException e){
                                            System.out.println("Error al actualizar la matricula del alumno: " + e.getMessage());
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
                                        System.out.println("Ingresa el codigo: ");
                                        codigo = scanLine();
                                        System.out.println("Ingresa el nuevo número del asesor: ");
                                        ansss = scanLine();
                                        try{
                                            Connection connection = DriverManager.getConnection(url, username, password);
                                            String query = "UPDATE estadias SET Asesore = ? WHERE codigo = ?";
                                            PreparedStatement statement = connection.prepareStatement(query);
                                            statement.setString(1, ansss);
                                            statement.setString(2, codigo);
                                            int rowsAffected = statement.executeUpdate();
                                            statement.close();
                                            connection.close();
                        
                                            if(rowsAffected>0){
                                                System.out.println("El número del asesor fue actualizado.");
                                            }else {
                                                System.out.println("No se encontró el registro con relación al codigo.");
                                            }
                                        } catch (SQLException e){
                                            System.out.println("Error al actualizar el numero del asesor: " + e.getMessage());
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
                                    System.out.println("Opción inválida!, intente de nuevo.");
                                    break;
                            }
                            }while(ans != 9);
}

public static void estadiasInsert(String url, String username, String password, String codigo, String fechaInicio, String FechaFin, String Proyecto, String Alumno, int Asesor){
        
        String ans;
        int anss;
        boolean Correcta = false;

        System.out.println("Ingresa el codigo: ");
        codigo = scanLine();
        System.out.println("Ingresa la fecha de inicio: ");
        fechaInicio = scanLine();
        System.out.println("Ingresa la fecha de fin: ");
        FechaFin = scanLine();
        System.out.println("Ingresa el codigo del proyecto: ");
        Proyecto = scanLine();
        System.out.println("Ingresa la matricula del alumno: ");
        Alumno = scanLine();
        do{
            System.out.println("Ingresa la matricula del alumno: \n" 
                            + "0322103696. Sebastian Corbala Lizarraga  \n" 
                            + "0320130344. Angel Esteban Rojas Villalobos \n" 
                            + "0423243239. Leonela Navarro Gonzales\n" 
                            + "0322103829. Jesus Guadalupe Talla Lerma\n" 
                            + "0322103778. Jesus Esteban Olmos Labastida\n"  
                            + "0234768964. Kevin Ojeda Torres\n" 
                            + "0987452132. Daniela Ackerman Valenzuela\n" 
                            + "0967543422. Miguel Camarena Mendez\n" 
                            + "0378654324. Leslie Camacho Villalobos\n" 
                            + "0789654344. Fabrizio Morales Gasca\n" 
                            + "0977665544. Rodrigo Sanchez Virrelles\n"
                            + "0322103121. Erick Bonilla Soriano \n"
                            + "0322103339. Flores Rincon Russel Yissel\n"
                            + "0787788889. Frida Flores Serrano\n"
                            + "0656677893.  Luis Gomez Xochitl\n"
                            + "0877666666. Joselin Cordoba Escobar\n"
                            + "1. Salir"
                            );
                            ans = scanLine();
        switch(ans){
            case "0322103696":
                System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                anss = scanInt();
                scanLine();
                if(anss == 1){
                    Alumno = "0322103696";
                    Correcta = true;
                } 
                break;
            case "0320130344":
                System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                anss = scanInt();
                scanLine();
                if(anss == 1){
                    Alumno = "0320130344";
                    Correcta = true;
                } 
                break;
            case "0423243239":
                System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                anss = scanInt();
                scanLine();
                if(anss == 1){
                    Alumno = "0423243239";
                    Correcta = true;
                }
                break;
            case "0322103829":
                System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                anss = scanInt();
                scanLine();
                if(anss == 1){
                    Alumno = "0322103829";
                    Correcta = true;
                } 
                break;
            case "0322103778":
                System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                anss = scanInt();
                scanLine();
                if(anss == 1){
                    Alumno = "0322103778";
                    Correcta = true;
                } 
                break;
                case "0234768964":
                System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                anss = scanInt();
                scanLine();
                if(anss == 1){
                    Alumno = "0234768964";
                    Correcta = true;
                } 
                break;
                case "0987452132":
                System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                anss = scanInt();
                scanLine();
                if(anss == 1){
                    Alumno = "0987452132";
                    Correcta = true;
                } 
                break;
                case "0967543422":
                System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                anss = scanInt();
                scanLine();
                if(anss == 1){
                    Alumno = "0967543422";
                    Correcta = true;
                } 
                break;
                case "0378654324":
                System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                anss = scanInt();
                scanLine();
                if(anss == 1){
                    Alumno = "0378654324";
                    Correcta = true;
                }
                break;
                case "0789654344":
                System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                anss = scanInt();
                scanLine();
                if(anss == 1){
                    Alumno = "0789654344";
                    Correcta = true;
                } 
                break;
                case "0977665544":
                System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                anss = scanInt();
                scanLine();
                if(anss == 1){
                    Alumno = "0977665544";
                    Correcta = true;
                } 
                break;
                case "0322103121":
                System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                anss = scanInt();
                scanLine();
                if(anss == 1){
                    Alumno = "0322103121";
                    Correcta = true;
                } 
                break;
                case "0322103339":
                System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                anss = scanInt();
                scanLine();
                if(anss == 1){
                    Alumno = "0322103339";
                    Correcta = true;
                } 
                break;
                case "0787788889":
                System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                anss = scanInt();
                scanLine();
                if(anss == 1){
                    Alumno = "0787788889";
                    Correcta = true;
                } 
                break;
                case "0656677893":
                System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                anss = scanInt();
                scanLine();
                if(anss == 1){
                    Alumno = "0656677893";
                    Correcta = true;
                } 
                break;
                case "0877666666":
                System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                anss = scanInt();
                scanLine();
                if(anss == 1){
                    Alumno = "0877666666";
                    Correcta = true;
                } 
                break;
                case "1":
                System.out.println("Regresando al menú anterior!");
                break;
                default:
                    System.out.println("La opción es inválida. Intente de nuevo!");
                    break;
        }
        } while (!Correcta);

        System.out.println("Ingresa el numero del asesor: ");
        Asesor = scanInt();
        scanLine();
        String ansss;
        //ASESOR
        do{  
            System.out.println("Ingresa el numero del asesor: \n" 
                            + "10. Ivan Alonso Lopez Sanchez  \n" 
                            + "20. Clara Lidia Uyeda \n" 
                            + "30. Humberto Vejar Polanco\n" 
                            + "40. Cleotilde Tenorio Hernandez\n"
                            + "1. Salir");
                            anss = scanInt();
                            scanLine();
            switch(anss){
            case 10:
                System.out.println("¿Estás seguro de que deseas esta opción?: (1. Si / 2. No)");
                anss = scanInt();
                scanLine();
                if(anss == 1){
                    Asesor = 10;
                } 
                break;
            case 20:
                System.out.println("¿Estás seguro de que deseas esta opción?: (1. Si / 2. No)");
                anss = scanInt();
                scanLine();
                if(anss == 1){
                    Asesor = 20;
                } 
                break;
            case 30:
                System.out.println("¿Estás seguro de que deseas esta opción?: (1. Si / 2. No)");
                anss = scanInt();
                scanLine();
                if(anss == 1){
                    Asesor = 30;
                }
                break;
            case 40:
                System.out.println("¿Estás seguro de que deseas esta opción?: (1. Si / 2. No)");
                anss = scanInt();
                scanLine();
                if(anss == 1){
                    Asesor = 40;
                }
                break;
            case 1:
                System.out.println("Regresando al menú anterior!");
                break;
                default:
                    System.out.println("La opción es inválida. Intente de nuevo!");
                    break;
          }
        }while (anss != 1);
               //PROYECTOS
    
                do{  
            System.out.println("Ingresa el codigo del proyecto: \n" 
                            + "A598. Clínica veterinaria  \n" 
                            + "A798. Sistema de gestión de biblioteca \n" 
                            + "A1053. Plataforma de aprendizaje en línea\n" 
                            + "A104. Aplicación de seguimiento de tareas\n"
                            + "1. Salir");
                            ansss = scanLine();
            switch(ansss){
            case "A598":
                System.out.println("¿Estás seguro de la opción elegida?: (S/N)");
                ansss = scanLine().toLowerCase();
                if(ansss.equals("s")){
                    Proyecto = "A598";
                    Correcta = true;
                } 
                break;
            case "A798":
                System.out.println("¿Estás seguro de la opción elegida?: (S/N)");
                ansss = scanLine().toLowerCase();
                if(ansss.equals("s")){
                    Proyecto = "A798";
                    Correcta = true;
                } 
                break;
            case "A1053":
                System.out.println("¿Estás seguro de la opción elegida?: (S/N)");
                ansss = scanLine().toLowerCase();
                if(ansss.equals("s")){
                    Proyecto = "A1053";
                    Correcta = true;
                }
                break;
            case "A104":
                System.out.println("¿Estás seguro de la opción elegida?: (S/N)");
                ansss = scanLine().toLowerCase();
                if(ansss.equals("s")){
                    Proyecto = "A104";
                    Correcta = true;
                }
                break;
            case "1":
                System.out.println("Regresando al menú anterior!");
                break;
                 default:
                    System.out.println("La opción es inválida. Intente de nuevo!");
                    break;
          }
        }while (!Correcta);

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO estadias (codigo, fechaInicio, fechaFin, Proyecto, Alumno, Asesor) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, codigo);
            statement.setString(2, fechaInicio);
            statement.setString(3, FechaFin);
            statement.setString(4, Proyecto);
            statement.setString(5, Alumno);
            statement.setInt(6, Asesor);
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

public static void estadiasDelete(String url, String username, String password, String PK){
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

