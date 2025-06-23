package OnTap;

import java.util.*;
	
public class QLHocSinh {
	// Phuong thuc sap xep
	public void bubbleSort(HocSinh[] students, int M) {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M - i - 1; j++) {
				if (students[j].diemTB() < students[j + 1].diemTB()) {
					HocSinh temp = students[j];
					students[j] = students[j + 1];
					students[j + 1] = temp;
				}
			}
		}
	}

	// Phuong thuc dem so luong ten bi trung
	public void trungTen(HocSinh[] students, int M, Scanner sc) {
		System.out.print("Nhap ten hoc sinh: ");
		String name = sc.nextLine();
		int count = 0;
		for (int i = 0; i < M; i++) {
			if (students[i].getName().equals(name))
				count++;
		}
		System.out.print("So hoc sinh trung ten voi " + name + " la: " + count);
	}

	// Phuong thuc nhap diem
	public double nhapDiem(Scanner sc) {
		double value;
		do {
			try {
				value = Double.parseDouble(sc.nextLine());
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
		Scanner sc = new Scanner(System.in);

		System.out.print("Nhap so luong hoc sinh: ");
		int M;
		do {
			try {
				M = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException ex) {
				System.out.println("Sai dinh dang du lieu | " + ex.getMessage());
				M = -1;
			}
			if (M < 0) {
				System.out.print("Nhap lai so luong hoc sinh: ");
			}
		} while (M < 0);

		// Tao mang luu tru sinh vien
		HocSinh[] students = new HocSinh[M];

		for (int i = 0; i < M; i++) {
			QLHocSinh temp = new QLHocSinh();

			System.out.print("Nhap ten: ");
			String name = sc.nextLine();

			System.out.print("Nhap diem Toan: ");
			double diemToan = temp.nhapDiem(sc);

			System.out.print("Nhap diem Ly: ");
			double diemLy = temp.nhapDiem(sc);

			System.out.print("Nhap diem Hoa: ");
			double diemHoa = temp.nhapDiem(sc);

			students[i] = new HocSinh(name, diemToan, diemLy, diemHoa);
		}

		// Sap xep danh sach theo thu tu giam dan cua diem trung binh
		QLHocSinh sort = new QLHocSinh();
		sort.bubbleSort(students, M);

		// In thong tin ra man hinh3
		System.out.printf("%-20s %-15s %-15s %-15s %-15s\n", "Ho Ten", "Diem Toan", "Diem Ly", "Diem Hoa",
				"Diem Trung binh");
		System.out.println("-------------------------------------------------------------------------------");

		for (int i = 0; i < M; i++) {
			System.out.println(students[i]);
		}

		// Dem so luong hoc sinh trung ten voi ten duoc nhap
		QLHocSinh count = new QLHocSinh();
		count.trungTen(students, M, sc);

		sc.close();
	}
}