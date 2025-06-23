package VuDinhDinh;

import java.util.Scanner;

public class NguoiDung {
    String Ten;
    int Tuoi;
    String email;
    
    public void Input() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Nhập Tên Người Dùng: ");
            this.Ten = sc.nextLine();
            System.out.print("Nhập Tuổi Người Dùng: ");
            this.Tuoi = sc.nextInt();
            sc.nextLine();
            if (Tuoi < 18) {
                System.out.println("Tuổi không hợp lệ! Người dùng phải từ 18 tuổi trở lên.");
            } else {
                System.out.print("Nhập email: ");
                this.email = sc.nextLine();
                break;
            }
        }
        sc.close();
    }

    public void Output() {
        System.out.println("Tên Người Dùng: " + Ten);
        System.out.println("Tuổi Người Dùng: " + Tuoi);
        System.out.println("Email: " + email);
    }
}