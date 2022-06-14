
public class Passenger {
	
	private int id;
	private String name;
	private String surname;
	private String gender;
	private int journey_id;
	

	
	public Passenger(int id, String name, String surname, String gender, int journey_id) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.journey_id = journey_id;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getJourney_id() {
		return journey_id;
	}
	public void setJourney_id(int journey_id) {
		this.journey_id = journey_id;
	}
}
