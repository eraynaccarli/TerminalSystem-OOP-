
public class Bus {
 
	private int id;
	private String name;
	private int capacity;
	private int company_id;
	private int driver_id;
	
	
	
	
	public Bus(int id, String name, int capacity, int company_id, int driver_id) {
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.company_id = company_id;
		this.driver_id = driver_id;
	}
	
	public Bus() {
		
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
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	public int getDriver_id() {
		return driver_id;
	}
	public void setDriver_id(int driver_id) {
		this.driver_id = driver_id;
	}
	
	
}
