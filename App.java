package Principal;
import Rest.*;
import static Scan.MyScan.*;

import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import java.sql.DriverManager;

public class App {
    private static final String url = "jdbc:mysql://localhost:3306/estadias2dd";
    private static final String username = "root";
    private static final String password = "";

    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("                    ¡Bienvenido al sistema!                ");
            int mainCh = 0;

            do{
                do{
                try{
                System.out.println(" ----------------------- Menú ------------------------- ");
                System.out.println(" ¡Elige alguna opción por medio de la lista de números! ");
                System.out.println(" ------------------------------------------------------ ");
                System.out.println("1.                      Alumnos                         ");
                System.out.println("2.                      Asesores                        ");
                System.out.println("3.                      Estadías                        ");
                System.out.println("4.                      Pagos                           ");
                System.out.println("5.                      Proyectos                       ");
                System.out.println("6.                      Salir                           ");
                System.out.println(" ------------------------------------------------------ ");
                mainCh = scanInt();
                scanLine();

                switch(mainCh){
                    case 1:
                        AlumnosOps();
                        break;
                    case 2:
                        AsesoresOps();
                        break;
                    case 3:
                        EstadiasOps();
                        break;
                    case 4:
                        PagosOps();
                        break;
                    case 5:
                        ProyectosOps();
                        break;
                    case 6:
                        System.out.println("Gracias por usar el sistema. ¡Nos vemos luego!");
                        break;
                    default:
                    System.out.println("Opción inválida. Por favor, ingresa una opción válida.");
                }
                } catch(InputMismatchException e){
            System.out.println("Opción inválida!, por favor ingresa un número.");
            }
            scanLine();
            }while(mainCh != 6);

            }while(mainCh != 6);

        } 
        catch (SQLException e) {
            e.printStackTrace();
        }    
    } 

        
        
        private static void ProyectosOps(){
            int Choice;
                        proyectos prD = new proyectos();
                        proyectos prU = new proyectos();
                        proyectos prI = new proyectos();
                        alumnos aQ = new alumnos();

                        do{
                        System.out.println(" ---------------------- Proyectos --------------------- ");
                        System.out.println(" ¡Elige alguna opción por medio de la lista de números! ");
                        System.out.println(" ------------------------------------------------------ ");
                        System.out.println("1.                      Consultar                       ");
                        System.out.println("2.                      Insertar                        ");
                        System.out.println("3.                      Actualizar                      ");
                        System.out.println("4.                      Eliminar registros              ");
                        System.out.println("5.                      Salir                           ");
                        System.out.println(" ------------------------------------------------------ ");
                        Choice = scanInt();
                        scanLine();
                            
                            switch(Choice){
                                case 1:
                                aQ.alumnosQueries(url, username, password, url, password, Choice, Choice);
                                break;
                            case 2:
                                prI.proyectosInsert(url, username, password, username, url, password);
                                break;
                            case 3:
                                prU.proyectosUpdate(url, username, password, username, url, password);
                                break;
                            case 4:
                                prD.proyectosDelete(url, username, password, password);
                                break;
                            case 5:
                                System.out.println("¡Regresando al menú principal!");
                                break;
                            default:
                            System.out.println("Opción inválida!, intenta de nuevo.");
                                break;
                            }

                        }while(Choice != 5);
        }

        private static void PagosOps(){
            int Choice;
                        pagos pD = new pagos();
                        pagos pU = new pagos();
                        pagos pI = new pagos();
                        alumnos aQ = new alumnos();

                        do{
                        System.out.println(" ------------------------ Pagos ----------------------- ");
                        System.out.println(" ¡Elige alguna opción por medio de la lista de números! ");
                        System.out.println(" ------------------------------------------------------ ");
                        System.out.println("1.                      Consultar                       ");
                        System.out.println("2.                      Insertar                        ");
                        System.out.println("3.                      Actualizar                      ");
                        System.out.println("4.                      Eliminar registros              ");
                        System.out.println("5.                      Salir                           ");
                        System.out.println(" ------------------------------------------------------ ");
                        Choice = scanInt();
                        scanLine();
                            
                            switch(Choice){
                                case 1:
                                aQ.alumnosQueries(url, username, password, url, password, Choice, Choice);
                                break;
                            case 2:
                                pI.pagosInsert(url, username, password, Choice, password, username, url, password);
                                break;
                            case 3:
                                pU.pagosUpdate(url, username, password, Choice);
                                break;
                            case 4:
                                pD.pagosDelete(url, username, password, password);
                                break;
                            case 5:
                                System.out.println("¡Regresando al menú principal!");
                                break;
                            default:
                            System.out.println("Opción inválida!, intenta de nuevo.");
                                break;
                            }

                        }while(Choice != 5);
        }

        private static void EstadiasOps(){
            int Choice;
                        estadias eD = new estadias();
                        estadias eU = new estadias();
                        estadias eI = new estadias();
                        alumnos aQ = new alumnos();

                        do{
                        System.out.println(" ---------------------- Estadías ---------------------- ");
                        System.out.println(" ¡Elige alguna opción por medio de la lista de números! ");
                        System.out.println(" ------------------------------------------------------ ");
                        System.out.println("1.                      Consultar                       ");
                        System.out.println("2.                      Insertar                        ");
                        System.out.println("3.                      Actualizar                      ");
                        System.out.println("4.                      Eliminar registros              ");
                        System.out.println("5.                      Salir                           ");
                        System.out.println(" ------------------------------------------------------ ");
                        Choice = scanInt();
                        scanLine();
                            
                            switch(Choice){
                                case 1:
                                aQ.alumnosQueries(url, username, password, url, password, Choice, Choice);
                                break;
                            case 2:
                                eI.estadiasInsert(url, username, password, password, password, username, url, password, Choice);
                                break;
                            case 3:
                                eU.estadiasUpdate(url, username, password, password, password, username, url, password, Choice);
                                break;
                            case 4:
                                eD.estadiasDelete(url, username, password, password);
                                break;
                            case 5:
                                System.out.println("¡Regresando al menú principal!");
                                break;
                            default:
                            System.out.println("Opción inválida!, intenta de nuevo.");
                                break;
                            }

                        }while(Choice != 5);
        }

        private static void AsesoresOps(){
            int Choice;
                    asesores asD = new asesores();
                    asesores asU = new asesores();
                    asesores asI = new asesores();
                    alumnos aQ = new alumnos();
                    do{
                        System.out.println(" ---------------------- Asesores ---------------------- ");
                        System.out.println(" ¡Elige alguna opción por medio de la lista de números! ");
                        System.out.println(" ------------------------------------------------------ ");
                        System.out.println("1.                      Consultar                       ");
                        System.out.println("2.                      Insertar                        ");
                        System.out.println("3.                      Actualizar                      ");
                        System.out.println("4.                      Eliminar registros              ");
                        System.out.println("5.                      Salir                           ");
                        System.out.println(" ------------------------------------------------------ ");
                        Choice = scanInt();
                        scanLine();

                        switch(Choice){
                            case 1:
                                aQ.alumnosQueries(url, username, password, url, password, Choice, Choice);
                                break;
                            case 2:
                                asI.asesoresInsert(url, username, password, Choice, password, password, username, url, password);
                                break;
                            case 3:
                                asU.asesoreUpdate(url, username, password, Choice);
                                break;
                            case 4:
                                asD.asesoresDelete(url, username, password, password);
                                break;
                            case 5:
                                System.out.println("¡Regresando al menú principal!");
                                break;
                            default:
                            System.out.println("Opción inválida!, intenta de nuevo.");
                                break;
                        }
                        }while(Choice != 5);
        }

        private static void AlumnosOps(){
            int Choice;
                    alumnos aD = new alumnos();
                    alumnos aU = new alumnos();
                    alumnos aI = new alumnos();
                    alumnos aQ = new alumnos();
                    do{
                        System.out.println(" ---------------------- Alumnos ----------------------- ");
                        System.out.println(" ¡Elige alguna opción por medio de la lista de números! ");
                        System.out.println(" ------------------------------------------------------ ");
                        System.out.println("1.                      Consultar                       ");
                        System.out.println("2.                      Insertar                        ");
                        System.out.println("3.                      Actualizar                      ");
                        System.out.println("4.                      Eliminar registros              ");
                        System.out.println("5.                      Salir                           ");
                        System.out.println(" ------------------------------------------------------ ");
                        Choice = scanInt();
                        scanLine();

                        switch(Choice){
                            case 1:
                                aQ.alumnosQueries(url, username, password, url, password, Choice, Choice);
                                break;
                            case 2:
                                aI.alumnosInsert(url, username, password, password, password, password, password, password, username, url, password);
                                break;
                            case 3:
                                aU.alumnosUpdate(url, username, password, password);
                                break;
                            case 4:
                                aD.alumnosDelete(url, username, password, password);
                                break;
                            case 5:
                                System.out.println("¡Regresando al menú principal!");
                                break;
                            default:
                            System.out.println("Opción inválida!, intenta de nuevo.");
                                break;
                        }

                    }while(Choice != 5);
        }

        /*
    private static void Deletes() throws SQLException{
        alumnos aD = new alumnos();
        asesores asD = new asesores();
        estadias eD = new estadias();
        pagos pD = new pagos();
        proyectos prD = new proyectos();
        int scChoi;

        do{    
                        System.out.println("¿Cuál tabla deseas actualizar?\n"
                                        + "1. alumnos\n"
                                        + "2. proyectos\n"
                                        + "3. asesores\n"
                                        + "4. estadias\n"
                                        + "5. pagos\n"
                                        + "6. Salir al menú anterior");
                                        scChoi = scanInt();
                                        scanLine();
                        switch(scChoi){
                            case 1:
                                aD.alumnosDelete(url, username, password, password);
                                break;
                            case 2:
                                prD.proyectosDelete(url, username, password, password);
                                break;
                            case 3:
                                asD.asesoresDelete(url, username, password, password);
                                break;
                            case 4:
                                eD.estadiasDelete(url, username, password, password);
                                break;
                            case 5:
                                pD.pagosDelete(url, username, password, password);
                                break;
                            case 6:
                                System.out.println("Regresando al menú anterior.");
                                break;
                            default:
                                System.out.println("Opción inválida!, intente de nuevo.");
                                break;
                        }
                    }while(scChoi != 6);

    }

    private static void Updates() throws SQLException {
        alumnos aU = new alumnos();
        proyectos pU = new proyectos();
        asesores asU = new asesores();
        estadias eU = new estadias();
        pagos paU = new pagos();
        int scChoi;
        do{    
                        System.out.println("¿Cuál tabla deseas actualizar?\n"
                                        + "1. alumnos\n"
                                        + "2. proyectos\n"
                                        + "3. asesores\n"
                                        + "4. estadias\n"
                                        + "5. pagos\n"
                                        + "6. Salir al menú anterior");
                                        scChoi = scanInt();
                                        scanLine();
                        switch(scChoi){
                            case 1:
                                aU.alumnosUpdate(url, username, password, password);
                                break;
                            case 2:
                                pU.proyectosUpdate(url, username, password, username, url, password);
                                break;
                            case 3:
                                asU.asesoreUpdate(url, username, password, scChoi);
                                break;
                            case 4:
                                eU.estadiasUpdate(url, username, password, password, password, username, url, password, scChoi);
                                break;
                            case 5:
                                paU.pagosUpdate(url, username, password, scChoi);
                                break;
                            case 6:
                                System.out.println("Regresando al menú anterior.");
                                break;
                            default:
                                System.out.println("Opción inválida!, intente de nuevo.");
                                break;
                        }
                    }while(scChoi != 6);
    }

    private static void Inserts() throws SQLException {
        alumnos aI = new alumnos();
        proyectos pI = new proyectos();
        asesores asI = new asesores();
        estadias eI = new estadias();
        pagos paI = new pagos();
        int scChoi;
        do{    
                        System.out.println("¿En cuál tabla deseas ingresar un registro?\n"
                                        + "1. alumnos\n"
                                        + "2. proyectos\n"
                                        + "3. asesores\n"
                                        + "4. estadias\n"
                                        + "5. pagos\n"
                                        + "6. Salir al menú anterior");
                                        scChoi = scanInt();
                                        scanLine();
                        switch(scChoi){
                            case 1:
                                aI.alumnosInsert(url, username, password, password, password, password, password, password, username, url, password);
                                break;
                            case 2:
                                pI.proyectosInsert(url, username, password, username, url, password);
                                break;
                            case 3:
                                asI.asesoresInsert(url, username, password, scChoi, password, password, username, url, password);
                                break;
                            case 4:
                                eI.estadiasInsert(url, username, password, password, password, username, url, password, scChoi);
                                break;
                            case 5:
                                paI.pagosInsert(url, username, password, scChoi, password, username, url, password);
                                break;
                            case 6:
                                System.out.println("Regresando al menú anterior.");
                                break;
                            default:
                                System.out.println("Opción inválida!, intente de nuevo.");
                                break;
                        }
                    }while(scChoi != 6);
    }


*/

/*      public static void Queries() throws SQLException{
            alumnos aQ = new alumnos();
            int QChoice;
            do{
                System.out.println("¿Cuál consulta deseas revisar?\n"
                                    + "1. Todos los alumnos\n"
                                    + "2. Regresar al menú anterior.");
                QChoice = scanInt();

            switch(QChoice){
                case 1:
                    aQ.alumnosQueries(url, username, password);
                    break;
                case 2:
                System.out.println("Regresando al menú anterior!");
                break;
                default:
                System.out.println("Opción inválida!, intente de nuevo.");
                break;
            }
            }while(QChoice != 2);
            
        }*/
    }