package net.labtest.usermanagement.model;

public class LabTest {
	private int id;
	private String name;
	private String area;
	private String lab;
	private String email;
	private String phone;
	
	
	public LabTest(int id, String name, String area, String lab, String email, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.area = area;
		this.lab = lab;
		this.email = email;
		this.phone = phone;
	}
	
	
	public LabTest(String name, String area, String lab, String email, String phone) {
		super();
		this.name = name;
		this.area = area;
		this.lab = lab;
		this.email = email;
		this.phone = phone;
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
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getLab() {
		return lab;
	}
	public void setLab(String lab) {
		this.lab = lab;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
