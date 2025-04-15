# Employee Management System

## Overview
The Employee Management System is a simple Java-based application that allows users to add, remove, and search for employees. Employee records are stored in a text file for persistence.

## Features
- **Add Employee**: Users can enter details such as ID, full name, email, age, and date of birth to add a new employee.
- **Remove Employee**: Allows users to remove an employee by entering their ID.
- **Find Employee**: Enables users to search for employees by name or email with sorting options.
- **Data Persistence**: Employee records are saved to a file and loaded when the program starts.

## Technologies Used
- Java
- File Handling (BufferedReader, BufferedWriter)
- Collections (ArrayList)
- User Input Handling (Scanner)

## How to Run
1. Compile the program using `javac EmployeeManager.java`.
2. Run the program using `java EmployeeManager`.
3. Follow the menu prompts to add, remove, or search for employees.

## File Structure
- `EmployeeManager.java`: The main class that handles user interaction and file operations.
- `StaffMember.java`: A class representing an employee, including methods for retrieving and formatting employee data.
- `employees.txt`: The file where employee records are stored.

## Example Usage
```
1. Add Employee
2. Remove Employee
3. Find Employee
4. Exit
Enter your choice: 1
Employee ID: 101
Full Name: John Doe
Email: john.doe@example.com
Age: 30
Date of Birth: 1993-05-12
Employee added successfully.
```

## Future Enhancements
- Add a graphical user interface (GUI) for easier interaction.
- Implement a database for better scalability.
- Add more search and filter options.

## License
This project is released under the MIT License.