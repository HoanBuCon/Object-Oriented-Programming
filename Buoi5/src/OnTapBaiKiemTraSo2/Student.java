package OnTapBaiKiemTraSo2;

import java.util.Scanner;

public class Student extends Person {
	String maSV;
	float diemToan;
	float diemLy;
	float diemHoa;
	
	//Constructor
	public Student(String name, String gender, int age, String maSV,
					float diemToan, float diemLy, float diemHoa) {
		super(name, gender, age);
		this.maSV = maSV;
		this.diemToan = diemToan;
		this.diemLy = diemLy;
		this.diemHoa = diemHoa;
	}
		
	//Ghi de phuong thuc outputData
	@Override
	public void outputInfo() {
		super.outputInfo();
		System.out.println("Ma sinh vien: " + maSV);
		System.out.println("Diem Toan: " + diemToan);
		System.out.println("Diem Ly: " + diemLy);
		System.out.println("Diem Hoa: " + diemHoa);
	}
	
	//Cau truc try-catch nhap diem
	public float nhapDiem(Scanner inputData) {
		float value;
		do {
			try {
				value = Float.parseFloat(inputData.nextLine());
			} catch (NumberFormatException ex) {
				System.out.println("Sai dinh dang du lieu | " + ex.getMessage());
				value = -1;
			}
			if (value < 0 || value > 10) {
				System.out.print("Nhap lai diem trong khoang 0 - 10: ");
			}
		} while (value < 0 || value > 10);
		return value;
	}
	
	public static void main(String[] args) {
		System.out.println("|| BAI TOAN QUAN LY SINH VIEN ||");
		Scanner inputData = new Scanner(System.in);
		
		//Cau truc try-catch nhap so luong sinh vien
		int N;
		do {
			try {
				System.out.print("Nhap so luong sinh vien: ");
				N = Integer.parseInt(inputData.nextLine());
			} catch (NumberFormatException ex) {
				System.out.println("Sai dinh dang du lieu ! " + ex.getMessage());
				N = -1;
			}
			if (N < 0) {
				System.out.println("Vui long nhap lai so luong sinh vien !");
			}
		} while (N < 0);
		
		//Tao mang luu tru thong tin sinh vien
		Student[] sinhvien = new Student[N];
		
		//Cau truc try-catch nhap thong tin sinh vien
		for (int i = 0; i < N; i ++) {
			
			//Nhap ten
			System.out.print("Nhap ten sinh vien: ");
			String name = inputData.nextLine();
			
			//Nhap gioi tinh
			int genderValue;
			String gender = null;
			do {
				System.out.print("Nhap gioi tinh sinh vien (1 = Nam, 0 = Nu): ");
				genderValue = inputData.nextInt();
				
				if (genderValue != 1 && genderValue != 0)
					System.out.println("Gia tri khong hop le, vui long nhap 1 hoac 0 !");
			} while (genderValue != 1 && genderValue != 0);
			if (genderValue == 1)
				gender = "Nam";
			if (genderValue == 0)
				gender = "Nu";
			inputData.nextLine();
			
			//Nhap tuoi
			int age = -1;
			do {
				try {
					System.out.print("Nhap tuoi sinh vien lon hon 0: ");
					age = inputData.nextInt();
					if (age < 0)
						System.out.println("Vui long nhap lai !");
				} catch (NumberFormatException ex) {
					System.out.println("Vui long nhap tuoi la so nguyen !");
				} catch (Exception ex) {
					System.out.println("Loi khong xac dinh !" + ex.getMessage());
				}
			} while (age < 0);
			inputData.nextLine();
			
			//Nhap ma sinh vien
			System.out.print("Nhap ma sinh vien: ");
			String maSV = inputData.nextLine();
			
			//Nhap diem
			Student temp = new Student(name, gender, age, maSV, 0, 0, 0);
			System.out.print("Nhap diem Toan: ");
			float diemToan = temp.nhapDiem(inputData);
			
			System.out.print("Nhap diem Ly: ");
			float diemLy = temp.nhapDiem(inputData);
			
			System.out.print("Nhap diem Hoa: ");
			float diemHoa = temp.nhapDiem(inputData);
			
			sinhvien[i] = new Student(name, gender, age, maSV, diemToan, diemLy, diemHoa);
		}
		
		//Hien thi thong tin sinh vien
		System.out.println("|| THONG TIN SINH VIEN ||");
		for (int i = 0; i < N; i ++) {
			sinhvien[i].outputInfo();
			System.out.println("-------------------");
		}
		inputData.close();
	}
}
