package Data_Layer;

public class Teachers {
	
	int ID;
	String Name;
	String username;
	String password;
	
	public Teachers(int id,String name,String username,String password) {
		
		this.ID=id;
		this.Name=name;
		this.username=username;
		this.password=password;
	}

	public Teachers() {
		// TODO Auto-generated constructor stub
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
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

	@Override
	public String toString() {
		return "Teachers [ID=" + ID + ", Name=" + Name + ", username=" + username + ", password=" + password + "]";
	}


}
