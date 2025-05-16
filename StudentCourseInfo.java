//master
 public class StudentCourseInfo {
    public static void main(String[] args) {
        Student student = new Student("Alice Johnson", "2004-03-15", "yyyy-MM-dd");
        student.displayStudentDetails();

        StudentCourses sc = new StudentCourses();
        sc.addCourseMarks("Semester 1", "Mathematics", 85);
        sc.addCourseMarks("Semester 1", "Physics", 78);
        sc.addCourseMarks("Semester 2", "Chemistry", 88);
        sc.addCourseMarks("Semester 2", "Biology", 90);
        sc.displayCoursesAndMarks();
    }
}

// Student class reused
class Student {
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
}

// StudentCourses class
class StudentCourses {
    private java.util.Map<String, java.util.Map<String, Integer>> semesterCourses = new java.util.LinkedHashMap<>();

    public void addCourseMarks(String semester, String course, int marks) {
        semesterCourses.putIfAbsent(semester, new java.util.LinkedHashMap<>());
        semesterCourses.get(semester).put(course, marks);
    }

    public void displayCoursesAndMarks() {
        for (String semester : semesterCourses.keySet()) {
            System.out.println("Semester: " + semester);
            java.util.Map<String, Integer> courses = semesterCourses.get(semester);
            for (java.util.Map.Entry<String, Integer> entry : courses.entrySet()) {
                System.out.println("Course: " + entry.getKey() + ", Marks: " + entry.getValue());
            }
            System.out.println();
        }
    }
}
