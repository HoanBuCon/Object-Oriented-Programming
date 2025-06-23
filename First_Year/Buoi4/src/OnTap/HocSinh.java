package OnTap;

import java.text.DecimalFormat;

public class HocSinh {
	private String hoTen;
	private double diemToan;
	private double diemLy;
	private double diemHoa;

	public HocSinh(String hoTen, double diemToan, double diemLy, double diemHoa) {
		this.hoTen = hoTen;
		this.diemToan = diemToan;
		this.diemLy = diemLy;
		this.diemHoa = diemHoa;
	}
	
	public double diemTB() {
		return (3 * diemToan + 2 * diemLy + diemHoa) / 6;
	}

	@Override
	public String toString() {
		DecimalFormat temp = new DecimalFormat("#.00");
		return String.format("%-20s %-15s %-15s %-15s %-15s", hoTen, diemToan, diemLy, diemHoa, temp.format(diemTB()));
	}

	//Phuong thuc getter
	public String getName() {
		return hoTen;
	}

	public double getToan() {
		return diemToan;
	}

	public double getLy() {
		return diemLy;
	}

	public double getHoa() {
		return diemHoa;
	}
}