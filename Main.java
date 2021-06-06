import java.io.*;
import java.util.*;

public class Main {
    //Design of Main Menu along with the Welcome message..!
    static Scanner userinput = new Scanner(System.in);

    public static void Menu() {
            System.out.println("     *****************************************************");
            System.out.println("\n          !!..Welcome to LockedMe.com (Assessment 1)..!!");
            System.out.println("             Developed by :-  Mohanish Pingale \n");
            System.out.println(" Please select from one of the following options and enter the number associated with it : ");
            System.out.println(" 1 : View All Files \n" + " 2 : View the Options Menu\n" + " 3 : Exit the Application\n");

            try {
                int x = userinput.nextInt();
                if (x == 1) {
                    DisplayAllFiles();
                } else if (x == 2) {
                    Optionsmenu();
                } else if (x == 3) {
                    System.out.println("THANK-YOU");
                    System.exit(0);
                } else {
                    System.out.println("Invalid Input Please Try Again");
                }
            } catch (InputMismatchException e) {
                System.out.println("invalid input");
                userinput.nextLine();
            }
        }


    // Design of Options Menu
    public static void Optionsmenu() {
        System.out.println("Welcome to Options Menu");
        System.out.println(" Please select from one of the following options and enter the number associated with it : ");
        System.out.println(" 1 : Add a File \n" + " 2 : Delete a File \n" + " 3 : Search for a Specific File \n"
                + " 4 : Display Context of a Specific file \n" + " 5 : Go Back to Main Menu \n" + " 6 : Exit the Application");

        int y = userinput.nextInt();
        try {
            if (y == 1) {
                add();
            } else if (y == 2) {
                delete();
            } else if (y == 3) {
                search();
            } else if (y == 4) {
                contextOfFile();
            } else if (y == 5) {
                Menu();
            } else if (y == 6) {
                System.out.println("THANK-YOU");
                System.exit(0);
            } else {
                System.out.println("Invalid Input Please Try Again");
            }
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("invalid input");
        }
    }

    static void add() {
        System.out.println("Please enter the name of the file you want to create along with the file extension. (.txt , .pdf etc etc..)");
        String addd = userinput.next();
        try {
            File file1 = new File("D:\\11\\" + addd);
            boolean flag = file1.createNewFile();
            if (flag) {
                System.out.println("File " + file1.getName() + " has been created successfully at the specified location");
            } else {
                System.out.println("File already present at the specified location.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void delete() {
        System.out.println("Please enter the name of the file you want to delete along with the file extension. (.txt , .pdf etc etc..)");
        String del = userinput.next();
        File myFile = new File("D:\\11\\" + del);
        if (myFile.delete()) {
            System.out.println("File deleted : " + myFile.getName());
        } else {
            System.out.println("Some problem occurred while deleting the file");
        }
    }

    public static void search() {
        System.out.println("Please enter the name of the file you want to search along with the file extension. (.txt , .pdf etc etc..)");
        String initials = userinput.next();

        File directory = new File("D:\\11\\");

        String[] flist = directory.list();
        int flag = 0;
        if (flist == null) {
            System.out.println("Empty directory.");
        } else {
            for (int i = 0; i < flist.length; i++) {
                String filename = flist[i];
                if (filename.equals(initials)) {
                    System.out.println(filename + " found");
                    flag = 1;
                }
            }
        }
        if (flag == 0) {
            System.out.println("File Not Found");
        }
    }

    public static void contextOfFile() {
        System.out.println("Please enter the name of the file to display it's context along with the file extension. (.txt , .pdf etc etc..)");
        String searrchh = userinput.next();
        File myFile = new File("D:\\11\\" + searrchh);
        try {
            System.out.println("The contents of searched file '" + searrchh + "' are as displayed below");
            Scanner sc = new Scanner(myFile);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void DisplayAllFiles() {

        File folder = new File("D:\\11\\");
        List listFile = Arrays.asList(folder.list());
        Collections.sort(listFile);
        System.out.println("---------------------------------------");
        System.out.println("Sorting by filename in ascending order");
        for (Object file : listFile) {
            System.out.println(file);
        }
    }

    public static void main(String[] args) {
        while (true) {
            Menu();

        }
    }
}

