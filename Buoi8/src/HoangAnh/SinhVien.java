package HoangAnh;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Nguoi {
    private String hoTen;
    private int namSinh;
    private String que;

    public Nguoi() {}

    public Nguoi(String hoTen, int namSinh, String que) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.que = que;
    }

    public void nhapTT() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ho ten: ");
        this.hoTen = scanner.nextLine();
        System.out.print("Nhap nam sinh: ");
        this.namSinh = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Nhap que: ");
        this.que = scanner.nextLine();
    }

    public void hienThiTT() {
        System.out.printf("Ho ten: %s, Nam sinh: %d, Que: %s%n", this.hoTen, this.namSinh, this.que);
    }
       public static void main(String[] args) {
        Nguoi nguoi = new Nguoi();
        System.out.println("Nhap thong tin cho nguoi:");
        nguoi.nhapTT();
        System.out.println("Thong tin nguoi vua nhap:");
        nguoi.hienThiTT();
    }
}

public class SinhVien extends Nguoi {
    private String maSV;
    private String lop;
    private double diemTB;

    public SinhVien() {}

    public SinhVien(String hoTen, int namSinh, String que, String maSV, String lop, double diemTB) {
        super(hoTen, namSinh, que);
        this.maSV = maSV;
        this.lop = lop;
        this.diemTB = diemTB;
    }

    public void nhapTT() {
        super.nhapTT();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma sinh vien: ");
        this.maSV = scanner.nextLine();
        System.out.print("Nhap lop: ");
        this.lop = scanner.nextLine();
        System.out.print("Nhap diem trung binh: ");
        this.diemTB = scanner.nextDouble();
    }

    public void hienThiTT() {
        super.hienThiTT();
        System.out.printf("Ma sinh vien: %s, Lop: %s, Diem trung binh: %.2f%n", this.maSV, this.lop, this.diemTB);
    }

    public static void main(String[] args) {
        List<SinhVien> danhSachSV = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong sinh vien: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhap thong tin sinh vien thu " + (i + 1) + ":");
            SinhVien sv = new SinhVien();
            sv.nhapTT();
            danhSachSV.add(sv);
        }

        System.out.println("Danh sach sinh vien co diem trung binh >= 8.00:");
        for (SinhVien sv : danhSachSV) {
            if (sv.diemTB >= 8.0) {
                sv.hienThiTT();
            }
        }

        scanner.close();
    }
}