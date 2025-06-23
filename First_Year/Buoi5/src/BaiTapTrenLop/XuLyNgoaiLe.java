package BaiTapTrenLop;

import java.util.*;

public class XuLyNgoaiLe {
	public static void main(String[] args) {
		int m = 0, output = 0;
		Scanner inputData = new Scanner(System.in);
		System.out.print("Nhap m trong khoang 2 - 100: ");
		do {
			try {
				m = Integer.parseInt(inputData.nextLine());
				output = 10/m;
			}
			catch (ArithmeticException ex) {
				System.out.println("Deo chia duoc cho 0 | " + ex.getMessage());
				output = 1;
			}
			catch (NumberFormatException ex) {
				System.out.println("Sai dinh dang du lieu | " + ex.getMessage());
				output = 0;
			}
			if (m < 2 || m > 100) {
				System.out.print("Gia tri ngoai khoang quy dinh 2 - 100, NHAP LAI!: ");
			}
		} while (m < 2 || m > 100);
		System.out.print("Output 10/m = " + output);
		inputData.close();
	}
}
