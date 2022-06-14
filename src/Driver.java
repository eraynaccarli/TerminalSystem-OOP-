
public class Driver {

	private int id;
	private String name;
	private String surname;
	private int age;
	private int company_id;
	
	
	Driver(int id , String name, String surname,int age , int company_id){
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.company_id = company_id;
	}
	
	Driver(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
