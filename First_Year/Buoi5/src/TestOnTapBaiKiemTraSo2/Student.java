package TestOnTapBaiKiemTraSo2;

import java.util.Scanner;

public class Student extends Person {
    String studentId;

    // Constructor
    public Student(String name, int age, String studentId) {
        super(name, age); // Gọi constructor của lớp cha
        this.studentId = studentId;
    }

    // Ghi đè phương thức hiển thị thông tin
    @Override
    public void displayInfo() {
        super.displayInfo(); // Gọi phương thức của lớp cha
        System.out.println("Mã sinh viên: " + studentId);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Nhập tên sinh viên: ");
            String name = scanner.nextLine();

            System.out.print("Nhập tuổi sinh viên: ");
            int age = Integer.parseInt(scanner.nextLine()); // Chuyển đổi nhập liệu sang int

            if (age < 0) {
                throw new IllegalArgumentException("Tuổi không thể là số âm!");
            }

            System.out.print("Nhập mã sinh viên: ");
            String studentId = scanner.nextLine();

            // Tạo đối tượng Student
            Student student = new Student(name, age, studentId);
            System.out.println("\nThông tin sinh viên:");
            student.displayInfo();

        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Vui lòng nhập vào một số nguyên cho tuổi.");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Lỗi không xác định: " + e.getMessage());
        } finally {
            scanner.close(); // Đóng Scanner
        }
    }
}
