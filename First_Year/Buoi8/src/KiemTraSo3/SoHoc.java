package KiemTraSo3;

import java.util.Scanner;

public class SoHoc {
	public boolean checkSNT(int n) {
		if (n <= 1)
			return false;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
	
	public int checkEx(Scanner inputData) {
        int value = 0;
        while (true) {
            try {
            	value = Integer.parseInt(inputData.nextLine());
            	if (value < 0) {
            		throw new NumberFormatException("Vui long nhap so luong lon hon hoac bang 0!");
            	}
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Sai dinh dang du lieu! | " + ex.getMessage());
                System.out.print("Vui long nhap lai: ");
            } catch (Exception ex) {
                System.out.println("Loi khong xac dinh! | " + ex.getMessage());
                System.out.print("Vui long nhap lai: ");
            }
        }
        return value;
    }
	
	public static void main(String[] args) {
		Scanner inputData = new Scanner(System.in);
		SoHoc temp = new SoHoc();
		System.out.print("Nhap M trong khoang 2 <= M <= 100: ");
		int M = temp.checkEx(inputData);
		
		System.out.print("DANH SACH SO NGUYEN TO NHO HON HOAC BANG M: ");
		for (int i = 2; i <= M; i++) {
			if (temp.checkSNT(i) == true)
				System.out.print(i + " ");
		}
		inputData.close();
	}
}