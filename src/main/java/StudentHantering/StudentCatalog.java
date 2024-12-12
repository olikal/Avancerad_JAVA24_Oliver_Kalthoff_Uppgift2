package StudentHantering;


import java.util.HashMap;
import java.util.Map;

// Klass som hanterar singleton lista över studenter och metoder för denna
public class StudentCatalog {

    // Använder Hashmap för att spara min data. Passar bra med studenters unika ID
    private Map<Integer, Student> studentList = new HashMap<Integer, Student>();

    // Deklarerar private variabel för min enda instance av StudentCatalog med singleton
    private static StudentCatalog instance;

    // Private konstruktor för att undvika att objekt skapas pga singleton
    // Skapar 4 teststudenter för att demonstrera applikationens funktionalitet
    private StudentCatalog() {
        studentList.put(1, new Student("teststudent1", 1));
        studentList.put(2, new Student("teststudent2", 2));
        studentList.put(3, new Student("teststudent3", 3));
        studentList.put(4, new Student("teststudent4", 4));
    }

    // Getter metod för att hämta StudentCatalog singleton instancen. Skapar den om den inte redan existerar.
    public static StudentCatalog getInstance() {
        if (instance == null) {
            instance = new StudentCatalog();
        }
        return instance;
    }

    // Metod för att lägga till student.
    public void addStudent(int id, String name, int grade){
        // Kontrollerar om student redan existerar med hjälpmetoden studentExists
        if (studentList.containsKey(id)) {
            System.out.println("Student with id " + id + " already exists\n");
            return;
        }
        // Om student med angivet ID inte existerar läggs student till i listan med attributen som metoden fått
        studentList.put(id, new Student(name, grade));
    }

    // Metod som kontrollerar om studentens ID finns i listan
    public boolean studentExists(int id) {
        // Returnerar true/false baserat på om parametern ID hittas i listan
        return studentList.containsKey(id);
    }

    // Metod som skriver ut samtliga studenters data från listan
    public void printAllStudents(){
        // For each metod som går igenom varje student i studentList och skriver ut värdena enligt angivet format
        for (Map.Entry<Integer, Student> entry : studentList.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Name: " + entry.getValue().getName() + ", Grade: " + entry.getValue().getGrade());
        }
    }

    // Metod som skriver ut en specifik student via sökning på ID
    public void printStudent(int id){
        // Hämtar studentobjektet med ID från listan
        Student student = studentList.get(id);
        // Om studenten inte finns i listan skrivs felmeddelande ut
        if (student == null) {
            System.out.println("Student does not exist!\n");
            return;
        }
        // Om studenten hittas, skrivs informationen ut
        System.out.println("ID: " + id + ", Name: " + student.getName() + ", Grade: " + student.getGrade());
    }

    // Getter för studentlist
    public Map<Integer, Student> getStudentList() {
        return studentList;
    }
}
