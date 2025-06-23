package OnTapBaiKiemTraSo2;

public class Person {
	private String name;
	private String gender;
	private int age;
	
	//Constructor
	public Person(String name, String gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	
	//Output
	public void outputInfo() {
		System.out.println("Ho va ten: " + name);
		System.out.println("Gioi tinh: " + gender);
		System.out.println("Tuoi: " + age);
	}
}