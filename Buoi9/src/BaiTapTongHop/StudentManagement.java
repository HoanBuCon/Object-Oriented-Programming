package BaiTapTongHop;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int birthYear;
    private String hometown;
    private String studentId;
    private String className;
    private double gpa;

    public Student(String name, int birthYear, String hometown, String studentId, String className, double gpa) {
        this.name = name;
        this.birthYear = birthYear;
        this.hometown = hometown;
        this.studentId = studentId;
        this.className = className;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Tên: " + name + ", Năm sinh: " + birthYear + ", Quê quán: " + hometown +
               ", Mã sinh viên: " + studentId + ", Lớp: " + className + ", Điểm TB: " + gpa;
    }

    public String toFileString() {
        return "Tên: " + name + ", Năm sinh: " + birthYear + ", Quê quán: " + hometown +
               ", Mã sinh viên: " + studentId + ", Lớp: " + className + ", Điểm TB: " + gpa;
    }

    public static Student fromFileString(String line) {
        String[] parts = line.split(", ");
        String name = parts[0].split(": ")[1];
        int birthYear = Integer.parseInt(parts[1].split(": ")[1]);
        String hometown = parts[2].split(": ")[1];
        String studentId = parts[3].split(": ")[1];
        String className = parts[4].split(": ")[1];
        double gpa = Double.parseDouble(parts[5].split(": ")[1]);
        return new Student(name, birthYear, hometown, studentId, className, gpa);
    }
}

public class StudentManagement {
    private static final String FILE_NAME = "students.txt";
    private static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Nhập thông tin sinh viên");
            System.out.println("2. Lưu thông tin sinh viên vào file");
            System.out.println("3. Đọc thông tin sinh viên từ file");
            System.out.println("4. Hiển thị thông tin sinh viên");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự xuống dòng

            switch (choice) {
                case 1:
                    inputStudentInfo(scanner);
                    break;
                case 2:
                    saveStudentsToFile();
                    break;
                case 3:
                    readStudentsFromFile();
                    break;
                case 4:
                    displayStudents();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void inputStudentInfo(Scanner scanner) {
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();

        System.out.print("Nhập năm sinh: ");
        int birthYear = scanner.nextInt();

        System.out.print("Nhập quê quán: ");
        scanner.nextLine(); // Đọc ký tự xuống dòng
        String hometown = scanner.nextLine();

        System.out.print("Nhập mã sinh viên: ");
        String studentId = scanner.nextLine();

        System.out.print("Nhập lớp: ");
        String className = scanner.nextLine();

        System.out.print("Nhập điểm trung bình: ");
        double gpa = scanner.nextDouble();

        Student student = new Student(name, birthYear, hometown, studentId, className, gpa);
        studentList.add(student);
        System.out.println("Thông tin sinh viên đã được thêm.");
    }

    private static void saveStudentsToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student student : studentList) {
                writer.println(student.toFileString());
            }
            System.out.println("Thông tin sinh viên đã được lưu vào file " + FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readStudentsFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            studentList.clear(); // Xóa danh sách cũ
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    Student student = Student.fromFileString(line);
                    studentList.add(student);
                }
            }
            System.out.println("Thông tin sinh viên đã được đọc từ file " + FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("Không có thông tin sinh viên.");
            return;
        }
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}