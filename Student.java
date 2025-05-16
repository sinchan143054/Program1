//main
 public class Student {
    private String name;
    private java.time.LocalDate dateOfBirth;

    public Student(String name, String dobStr, String format) {
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern(format);
        this.name = name;
        this.dateOfBirth = java.time.LocalDate.parse(dobStr, formatter);
    }

    public void displayStudentDetails() {
        int age = java.time.Period.between(dateOfBirth, java.time.LocalDate.now()).getYears();
        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age + " years");
    }

    public static void main(String[] args) {
        Student student = new Student("Alice Johnson", "2004-03-15", "yyyy-MM-dd");
        student.displayStudentDetails();
    }
}
