import java.io.*;
import java.util.Scanner;

public class Main {
    private static final EmployeeManagementSystem ems = new EmployeeManagementSystem();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Write Employees to File");
            System.out.println("6. Read Employees from File");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    writeEmployeesToFile();
                    break;
                case 6:
                    readEmployeesFromFile();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addEmployee() {
        System.out.print("Enter ID: ");
        String ID = scanner.nextLine();
        System.out.print("Enter Full Name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter Birth Day(dd/mm/yyyy): ");
        String birthDay = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Employee Type: ");
        String employeeType = scanner.nextLine();
    
        Employee employee = new Employee(ID, fullName, birthDay, phone, email, employeeType);
        ems.addEmployee(employee);
    }
    
    private static void viewEmployees() {
        ems.viewEmployees();
    }
    
    private static void updateEmployee() {
        System.out.print("Enter ID of employee to update: ");
        String ID = scanner.nextLine();
        ems.updateEmployee(ID);
    }
    
    private static void deleteEmployee() {
        System.out.print("Enter ID of employee to delete: ");
        String ID = scanner.nextLine();
        ems.deleteEmployee(ID);
    }

    private static void writeEmployeesToFile() {
        System.out.print("Enter file name to write employee data: ");
        String fileName = scanner.nextLine();
        ems.writeEmployeesToFile(fileName);
    }

    private static void readEmployeesFromFile() {
        System.out.print("Enter file name to read employee data: ");
        String fileName = scanner.nextLine();
        ems.readEmployeesFromFile(fileName);
    }
}