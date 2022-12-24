package Champions;

import java.io.File;
import java.util.Scanner;

public class Util {
    static private Scanner scanner;
    static{
        try{
            scanner=new Scanner(new File("Champions1.txt"));
        }catch(Exception e){}
    }
    
    public static int nextInt(){ return scanner.nextInt();}
    public static String nextLine(){ return scanner.nextLine();}
    public static double nextDouble(){ return scanner.nextDouble();}
    public static boolean hasNext(){ return scanner.hasNext();}
}
