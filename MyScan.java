package Scan;
import java.util.*;

public class MyScan {

    public static Scanner scan = new Scanner(System.in);

    public static String scan() {
        return scan.next();
    }

    public static String scanLine(){
        return scan.nextLine();
    }

    public static int scanInt(){
        return scan.nextInt();
    }

    public static double scanDouble(){
        return scan.nextDouble();
    }

    public static boolean scanBool(){
        return scan.nextBoolean();
    }
}
