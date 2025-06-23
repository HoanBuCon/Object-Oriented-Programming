package De3KT2;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;

//Lop Sach
class Sach {
	private String tenSach;
	private String tenTacGia;
	private int namXB;
	
	//Constructor
	public Sach(String tenSach, String tenTacGia, int namXB) {
		this.tenSach = tenSach;
		this.tenTacGia = tenTacGia;
		this.namXB = namXB;
	}
	
	//Setter
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
	}
	public void setNamXB(int namXB) {
		this.namXB = namXB;
	}
	
	//Getter
	public String getTenSach() {
		return tenSach;
	}
	public String getTenTacGia() {
		return tenTacGia;
	}
	public int getNamXB() {
		return namXB;
	}
	
	//Kiem tra nam xuat ban
	public boolean checkNamXB(int namXB) {
		LocalDate currentDate = LocalDate.now();
		int currentYear = currentDate.getYear(); //Lay nam hien tai
		
		//Kiem tra dieu kien nam xuat ban
		if (namXB > currentYear)
			return false;
		else
			return true;
	}

	//Nhap du lieu
	public void nhapTT(Scanner inputData) {
		System.out.print("Nhap ten sach: ");
		tenSach = inputData.nextLine();
		
		System.out.print("Nhap ten tac gia: ");
		tenTacGia = inputData.nextLine();
		
		System.out.print("Nhap nam xuat ban: ");
		namXB = checkEx(inputData);
	}
	
	@Override
	public String toString() {
		return "Ten sach: " + tenSach + "\n" +
				"Ten tac gia: " + tenTacGia + "\n" +
				"Nam xuat ban: " + namXB + "\n";
	}
	
	//Phuong thuc bat ngoai le
	public int checkEx(Scanner inputData) {
		int value = 0;
		while (true) {
			try {
				value = Integer.parseInt(inputData.nextLine());
				if (checkNamXB(value) == false) {
					throw new IllegalArgumentException("Nam xuat ban khong hop le!");
				}
				break;
			} catch (NumberFormatException ex) {
				System.out.println("Gia tri khong hop le! | " + ex.getMessage());
				System.out.print("Vui long nhap lai: ");
			} catch (IllegalArgumentException ex){
				System.out.println("Nam xuat ban khong hop le! | " + ex.getMessage());
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

//Lop SachGiaoKhoa
class SachGiaoKhoa extends Sach {
	
	//Constructor
	public SachGiaoKhoa(String tenSach, String tenTacGia, int namXB) {
		super(tenSach, tenTacGia, namXB);
	}
	
	//Kiem tra nam xuat ban
	public boolean checkNamXB(int namXB) {
		LocalDate currentDate = LocalDate.now();
		int currentYear = currentDate.getYear(); //Lay nam hien tai
		
		//Kiem tra dieu kien nam xuat ban
		if (namXB > currentYear || namXB < currentYear - 5)
			return false;
		else
			return true;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner inputData = new Scanner(System.in);
		SachGiaoKhoa SGK = new SachGiaoKhoa("", "", 0);
		
		System.out.println("----- Nhap Du Lieu -----");
		SGK.nhapTT(inputData);
		
		System.out.println("----- Hien Thi Du Lieu -----");
		System.out.print(SGK.toString());
		
		inputData.close();;
		System.out.println("----- Ket Thuc Chuong Trinh -----");
	}
}
