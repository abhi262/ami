package emp;
public class Employee {
	private int id;
	private String name;
	private int age;
	private Employetype employeeType;
	
	public Employee(int id, String name, int age,Employetype employeeType) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.employeeType=employeeType;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	  public Employetype getEmployeeType() {
		  return this.employeeType;
	    }

	    public void setEmployeeType(Employetype employeeType) {
	        this.employeeType = employeeType;
	    }

}

