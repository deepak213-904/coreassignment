package assignment3;

import java.io.*;
import java.util.*;

public class EmployeeManager {
    private static final String DATA_FILE = "employees.txt";
    private static List<StaffMember> staffList = new ArrayList<>();

    public static void main(String[] args) {
        loadStaffFromFile();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Find Employee");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStaffMember(scanner);
                    break;
                case 2:
                    removeStaffMember(scanner);
                    break;
                case 3:
                    findStaffMembers(scanner);
                    break;
                case 4:
                    saveStaffToFile();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStaffMember(Scanner scanner) {
        System.out.print("Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Full Name: ");
        String fullName = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Date of Birth: ");
        String birthDate = scanner.nextLine();

        StaffMember member = new StaffMember(id, fullName, email, age, birthDate);
        staffList.add(member);
        saveStaffToFile();
        System.out.println("Employee added successfully.");
    }

    private static void removeStaffMember(Scanner scanner) {
        System.out.print("Enter Employee ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean deleted = staffList.removeIf(member -> member.getId() == id);
        if (deleted) {
            saveStaffToFile();
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee ID not found.");
        }
    }

    private static void findStaffMembers(Scanner scanner) {
        System.out.print("Enter name or email to search: ");
        String keyword = scanner.nextLine().toLowerCase();
        System.out.print("Sort by (name/age/dob): ");
        String sortingField = scanner.nextLine().toLowerCase();
        System.out.print("Order (asc/desc): ");
        String order = scanner.nextLine().toLowerCase();

        List<StaffMember> foundStaff = new ArrayList<>();
        for (StaffMember member : staffList) {
            if (member.getFullName().toLowerCase().contains(keyword) || member.getEmail().toLowerCase().contains(keyword)) {
                foundStaff.add(member);
            }
        }

        Comparator<StaffMember> comparator;
        switch (sortingField) {
            case "name":
                comparator = Comparator.comparing(StaffMember::getFullName);
                break;
            case "age":
                comparator = Comparator.comparingInt(StaffMember::getAge);
                break;
            case "dob":
                comparator = Comparator.comparing(StaffMember::getBirthDate);
                break;
            default:
                System.out.println("Invalid sorting field.");
                return;
        }

        if ("desc".equals(order)) {
            comparator = comparator.reversed();
        }

        foundStaff.sort(comparator);
        if (foundStaff.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("\nSearch Results:");
            for (StaffMember member : foundStaff) {
                System.out.println(member);
            }
        }
    }

    private static void loadStaffFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            String record;
            while ((record = reader.readLine()) != null) {
                String[] details = record.split(",");
                if (details.length == 5) {
                    int id = Integer.parseInt(details[0]);
                    String name = details[1];
                    String email = details[2];
                    int age = Integer.parseInt(details[3]);
                    String birthDate = details[4];
                    staffList.add(new StaffMember(id, name, email, age, birthDate));
                }
            }
        } catch (IOException e) {
            System.out.println("No previous employee records found.");
        }
    }

    private static void saveStaffToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE))) {
            for (StaffMember member : staffList) {
                writer.write(member.toCsv());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving employee records.");
        }
    }
}

class StaffMember {
    private int id;
    private String fullName;
    private String email;
    private int age;
    private String birthDate;

    public StaffMember(int id, String fullName, String email, int age, String birthDate) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.age = age;
        this.birthDate = birthDate;
    }

    public int getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public int getAge() { return age; }
    public String getBirthDate() { return birthDate; }

    public String toCsv() {
        return id + "," + fullName + "," + email + "," + age + "," + birthDate;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + fullName + ", Email: " + email + ", Age: " + age + ", DOB: " + birthDate;
    }
}
