package BaiKiemTra;

import java.util.Scanner;

public class KhachHangNuoc {
	private String hoTen;
	private String soNha;
	private String maClock;
	
	//Constructor
	public KhachHangNuoc(String hoTen, String soNha, String maClock) {
		this.hoTen = hoTen;
		this.soNha = soNha;
		this.maClock = maClock;
	}
	
	//Phuong thuc hien thi thong tin
	public void outputInfo() {
		System.out.println("Ten khach hang: " + hoTen);
		System.out.println("So nha: " + soNha);
		System.out.println("Ma so dong ho: " + maClock);
	}
}

class BienLaiNuoc extends KhachHangNuoc {
	float tienNuoc;
	float chisoCu;
	float chisoMoi;
	float soNuoc;
	
	public BienLaiNuoc(String hoTen, String soNha, String maClock,
					float chisoCu, float chisoMoi, float soNuoc, float tienNuoc) {
		super(hoTen, soNha, maClock);
		this.chisoCu = chisoCu;
		this.chisoMoi = chisoMoi;
		this.soNuoc = soNuoc;
		this.tienNuoc = tienNuoc;
	}
	
	//Ghi de phuong thuc hien thi
	@Override
	public void outputInfo() {
		super.outputInfo();
		System.out.printf("Chi so cu: %.2f\n", chisoCu);
		System.out.printf("Chi so moi: %.2f\n", chisoMoi);
		System.out.printf("So so nuoc da dung: %.2f\n", soNuoc);
		System.out.printf("So tien phai thanh toan: %.2f\n", tienNuoc);
	}
	
	//Phuoc thuc nhap chi so
	public float nhapChiso(Scanner inputData) {
		float value;
		do {
			try {
				value = Float.parseFloat(inputData.nextLine());
			} catch (NumberFormatException ex) {
				System.out.println("Sai dinh dang du lieu | " + ex.getMessage());
				value = -1;
			} catch (Exception ex) {
				System.out.println("Loi khong xac dinh |" + ex.getMessage());
				value = -1;
			}
			if (value < 0) {
				System.out.print("Nhap lai chi so lon hon 0: ");
			}
		} while (value < 0);
		return value;
	}
	
	public static void main(String[] args) {
		System.out.println("|| BAI TOAN THU TIEN NUOC ||");
		Scanner inputData = new Scanner(System.in);
		
		//Nhap so ho dan su dung nuoc
		int N;
		do {
			try {
				System.out.print("So luong ho dan su dung nuoc: ");
				N = Integer.parseInt(inputData.nextLine());
			} catch (NumberFormatException ex) {
				System.out.println("Sai dinh dang du lieu ! " + ex.getMessage());
				N = -1;
			} catch (Exception ex) {
				System.out.println("Loi khong xac dinh !" + ex.getMessage());
				N = -1;
			}
			if (N < 0) {
				System.out.println("Vui long nhap lai so ho dan su dung nuoc !");
			}
		} while (N < 0);
		
		//Duyet danh sach khach hang
		KhachHangNuoc[] hoDan = new KhachHangNuoc[N];
		for (int i = 0; i < N; i++) {
			
			//Nhap ten ho dan
			System.out.print("Nhap ten chu ho: ");
			String hoTen = inputData.nextLine();
			
			//Nhap so nha
			System.out.print("Nhap so nha (vi du: 20A): ");
			String soNha = inputData.nextLine();
			
			//Nhap ma dong ho nuoc
			System.out.print("Nhap ma dong ho nuoc (vi du: VN-08): ");
			String maClock = inputData.nextLine();
			
			BienLaiNuoc temp = new BienLaiNuoc(hoTen, soNha, maClock, 0, 0, 0, 0);
			//Nhap chi so dong ho nuoc
			System.out.print("Nhap chi so cu: ");
			float chisoCu = temp.nhapChiso(inputData);
			float tempValue = 0;
			float chisoMoi = 0;
			do {
				System.out.print("Nhap chi so moi: ");
				chisoMoi = temp.nhapChiso(inputData);
				tempValue = chisoMoi;
				if (tempValue < chisoCu) {
					System.out.println("Chi so moi phai lon hon hoac bang chi so cu !");
				}
			} while (tempValue < chisoCu);
			
			
			//Tinh so so nuoc
			float soNuoc = chisoMoi - chisoCu;
			
			//Tinh tien nuoc
			float tienNuoc = soNuoc * 25000;
			
			hoDan[i] = new BienLaiNuoc(hoTen, soNha, maClock, chisoCu, chisoMoi, soNuoc, tienNuoc);
			System.out.println("-------------------");
		}
		
		//Hien thi thong tin bien lai
				System.out.println("|| THONG TIN BIEN LAI ||");
				for (int i = 0; i < N; i ++) {
					hoDan[i].outputInfo();
					System.out.println("-------------------");
				}
				inputData.close();
	}
}
