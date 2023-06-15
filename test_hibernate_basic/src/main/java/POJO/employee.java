package POJO;

import java.time.LocalDate;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

  
   @Entity
   @Table(name= "emps")
public class employee {
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Column(name ="emp_id")
    
	private Integer empid;
	   
	   @Column(name="first_name",length=20)
	private String firstname;
	   @Column(name="lastname",length=20)
	private String lastname;
	   @Column(length=30,unique=true)
	private String email;
	   @Column(length=20,nullable=false)
	private String password;
	   @Transient
	private String confirmpassword;
	   @Column(name="join_date")
	private LocalDate joinDate;
	   @Enumerated(EnumType.STRING)
	   @Column(length=20)
	private Employment type;
	private double salary;
	   @Lob
	private byte[]image;
	
	public employee()
	{
		super();
		
	}

	public employee(String firstname, String lastname, String email, String password,
			String confirmpassword, LocalDate joinDate, Employment type,double salary) {
		super();
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.joinDate = joinDate;
		this.type = type;
		this.salary=salary;
		
	}

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public Employment getType() {
		return type;
	}

	public void setType(Employment type) {
		this.type = type;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "employee [empid=" + empid + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", confirmpassword=" + confirmpassword + ", joinDate=" + joinDate
				+ ", type=" + type + ", image=" + Arrays.toString(image) + "]";
	}
	
	
	
}
