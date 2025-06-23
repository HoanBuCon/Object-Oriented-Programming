package MingCong;

import java.util.Scanner;

public class SanPhamKhuyenMai extends SanPham{
	
	public SanPhamKhuyenMai(String ten, int soluong, double gia) {
		super(ten, soluong, gia);
	}
	
	void nhapTT() {
		Scanner sc = new Scanner(System.in);
		super.nhapTT();
	}
	
	@Override
	public double tong() {
		double a = super.tong();
		return a;
	}
}