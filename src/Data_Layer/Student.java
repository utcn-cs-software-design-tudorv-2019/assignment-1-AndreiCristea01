package Data_Layer;

public class Student {
	
	String CNP;
	String Name;
	String username;
	String password;
	
	int ID;
	
	public Student(String c,String n,int id,String username, String password)
	{
		this.CNP=c;
		this.Name=n;
		
		this.ID=id;
		this.username=username;
		this.password=password;
		
		
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public String getCNP() {
		return CNP;
	}

	public void setCNP(String cNP) {
		CNP = cNP;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	@Override
	public String toString() {
		return "Student [CNP=" + CNP + ", Name=" + Name + ", ID=" + ID + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
