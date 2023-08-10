package Rest;
import static Scan.MyScan.*;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;    
import java.util.Date;

public class alumnos {

    //QUERIES
    public static void alumnosQueries(String url, String username, String password, String matricula, String clave, int asesorNum, int month){
        int Choicee;
        do{
            System.out.println("Elige el número de consulta que deseas realizar: \n" + 
                                "1. Estadía empresarial de un alumno\n" +
                                "2. Pagos realizados a un alumno\n" + 
                                /* "3. Proyectos realizados por alumnos de la misma universidad\n" + 
                                "4. Proyectos realizados por alumnos de la misma carrera\n" + 
                                "5. Estadías que ha asesorado un asesor\n" + 
                                "6. Cantidad de pagos por estadía\n" +
                                "7. Carreras de una universidad\n" + */
                                "3. Alumnos que son de la misma universidad\n" +
                                "4. Alumnos de la misma carrera\n" + 
                                //"10. Estadías que iniciaron el mismo mes\n" + 
                                "5. Salir al menú anterior.");
                                Choicee = scanInt();
                                scanLine();

                switch(Choicee){
                    case 1:
                    System.out.println("Ingresa la matrícula del alumno para realizar la consulta: ");
                    matricula = scanLine();
                    consult1(url, username, password, matricula);
                        break;
                    case 2:
                    System.out.println("Ingresa la matrícula del alumno para realizar la consulta: ");
                    matricula = scanLine();
                    consult2(url, username, password, matricula);
                        break;
                    /*case 3:
                    System.out.println("Ingresa la clave de la universidad para realizar la consulta: ");
                    clave = scanLine();
                    consult3(url, username, password, clave);
                        break;
                    case 4:
                    System.out.println("Ingresa la clave de la carrera para realizar la consulta: ");
                    clave = scanLine();
                    consult4(url, username, password, clave);
                        break;
                    case 5:
                    System.out.println(" --------------------------------------------- ");
                    System.out.println("Ingresa el número del Asesor para la consulta: ");
                    asesorNum = scanInt();
                    scanLine();
                    consult5(url, username, password, asesorNum);
                        break;
                    case 6:
                    System.out.println(" --------------------------------------------- ");
                    consult6(url, username, password);
                        break;
                    case 7:
                    System.out.println(" --------------------------------------------- ");
                    System.out.println("Ingresa la clave de la universidad para realizar la consulta: ");
                    clave = scanLine();
                    consult7(url, username, password, clave);
                        break; */
                    case 3:
                    System.out.println(" --------------------------------------------- ");
                    System.out.println("Ingresa la clave de la universidad para realizar la consulta: ");
                    clave = scanLine();
                    consult8(url, username, password, clave);
                        break;
                    case 4:
                    System.out.println(" --------------------------------------------- ");
                    System.out.println("Ingresa la clave de la Carrera para realizar la consulta: ");
                    clave = scanLine();
                    consult9(url, username, password, clave);
                        break;
                    /*case 10:
                    System.out.println(" --------------------------------------------- ");
                    System.out.println("Ingresa el número de mes para consultar: ");
                    month = scanInt();
                    consult10(url, username, password, month);
                        break;*/
                    case 5:
                    System.out.println("¡Regresando al menú anterior!");
                        break;
                    default:
                    System.out.println("Opción inválida!, intenta de nuevo.");
                        break;
                }
        }while(Choicee != 11);
    }
            
    

    

