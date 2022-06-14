
public class Company {
	
	private int id;
	private String name;
	private String founder;
	
	Company(int id, String name, String founder){
		this.id = id;
		this.name = name;
		this.founder = founder;
	}
	
	Company(){
		
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
	public String getFounder() {
		return founder;
	}
	public void setFounder(String founder) {
		this.founder = founder;
	}


}
