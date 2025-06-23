package BaiTapTongHop;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

class Nguoi {
	private String hoTen;
	private int namSinh;
	
	//Tao lap doi tuong
	public Nguoi(String hoTen, int namSinh) {
		this.hoTen = hoTen;
		this.namSinh = namSinh;
	}
	
	
	//Setter va Getter
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}
	public String getHoTen() {
		return hoTen;
	}
	public int getNamSinh() {
		return namSinh;
	}
	
	//Bat ngoai le
	public double checkEx(Scanner inputData, String type) {
        double value = 0;
        while (true) {
            try {
                if (type.equals("soThuc")) {
                    value = Double.parseDouble(inputData.nextLine());
                    if (value < 0) {
                        throw new NumberFormatException("Vui long nhap gia tri lon hon 0!");
                    }
                } else if (type.equals("soNguyen")) {
                    value = Integer.parseInt(inputData.nextLine());
                    if (value < 0) {
                        throw new NumberFormatException("Vui long nhap so luong lon hon hoac bang 0!");
                    }
                } else {
                    throw new IllegalArgumentException("Kieu gia tri khong hop le!");
                }
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Sai dinh dang du lieu! | " + ex.getMessage());
                System.out.print("Vui long nhap lai: ");
            } catch (Exception ex) {
                System.out.println("Loi khong xac dinh! | " + ex.getMessage());
                System.out.print("Vui long nhap lai ");
            }
        }
        return value;
    }
	
	//Nhap thong tin
	public void nhapTT(Scanner inputData) {
        System.out.print("Nhap ho ten: ");
        hoTen = inputData.nextLine();

        System.out.print("Nhap nam sinh: ");
        namSinh = (int) checkEx(inputData, "soNguyen");
    }
	
	 //Luu thong tin vao file
    public String toFileString() {
    	return "Ho va ten: " + hoTen + ", Nam sinh: " + namSinh;
    }

	//Hien thi thong tin
    @Override
    public String toString() {
        return "Ho va ten: " + hoTen + "\n" +
               "Nam sinh: " + namSinh;
    }
}

class SinhVien extends Nguoi {
	String lop;
	double diemTB;
	
	//Tao lap
	public SinhVien(String hoTen, int namSinh, String lop, double diemTB) {
		super(hoTen, namSinh);
		this.lop = lop;
		this.diemTB = diemTB;
	}
	
	//Setter va Getter
	public void setLop(String lop) {
		this.lop = lop;
	}
	public void setDiemTB(double diemTB) {
		this.diemTB = diemTB;
	}
	public String getLop() {
		return lop;
	}
	public double getDiemTB() {
		return diemTB;
	}
	
	//Nhap thong tin
		public void nhapTT(Scanner inputData) {
			super.nhapTT(inputData);
			
	        System.out.print("Nhap lop: ");
	        lop = inputData.nextLine();
	        
	        do {
		        System.out.print("Nhap diem trung binh: ");
		        diemTB = checkEx(inputData, "soThuc");
		        if (diemTB < 0 || diemTB >10)
		        	System.out.println("Diem trung binh khong the nho hon 0 hoac lon hon 10 !");
	        } while (diemTB < 0 || diemTB > 10);
	    }
		
		//Luu thong tin vao file
	    public String toFileString() {
	    	return super.toFileString() + ", Lop: " + lop + ", Diem trung binh: " + diemTB;
	    }

		//Hien thi thong tin
	    @Override
	    public String toString() {
	        return super.toString() + "\n" +
	        		"Lop: " + lop + "\n" +
	        		"Diem trung binh: " + diemTB;
	    }
}

public class QuanLySinhVien {
	private int N;
    private SinhVien[] danhsachSV;
	
	//Phuong thuc nhap thong tin
	public void nhapThongTin(Scanner inputData) {
		Nguoi temp = new Nguoi("", 0);
		System.out.println("===== NHAP DANH SACH SINH VIEN =====");
		System.out.print("Nhap so luong sinh vien: ");
		N = (int) temp.checkEx(inputData, "soNguyen");
		
		danhsachSV = new SinhVien[N];
		for (int i = 0; i < N; i++) {
			System.out.printf("----- NHAP THONG TIN SINH VIEN THU %d -----\n", i+1);
			danhsachSV[i] = new SinhVien("", 0, "", 0);
			danhsachSV[i].nhapTT(inputData);
		}
		System.out.println("===== DANH SACH SINH VIEN =====");
		for (int i = 0; i < N; i++) {
			System.out.printf("----- THONG TIN SINH VIEN THU %d -----\n", i+1);
			System.out.println(danhsachSV[i].toString());
		}
	}
	
