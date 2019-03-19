package P03_StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> studentTable;

    public StudentSystem() {
        this.studentTable = new HashMap<>();
    }

    public void ParseCommand(String[] args) {
        if (args[0].equals("Create")) {
            createStudent(args);
        } else if (args[0].equals("Show")) {
            showStudent(args);
        }
    }

    private void showStudent(String[] args) {
        String name = args[1];

        if (!studentTable.containsKey(name)) {
            return;
        }

        Student student = studentTable.get(name);
        System.out.println(student.toString());
    }


    private void createStudent(String[] args) {
        String name = args[1];

        if (studentTable.containsKey(name)) {
            return;
        }

        int age = Integer.parseInt(args[2]);
        double grade = Double.parseDouble(args[3]);

        Student student = new Student(name, age, grade);
        studentTable.put(name, student);

    }
}
