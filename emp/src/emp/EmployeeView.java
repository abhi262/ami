package emp;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
public class EmployeeView {
    private Scanner scanner = new Scanner(System.in);
    private Map<String, String> userCredentials = new HashMap<>();
    private Map<Integer, String> adminCredentials = new HashMap<>();
    private int empCount = 4;
    private Employee[] employees = new Employee[50];

    {
        Employee employee1 = new Employee(1, "nausha", 55, Employetype.CEO);
        Employee employee2 = new Employee(2, "akhtar", 33, Employetype.MANAGER);
        Employee employee3 = new Employee(3, "ravi", 22, Employetype.DEVELOPER);
        Employee employee4 = new Employee(4, "Roy", 22, Employetype.CTO);
        employees[0] = employee1;
        employees[1] = employee2;
        employees[2] = employee3;
        employees[3] = employee4;

        // Initialize user credentials
        userCredentials.put("user", "password");
        // Initialize admin credentials
        adminCredentials.put(1234, "adminpassword");
    }

    public void EmployeeView() {
        System.out.println("Employee Management System");
        System.out.println("1) Employee login");
        System.out.println("2)admin Login");
        int option2 = scanner.nextInt();
        scanner.nextLine();
        switch (option2) {
        case 1:
        	userLogin();
            break;
        case 2:
        	adminlogin();
            break;
        default:
        	 System.out.println("Invalid login");
            break;
        }
        
    }

