package KiemTraSo3;

import java.util.Scanner;

interface GiaoDien {
	void nhapTT(Scanner inputData);
	String toString();
}

abstract class Nguoi implements GiaoDien {
	String hoTen;
	int namSinh;
	String queQuan;
	
	public Nguoi(String hoTen, int namSinh, String queQuan) {
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
	public void setqueQuan(String queQuan) {
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
                        throw new NumberFormatException("Vui long nhap gia tri lon hon 0!");
                    }
                }
                else if (type.equals("soNguyen")) {
                    value = Integer.parseInt(inputData.nextLine());
                    if (value < 0) {
                        throw new NumberFormatException("Vui long nhap so luong lon hon hoac bang 0!");
                    }
                } else
                    throw new IllegalArgumentException("Kieu gia tri khong hop le!");
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Sai dinh dang du lieu! | " + ex.getMessage());
                System.out.print("Vui long nhap lai: ");
            } catch (Exception ex) {
                System.out.println("Loi khong xac dinh! | " + ex.getMessage());
                System.out.print("Vui long nhap lai: ");
            }
        }
        return value;
    }
	public void nhapTT(Scanner inputData) {
		System.out.print("Nhap ho ten: ");
		hoTen = inputData.nextLine();
		
		System.out.print("Nhap nam sinh: ");
		namSinh = (int) checkEx(inputData, "soNguyen");
		
		System.out.print("Nhap que quan: ");
		queQuan = inputData.nextLine();
	}
	
	@Override
	public String toString() {
		return "Ho va ten: " + hoTen + "\n" +
				"Nam sinh: " + namSinh + "\n" +
				"Que quan: " + queQuan;
	}
}

class SinhVien extends Nguoi {
	String maSV;
	String Lop;
	double diemTB;
	
	public SinhVien(String hoTen, int namSinh, String queQuan, String maSV, String Lop, double diemTB) {
		super(hoTen, namSinh, queQuan);
		this.maSV = maSV;
		this.Lop = Lop;
		this.diemTB = diemTB;
	}
	
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public void setLop(String Lop) {
		this.Lop = Lop;
	}
	public void setDiemTB(double diemTB) {
		this.diemTB = diemTB;
	}
	
	public String getMaSV() {
		return maSV;
	}
	public String getLop() {
		return Lop;
	}
	public double getDiemTB() {
		return diemTB;
	}
	public void nhapTT(Scanner inputData) {
		super.nhapTT(inputData);
		
		System.out.print("Nhap ma sinh vien: ");
		maSV = inputData.nextLine();
		
		System.out.print("Nhap lop: ");
		Lop = inputData.nextLine();
		
		System.out.print("Nhap diem trung binh: ");
		do {
			diemTB = checkEx(inputData, "soThuc");
			if (diemTB < 0 || diemTB >= 10) {
				System.out.println("Diem trung binh khong the < 0 hoac > 10");
				System.out.print("Nhap lai diem trung binh: ");
			}
		} while (diemTB < 0 || diemTB > 10);
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n" +
				"Ma sinh vien: " + maSV + "\n" +
				"Lop: " + Lop + "\n" +
				"Diem trung binh " + diemTB;
	}
}

public class QL_SinhVien {
	public static void main(String[] args) {
		Scanner inputData = new Scanner(System.in);
		System.out.print("Nhap so luong sinh vien: ");
		Nguoi temp = new Nguoi("", 0, "") {
		};
		int N = (int) temp.checkEx(inputData, "soNguyen");
		SinhVien[] svList = new SinhVien[N];
		
		for (int i = 0; i < N; i++) {
			System.out.printf("----- NHAP THONG TIN SINH VIEN THU %d -----\n", i+1);
			svList[i] = new SinhVien("", 0, "", "", "", 0);
			svList[i].nhapTT(inputData);
		}
		
		System.out.println("|| DANH SACH SINH VIEN CO DIEM TRUNG BINH LON HON 8 ||");
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (svList[i].diemTB >= 8) {
				count++;
				System.out.printf("----- THONG TIN SINH VIEN THU %d -----\n", count);
				System.out.println(svList[i].toString());
			}
		}
	}
}