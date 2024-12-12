package StudentHantering;


import java.io.*;
import java.util.Map;

// Klass med filhantering för att spara och läsa textfil
public class FileHandling {

    // Metod som sparar data till textfil
    public static void saveToFile(Map<Integer, Student> studentList) {
        try {
            // Skapar objekt för textfilen
            File file = new File("studentdata.txt");
            // Skapar writer och buffer för att skriva
            FileWriter writer = new FileWriter(file);
            BufferedWriter buffer = new BufferedWriter(writer);

            // For each metod som loopar samtliga objekt i listan
            for (Integer key : studentList.keySet()) {
                // Hämtar student för aktuellt ID
                Student student = studentList.get(key);
                // Skriver formaterad text till filen
                writer.write("ID: " + key + ", Name: " + student.getName() + ", Grade: " + student.getGrade());
                writer.write("\n");
            }

            // Stänger buffer
            buffer.close();
            // Catch som skriver ut eventuellt felmeddelande
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metod som läser från textfilen och skriver ut i konsollen
    public static void readFromFile() {
        try{
            // Skapar en reader och buffer för att läsa från filen
            FileReader reader = new FileReader("studentdata.txt");
            BufferedReader buffer = new BufferedReader(reader);

            // Variabel för line
            String line;

            // While loop som läser ny rad tills det inte finns fler
            while ((line = buffer.readLine()) != null){
                // Skriver ut aktuell rad
                System.out.println(line);
            }
            // Stänger buffer
            buffer.close();

        }catch (FileNotFoundException e) {
            // Catch som fångar och skriver ut felmeddelande om filen inte hittas
            throw new RuntimeException(e);
        } catch (IOException e) {
            // Catch som fångar och skriver ut felmeddelande om läsningen blir fel
            throw new RuntimeException(e);
        }
    }

}
