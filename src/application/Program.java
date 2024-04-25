package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a folder path: ");
        String strPath = sc.nextLine();

        File path = new File(strPath);
        File[] folders = path.listFiles(File::isDirectory);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(strPath + "\\folders.txt", true))) {
            bw.write("FOLDERS: \n");
            bw.newLine();
            System.out.println("FOLDERS: ");
            for (File folder : folders) {
                bw.write(folder.getName());
                bw.newLine();
                System.out.println(folder);
            }
            bw.newLine();
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
