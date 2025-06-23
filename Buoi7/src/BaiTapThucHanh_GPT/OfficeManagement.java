package BaiTapThucHanh_GPT;

import java.util.Scanner;

//Lop giao dien
interface Employee {
	void displayInfo();
	double calculateSalary();
}

//Lop truu tuong
abstract class AbstractEmployee implements Employee {
	private String name;
	private int age;
	private String employeeID;

	public AbstractEmployee(String name, int age, String employeeID) {
		this.name = name;
		this.age = age;
		this.employeeID = employeeID;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getID() {
		return employeeID;
	}
}

//Lop con 1
class OfficeEmployee extends AbstractEmployee {
	private double baseSalary;

	public OfficeEmployee(String name, int age, String employeeID, double baseSalary) {
		super(name, age, employeeID);
		this.baseSalary = baseSalary;
	}

	@Override
	public double calculateSalary() {
		double salary = baseSalary;
		return salary;
	}

	@Override
	public void displayInfo() {
		System.out.println("|| Thong tin nhan vien Van Phong ||");
		System.out.println("Ten: " + getName());
		System.out.println("Tuoi: " + getAge());
		System.out.println("Ma nhan vien: " + getID());
		System.out.printf("Luong: %.2f\n", calculateSalary());
		System.out.println("------------------------------");
	}
}

//Lop con 2
class ITEmployee extends AbstractEmployee {
	private double hourlyRate;
	private double hoursWorked;

	public ITEmployee(String name, int age, String employeeID, double hourlyRate, double hoursWorked) {
		super(name, age, employeeID);
		this.hourlyRate = hourlyRate;
		this.hoursWorked = hoursWorked;
	}

	@Override
	public double calculateSalary() {
		double salary = hourlyRate * hoursWorked;
		return salary;
	}

	@Override
	public void displayInfo() {
		System.out.println("|| Thong tin nhan vien IT ||");
		System.out.println("Ten: " + getName());
		System.out.println("Tuoi: " + getAge());
		System.out.println("Ma nhan vien: " + getID());
		System.out.printf("Luong: %.2f\n", calculateSalary());
		System.out.println("------------------------------");
	}
}

//Lop con 3
class SalesEmployee extends AbstractEmployee {
	private double salesAmount;
	private double commissionRate;

	public SalesEmployee(String name, int age, String employeeID, double salesAmount, double commissionRate) {
		super(name, age, employeeID);
		this.salesAmount = salesAmount;
		this.commissionRate = commissionRate;
	}

	@Override
	public double calculateSalary() {
		double salary = salesAmount * commissionRate;
		return salary;
	}

	@Override
	public void displayInfo() {
		System.out.println("|| Thong tin nhan vien Sales ||");
		System.out.println("Ten: " + getName());
		System.out.println("Tuoi: " + getAge());
		System.out.println("Ma nhan vien: " + getID());
		System.out.printf("Luong: %.2f\n", calculateSalary());
		System.out.println("------------------------------");
	}
}

//Lop chinh
public class OfficeManagement {
	public static void main(String[] args) {
		Scanner inputData = new Scanner(System.in);

		System.out.print("Nhap so luong nhan vien: ");
		int N = inputData.nextInt();
		inputData.nextLine();
		AbstractEmployee[] employeeList = new AbstractEmployee[N];

		// Nhap thong tin nhan vien
		for (int i = 0; i < N; i++) {
			System.out.println("Nhap thong tin nhan vien thu " + (i + 1));
			System.out.print("Loai nhan vien (1 = Office, 2 = IT, 3 = Sales): ");
			int typeValue = inputData.nextInt();
			inputData.nextLine();

			System.out.print("Nhap ten nhan vien: ");
			String name = inputData.nextLine();

			System.out.print("Nhap tuoi: ");
			int age = inputData.nextInt();
			inputData.nextLine();

			System.out.print("Nhap ma nhan vien: ");
			String employeeID = inputData.nextLine();

			if (typeValue == 1) {
				System.out.print("Nhap luong co ban: ");
				double baseSalary = inputData.nextDouble();
				inputData.nextLine();
				employeeList[i] = new OfficeEmployee(name, age, employeeID, baseSalary);
			}
			if (typeValue == 2) {
				System.out.print("Nhap luong / gio lam: ");
				double hourlyRate = inputData.nextDouble();
				inputData.nextLine();
				System.out.print("Nhap so gio lam: ");
				double hoursWorked = inputData.nextDouble();
				inputData.nextLine();
				employeeList[i] = new ITEmployee(name, age, employeeID, hourlyRate, hoursWorked);
			}
			if (typeValue == 3) {
				System.out.print("Nhap doanh thu: ");
				double salesAmount = inputData.nextDouble();
				inputData.nextLine();
				System.out.print("Nhap hoa hong: ");
				double commissionRate = inputData.nextDouble();
				inputData.nextLine();
				employeeList[i] = new SalesEmployee(name, age, employeeID, salesAmount, commissionRate);
			}
		}

		// Hien thi thong tin nhan vien
		System.out.println("---------- Thong Tin Nhan Vien ----------");
		for (int i = 0; i < N; i++) {
			employeeList[i].displayInfo();
		}
		inputData.close();
	}
}