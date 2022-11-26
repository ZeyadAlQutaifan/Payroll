package globals;

import java.io.BufferedReader;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zeyad
 */
public class GlobalVariable {

    public static List<String> departments = new ArrayList<>();

    private static FileReader fileReader;
    // private static FileWriter fileWriter;
    // private static PrintWriter pw ; 
    private static BufferedReader br;

    /**
     * contain all employees
     */
    public static List<String> employeeListBuffer = new ArrayList<>();

    public GlobalVariable() throws FileNotFoundException, IOException {

        /**
         * ignore appending
         */
        //fileWriter = new FileWriter("employees.txt" , false) ; 
        // pw = new PrintWriter(fileWriter); 
        fileReader = new FileReader("employees.txt");
        br = new BufferedReader(fileReader);

        departments.add("IT");
        departments.add("Sales");
        departments.add("Financial");

        String line = br.readLine();
        System.out.println("line => " + line);
        while (line != null) {
            employeeListBuffer.add(line);
            line = br.readLine();
        }

        System.out.println("emp list => " + employeeListBuffer.toString());

    }

    public static BufferedReader getReader() {
        return br;
    }

    /*  public static PrintWriter getWriter(){
        
        return pw; 
    }*/
    public static void closeReader() throws IOException {
        br.close();
    }

    /* public static void closeWriter() throws IOException{
        pw.close();
    }*/
   
    public static void saveChanges() throws IOException {
        FileWriter fileWriter = new FileWriter("employees.txt", false);;
        PrintWriter pw = new PrintWriter(fileWriter);;
        String fullText = "";
        for (int i = 0; i < employeeListBuffer.size(); i++) {
            fullText += employeeListBuffer.get(i) + "\n";
        }
        pw.write(fullText);
        pw.close();

    }

}