    //UPDATES
    public static void alumnosUpdate(String url, String username, String password, String matricula){
        int ans;
        int anss;
        int other;
        String ansss;

        do{
            System.out.println("Ingresa el campo que deseas actualizar: \n"
                            + "1. matricula\n"
                            + "2. nombre\n"
                            + "3. apPaterno\n"
                            + "4. apMaterno\n"
                            + "5. correoElect\n"
                            + "6. numTel\n"
                            + "7. Universidad\n"
                            + "8. Carrera\n"
                            + "9. Salir");
                            ans = scanInt();
                            scanLine();
        switch(ans){
        case 1:
            System.out.println("¿Estás seguro de que deseas esta opción?: (1. Si / 2. No)");
            anss = scanInt();
            scanLine();
            if(anss == 1){
                System.out.println("Ingresa la matrícula actual: ");
                matricula = scanLine();
                System.out.println("Ingresa la nueva matrícula: ");
                ansss = scanLine();
                try{
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String query = "UPDATE alumnos SET matricula = ? WHERE matricula = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, ansss);
                    statement.setString(2, matricula);
                    int rowsAffected = statement.executeUpdate();
                    statement.close();
                    connection.close();

                    if(rowsAffected>0){
                        System.out.println("La matrícula fue actualizada.");
                    }else {
                        System.out.println("No se encontró la matrícula.");
                    }
                } catch (SQLException e){
                    System.out.println("Error al actualizar la matrícula: " + e.getMessage());
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
                System.out.println("Ingresa la matrícula: ");
                matricula = scanLine();
                System.out.println("Ingresa el nuevo nombre: ");
                ansss = scanLine();
                try{
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String query = "UPDATE alumnos SET nombre = ? WHERE matricula = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, ansss);
                    statement.setString(2, matricula);
                    int rowsAffected = statement.executeUpdate();
                    statement.close();
                    connection.close();

                    if(rowsAffected>0){
                        System.out.println("El nombre fue actualizado.");
                    }else {
                        System.out.println("No se encontró el registro con relación a la matrícula.");
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
                System.out.println("Ingresa la matrícula: ");
                matricula = scanLine();
                System.out.println("Ingresa el nuevo apellido paterno: ");
                ansss = scanLine();
                try{
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String query = "UPDATE alumnos SET apPaterno = ? WHERE matricula = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, ansss);
                    statement.setString(2, matricula);
                    int rowsAffected = statement.executeUpdate();
                    statement.close();
                    connection.close();

                    if(rowsAffected>0){
                        System.out.println("El apellido paterno fue actualizado.");
                    }else {
                        System.out.println("No se encontró el registro con relación a la matrícula.");
                    }
                } catch (SQLException e){
                    System.out.println("Error al actualizar el apellido paterno: " + e.getMessage());
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
            System.out.println("¿Estás seguro de que deseas esta opción?: (1. Si / 2. No)");
            anss = scanInt();
            scanLine();
            if(anss == 1){
                System.out.println("Ingresa la matrícula: ");
                matricula = scanLine();
                System.out.println("Ingresa el nuevo apellido materno: ");
                ansss = scanLine();
                try{
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String query = "UPDATE alumnos SET apMaterno = ? WHERE matricula = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, ansss);
                    statement.setString(2, matricula);
                    int rowsAffected = statement.executeUpdate();
                    statement.close();
                    connection.close();

                    if(rowsAffected>0){
                        System.out.println("El apellido materno fue actualizado.");
                    }else {
                        System.out.println("No se encontró el registro con relación a la matrícula.");
                    }
                } catch (SQLException e){
                    System.out.println("Error al actualizar el apellido materno: " + e.getMessage());
                }
            }
            System.out.println("¿Desearías actualizar otro campo? (1. Si / 2. No)");
            other = scanInt();
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
                System.out.println("Ingresa la matrícula: ");
                matricula = scanLine();
                System.out.println("Ingresa el nuevo correo electrónico: ");
                ansss = scanLine();
                try{
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String query = "UPDATE alumnos SET correoElect = ? WHERE matricula = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, ansss);
                    statement.setString(2, matricula);
                    int rowsAffected = statement.executeUpdate();
                    statement.close();
                    connection.close();

                    if(rowsAffected>0){
                        System.out.println("El correo electrónico fue actualizado.");
                    }else {
                        System.out.println("No se encontró el registro con relación a la matrícula.");
                    }
                } catch (SQLException e){
                    System.out.println("Error al actualizar el correo electrónico: " + e.getMessage());
                }
            }
            System.out.println("¿Desearías actualizar otro campo? (1. Si / 2. No)");
            other = scanInt();
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
                System.out.println("Ingresa la matrícula: ");
                matricula = scanLine();
                System.out.println("Ingresa el nuevo número de teléfono: ");
                ansss = scanLine();
                try{
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String query = "UPDATE alumnos SET numTel = ? WHERE matricula = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, ansss);
                    statement.setString(2, matricula);
                    int rowsAffected = statement.executeUpdate();
                    statement.close();
                    connection.close();

                    if(rowsAffected>0){
                        System.out.println("El número de teléfono fue actualizado.");
                    }else {
                        System.out.println("No se encontró el registro con relación a la matrícula.");
                    }
                } catch (SQLException e){
                    System.out.println("Error al actualizar el número de teléfono: " + e.getMessage());
                }
            }
            System.out.println("¿Desearías actualizar otro campo? (1. Si / 2. No)");
            other = scanInt();
        if(other == 1){
            break;
        } else {
            return;
        }
        case 7:
            System.out.println("¿Estás seguro de que deseas esta opción?: (1. Si / 2. No)");
            anss = scanInt();
            scanLine();
            if(anss == 1){
                System.out.println("Ingresa la matrícula: ");
                matricula = scanLine();
                System.out.println("Ingresa la nueva clave de la Universidad: ");
                ansss = scanLine();
                try{
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String query = "UPDATE alumnos SET Universidad = ? WHERE matricula = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, ansss);
                    statement.setString(2, matricula);
                    int rowsAffected = statement.executeUpdate();
                    statement.close();
                    connection.close();

                    if(rowsAffected>0){
                        System.out.println("La clave de la Universidad fue actualizada.");
                    }else {
                        System.out.println("No se encontró el registro con relación a la matrícula.");
                    }
                } catch (SQLException e){
                    System.out.println("Error al actualizar la clave: " + e.getMessage());
                }
            }
            System.out.println("¿Desearías actualizar otro campo? (1. Si / 2. No)");
            other = scanInt();
        if(other == 1){
            break;
        } else {
            return;
        }
        case 8:
            System.out.println("¿Estás seguro de que deseas esta opción?: (1. Si / 2. No)");
            anss = scanInt();
            scanLine();
            if(anss == 1){
                System.out.println("Ingresa la matrícula: ");
                matricula = scanLine();
                System.out.println("Ingresa la nueva clave de la Carrera: ");
                ansss = scanLine();
                try{
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String query = "UPDATE alumnos SET Carrera = ? WHERE matricula = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, ansss);
                    statement.setString(2, matricula);
                    int rowsAffected = statement.executeUpdate();
                    statement.close();
                    connection.close();

                    if(rowsAffected>0){
                        System.out.println("La clave de la Carrera fue actualizada.");
                    }else {
                        System.out.println("No se encontró el registro con relación a la matrícula.");
                    }
                } catch (SQLException e){
                    System.out.println("Error al actualizar la clave: " + e.getMessage());
                }
            }
            System.out.println("¿Desearías actualizar otro campo? (1. Si / 2. No)");
            other = scanInt();
        if(other == 1){
            break;
        } else {
            return;
        }
        case 9:
            System.out.println("Regresando al menú anterior!");
            break;
        default:
            System.out.println("Opción inválida, intente de nuevo!");
            break;
        }
        }while(ans != 9);
    }

    //DELETES
    public static void alumnosDelete(String url, String username, String password, String PK){
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

    public static String getCol(String tabla, Scanner scan) {
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
    public static void alumnosInsert(String url, String username, String password, String matricula, String nombre, String apPaterno, String apMaterno, String correoElect, String numTel, String Universidad, String Carrera){
                
        int ans;
        int anss;

        System.out.println(" ----------- Insertando datos del alumno ----------- ");
        System.out.println("Ingresa la matrícula del alumno: ");
        matricula = scanLine();
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
        do{
            System.out.println("Ingresa la opción de tu Universidad de procedencia de la siguiente tabla: \n" 
                            + "1. Universidad de las Californias\n" 
                            + "2. Universidad del Desarrollo Profesional Plantel Tijuana\n" 
                            + "3. Universidad Tecnologica de Tijuana \n" 
                            + "4. Centro de Estudios Superiores del Noroeste\n" 
                            + "5. Instituto Tecnológico de Tijuana \n"  
                            + "6. Universidad Autónoma de Baja California, Campus Tijuana\n" 
                            + "7. Universidad Interamericana para el Desarrollo Sede Tijuana\n" 
                            + "8. University of Advanced Technologies Tijuana\n" 
                            + "9. Tecnológico de Baja California, Campus Tijuana\n" 
                            + "10. Universidad de Tijuana Campus Tijuana\n" 
                            + "11. Centro de Enseñanza Técnica y Superior, Campus Tijuana\n"
                            + "12. Regresar al memú anterior.");
                            ans = scanInt();
                            scanLine();
        switch(ans){
            case 1:
                System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                anss = scanInt();
                scanLine();
                if(anss == 1){
                    Universidad = "UDC";
                } 
                break;
            case 2:
                System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                anss = scanInt();
                scanLine();
                if(anss == 1){
                    Universidad = "UNIDEP";
                } 
                break;
            case 3:
                System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                anss = scanInt();
                scanLine();
                if(anss == 1){
                    Universidad = "UTT";
                }
                break;
            case 4:
                System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                anss = scanInt();
                scanLine();
                if(anss == 1){
                    Universidad = "CESN";
                } 
                break;
            case 5:
                System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                anss = scanInt();
                scanLine();
                if(anss == 1){
                    Universidad = "ITT";
                    break;
                } 
                
                case 6:
                System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                anss = scanInt();
                scanLine();
                if(anss == 1){
                    Universidad = "UABC";
                } 
                break;
                case 7:
                System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                anss = scanInt();
                scanLine();
                if(anss == 1){
                    Universidad = "UNID";
                } 
                break;
                case 8:
                System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                anss = scanInt();
                scanLine();
                if(anss == 1){
                    Universidad = "UNIAT";
                } 
                break;
                case 9:
                System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                anss = scanInt();
                scanLine();
                if(anss == 1){
                    Universidad = "TBC";
                }
                break;
                case 10:
                System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                anss = scanInt();
                scanLine();
                if(anss == 1){
                    Universidad = "CUT";
                } 
                break;
                case 11:
                System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                anss = scanInt();
                scanLine();
                if(anss == 1){
                    Universidad = "CETYS";
                } 
                break;
                case 12:
                System.out.println("Regresando al menú anterior!");
                break;
                default:
                    System.out.println("La opción es inválida. Intente de nuevo!");
                    break;
        }

        int ansss;
        //OPCIONES DE UDC
        if(ans == 1){
            do {
                System.out.println("Ingresa la opción de la carrera de procedencia de dicha Universidad: \n"
                                + "1. DGE	Diseño gráfico y electrónico\n"
                                + "2. TSI Tecnologías de sistemas inteligentes\n"
                                + "3. Regresar el menú anterior.");
                                anss = scanInt();
                                scanLine();
            switch(anss){
            case 1:
            System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                ansss = scanInt();
                scanLine();
                if(ansss == 1){
                    Carrera = "DSE";
                } 
                break;
            case 2:
            System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                ansss = scanInt();
                scanLine();
                if(ansss == 1){
                    Carrera = "TSI";
                } 
                break;
            case 3:
            System.out.println("Regresando al menú anterior!");
            break;
                default:
                    System.out.println("La opción es inválida. Intente de nuevo!");
                    break;
            } 
            } while (anss != 3);
        }

        //OPCIONES DE UNIDEP
        if(ans == 2){
            do {
                System.out.println("Ingresa la opción de la carrera de procedencia de dicha Universidad: \n"
                                + "1. ICT	Ingeniería en ciberseguridad y telecomunicaciones\n"
                                + "2. IDSA	Ingeniería en desarrollo de software y aplicaciones\n"
                                + "3. LND	licenciatura en negocios digitales\n"
                                + "4. LMDD	licenciatura en marketing y diseño digital\n"
                                + "5. Regresar al menú anterior.");
                                anss = scanInt();
                                scanLine();
            switch(anss){
            case 1:
            System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                ansss = scanInt();
                scanLine();
                if(ansss == 1){
                    Carrera = "ICT";
                } 
                break;
            case 2:
            System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                ansss = scanInt();
                scanLine();
                if(ansss == 1){
                    Carrera = "IDSA";
                } 
                break;
            case 3:
            System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                ansss = scanInt();
                scanLine();
                if(ansss == 1){
                    Carrera = "LND";
                } 
                break;
            case 4:
            System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                ansss = scanInt();
                scanLine();
                if(ansss == 1){
                    Carrera = "LMDD";
                } 
                break;
            case 5:
            System.out.println("Regresando al menú anterior!");
            break;
                default:
                    System.out.println("La opción es inválida. Intente de nuevo!");
                    break;
            }
            } while (anss != 5);
        }

        //OPCIONES DE UTT
        if(ans == 3){
            do{
                System.out.println("Ingresa la opción de la carrera de procedencia de dicha Universidad: \n"
                                + "1. IDGS	Ingeniería en desarrollo y gestion de software\n"
                                + "2. IEVND	Ingenieria en entornos virtuales y negocios digitales\n"
                                + "3. IRIC	Ingenieria en redes inteligentes y ciberseguridad\n"
                                + "4. Regresar al menú anterior.");
                                anss = scanInt();
                                scanLine();
            switch(anss){
            case 1:
            System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                ansss = scanInt();
                scanLine();
                if(ansss == 1){
                    Carrera = "IDGS";
                } 
                break;
            case 2:
            System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                ansss = scanInt();
                scanLine();
                if(ansss == 1){
                    Carrera = "IEVND";
                } 
                break;
            case 3:
            System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                ansss = scanInt();
                scanLine();
                if(ansss == 1){
                    Carrera = "IRIC";
                } 
                break;
            case 4:
            System.out.println("Regresando al menú anterior!");
            break;
                default:
                    System.out.println("La opción es inválida. Intente de nuevo!");
                    break;
            }
            } while (anss != 4);
        }
    


        //OPCIONES DE CESUN
        if(ans == 4){
            do{
                System.out.println("Ingresa la opción de la carrera de procedencia de dicha Universidad: \n"
                                + "1. IM Ingeniería en multimedia\n"
                                + "2. IDS Ingeniería en desarrollo de software\n"
                                + "3. Regresar al menú anterior.");
                                anss = scanInt();
                                scanLine();
            switch(anss){
            case 1:
            System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                ansss = scanInt();
                scanLine();
                if(ansss == 1){
                    Carrera = "IM";
                } 
                break;
            case 2:
            System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                ansss = scanInt();
                scanLine();
                if(ansss == 1){
                    Carrera = "IDS";
                } 
                break;
            case 3:
            System.out.println("Regresando al menú anterior!");
            break;
                default:
                    System.out.println("La opción es inválida. Intente de nuevo!");
                    break;
            } 
            }while (anss != 3);
        }

        //OPCIONES DE ITT
        if(ans == 5){
            do{
                System.out.println("Ingresa la opción de la carrera de procedencia de dicha Universidad: \n"
                                + "1. II Ingeniería en informática\n"
                                + "2. ISC Ingeniería en sistemas computacionales\n"
                                + "3. ITICS Ingeniería en tecnologías de la información y comunicación\n"
                                + "4. Regresar el menú anterior.");
                                anss = scanInt();
                                scanLine();
            switch(anss){
            case 1:
            System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                ansss = scanInt();
                scanLine();
                if(ansss == 1){
                    Carrera = "II";
                } 
                break;
            case 2:
            System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                ansss = scanInt();
                scanLine();
                if(ansss == 1){
                    Carrera = "ISC";
                } 
                break;
            case 3:
            System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                ansss = scanInt();
                scanLine();
                if(ansss == 1){
                    Carrera = "ITICS";
                } 
                break;
            case 4:
            System.out.println("Regresando al menú anterior!");
            break;
                default:
                    System.out.println("La opción es inválida. Intente de nuevo!");
                    break;
            }
            } while (anss != 4);
        }

        //OPCIONES DE UABC
        if(ans == 6){
            do {
                System.out.println("Ingresa la opción de la carrera de procedencia de dicha Universidad: \n"
                                + "1. IC Ingeniería en computación\n"
                                + "2. ISTE Ingeniería en software y tecnologías emergentes\n"
                                + "3. IDG Ingeniería en diseño gráfico\n"
                                + "4. LSC Licenciado en sistemas computacionales");
                                anss = scanInt();
                                scanLine();
            switch(anss){
            case 1:
            System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                ansss = scanInt();
                scanLine();
                if(ansss == 1){
                    Carrera = "IC";
                }
                break;
            case 2:
            System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                ansss = scanInt();
                scanLine();
                if(ansss == 1){
                    Carrera = "ISTE";
                } 
                break;
            case 3:
            System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                ansss = scanInt();
                scanLine();
                if(ansss == 1){
                    Carrera = "IDG";
                } 
                break;
            case 4:
            System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                ansss = scanInt();
                scanLine();
                if(ansss == 1){
                    Carrera = "LSC";
                } 
                break;
            case 5:
            System.out.println("Regresando al menú anterior!");
            break;
                default:
                    System.out.println("La opción es inválida. Intente de nuevo!");
                    break;
            }
            } while (anss != 5);
        }

        //OPCIONES DE UNID
        if(ans == 7){
            do {
                System.out.println("Ingresa la opción de la carrera de procedencia de dicha Universidad: \n"
                                + "1. ISSC Ingeniería de software y sistemas computacionales\n"
                                + "2. Regresar al menú anterior.");
                                anss = scanInt();
                                scanLine();
            switch(anss){
            case 1:
            System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                ansss = scanInt();
                scanLine();
                if(ansss == 1){
                    Carrera = "ISSC";
                } 
                break;
            case 2: 
            System.out.println("Regresando al menú anterior!");
            break;
                default:
                    System.out.println("La opción es inválida. Intente de nuevo!");
                    break;
            } 
            } while (anss != 2);
        }

        //OPCIONES UNIAT
        if(ans == 8){
            do {
                System.out.println("Ingresa la opción de la carrera de procedencia de dicha Universidad: \n"
                                + "1. LCAD Licenciatura en cine y animación digital\n"
                                + "2. LNIA Licenciatura en negocios en inteligencia artificial\n"
                                + "3. IPV Ingeniería en programación de videojuegos\n"
                                + "4. LA3D Licenciatura en arquitectura 3D\n"
                                + "5. LMD Licenciatura en marketing digital\n"
                                + "6. IDST Ingeniería en desarrollo de software\n"
                                + "7. INTA Ingeniería en negocios de tecnologías avanzadas\n"
                                + "8. Regresar al menú anterior");
                                anss = scanInt();
                                scanLine();
            switch(anss){
            case 1:
            System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                ansss = scanInt();
                scanLine();
                if(ansss == 1){
                    Carrera = "LCAD";
                } 
                break;
            case 2:
            System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                ansss = scanInt();
                scanLine();
                if(ansss == 1){
                    Carrera = "LNIA";
                } 
                break;
            case 3:
            System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                ansss = scanInt();
                scanLine();
                if(ansss == 1){
                    Carrera = "IPV";
                } 
                break;
            case 4:
            System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                ansss = scanInt();
                scanLine();
                if(ansss == 1){
                    Carrera = "LA3D";
                } 
                break;
            case 5:
            System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                ansss = scanInt();
                scanLine();
                if(ansss == 1){
                    Carrera = "LMD";
                } 
                break;
            case 6:
            System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                ansss = scanInt();
                scanLine();
                if(ansss == 1){
                    Carrera = "IDST";
                } 
                break;
            case 7:
            System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                ansss = scanInt();
                scanLine();
                if(ansss == 1){
                    Carrera = "INTA";
                } 
                break;
            case 8:
            System.out.println("Regresando al menú anterior!");
            break;
                default:
                    System.out.println("La opción es inválida. Intente de nuevo!");
                    break;
            }
            } while (anss != 8);
        }

        //OPCIONES DE TBC
        if(ans == 9){
            do {
                System.out.println("Ingresa la opción de la carrera de procedencia de dicha Universidad: \n"
                                + "1. IDSF Ingeniería en desarrollo de software\n"
                                + "2. Regresar al menú anterior.");
                                anss = scanInt();
                                scanLine();
            switch(anss){
            case 1:
            System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                ansss = scanInt();
                scanLine();
                if(ansss == 1){
                    Carrera = "IDSF";
                } 
                break;
            case 2:
            System.out.println("Regresando al menú anterior!");
            break;
                default:
                    System.out.println("La opción es inválida. Intente de nuevo!");
                    break;
            } 
            } while (anss != 2);
        }

        //OPCIONES DE CUT
        if(ans == 10){
            do{
                System.out.println("Ingresa la opción de la carrera de procedencia de dicha Universidad: \n"
                                + "1. ITIC Ingeniería en tecnologías de la información y comunicación\n"
                                + "2. DG Diseño gráfico\n"
                                + "3. Regresar al menú anterior.");
                                anss = scanInt();
            switch(anss){
            case 1:
            System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                ansss = scanInt();
                scanLine();
                if(ansss == 1){
                    Carrera = "ITIC";
                } 
                break;
            case 2:
            System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                ansss = scanInt();
                scanLine();
                if(ansss == 1){
                    Carrera = "DG";
                } 
                break;
                default:
                    System.out.println("La opción es inválida. Intente de nuevo!");
                    break;
            } 
            }while (anss != 2);
        }

        //OPCIONES DE CETYS
        if(ans == 11){
            do{
                System.out.println("Ingresa la opción de la carrera de procedencia de dicha Universidad: \n"
                                + "1. ICC Ingeniería en ciencias computacionales\n"
                                + "2. IDGD Ingeniería en diseño gráfico digital\n"
                                + "3. IS Ingeniería en software\n"
                                + "4. Regresar el menú anterior");
                                anss = scanInt();
            switch(anss){
            case 1:
            System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                ansss = scanInt();
                scanLine();
                if(ansss == 1){
                    Carrera = "ICC";
                } 
                break;
            case 2:
            System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                ansss = scanInt();
                scanLine();
                if(ansss == 1){
                    Carrera = "IDGD";
                } 
                break;
            case 3:
            System.out.println("¿Estás seguro de la opción elegida?: (1. Si / 2. No)");
                ansss = scanInt();
                scanLine();
                if(ansss == 1){
                    Carrera = "IS";
                } 
                break;
            case 4:
            System.out.println("Regresando al menú anterior!");
            break;
                default:
                    System.out.println("La opción es inválida. Intente de nuevo!");
                    break;
            }
            } while (anss != 4);
        }
        } while (ans != 12);

        

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO alumnos (matricula, nombre, apPaterno, apMaterno, correoElect, numTel, Universidad, Carrera) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, matricula);
            statement.setString(2, nombre);
            statement.setString(3, apPaterno);
            statement.setString(4, apMaterno);
            statement.setString(5, correoElect);
            statement.setString(6, numTel);
            statement.setString(7, Universidad);
            statement.setString(8, Carrera);
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

    public static void consult1(String url, String username, String password, String matricula){
        try {
                // Establecer la conexión con la base de datos
                Connection conexion = DriverManager.getConnection(url, username, password);
    
                // Crear el statement
                PreparedStatement statement = conexion.prepareStatement(
                        "SELECT a.matricula AS Matricula, " +
                                "concat(ifnull(concat(a.nombre,' '),' '), ifnull(concat(a.apPaterno,' '),' '), ifnull(concat(a.apMaterno,' '),' ')) AS \"Nombre del alumno\", " +
                                "u.nombre AS \"Nombre de la universidad\", " +
                                "c.nombre AS \"Nombre de la carrera\", " +
                                "p.nombre AS \"Nombre del proyecto asignado\", " +
                                "concat(ifnull(concat(asr.nombre,' '),' '), ifnull(concat(asr.apPaterno,' '),' '), ifnull(concat(asr.apMaterno,' '),' ')) AS \"Nombre del asesor\", " +
                                "date_format(e.fechaInicio, \"%d-%m-%Y\") AS \"Fecha Inicio\", " +
                                "date_format(e.fechaFin, \"%d-%m-%Y\") AS \"Fecha Final\" " +
                                "FROM Estadias AS e " +
                                "INNER JOIN Alumnos AS a ON e.Alumno = a.matricula " +
                                "INNER JOIN Universidades AS u ON a.Universidad = u.clave " +
                                "INNER JOIN Carreras AS c ON a.Carrera = c.clave " +
                                "INNER JOIN Proyectos AS p ON e.Proyecto = p.codigo " +
                                "INNER JOIN Asesores AS asr ON e.Asesor = asr.numero " +
                                "WHERE a.matricula = ?");
                statement.setString(1, matricula);
                ResultSet resultSet = statement.executeQuery();
    
                // Obtener los resultados
                List<String[]> results = new ArrayList<>();
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                while (resultSet.next()) {
                    String[] row = new String[columnCount];
                    for (int i = 1; i <= columnCount; i++) {
                        String value = resultSet.getString(i);
                        row[i - 1] = value;
                    }
                    results.add(row);
                }
    
                // Cerrar el statement y la conexión
                statement.close();
                conexion.close();
    
                // Imprimir la tabla utilizando listas y párrafos
                List<List<String>> headers = new ArrayList<>();
                headers.add(List.of("Matricula", "Nombre del alumno", "Nombre de la universidad", "Nombre de la carrera", "Nombre del proyecto asignado", "Nombre del asesor", "Fecha Inicio", "Fecha Final"));
                List<List<String>> rows = new ArrayList<>();
                for (String[] row : results) {
                    List<String> rowData = new ArrayList<>();
                    for (String value : row) {
                        rowData.add(value);
                    }
                    rows.add(rowData);
                }
                int[] columnWidths = new int[]{20, 40, 40, 40, 40, 40, 20, 20};
                printHeader(headers, columnWidths);
                printLine(columnWidths);
                for (List<String> row : rows) {
                    printRow(row, columnWidths);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
        public static void printHeader(List<List<String>> headers, int[] columnWidths) {
            for (List<String> headerRow : headers) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < headerRow.size(); i++) {
                    String value = headerRow.get(i);
                    int width = columnWidths[i];
                    sb.append(String.format("| %-" + width + "s ", value));
                }
                sb.append("|");
                System.out.println(sb.toString());
            }
        }
    
        public static void printRow(List<String> row, int[] columnWidths) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < row.size(); i++) {
                String value = row.get(i);
                int width = columnWidths[i];
                sb.append(String.format("| %-" + width + "s ", wrapText(value, width)));
            }
            sb.append("|");
            System.out.println(sb.toString());
        }
    
        public static void printLine(int[] columnWidths) {
            StringBuilder sb = new StringBuilder();
            for (int width : columnWidths) {
                sb.append(String.format("+%-" + width + "s", "").replace(' ', '-'));
            }
            sb.append("+");
            System.out.println(sb.toString());
        }
    
        public static String wrapText(String text, int width) {
            StringBuilder sb = new StringBuilder();
            int start = 0;
            int end = width;
            while (start < text.length()) {
                if (end >= text.length()) {
                    sb.append(text.substring(start));
                    break;
                }
                int spaceIndex = text.lastIndexOf(' ', end);
                if (spaceIndex == -1) {
                    sb.append(text.substring(start, end));
                    sb.append("\n");
                    start = end;
                    end += width;
                } else {
                    sb.append(text.substring(start, spaceIndex));
                    sb.append("\n");
                    start = spaceIndex + 1;
                    end = start + width;
                }
            }
            return sb.toString().trim();
        }

        public static void displayAlumnosMenu(String url, String username, String password) {
    
    
            try {
                // Establish the connection with the database
                Connection conexion = DriverManager.getConnection(url, username, password);
            
                // Create the statement
                Statement statement = conexion.createStatement();
            
                // Execute the query
                String query = "SELECT matricula, nombre FROM Alumnos";
                ResultSet resultSet = statement.executeQuery(query);
            
                // Get the results
                List<String[]> results = new ArrayList<>();
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                while (resultSet.next()) {
                    String[] row = new String[columnCount];
                    for (int i = 1; i <= columnCount; i++) {
                        String value = resultSet.getString(i);
                        row[i - 1] = value;
                    }
                    results.add(row);
                }
            
                // Close the statement and the connection
                statement.close();
                conexion.close();
            
                // Print the menu using lists and paragraphs
                System.out.println("Menu de Alumnos:");
                for (String[] row : results) {
                    System.out.println("- " + row[0] + ": " + row[1]);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    public static void consult2(String url, String username, String password, String matricula){
        try {
            // Establish the connection with the database
            Connection conexion = DriverManager.getConnection(url, username, password);
        
            // Create the statement
            Statement statement = conexion.createStatement();
        
            // Execute the query
            String query = "SELECT a.matricula AS \"Matricula del alumno\", " +
                "concat(ifnull(concat(a.nombre,' '),' '), " +
                "ifnull(concat(a.apPaterno,' '),' '), " +
                "ifnull(concat(a.apMaterno,' '),' ')) AS \"Nombre del alumno\", " +
                "p.nombre AS \"Nombre del proyecto\", " +
                "pa.numero AS \"Numero del pago\", " +
                "date_format(pa.fechaPago, \"%d-%m-%Y\") AS \"Fecha del pago\", " +
                "pa.concepto AS \"Concepto del pago\", " +
                "pa.cantidad AS \"Monto del pago\" " +
                "FROM Alumnos AS a " +
                "INNER JOIN Estadias AS e ON a.matricula=e.Alumno " +
                "INNER JOIN Pagos AS pa ON pa.Estadia=e.codigo " +
                "INNER JOIN Proyectos AS p ON p.codigo=e.Proyecto " +
                "WHERE a.matricula='" + matricula + "'";
            ResultSet resultSet = statement.executeQuery(query);
        
            // Get the results
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            List<String[]> results = new ArrayList<>();
            while (resultSet.next()) {
                String[] row = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    String value = resultSet.getString(i);
                    row[i - 1] = value;
                }
                results.add(row);
            }
        
            // Close the statement and the connection
            statement.close();
            conexion.close();
        
            // Print the results using lists and paragraphs
            System.out.println("Resultados:");
            System.out.println("- Matricula del alumno: " + matricula);
            System.out.println("- Nombre del alumno: " + results.get(0)[1]);
            System.out.println("- Pagos:");
            for (String[] row : results) {
                System.out.println("  - Numero del pago: " + row[3]);
                System.out.println("    Fecha del pago: " + row[4]);
                System.out.println("    Concepto del pago: " + row[5]);
                System.out.println("    Monto del pago: " + row[6]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void consult3(String url, String username, String password, String clave){
        try {
            // Establish the connection with the database
            Connection conexion = DriverManager.getConnection(url, username, password);

            // Create the statement
            Statement statement = conexion.createStatement();

            // Execute the query
            String query = "SELECT u.nombre AS \"Nombre de la universidad\", " +
                    "concat(ifnull(concat(a.nombre,' '),' '), " +
                    "ifnull(concat(a.apPaterno,' '),' '), " +
                    "ifnull(concat(a.apMaterno,' '),' ')) AS \"Nombre del alumno\", " +
                    "p.nombre AS \"Nombre del proyecto\", " +
                    "p.descripcion AS \"Descripcion del proyecto\", " +
                    "concat(ifnull(concat(asr.nombre,' '),' '), " +
                    "ifnull(concat(asr.apPaterno,' '),' '), " +
                    "ifnull(concat(asr.apMaterno,' '),' ')) AS \"Nombre del asesor\", " +
                    "date_format(e.fechaInicio, \"%d-%m-%Y\") AS \"Fecha Inicio\", " +
                    "date_format(e.fechaFin, \"%d-%m-%Y\") AS \"Fecha Final\" " +
                    "FROM Estadias AS e " +
                    "INNER JOIN Alumnos AS a ON e.Alumno=a.matricula " +
                    "INNER JOIN Universidades AS u ON a.Universidad=u.clave " +
                    "INNER JOIN Proyectos AS p ON e.Proyecto=p.codigo " +
                    "INNER JOIN Asesores AS asr ON e.Asesor=asr.numero " +
                    "WHERE u.clave=" + clave;
            ResultSet resultSet = statement.executeQuery(query);

            // Get the results
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            List<String[]> results = new ArrayList<>();
            while (resultSet.next()) {
                String[] row = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    String value = resultSet.getString(i);
                    row[i - 1] = value;
                }
                results.add(row);
            }

            // Close the statement and the connection
            statement.close();
            conexion.close();

            // Print the results using lists and paragraphs
            System.out.println("Resultados:");
            System.out.println("- Clave de la universidad: " + clave);
            System.out.println("- Nombre de la universidad: " + results.get(0)[0]);
            System.out.println("- Proyectos:");
            for (String[] row : results) {
                System.out.println("  - Nombre del proyecto: " + row[2]);
                System.out.println("    Descripcion del proyecto: " + row[3]);
                System.out.println("    Alumno: " + row[1]);
                System.out.println("    Asesor: " + row[4]);
                System.out.println("    Fecha Inicio: " + row[5]);
                System.out.println("    Fecha Final: " + row[6]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void uniMenu(String url, String username, String password){
        try {
            // Establish the connection with the database
            Connection conexion = DriverManager.getConnection(url, username, password);

            // Create the statement
            Statement statement = conexion.createStatement();

            // Execute the query
            String query = "SELECT clave, nombre FROM Universidades";
            ResultSet resultSet = statement.executeQuery(query);

            // Get the results
            List<String[]> results = new ArrayList<>();
            while (resultSet.next()) {
                String clave = resultSet.getString("clave");
                String nombre = resultSet.getString("nombre");
                String[] row = {clave, nombre};
                results.add(row);
            }

            // Close the statement and the connection
            statement.close();
            conexion.close();

            // Print the menu using lists and paragraphs
            System.out.println("Menu de Universidades:");
            for (String[] row : results) {
                System.out.println("- " + row[0] + ": " + row[1]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void carMenu(String url, String username, String password){
        try {
            // Establecer la conexión con la base de datos
            Connection conexion = DriverManager.getConnection(url, username, password);

            // Crear el statement
            Statement statement = conexion.createStatement();

            // Ejecutar la consulta
            String query = "SELECT DISTINCT clave, nombre FROM Carreras";
            ResultSet resultSet = statement.executeQuery(query);

            // Obtener los resultados
            List<String[]> results = new ArrayList<>();
            while (resultSet.next()) {
                String clave = resultSet.getString("clave");
                String nombre = resultSet.getString("nombre");
                String[] row = {clave, nombre};
                results.add(row);
            }

            // Cerrar el statement y la conexión
            statement.close();
            conexion.close();

            // Imprimir la tabla utilizando listas y párrafos
            List<List<String>> headers = new ArrayList<>();
            headers.add(List.of("Clave", "Nombre"));
            List<List<String>> rows = new ArrayList<>();
            for (String[] row : results) {
                List<String> rowData = new ArrayList<>();
                for (String value : row) {
                    rowData.add(value);
                }
                rows.add(rowData);
            }
            int[] columnWidths = new int[]{20, 40};
            printHeader(headers, columnWidths);
            printLine(columnWidths);
            for (List<String> row : rows) {
                printRow(row, columnWidths);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    public static void consult4(String url, String username, String password, String clave){
        try {
            // Establish the connection with the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create the statement
            Statement statement = connection.createStatement();

            // Execute the query
            String query = "SELECT c.nombre AS \"Nombre de la carrera\", " +
                    "concat(ifnull(concat(a.nombre,' '),' '), " +
                    "ifnull(concat(a.apPaterno,' '),' '), " +
                    "ifnull(concat(a.apMaterno,' '),' ')) AS \"Nombre del alumno\", " +
                    "u.nombre AS \"Nombre de la universidad\", " +
                    "p.nombre AS \"Nombre del proyecto\", " +
                    "p.descripcion AS \"Descripcion del proyecto\", " +
                    "concat(ifnull(concat(asr.nombre,' '),' '), " +
                    "ifnull(concat(asr.apPaterno,' '),' '), " +
                    "ifnull(concat(asr.apMaterno,' '),' ')) AS \"Nombre del asesor\", " +
                    "date_format(e.fechaInicio, \"%d-%m-%Y\") AS \"Fecha Inicio\", " +
                    "date_format(e.fechaFin, \"%d-%m-%Y\") AS \"Fecha Final\" " +
                    "FROM Estadias AS e " +
                    "INNER JOIN Alumnos AS a ON e.Alumno=a.matricula " +
                    "INNER JOIN Carreras AS c ON a.Carrera=c.clave " +
                    "INNER JOIN Universidades AS u ON a.Universidad=u.clave " +
                    "INNER JOIN Proyectos AS p ON e.Proyecto=p.codigo " +
                    "INNER JOIN Asesores AS asr ON e.Asesor=asr.numero " +
                    "WHERE a.Carrera='" + clave + "'";
            ResultSet resultSet = statement.executeQuery(query);

            // Get the results
            List<String[]> results = new ArrayList<>();
            while (resultSet.next()) {
                String carrera = resultSet.getString("Nombre de la carrera");
                String alumno = resultSet.getString("Nombre del alumno");
                String universidad = resultSet.getString("Nombre de la universidad");
                String proyecto = resultSet.getString("Nombre del proyecto");
                String descripcion = resultSet.getString("Descripcion del proyecto");
                String asesor = resultSet.getString("Nombre del asesor");
                String fechaInicio = resultSet.getString("Fecha Inicio");
                String fechaFin = resultSet.getString("Fecha Final");
                String[] row = {carrera, alumno, universidad, proyecto, descripcion, asesor, fechaInicio, fechaFin};
                results.add(row);
            }

            // Close the statement and the connection
            statement.close();
            connection.close();

            // Print the results using lists and paragraphs
            System.out.println("Resultados:");
            for (String[] row : results) {
                System.out.println("- Carrera: " + row[0]);
                System.out.println("  Alumno: " + row[1]);
                System.out.println("  Universidad: " + row[2]);
                System.out.println("  Proyecto: " + row[3]);
                System.out.println("  Descripcion: " + row[4]);
                System.out.println("  Asesor: " + row[5]);
                System.out.println("  Fecha Inicio: " + row[6]);
                System.out.println("  Fecha Final: " + row[7]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void consult5(String url, String username, String password, int asesorNum){
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            String query = "SELECT\n" +
                    "concat(ifnull(concat(a.nombre,' '),' '),\n" +
                    "   ifnull(concat(a.apPaterno,' '),' '),\n" +
                    "   ifnull(concat(a.apMaterno,' '),' ')\n" +
                    " ) as \"Nombre del asesor\",\n" +
                    " p.nombre as \"Nombre del proyecto\",\n" +
                    " date_format(e.fechaInicio, \"%d-%m-%Y\") as \"Fecha Inicio\",\n" +
                    " date_format(e.fechaFin, \"%d-%m-%Y\") as \"Fecha Final\",\n" +
                    "concat(ifnull(concat(al.nombre,' '),' '),\n" +
                    "   ifnull(concat(al.apPaterno,' '),' '),\n" +
                    "   ifnull(concat(al.apMaterno,' '),' ')\n" +
                    " ) as \"Nombre del alumno\",\n" +
                    "u.nombre as \"Nombre de la universidad\",\n" +
                    "c.nombre as \"Nombre de la carrera\",\n" +
                    "e.codigo as \"Codigo de estadia\"\n" +
                    "from Estadias as e\n" +
                    "inner join Asesores as a on e.Asesor = a.numero\n" +
                    "inner join Proyectos as p on e.Proyecto = p.codigo\n" +
                    "inner join Alumnos as al on e.Alumno = al.matricula\n" +
                    "inner join Universidades as u on al.Universidad = u.clave\n" +
                    "inner join Carreras as c on al.Carrera = c.clave\n" +
                    "where e.Asesor = " + asesorNum;

            ResultSet resultSet = statement.executeQuery(query);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

            while (resultSet.next()) {
                String nombreAsesor = resultSet.getString("Nombre del asesor");
                String nombreProyecto = resultSet.getString("Nombre del proyecto");
                Date fechaInicio = dateFormat.parse(resultSet.getString("Fecha Inicio"));
                Date fechaFin = dateFormat.parse(resultSet.getString("Fecha Final"));
                String nombreAlumno = resultSet.getString("Nombre del alumno");
                String nombreUniversidad = resultSet.getString("Nombre de la universidad");
                String nombreCarrera = resultSet.getString("Nombre de la carrera");
                String codigoEstadia = resultSet.getString("Codigo de estadia");

                System.out.println("Nombre del asesor: " + nombreAsesor);
                System.out.println("Nombre del proyecto: " + nombreProyecto);
                System.out.println("Fecha Inicio: " + dateFormat.format(fechaInicio));
                System.out.println("Fecha Final: " + dateFormat.format(fechaFin));
                System.out.println("Nombre del alumno: " + nombreAlumno);
                System.out.println("Nombre de la universidad: " + nombreUniversidad);
                System.out.println("Nombre de la carrera: " + nombreCarrera);
                System.out.println("Codigo de estadia: " + codigoEstadia);
                System.out.println("-----------------------------------------");
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static void consult6(String url, String username, String password){

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            String query = "select \n" +
                    "e.codigo as \"Codigo de la estadia\",\n" +
                    "p.nombre as \"Nombre del proyecto\",\n" +
                    "concat(ifnull(concat(a.nombre,' '),' '),\n" +
                    "   ifnull(concat(a.apPaterno,' '),' '),\n" +
                    "   ifnull(concat(a.apMaterno,' '),' ')\n" +
                    " ) as \"Nombre del alumno\",\n" +
                    " COUNT(pa.numero) as \"Cantidad de pagos realizados\"\n" +
                    "from Estadias as e\n" +
                    "inner join Proyectos as p on e.Proyecto=p.codigo\n" +
                    "inner join Alumnos as a on e.Alumno=a.matricula\n" +
                    "inner join Pagos as pa on pa.Estadia=e.codigo\n" +
                    "group by e.codigo, p.nombre, concat(ifnull(concat(a.nombre,' '),' '),\n" +
                    "   ifnull(concat(a.apPaterno,' '),' '),\n" +
                    "   ifnull(concat(a.apMaterno,' '),' ')\n" +
                    " )";

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String codigoEstadia = resultSet.getString("Codigo de la estadia");
                String nombreProyecto = resultSet.getString("Nombre del proyecto");
                String nombreAlumno = resultSet.getString("Nombre del alumno");
                int cantidadPagos = resultSet.getInt("Cantidad de pagos realizados");

                System.out.println("Codigo de la estadia: " + codigoEstadia);
                System.out.println("Nombre del proyecto: " + nombreProyecto);
                System.out.println("Nombre del alumno: " + nombreAlumno);
                System.out.println("Cantidad de pagos realizados: " + cantidadPagos);
                System.out.println("-----------------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void consult7(String url, String username, String password, String clave){
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            String query = "SELECT u.nombre AS \"Nombre de la universidad\", c.nombre AS \"Nombre de la carrera\"\n" +
                    "FROM Universidades AS u\n" +
                    "INNER JOIN UNI_CARRERAS AS uc ON u.clave = uc.Universidad\n" +
                    "INNER JOIN Carreras AS c ON uc.Carrera = c.clave\n" +
                    "WHERE u.clave = " + clave;

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String nombreUniversidad = resultSet.getString("Nombre de la universidad");
                String nombreCarrera = resultSet.getString("Nombre de la carrera");

                System.out.printf("| %-30s | %-30s |\n", nombreUniversidad, nombreCarrera);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void consult8(String url, String username, String password, String clave){
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            String query = "select\n" +
                    "u.nombre as \"Nombre de la universidad\",\n" +
                    "concat(ifnull(concat(a.nombre,' '),' '),\n" +
                    "   ifnull(concat(a.apPaterno,' '),' '),\n" +
                    "   ifnull(concat(a.apMaterno,' '),' ')\n" +
                    " ) as \"Nombre del alumno\",\n" +
                    "c.nombre as \"Nombre de la carrera\"\n" +
                    "from Alumnos as a\n" +
                    "inner join Universidades as u on a.Universidad=u.clave\n" +
                    "inner join UNI_CARRERAS as uc on u.clave=uc.Universidad\n" +
                    "inner join Carreras as c on uc.Carrera=c.clave\n" +
                    "where a.Universidad=" + clave;

            ResultSet resultSet = statement.executeQuery(query);

            ArrayList<String[]> tableData = new ArrayList<>();

            while (resultSet.next()) {
                String nombreUniversidad = resultSet.getString("Nombre de la universidad");
                String nombreAlumno = resultSet.getString("Nombre del alumno");
                String nombreCarrera = resultSet.getString("Nombre de la carrera");

                String[] rowData = {nombreUniversidad, nombreAlumno, nombreCarrera};
                tableData.add(rowData);
            }

            displayTable(tableData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void displayTable(ArrayList<String[]> tableData) {
        System.out.println("Nombre de la universidad\tNombre del alumno\tNombre de la carrera");
        System.out.println("-----------------------------------------");

        for (String[] rowData : tableData) {
            for (String cellData : rowData) {
                System.out.print(cellData + "\t\t");
            }
            System.out.println();
        }

    }

    public static void consult9(String url, String username, String password, String clave){
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            String query = "select\n" +
                    "c.nombre as \"Nombre de la carrera\",\n" +
                    "concat(ifnull(concat(a.nombre,' '),' '),\n" +
                    "   ifnull(concat(a.apPaterno,' '),' '),\n" +
                    "   ifnull(concat(a.apMaterno,' '),' ')\n" +
                    " ) as \"Nombre del alumno\",\n" +
                    "u.nombre as \"Nombre de la universidad\"\n" +
                    "from Alumnos as a\n" +
                    "inner join Universidades as u on a.Universidad=u.clave\n" +
                    "inner join UNI_CARRERAS as uc on u.clave=uc.Universidad\n" +
                    "inner join Carreras as c on uc.Carrera=c.clave\n" +
                    "where a.Carrera=" + clave;

            ResultSet resultSet = statement.executeQuery(query);

            ArrayList<String[]> tableData = new ArrayList<>();

            while (resultSet.next()) {
                String nombreCarrera = resultSet.getString("Nombre de la carrera");
                String nombreAlumno = resultSet.getString("Nombre del alumno");
                String nombreUniversidad = resultSet.getString("Nombre de la universidad");

                String[] rowData = {nombreCarrera, nombreAlumno, nombreUniversidad};
                tableData.add(rowData);
            }

            displayTable2(tableData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void displayTable2(ArrayList<String[]> tableData) {
        System.out.println("Nombre de la carrera\tNombre del alumno\tNombre de la universidad");
        System.out.println("-----------------------------------------");

        for (String[] rowData : tableData) {
            for (String cellData : rowData) {
                System.out.print(cellData + "\t\t");
            }
            System.out.println();
        }
}

    public static void consult10(String url, String username, String password, int month){
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            String query = "select\n" +
                    "date_format(e.fechaInicio, \"%d-%m-%Y\") as \"Fecha Inicio\",\n" +
                    "e.codigo as \"Codigo de la estadia\",\n" +
                    "p.nombre as \"Nombre del proyecto\",\n" +
                    "concat(ifnull(concat(a.nombre,' '),' '),\n" +
                    "   ifnull(concat(a.apPaterno,' '),' '),\n" +
                    "   ifnull(concat(a.apMaterno,' '),' ')\n" +
                    " ) as \"Nombre del alumno\",\n" +
                    " concat(ifnull(concat(asr.nombre,' '),' '),\n" +
                    "   ifnull(concat(asr.apPaterno,' '),' '),\n" +
                    "   ifnull(concat(asr.apMaterno,' '),' ')\n" +
                    " ) as \"Nombre del asesor\"\n" +
                    " from Estadias as e\n" +
                    " inner join Proyectos as p on e.Proyecto=p.codigo\n" +
                    " inner join Alumnos as a on e.Alumno=a.matricula\n" +
                    " inner join Asesores as asr on e.Asesor=asr.numero\n" +
                    " where month(e.fechaInicio)=" + month;

            ResultSet resultSet = statement.executeQuery(query);

            ArrayList<String[]> tableData = new ArrayList<>();

            while (resultSet.next()) {
                String fechaInicio = resultSet.getString("Fecha Inicio");
                String codigoEstadia = resultSet.getString("Codigo de la estadia");
                String nombreProyecto = resultSet.getString("Nombre del proyecto");
                String nombreAlumno = resultSet.getString("Nombre del alumno");
                String nombreAsesor = resultSet.getString("Nombre del asesor");

                String[] rowData = {fechaInicio, codigoEstadia, nombreProyecto, nombreAlumno, nombreAsesor};
                tableData.add(rowData);
            }

            displayTable3(tableData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void displayTable3(ArrayList<String[]> tableData) {
        System.out.println("Fecha Inicio\tCodigo de la estadia\tNombre del proyecto\tNombre del alumno\tNombre del asesor");
        System.out.println("----------------------------------------------------------------------------------------------");

        for (String[] rowData : tableData) {
            for (String cellData : rowData) {
                System.out.print(cellData + "\t\t");
            }
            System.out.println();
        }

}
}





    


    

    




/*
 * public static void consul(String url, String username, String password, int numero){
        try {
            // Establish the connection with the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create the statement
            Statement statement = connection.createStatement();

            // Execute the query
            String query = "SELECT concat(ifnull(concat(a.nombre,' '),' '), " +
                    "ifnull(concat(a.apPaterno,' '),' '), " +
                    "ifnull(concat(a.apMaterno,' '),' ')) AS \"Nombre del asesor\", " +
                    "p.nombre AS \"Nombre del proyecto\", " +
                    "date_format(e.fechaInicio, \"%d-%m-%Y\") AS \"Fecha Inicio\", " +
                    "date_format(e.fechaFin, \"%d-%m-%Y\") AS \"Fecha Final\", " +
                    "concat(ifnull(concat(al.nombre,' '),' '), " +
                    "ifnull(concat(al.apPaterno,' '),' '), " +
                    "ifnull(concat(al.apMaterno,' '),' ')) AS \"Nombre del alumno\", " +
                    "u.nombre AS \"Nombre de la universidad\", " +
                    "c.nombre AS \"Nombre de la carrera\", " +
                    "e.codigo AS \"Codigo de estadia\" " +
                    "FROM Estadias AS e " +
                    "INNER JOIN Asesores AS a ON e.Asesor = a.numero " +
                    "INNER JOIN Proyectos AS p ON e.Proyecto = p.codigo " +
                    "INNER JOIN Alumnos AS al ON e.Alumno = al.matricula " +
                    "INNER JOIN Universidades AS u ON al.Universidad = u.clave " +
                    "INNER JOIN Carreras AS c ON al.Carrera = c.clave " +
                    "WHERE e.Asesor = " + numero;
            ResultSet resultSet = statement.executeQuery(query);

            // Get the results
            List<String[]> results = new ArrayList<>();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()) {
                String[] row = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    String value = resultSet.getString(i);
                    row[i - 1] = value;
                }
                results.add(row);
            }

            // Close the statement and the connection
            statement.close();
            connection.close();

            // Print the results using a table
            printTable(results);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 */

