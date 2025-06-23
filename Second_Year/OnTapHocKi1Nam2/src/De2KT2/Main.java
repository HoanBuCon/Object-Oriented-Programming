package De2KT2;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

//Lop NguoiDung
class NguoiDung {
	private String name;
	private int age;
	private String email;
	
	//Constructor
	public NguoiDung(String name, int age, String email) {
		this.name = name;
		this.age = age;
		this.email = email;
	}

	//Setter
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//Getter
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getEmail() {
		return email;
	}
	
	//Kiem tra do tuoi hop le
	public boolean tuoiHopLe(int age) {
		if (age >= 18)
			return true;
		else
			return false;
	}

	//Kiem tra email hop le
	public boolean emailHopLe(String email) {
		if (email.contains("@") && email.contains("."))
			return true;
		else
			return false;
	}
	
	//Nhap du lieu
	public void nhapTT(Scanner inputData) {
		System.out.print("Nhap ten nguoi dung: ");
		name = inputData.nextLine();
		
		System.out.print("Nhap tuoi nguoi dung: ");
		age = checkExTuoi(inputData);
		
		System.out.print("Nhap email nguoi dung: ");
		email = checkExEmail(inputData);
	}
	
	@Override
	public String toString() {
		return "Ten: " + name + "\n" +
				"Tuoi: " + age + "\n" +
				"Email: " + email + "\n";
	}
	
	//Kiem tra ngoai le tuoi
	public int checkExTuoi(Scanner inputData) {
		int value = 0;
		while (true) {
			try {
				value = Integer.parseInt(inputData.nextLine());
				if (tuoiHopLe(value) == false) {
					throw new IllegalArgumentException("Tuoi khong hop le (User >= 15 / Admin >= 25");
				}
				break;
			} catch (NumberFormatException ex) {
				System.out.println("Gia tri khong hop le! | " + ex.getMessage());
				System.out.print("Vui long nhap lai: ");
			} catch (IllegalArgumentException ex) {
				System.out.println("Tuoi khong hop le! | " + ex.getMessage());
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
	
	//Kiem tra ngoai le email
	public String checkExEmail(Scanner inputData) {
		String value = "NULL";
		while (true) {
			try {
				value = inputData.nextLine();
				if (emailHopLe(value) == false) {
					throw new IllegalArgumentException("Email khong hop le!");
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

//Lop QuanTriVien
class QuanTriVien extends NguoiDung {
	
	//Constructor
	public QuanTriVien(String name, int age, String email) {
		super(name, age, email);
	}
	
	//Kiem tra do tuoi hop le
	public boolean tuoiHopLe(int age) {
		if (age >= 25)
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
		QuanTriVien QTV = new QuanTriVien("", 0, "");
		
		System.out.println("----- Nhap Du Lieu -----");
		QTV.nhapTT(inputData);
		
		System.out.println("----- Hien Thi Du Lieu -----");
		System.out.print(QTV.toString());
		
		inputData.close();;
		System.out.println("----- Ket Thuc Chuong Trinh -----");
	}
}