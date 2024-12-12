package StudentHantering;

import java.util.Scanner;

// Klass som hanterar meny och utskrift i konsol.
public class Menu {
    Scanner scanner = new Scanner(System.in);

    // Konstant av invalid input som används då det blev många ställen som skriver ut meddelandet till användaren
    public static final String INVALID_INPUT = "Invalid input!";

    // Metod för att visa menyn
    public void showMenu() {

        System.out.println("--**|| Student Management System ||**--\n");

        // Hämtar min singleton studentCatalog instance
        StudentCatalog studentCatalog = StudentCatalog.getInstance();

        // WHile loop som kör menyn tills användaren avslutar den med Exit
        while (true) {
            System.out.println("1. Add student");
            System.out.println("2. Search specific student");
            System.out.println("3. Show all students");
            System.out.println("4. Save data to file");
            System.out.println("5. Read from file");
            System.out.println("6. Exit");

            // Deklarerar variabel för användarens val
            int choice = 0;

            // Anropar hjälpmetod för att läsa användarens input
            choice = getIntInput();


            // Deklarerar variabler för användning av metoder i menyn
            int id;
            String name;
            int grade;

            // Switch case för att köra alternativ som användaren väljer
            switch (choice) {
                // Lägger till student i katalog
                case 1:
                    // While loop för att användaren inte ska behöva börja om från början vid felinmatning
                    while (true) {
                        System.out.println("Enter student ID");
                        // Hämtar användarens input med hjälp av hjälpmetod
                        id = getIntInput();

                        System.out.println("Enter student name");
                        name = scanner.nextLine();

                        System.out.println("Enter student grade");
                        // Hämtar användarens input här också med hjälp av hjälpmetod
                        grade = getIntInput();

                        // Kontrollerar om studenten redan finns i katalogen
                        if ((studentCatalog.studentExists(id))) {
                            System.out.println("Student already exists!\n");
                            continue;
                        }

                        // Lägger till student med addStudent metod
                        studentCatalog.addStudent(id, name, grade);
                        break;
                    }
                    break;

                // Söker på specifikt studentID
                case 2:
                    System.out.println("Enter student ID");
                    // Hämtar användarens input med hjälp av hjälpmetod
                    id = getIntInput();
                        // Anropar metod som skriver ut studentens information med angivet ID, om det hittas
                        studentCatalog.printStudent(id);
                        break;
                // Skriver ut samtliga studenter
                case 3:
                    // Anropar metod som skriver ut samtliga studenters information från katalogen
                    studentCatalog.printAllStudents();
                    System.out.println();
                    break;
                // Spara hela listan till lokal fil
                case 4:
                    // Anropar metod som skapar fil om den inte existerar och sparar listans data i filen
                    FileHandling.saveToFile(studentCatalog.getStudentList());
                    break;
                // Läser och skriver ut data från den lokala filen
                case 5:
                    FileHandling.readFromFile();
                    break;
                // Avslutar program
                case 6:
                    return;
                // Skriver ut konstanten för invalid input ifall annan input än 1-6
                default:
                    System.out.println(INVALID_INPUT);
            }
        }
    }

    // Hjälpmetod för att ta emot input som int, med felhantering
    private int getIntInput() {
        // Variabel för input
        int input = 0;
        // While loop som låter användaren försöka tills de fyllt i korrekt
        while (true) {
            // Try catch som fångar upp ifall användaren fyller i fel format
            try {
                // Tar emot input från användaren och sparar i variabel om det är en int
                input = Integer.parseInt(scanner.nextLine());
                // Returnerar int från variabel input
                return input;
                // Fångar numberformat exception och kör följande ifall användaren fyllt i fel format
            } catch (NumberFormatException e) {
                // Skriver ut konstant invalid input om användaren angett fel format
                System.out.println(INVALID_INPUT);
            }
        }
    }
}
