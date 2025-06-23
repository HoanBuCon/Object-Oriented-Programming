package BaiTap;

import java.util.Scanner;

public class Mang2D {
	public int x;
	public int y;
	public int[][] array2;
	public void input2D(Scanner sc) {
		//Scanner sc = new Scanner(System.in);
		System.out.print("\nNhap kich thuoc cho mang 2 chieu A[x][y]\n");
		System.out.printf("Nhap x: ");
		x = sc.nextInt();
		System.out.printf("Nhap y: ");
		y = sc.nextInt();
		array2 = new int[x][y];
		
		for (int i=0; i<x; i++) {
			for (int j=0; j<y; j++) {
				System.out.printf("A[%d][%d] = ", i, j);
				array2[i][j] = sc.nextInt();
			}
		}
	}
	
	public void output2D() {
		System.out.println("MANG 2 CHIEU DA NHAP LA:");
		for (int i=0; i<x; i++) {
			for (int j=0; j<y; j++) {
				System.out.print(array2[i][j] + " ");
			} System.out.println();
		}
	}
	
	public int[][] getArray2() {
		return array2;
	}
}