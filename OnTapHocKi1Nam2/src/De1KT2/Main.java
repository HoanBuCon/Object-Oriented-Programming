package De1KT2;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

//Lop HinhChuNhat
class HinhChuNhat {
	private double chieuDai;
	private double chieuRong;
	
	//Constructor
	public HinhChuNhat(double chieuDai, double chieuRong) {
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
	}
	
	//Setter
	public void setChieuDai(double chieuDai) {
		this.chieuDai = chieuDai;
	}
	public void setChieuRong(double chieuRong) {
		this.chieuRong = chieuRong;
	}
	
	//Getter
	public double getChieuDai() {
		return chieuDai;
	}
	public double getChieuRong() {
		return chieuRong;
	}
	
	//Nhap du lieu
	public void nhapTT(Scanner inputData) {
		System.out.print("Nhap chieu dai: ");
		chieuDai = checkEx(inputData);
		
		System.out.print("Nhap chieu rong: ");
		chieuRong = checkEx(inputData);
	}
	
	//Tinh chu vi
	public double chuVi() {
		double chuVi = chieuDai + chieuRong;
		return chuVi;
	}
	
	//Tinh dien tich
	public double dienTich() {
		double dienTich = chieuDai * chieuRong;
		return dienTich;
	}
	
	//Hien thi thong tin chieu dai, chieu rong
	@Override
	public String toString() {
		return "Chieu dai hinh chu nhat: " + chieuDai + "\n" +
				"Chieu rong hinh chu nhat: " + chieuRong + "\n";
	}
	
	//Bat ngoai le
	public double checkEx(Scanner inputData) {
		double value = 0;
		while (true) {
			try {
				value = Double.parseDouble(inputData.nextLine());
				if (value <= 0) {
					throw new IllegalArgumentException("Vui long nhap canh lon hon 0!");
				}
				break; //Thoat vong lap neu chuyen doi thanh cong
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

//Lop HinhVuong
class HinhVuong extends HinhChuNhat {
	private double canh;
	
	//Constructor
	public HinhVuong(double canh) {
		super(canh, canh);
		this.canh = canh;
	}
	
	//Setter
	public void setCanh(double canh) {
		this.canh = canh;
	}
	
	//Getter
	public double getCanh() {
		return canh;
	}
	
	//Nhap du lieu
	public void nhapTT(Scanner inputData) {
		System.out.print("Nhap canh: ");
		canh = checkEx(inputData);
	}
	
	//Tinh chu vi
	public double chuVi() {
		double chuVi = canh * 4;
		return chuVi;
	}
	
	//Tinh dien tich
	public double dienTich() {
		double dienTich = canh * canh;
		return dienTich;
	}
	
	//Hien thi thong tin canh
	@Override
	public String toString() {
		return "Canh hinh vuong: " + canh + "\n";
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner inputData = new Scanner(System.in);
		HinhVuong HV = new HinhVuong(0);
		
		System.out.println("----- Nhap Du Lieu -----");
		HV.nhapTT(inputData);
		
		System.out.println("----- Hien Thi Du Lieu -----");
		System.out.print(HV.toString());
		System.out.println("Chu vi hinh vuong la: " + HV.chuVi());
		System.out.println("Dien tich hinh vuong la: " + HV.dienTich());
		
		inputData.close();;
		System.out.println("----- Ket Thuc Chuong Trinh -----");
	}
}
