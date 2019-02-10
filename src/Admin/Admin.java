package Admin;

public class Admin implements DBConnector{
	
	private String fname;
	private String lname;
	private String MNum;
	private String email;
	private String pass;
	private String pass2;
	private static Admin admin = null;
	
	private Admin(){
		
	};
	
	public static Admin getInstance(){
		if(admin == null)
			admin = new  Admin();
		return admin;
	}
	

	public String getFirstName() {
		return fname;
	}

	public void setFirstName(String fname) {
		this.fname = fname;
	}

	public String getLastName() {
		return lname;
	}

	public void setLastName(String lname) {
		this.lname = lname;
	}

	public String getMobileNumber() {
		return MNum;
	}

	public void setMobileNumber(String MNum) {
		this.MNum = MNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return pass;
	}

	public void setPassword(String pass) {
		this.pass = pass;
	}

	public String getConfirmPassword() {
		return pass2;
	}

	public void setConfirmPassword(String pass2) {
		this.pass2 = pass2;
	}
	
	
	@Override
	
	public String toString(){
		return "fname = " + fname + "\n" + "lname = " +lname + "\n" + "MNum = " + MNum +
				"\n" + "email = " + email + "\n" + "pass = " + pass + "\n" + " pass2 = " + pass2 ;
		
	}

}