	//Phuong thuc luu thong tin
	public void luuThongTin() {
		String fileThongTin = "XuatThongTinSinhVien.txt";
		try (BufferedWriter vietFile = new BufferedWriter(new FileWriter(fileThongTin, true))) {
			for (int i = 0; i < N; i++) {
				vietFile.write(danhsachSV[i].toFileString());
				vietFile.newLine();
			}
			System.out.println("Thong tin da duoc luu vao file " + fileThongTin);
		} catch (IOException ex) {
			System.out.println("Da xay ra loi khi ghi vao File: " + ex.getMessage());
		}
	}
	
	//Phuong thuc doc thong tin
	public void docThongTin() {
		String fileThongTin = "NhapThongTinSinhVien.txt";
		try (BufferedReader docFile = new BufferedReader(new FileReader(fileThongTin))) {
			String line;
			int index = 0;
			
			//Khoi tao danh sach sinh vien neu no chua duoc khoi tao
	        if (danhsachSV == null) {
	            danhsachSV = new SinhVien[0];
	        }
			
			while ((line = docFile.readLine()) != null) {
				String[] data = line.split(","); //Phan tach cac truong bang dau phay
				
				if (data.length == 4) { //Kiem tra so luong thong tin (4 truong)
					String hoTen = data[0];
					int namSinh = Integer.parseInt(data[1]);
					String lop = data[2];
					double diemTB = Double.parseDouble(data[3]);
					
					//Tang kich thuoc danh sach neu can thiet
					if (index >= danhsachSV.length) {
						SinhVien[] newDanhSachSV = new SinhVien[danhsachSV.length +1];
						System.arraycopy(danhsachSV, 0, newDanhSachSV, 0, danhsachSV.length);
						danhsachSV = newDanhSachSV;
					}
					danhsachSV[index] = new SinhVien(hoTen, namSinh, lop, diemTB);
					index++;
				}
			}
			N = index; //Cap nhat so luong sinh vien
			System.out.println("Da doc thong tin sinh vien trong File!");
		} catch (IOException ex) {
			System.out.println("Da xay ra loi khi ghi vao File: " + ex.getMessage());
		}
	}
	
	//Phuong thuc hien thi thong tin
	public void hienthiThongTin() {
		System.out.println("===== DANH SACH SINH VIEN TRONG FILE =====");
		for (int i = 0; i < N; i++) {
			System.out.println();
			System.out.printf("----- THONG TIN SINH VIEN THU %d -----\n", i+1);
			System.out.println(danhsachSV[i].toFileString());
		}
	}
	
	public static void main(String[] args) {
		Scanner inputData = new Scanner(System.in);
		QuanLySinhVien quanLy = new QuanLySinhVien();
		
		int luaChon;
		do {
			System.out.println("Danh sach cac viec co the lam: ");
			System.out.println("1. Nhap thong tin sinh vien");
			System.out.println("2. Luu thong tin sinh vien vao file");
			System.out.println("3. Doc thong tin sinh vien trong file");
			System.out.println("4. Hien thi thong tin sinh vien trong file");
			System.out.println("0. Dung chuong trinh");
			System.out.print("Chon cong viec muon lam: ");
			luaChon = Integer.parseInt(inputData.nextLine());
			
			switch (luaChon) {
				case 1:
					quanLy.nhapThongTin(inputData);
					break;
				case 2:
					quanLy.luuThongTin();
					break;
				case 3:
					quanLy.docThongTin();
					break;
				case 4:
					quanLy.hienthiThongTin();
					break;
				case 0:
					System.out.println("===== KET THUC CHUONG TRINH =====");
					break;
				default:
					System.out.println("Lua chon khong hop le, vui long nhap lai!");
					break;
			}
		} while (luaChon != 0);
		inputData.close();
	}
}