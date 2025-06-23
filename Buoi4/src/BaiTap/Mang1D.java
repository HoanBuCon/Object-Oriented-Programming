package BaiTap;

import java.util.Scanner;

public class Mang1D {
	public int m;
	public int[] array1;
	public void input1D(Scanner sc) {
		//Scanner sc = new Scanner(System.in);
		System.out.print("Nhap kich thuoc cho mang 1 chieu: ");
		m = sc.nextInt();
		array1 = new int[m];
		
		for (int i=0; i<m; i++) {
			System.out.printf("Array[%d] = ", i);
			array1[i] = sc.nextInt();
		}
	}
	
	public void output1D() {
		System.out.println("MANG 1 CHIEU DA NHAP LA:");
		for (int i=0; i<m; i++) {
			System.out.print(array1[i] + " ");
		}
	}
	
	public int[] getarray1() {
		return array1;
	}
}