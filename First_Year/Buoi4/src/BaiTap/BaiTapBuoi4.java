package BaiTap;

import java.util.*;

public class BaiTapBuoi4 {
	public boolean checkSNT(int n) {
		if (n <= 1)
			return false;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public int countSNT(int[][] a, int x, int y) {
		int count=0;
		for (int i=0; i<x; i++) {
			for (int j=0; j<y; j++) {
				if (checkSNT(a[i][j]) == true) {
					count++;
				}
			}
		}
		return count;
	}
	
	public boolean checkCHAN(int n) {
		if (n%2 == 0) {
			return true;
		} else
			return false;
	}
	
	public double averageCHAN(int[][] a, int x, int y) {
		int sum=0;
		int count=0;
		for (int i=0; i<x; i++) {
			for (int j=0; j<y; j++) {
				if (checkCHAN(a[i][j]) == true) {
					sum = sum + a[i][j];
					count++;
				}
			}
		}
		double avg = (double)sum / (double)count;
		return avg;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Mang1D amogus = new Mang1D();
		Mang2D sus = new Mang2D();
		amogus.input1D(sc);
		amogus.output1D();
		sus.input2D(sc);
		sus.output2D();
		sc.close();
		BaiTapBuoi4 temp = new BaiTapBuoi4();
		int c = temp.countSNT(sus.getArray2(), sus.x, sus.y);
		System.out.println("So luong SNT trong ma tran la: " + c);
		double chan = temp.averageCHAN(sus.getArray2(), sus.x, sus.y);
		System.out.printf("Trung binh cong so chan trong ma tran la: %.2f", chan);
	}
}