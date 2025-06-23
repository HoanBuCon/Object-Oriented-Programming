package VuDinhDinh;

import java.util.Scanner;

class QuanTriVien extends NguoiDung {
    @Override
    public void Input() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Nhập Tên Người Quản Trị: ");
            this.Ten = sc.nextLine();
            System.out.print("Nhập Tuổi Người Quản Trị: ");
            this.Tuoi = sc.nextInt();
            sc.nextLine();
            if (Tuoi < 25) {
                System.out.println("Tuổi không hợp lệ! Người quản trị phải từ 25 tuổi trở lên.");
            } else {
                System.out.print("Nhập email: ");
                this.email = sc.nextLine();
                break;
            }
        }
        sc.close();
    }

    @Override
    public void Output() {
        System.out.println("Tên Quản Trị Viên: " + Ten);
        System.out.println("Tuổi Quản Trị Viên: " + Tuoi);
        System.out.println("Email: " + email);
    }

    public static void main(String[] args) {
        QuanTriVien QTV = new QuanTriVien();
        QTV.Input();
        QTV.Output();
    }
}