    private void userLogin() {
        System.out.println("Login:");

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Check if it's a user login
        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            userFunctionality();
        }
        else {
        	System.out.print("Invalid credentials\n");
        	EmployeeView();
        }
       
    }
    private void adminlogin() {
    	 // Check if it's an admin login
    	System.out.println("Login:");

        System.out.print("Enter adminname: ");
        String adminid = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (adminCredentials.containsKey(Integer.parseInt(adminid)) && adminCredentials.get(Integer.parseInt(adminid)).equals(password)) {
            adminFunctionality();
        }
        else {
        	System.out.print("Invalid credentials \n ");
        	EmployeeView();
        }
        
    }

    private void userFunctionality() {
        System.out.println("User functionality:");
        System.out.println("1. Display Employee Info");
        System.out.println("2. Update Employee");
        System.out.println("3. Update Password");
        System.out.println("4. Logout");

        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (option) {
            case 1:
                displayEmployeeInfo();
                userFunctionality();
                break;
            case 2:
                updateEmployee();
                userFunctionality();
                break;
            case 3:
                updatePassword("user");
                userFunctionality();
                break;
            case 4:
                System.out.println("Logout.................");
            	EmployeeView();
            	break;           
            	
            default:
                System.out.println("Invalid option");
                userFunctionality();
                break;
        }
    }

    

	private void adminFunctionality() {
        System.out.println("Admin functionality:");
        System.out.println("1. Add New User");
        System.out.println("2. Add Employee");
        System.out.println("3. Delete Employee");
        System.out.println("4. displayEmployeeid");
        System.out.println("5. displayEmployees");
        System.out.println("6. Logout");

        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (option) {
            case 1:
                addNewUser();
                adminFunctionality();
                break;
            case 2:
                addEmployee();
                adminFunctionality();
                break;
            case 3:
                deleteEmployee();
                adminFunctionality();
                break;
            case 4:
            	displayEmployeeid();
            	adminFunctionality();
                break;
            case 5:
            	displayEmployees();
            	adminFunctionality();
                break;
            case 6:
                System.out.println("Logout.................");
                EmployeeView();
//                login(); // Return to login
//                adminFunctionality();
                break;
            default:
                System.out.println("Invalid option");
                adminFunctionality();
                break;
        }
    }

    private void addNewUser() {
    	System.out.print("Enter new username: ");
        String newUsername = scanner.nextLine();

        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();

        userCredentials.put(newUsername, newPassword);
        System.out.println("New user added successfully.");

    }
   

    private void addEmployee() {
    	 boolean ans = true;

		    do {

		    	
		             System.out.println("Enter Employee Id : ");
		             int id = scanner.nextInt();

		             for(Employee emp : employees){
		                 if(emp != null && emp.getId() == id){
		                     try {
		                         throw new EmployeeIdAlreadyExistsException("Employee ID already exist!");
		                     } catch (EmployeeIdAlreadyExistsException e) {
		                         System.out.println(e.toString());
		                         return;
		                     }
		                 }
		             }
		             System.out.println("Enter Employee Name : ");

		        scanner.nextLine();

		        String name = scanner.nextLine();



		        System.out.println("Enter Employee Age : ");

		        int age = scanner.nextInt();



		        System.out.println("Enter Employee Type : ");

		        scanner.nextLine();

		        String typeString = scanner.nextLine();

		        

		        Employetype type = Employetype.valueOf(typeString.toUpperCase());



		        Employee employee = new Employee(id, name, age, type); // Added type here



		        employees[empCount] = employee;

		        empCount++;

		        System.out.println("Employees Added....");

		        System.out.println("Do you want to continue..... y/n");

		        String input = scanner.next();

		        if (!input.equalsIgnoreCase("y")) {

		            ans = false;

		        }
		    	 
		    	
		    	 
		       
		    } while (ans);

		    return;

		}
    

    private void deleteEmployee() {
    	 System.out.println("Enter employee id to delete");

		    int id1 = scanner.nextInt();

		    for (int i = 0; i < employees.length; i++) {

		        if (employees[i] != null && employees[i].getId() == id1) {

		            employees[i] = null;

		            System.out.println("Employee deleted successfully");

		            return;

		        }

		    }

		    System.out.println("Employee not found");

    	
    }

    private void displayEmployeeid() {
    	System.out.println("enter employee id");

		int id1 = scanner.nextInt();

		  for (Employee emp : employees) {

		        if (emp != null && emp.getId() == id1) {

		            

		   

		        		System.out.println("Employee Name: " + emp.getName() + ", Type: " + emp.getEmployeeType());

		        	}

		          

		        }

    }

    private void displayEmployees() {
    	if (employees.length != 0) {

			System.out.println("=======================================");

			System.out.println("Id\t:\tName\t:\tAge\t:\tType");

			System.out.println("=======================================");

		}




		for (Employee emp : employees) {

			if (emp != null) {

				System.out.println(emp.getId() + "   \t\t" + emp.getName() + "\t\t" + emp.getAge() + "\t\t" + emp.getEmployeeType());

			}

		}




		System.out.println("=======================================");

	}
    

    private void displayEmployeeInfo() {
    	if (employees.length != 0) {

			System.out.println("=======================================");

			System.out.println("Id\t:\tName\t:\tAge\t:\tType");

			System.out.println("=======================================");

		}




		for (Employee emp : employees) {

			if (emp != null) {

				System.out.println(emp.getId() + "   \t\t" + emp.getName() + "\t\t" + emp.getAge() + "\t\t" + emp.getEmployeeType());

			}

		}




		System.out.println("=======================================");

    }

    private void updateEmployee() {
    	System.out.println("Enter employee id to update");

	    int id1 = scanner.nextInt();

	    System.out.println("Enter new Employee Name : ");

	    scanner.nextLine();

	    String newName = scanner.nextLine();

	    System.out.println("Enter new Employee Age : ");

	    int newAge = scanner.nextInt();

	    for (Employee emp : employees) {

	        if (emp != null && emp.getId() == id1) {

	            emp.setName(newName);

	            emp.setAge(newAge);

	            System.out.println("Employee updated successfully");

	            return;

	        }

	    }

	    System.out.println("Employee not found");


    }

    private void updatePassword(String username) {
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();
        userCredentials.put(username, newPassword);
        System.out.println("Password updated successfully.");
    }

//    public static void main(String[] args) {
//        new EmployeeView();
//    }
}

