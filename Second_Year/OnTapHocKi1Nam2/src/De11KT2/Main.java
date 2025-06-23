package De11KT2;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

//Lop CuocHen
class CuocHen {
	private String maCuocHen;
	private LocalTime startTime;
	private LocalTime endTime;
	
	//Constructor
	public CuocHen(String maCuocHen, LocalTime startTime, LocalTime endTime) {
		this.maCuocHen = maCuocHen;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	//Setter
	public void setMaCuocHen(String maCuocHen) {
		this.maCuocHen = maCuocHen;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	
	//Getter
	public String getMaCuocHen() {
		return maCuocHen;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	
	//Kiem tra khung thoi gian
	public boolean checkTime(LocalTime startTime, LocalTime endTime) {
		if (endTime.isAfter(startTime))
			return true;
		else
			return false;
	}
	
	//Kiem tra ngoai le
	public boolean checkExTime(LocalTime startTime, LocalTime endTime) {
		boolean isValid = false;
			try {
				if (checkTime(startTime, endTime) == false) {
					throw new IllegalArgumentException("Thoi gian khong hop le!");
				}
				isValid = true;
			} catch (NumberFormatException ex) {
				System.out.println("Gia tri khong hop le! | " + ex.getMessage());
				System.out.print("Vui long nhap lai!\n ");
			} catch (IllegalArgumentException ex) {
				System.out.println("Gia tri khong hop le! | " + ex.getMessage());
				System.out.print("Vui long nhap lai!\n");
			} catch (DateTimeParseException ex) {
				System.out.println("Thoi gian khong hop le! | " + ex.getMessage());
				System.out.print("Vui long nhap lai!\n");
			} catch (InputMismatchException ex) {
				System.out.println("Du lieu khong khop voi kieu mong doi! | " + ex.getMessage());
				System.out.print("Vui long nhap lai!\n");
			} catch (Exception ex) {
				System.out.println("Loi khong xac dinh! | " + ex.getMessage());
				System.out.print("Vui long nhap lai!\n");
			}
		if (isValid == true)
			return true;
		else
			return false;
	}

	//Nhap du lieu
	public void nhapTT(Scanner inputData) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm"); //Tao dinh dang thoi gian HH:mm
		String value; //Tao bien luu gia tri String thoi gian
		
		System.out.print("Nhap ma cuoc hen: ");
		maCuocHen = inputData.nextLine();
		
		while (true) {
			try {
				System.out.print("Nhap thoi gian ban dau (HH:mm): ");
				value = inputData.nextLine(); //Tao bien luu gia tri String thoi gian
				startTime = LocalTime.parse(value, format); //Chuyen doi bien String sang dung dinh dang HH:mm
				
				System.out.print("Nhap thoi gian ket thuc (HH:mm): ");
				value = inputData.nextLine(); //Tao bien luu gia tri String thoi gian
				endTime = LocalTime.parse(value, format); //Chuyen doi bien String sang dung dinh dang HH:mm
				
				if (checkTime(startTime, endTime) == false) {
					throw new IllegalArgumentException("Thoi gian khong hop le!");
				}
				break;
			} catch (NumberFormatException ex) {
				System.out.println("Gia tri khong hop le! | " + ex.getMessage());
				System.out.print("Vui long nhap lai!\n ");
			} catch (IllegalArgumentException ex) {
				System.out.println("Gia tri khong hop le! | " + ex.getMessage());
				System.out.print("Vui long nhap lai!\n");
			} catch (DateTimeParseException ex) {
				System.out.println("Loi dinh dang du lieu! | " + ex.getMessage());
				System.out.print("Vui long nhap lai!\n");
			} catch (InputMismatchException ex) {
				System.out.println("Du lieu khong khop voi kieu mong doi! | " + ex.getMessage());
				System.out.print("Vui long nhap lai!\n");
			} catch (Exception ex) {
				System.out.println("Loi khong xac dinh! | " + ex.getMessage());
				System.out.print("Vui long nhap lai!\n");
			}
		}
	}
	
	@Override
	public String toString() {
		return "Ma cuoc hen: " + maCuocHen + "\n" +
				"Thoi gian bat dau: " + startTime + "\n" +
				"Thoi gian ket thuc: " + endTime + "\n";
	}
}

//Lop CuocHenKhachHang
class CuocHenKhachHang extends CuocHen {
	private LocalTime startPoint = LocalTime.of(7, 59);
	private LocalTime endPoint = LocalTime.of(17, 1);
	
	//Constructor
	public CuocHenKhachHang(String maCuocHen, LocalTime startTime, LocalTime endTime) {
		super(maCuocHen, startTime, endTime);
	}
	
	//Kiem tra khung thoi gian
	@Override
	public boolean checkTime(LocalTime startTime, LocalTime endTime) {
		if(endTime.isAfter(startTime) && (startTime.isAfter(startPoint) && endTime.isBefore(endPoint)))
			return true;
		else
			return false;
	}
	
	//Setter
	public void setStartPoint(LocalTime startPoint) {
		this.startPoint = startPoint;
	}
	public void setEndPoint(LocalTime endPoint) {
		this.endPoint = endPoint;
	}
	
	//Getter
	public LocalTime getStartPoint() {
		return startPoint;
	}
	public LocalTime getEndPoint() {
		return endPoint;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner inputData = new Scanner(System.in);
		CuocHenKhachHang CHKH = new CuocHenKhachHang("", LocalTime.of(8, 0), LocalTime.of(17, 0));
		
		System.out.println("----- Nhap Du Lieu -----");
		CHKH.nhapTT(inputData);
		
		System.out.println("----- Hien Thi Du Lieu -----");
		System.out.print(CHKH.toString());
		
		inputData.close();;
		System.out.println("----- Ket Thuc Chuong Trinh -----");
	}
}
