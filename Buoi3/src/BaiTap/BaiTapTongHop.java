package BaiTap;

import java.util.*;

public class BaiTapTongHop {
	public static void main(String[] args) {
		BaiTapTongHop temp = new BaiTapTongHop();
		temp.nhapN();
		temp.hienthiSNT_NhoHon_n();
		temp.hienthiSNT();
		temp.hienthiFIBO();
	}
	private int n;
	public boolean checkSNT(int n) {
		if (n <= 1)
			return false;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
	public int tinhFIBO(int n) {
		int a = 1, b = 1, fibo = 0;
	    if (n > 0 && n < 3) 
	    	fibo = 1;
	    for (int i = 3; i <= n; i++) {
	        fibo = a + b;
	        a = b;
	        b = fibo; 
	    }
	    return fibo;
	}
	public void nhapN() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("Nhap n trong khoang 2 - 100: ");
			n = sc.nextInt();
			if (n < 2 || n > 100)
				System.out.print("Nhap lai n: ");
		} while (n < 2 || n > 100);
		sc.close();
	}
	public void hienthiSNT_NhoHon_n() {
		System.out.print("\nDanh sach so nguyen to nho hon n: ");
		for (int i = 0; i <= n; i++) {
			if (checkSNT(i) == true) {
				System.out.print(i+" ");
			}
		}
	}
	public void hienthiSNT() {
		System.out.printf("\nDanh sach %d so nguyen to dau tien: ", n);
		int i = 2, count = 0;
		while (count < n) {
			if (checkSNT(i) == true) {
				System.out.print(i+" ");
				count++;
			}
			i++;
		}
	}
	public void hienthiFIBO() {
		System.out.printf("\nDanh sach %d so Fibonacci dau tien la: ", n);
		for (int i = 3; i < n; i++) {
			System.out.print(tinhFIBO(i)+" ");
		}
	}
}