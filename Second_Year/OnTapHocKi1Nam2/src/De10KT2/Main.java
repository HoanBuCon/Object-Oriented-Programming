package De10KT2;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

//Lop DaiLy
class DaiLy {
	private String maDaily;
	private String tenDaily;
	private String diaChi;
	
	//Constructor
	public DaiLy(String maDaily, String tenDaily, String diaChi) {
		this.maDaily = maDaily;
		this.tenDaily = tenDaily;
		this.diaChi = diaChi;
	}
	
	//Setter
	public void setMaDaiLy(String maDaily) {
		this.maDaily = maDaily;
	}
	public void setTenDaiLy(String tenDaily) {
		this.tenDaily = tenDaily;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	//Getter
	public String getMaDaiLy() {
		return maDaily;
	}
	public String getTenDaiLy() {
		return tenDaily;
	}
	public String getDiaChi() {
		return diaChi;
	}
	
	//Kiem tra maDaily;
		public boolean checkMaDL(String maDaily) {
			if (maDaily.startsWith("DL")) //Kiem tra dinh dang bat dau bang "DL"
				return true;
			else
				return false;
		}
	
	//Nhap du lieu
	public void nhapTT(Scanner inputData) {
		System.out.print("Nhap ma dai ly: ");
		maDaily = checkEx(inputData);
		
		System.out.print("Nhap ten dai ly: ");
		tenDaily = inputData.nextLine();
		
		System.out.print("Nhap dia chi: ");
		diaChi = inputData.nextLine();
	}
	
	@Override
	public String toString() {
		return "Ma dai ly: " + maDaily + "\n" +
				"Ten dai ly: " + tenDaily + "\n" +
				"Dia chi: " + diaChi + "\n";
	}
	
	//Kiem tra ngoai le
	public String checkEx(Scanner inputData) {
		String value = "NULL";
		while (true) {
			try {
				value = inputData.nextLine();
				if (checkMaDL(value) == false) {
					throw new IllegalArgumentException("Ma dai ly khong hop le! (Dinh dang DLXXXX)");
				}
				break;
			} catch (NumberFormatException ex) {
				System.out.println("Gia tri khong hop le! | " + ex.getMessage());
				System.out.print("Vui long nhap lai: ");
			} catch (IllegalArgumentException ex) {
				System.out.println("Gia tri khong hop le! | " + ex.getMessage());
				System.out.print("Vui long nhap lai: ");
			} catch (InputMismatchException ex) {
				System.out.println("Du lieu khong khop voi kieu mong doi! | " + ex.getMessage());
				System.out.print("Vui long nhap lai: ");
			} catch (Exception ex) {
				System.out.println("Loi khong xac dinh! | " + ex.getMessage());
				System.out.print("Vui long nhap lai: ");
			}
		}
		return value;
	}
}

//Lop DaiLyQuanLy
class DaiLyQuanLy extends DaiLy {
	
	//Constructor
	public DaiLyQuanLy(String maDaily, String tenDaily, String diaChi) {
		super(maDaily, tenDaily, diaChi);
	}
	
	//Kiem tra maDaily
	public boolean checkMaDL(String maDaily) {
		if (maDaily.startsWith("DL") && maDaily.length() == 6) //Dinh dang "DLXXXX" co do dai la 6
			return true;
		else
			return false;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner inputData = new Scanner(System.in);
		DaiLyQuanLy DLQL = new DaiLyQuanLy("", "", "");
		
		System.out.println("----- Nhap Du Lieu -----");
		DLQL.nhapTT(inputData);
		
		System.out.println("----- Hien Thi Du Lieu -----");
		System.out.print(DLQL.toString());
		
		inputData.close();;
		System.out.println("----- Ket Thuc Chuong Trinh -----");
	}
}
