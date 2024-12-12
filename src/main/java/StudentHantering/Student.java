package StudentHantering;

// Klass för studenter
public class Student {
    // Privata variabler
    private String name;
    private int grade;

    // Getters och setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    // Konstruktor
    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
}
