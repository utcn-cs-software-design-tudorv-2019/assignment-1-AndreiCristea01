package Data_Layer;

public class Exam {

	
int id;
	
	
	String name;
	String date;
	public Exam(int id,String date,String name) {
		
		this.id=id;
		
		this.date=date;
		this.name=name;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
