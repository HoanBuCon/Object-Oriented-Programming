package DeSo1;

import java.util.Scanner;
import java.text.DecimalFormat;

//Lop giao dien
interface SanPhamDangBan {
	void nhapTT(Scanner inputData);
	String toString();
}

//Lop truu tuong
abstract class SanPham implements SanPhamDangBan {
	private String tenSP;
	private double giaThanh;
	private int soLuong;

	public SanPham(String tenSP, double giaThanh, int soLuong) {
		this.tenSP = tenSP;
		this.giaThanh = giaThanh;
		this.soLuong = soLuong;
	}

	// Setter
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public void setGiaThanh(double giaThanh) {
		this.giaThanh = giaThanh;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	// Getter
	public String getTenSP() {
		return tenSP;
	}

	public double getGiaThanh() {
		return giaThanh;
	}

	public int getSoLuong() {
		return soLuong;
	}

	// Kiem tra ngoai le
	public double checkEx(Scanner inputData, String type) {
		double value = 0;
		while (true) {
			try {
				if (type.equals("soThuc")) {
					value = Double.parseDouble(inputData.nextLine());
					if (value < 0) {
						throw new NumberFormatException("Vui long nhap gia tri lon hon 0!");
					}
				} else if (type.equals("soNguyen")) {
					value = Integer.parseInt(inputData.nextLine());
					if (value < 0) {
						throw new NumberFormatException("Vui long nhap so luong lon hon hoac bang 0!");
					}
				} else
					throw new IllegalArgumentException("Kieu gia tri khong hop le!");
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

	// Nhap thong tin
	public void nhapTT(Scanner inputData) {
		System.out.print("Nhap ten san pham: ");
		this.tenSP = inputData.nextLine();

		System.out.print("Nhap gia thanh: ");
		this.giaThanh = checkEx(inputData, "soThuc");

		System.out.print("Nhap so luong: ");
		this.soLuong = (int) checkEx(inputData, "soNguyen");
	}

	// In thong tin
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.00");
		return "Ten san pham: " + tenSP + "\n" +
				"Gia thanh: " + df.format(giaThanh) + "\n" +
				"So luong: " + soLuong;
	}
}

//Lop DienThoai
class DienThoai extends SanPham {
	private String hangSX;
	private String timeBaoHanh;

	public DienThoai(String tenSP, double giaThanh, int soLuong, String hangSX, String timeBaoHanh) {
		super(tenSP, giaThanh, soLuong);
		this.hangSX = hangSX;
		this.timeBaoHanh = timeBaoHanh;
	}

	// Setter
	public void setHangSX(String hangSX) {
		this.hangSX = hangSX;
	}

	public void setTimeBaoHanh(String timeBaoHanh) {
		this.timeBaoHanh = timeBaoHanh;
	}

	// Getter
	public String getHangSX() {
		return hangSX;
	}

	public String getTimeBaoHanh() {
		return timeBaoHanh;
	}

	// Nhap thong tin
	public void nhapTT(Scanner inputData) {
		super.nhapTT(inputData);

		System.out.print("Nhap hang san xuat: ");
		this.hangSX = inputData.nextLine();

		System.out.print("Nhap thoi gian bao hanh: ");
		this.timeBaoHanh = inputData.nextLine();
	}

	// In thong tin
	@Override
	public String toString() {
		return super.toString() + "\n" +
				"Hang san xuat: " + hangSX + "\n" +
				"Thoi gian bao hanh: " + timeBaoHanh;
	}
}

//Lop chinh
public class QL_SanPham {
	public void bubbleSort(DienThoai[] phoneList) {
		int n = phoneList.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (phoneList[j].getTenSP().compareTo(phoneList[j + 1].getTenSP()) > 0) {
					DienThoai temp = phoneList[j];
					phoneList[j] = phoneList[j + 1];
					phoneList[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner inputData = new Scanner(System.in);
		System.out.print("Nhap so luong san pham: ");
		SanPham temp = new SanPham("", 0, 0) {
		};
		int N = (int) temp.checkEx(inputData, "soNguyen");

		// Khoi tao danh sach dien thoai
		int scale = (int) N;
		DienThoai[] phoneList = new DienThoai[scale];
		for (int i = 0; i < scale; i++) {
			System.out.printf("----- NHAP THONG TIN SAN PHAM THU %d -----\n", i + 1);
			phoneList[i] = new DienThoai("", 0, 0, "", "");
			phoneList[i].nhapTT(inputData);
		}

		QL_SanPham sort = new QL_SanPham();
		sort.bubbleSort(phoneList);

		for (int i = 0; i < scale; i++) {
			System.out.printf("----- THONG TIN SAN PHAM THU %d -----\n", i + 1);
			System.out.println(phoneList[i].toString());
		}
		inputData.close();
	}
}