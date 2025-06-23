package MingCong;

import java.util.Scanner;

public class SanPham {
	public String ten;
	public double gia;
	public int soluong;
	
	public SanPham(String ten, int soluong, double gia) {
		this.ten = ten;
		this.soluong = soluong;
		this.gia = gia;
	}
	
	
	void nhapTT() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Ten SP: " );
		this.ten = sc.nextLine();
		
		System.out.print("Gia SP: ");
		this.gia = sc.nextDouble();
		sc.nextLine();
		
		System.out.print("So luong SP: ");
		this.soluong = sc.nextInt();
	}

	public double tong() {
		return this.gia * this.soluong;
	}
	
	public String toString () {
		String myString = "\n" + "Ten SP: " + this.ten + "\n" + "Gia SP: " + this.gia + "\n" + "So Luong SP: " + this.soluong + "\n" + "Tong: " + tong();
		return myString; 	
	}
	

}