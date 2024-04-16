import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagementSystem {
    private final List<Employee> employees = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added successfully.");
    }

    public void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            System.out.println("Total Employees: " + Employee.getEmployeeCount());
            for (Employee employee : employees) {
                System.out.println("\nEmployee Details:");
                employee.showInfo();
            }
        }
    }

    public void updateEmployee(String ID) {
        for (Employee employee : employees) {
            if (employee.ID.equals(ID)) {
                System.out.print("Enter New Full Name: ");
                employee.fullName = scanner.nextLine();
                System.out.print("Enter New Birth Day: ");
                employee.birthDay = scanner.nextLine();
                System.out.print("Enter New Phone: ");
                employee.phone = scanner.nextLine();
                System.out.print("Enter New Email: ");
                employee.email = scanner.nextLine();
                System.out.println("Employee updated successfully.");
                return;
            }
        }
        System.out.println("Employee with ID " + ID + " not found.");
    }

    public void deleteEmployee(String ID) {
        for (Employee employee : employees) {
            if (employee.ID.equals(ID)) {
                employees.remove(employee);
                Employee.employeeCount--;
                System.out.println("Employee deleted successfully.");
                return;
            }
        }
        System.out.println("Employee with ID " + ID + " not found.");
    }

    // chức năng ghi thông tin nhân viên vào file
    public void writeEmployeesToFile(String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(employees);
            System.out.println("Employee data written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing employee data to file: " + e.getMessage());
        }
    }

    // chức năng đọc thông tin nhân viên từ file
    public void readEmployeesFromFile(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Employee> storedEmployees = (List<Employee>) inputStream.readObject();
            employees.addAll(storedEmployees);
            System.out.println("Employee data read from file successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading employee data from file: " + e.getMessage());
        }
    }
}
