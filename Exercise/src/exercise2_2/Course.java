package exercise2_2;

/**
 * Exercise 2.2: Course class.
 * Models a course and the students enrolled in it.
 * The students array grows automatically when it becomes full.
 */
public class Course {

    // ---------- Data fields ----------
    private String courseName;                // name of the course
    private String[] students = new String[4]; // array storing student names (initial capacity 4)
    private int numberOfStudents = 0;          // number of students currently enrolled (default 0)

    // ---------- Constructor ----------

    /** Creates a course with the specified name. */
    public Course(String courseName) {
        this.courseName = courseName;
    }

    // ---------- Methods ----------

    /** Returns the course name. */
    public String getCourseName() {
        return courseName;
    }

    /** Adds a new student to the course. */
    public void addStudent(String student) {
        // If the array is full, create a larger array (double size) and copy the old students
        if (numberOfStudents == students.length) {
            String[] larger = new String[students.length * 2];
            for (int i = 0; i < numberOfStudents; i++) {
                larger[i] = students[i];
            }
            students = larger;
        }

        students[numberOfStudents] = student; // place the student in the next free slot
        numberOfStudents++;                   // update the count
    }

    /** Drops a student from the course (does nothing if the student isn't found). */
    public void dropStudent(String student) {
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].equals(student)) {
                // Shift all following students one position to the left
                for (int j = i; j < numberOfStudents - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[numberOfStudents - 1] = null; // clear the last (now duplicate) slot
                numberOfStudents--;                    // update the count
                return;                                // stop after removing the first match
            }
        }
    }

    /** Returns the students of the course (only the enrolled ones, without empty slots). */
    public String[] getStudents() {
        String[] enrolled = new String[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            enrolled[i] = students[i];
        }
        return enrolled;
    }

    /** Returns the number of students in the course. */
    public int getNumberOfStudents() {
        return numberOfStudents;
    }

}

class test{
    // ---------- Simple test ----------
    public static void main(String[] args) {
        Course course = new Course("Java Programming");
        String[] names = {"Ahmed", "Fatima", "Omar", "Hodan", "Yusuf", "Amina"};
        for (String n : names) {
            course.addStudent(n);   // more than 4 students -> array grows
        }

        System.out.println("Course: " + course.getCourseName());
        System.out.println("Students: " + course.getNumberOfStudents());

        course.dropStudent("Omar");
        System.out.println("After dropping Omar: " + course.getNumberOfStudents());
        for (String s : course.getStudents()) {
            System.out.println(" - " + s);
        }
    }
}