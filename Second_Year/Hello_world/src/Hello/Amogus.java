package Hello;

import java.util.*;

public class Amogus {
	public static void main(String[] args) {
		System.out.println("Joe mama fat!");
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nhap ten: ");
		String name = scanner.nextLine();

		System.out.print("Nhap tuoi: ");
		byte age = scanner.nextByte();
		System.out.println("Ten: " + name);
		System.out.println("Tuoi: " + age);
		System.out.println("Bai toan kiem tra so nguyen to");

		System.out.print("Nhap so phan tu cua mang: ");
		int n = scanner.nextInt();
		System.out.print("Nhap phan tu cho mang: ");
		int[] array = new int[n];

		for (int i = 0; i < n; i++) {
			array[i] = scanner.nextInt();
		}
		System.out.println("Mang da nhap la: ");
		for (int i = 0; i < n; i++) {
			System.out.printf("a[%d] =  %d\n", i, array[i]);
		}
		
		//Selection sort
		for (int i = 0; i < n; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			int temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}

		System.out.print("Mang sau khi sap xep la: ");
		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
		scanner.close();

		//Kiem tra so nguyen to
		for (int i = 0; i < n; i++) {
			if (check(array[i]) == true) {
				System.out.println(array[i] + " la so nguyen to");
			} else
				System.out.println(array[i] + " khong phai so nguyen to");
		}
	}

	//Ham kiem tra so nguyen to
	public static boolean check(int n) {
		if (n <= 1)
			return false;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}