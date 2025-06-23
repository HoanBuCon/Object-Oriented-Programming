package BaiTapTongHop;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

interface GiaoDien {
    void nhapTT(Scanner inputData);
    String toString();
}

abstract class Human implements GiaoDien {
    String hoTen;
    int namSinh;
    String queQuan;

    public Human(String hoTen, int namSinh, String queQuan) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.queQuan = queQuan;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }
    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getHoTen() {
        return hoTen;
    }
    public int getNamSinh() {
        return namSinh;
    }
    public String getQueQuan() {
        return queQuan;
    }

    public double checkEx(Scanner inputData, String type) {
        double value = 0;
        while (true) {
            try {
                if (type.equals("soThuc")) {
                    value = Double.parseDouble(inputData.nextLine());
                    if (value < 0) {
                        throw new NumberFormatException("Vui lòng nhập giá trị lớn hơn 0!");
                    }
                } else if (type.equals("soNguyen")) {
                    value = Integer.parseInt(inputData.nextLine());
                    if (value < 0) {
                        throw new NumberFormatException("Vui lòng nhập số lượng lớn hơn hoặc bằng 0!");
                    }
                } else {
                    throw new IllegalArgumentException("Kiểu giá trị không hợp lệ!");
                }
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Sai định dạng dữ liệu! | " + ex.getMessage());
                System.out.print("Vui lòng nhập lại: ");
            } catch (Exception ex) {
                System.out.println("Lỗi không xác định! | " + ex.getMessage());
                System.out.print("Vui lòng nhập lại: ");
            }
        }
        return value;
    }

    public void nhapTT(Scanner inputData) {
        System.out.print("Nhập họ tên: ");
        hoTen = inputData.nextLine();

        System.out.print("Nhập năm sinh: ");
        namSinh = (int) checkEx(inputData, "soNguyen");

        System.out.print("Nhập quê quán: ");
        queQuan = inputData.nextLine();
    }

    @Override
    public String toString() {
        return "Họ và tên: " + hoTen + "\n" +
               "Năm sinh: " + namSinh + "\n" +
               "Quê quán: " + queQuan;
    }
}

class HocSinh extends Human {
    String maSV;
    String lop;
    double diemTB;

    public HocSinh(String hoTen, int namSinh, String queQuan, String maSV, String lop, double diemTB) {
        super(hoTen, namSinh, queQuan);
        this.maSV = maSV;
        this.lop = lop;
        this.diemTB = diemTB;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }
    public void setLop(String lop) {
        this.lop = lop;
    }
    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }

    public String getMaSV() {
        return maSV;
    }
    public String getLop() {
        return lop;
    }
    public double getDiemTB() {
        return diemTB;
    }

    public void nhapTT(Scanner inputData) {
        super.nhapTT(inputData);

        System.out.print("Nhập mã sinh viên: ");
        maSV = inputData.nextLine();

        System.out.print("Nhập lớp: ");
        lop = inputData.nextLine();

        System.out.print("Nhập điểm trung bình: ");
        do {
            diemTB = checkEx(inputData, "soThuc");
            if (diemTB < 0 || diemTB > 10) {
                System.out.println("Điểm trung bình không thể < 0 hoặc > 10");
                System.out.print("Nhập lại điểm trung bình: ");
            }
        } while (diemTB < 0 || diemTB > 10);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Mã sinh viên: " + maSV + "\n" +
               "Lớp: " + lop + "\n" +
               "Điểm trung bình: " + diemTB;
    }
}

public class QL_SinhVien {
    public static void main(String[] args) {
        Scanner inputData = new Scanner(System.in);
        System.out.print("Nhập số lượng sinh viên: ");
        Human temp = new Human("", 0, "") {};
        int N = (int) temp.checkEx(inputData, "soNguyen");
        HocSinh[] svList = new HocSinh[N];

        // Nhập thông tin sinh viên
        for (int i = 0; i < N; i++) {
            System.out.printf("----- NHẬP THÔNG TIN SINH VIÊN THỨ %d -----\n", i + 1);
            svList[i] = new HocSinh("", 0, "", "", "", 0);
            svList[i].nhapTT(inputData);
        }

        // Xuất danh sách sinh viên ra file
        try {
            FileWriter fileWriter = new FileWriter("sinhvien.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (HocSinh sv : svList) {
                printWriter.println(sv.toString());
                printWriter.println("-----------");
            }
            printWriter.close();
            System.out.println("Thông tin sinh viên đã được lưu vào file sinhvien.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Đọc thông tin sinh viên từ file
        System.out.println("|| DANH SÁCH SINH VIÊN ||");
        try {
            BufferedReader br = new BufferedReader(new FileReader("sinhvien.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    System.out.println(line);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}