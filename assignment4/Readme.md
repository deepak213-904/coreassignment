# Bank Simulation System

## Overview
The Bank Simulation System is a Java-based program that demonstrates the impact of multithreading on bank transactions, specifically focusing on synchronized and unsynchronized withdrawals. It shows how concurrent withdrawals can lead to inconsistencies when synchronization is not used.

## Features
- **Unsynchronized Withdrawal**: Simulates a scenario where multiple users withdraw from a shared bank account without synchronization, leading to possible overdraw situations.
- **Synchronized Withdrawal**: Uses synchronized methods to ensure thread safety and prevent inconsistent account balances.
- **Multithreading Implementation**: Uses Java threads to simulate multiple users withdrawing money simultaneously.

## Technologies Used
- Java
- Multithreading (Thread class)
- Synchronization (synchronized keyword)
- Exception Handling

## How to Run
1. Compile the program using:
   ```sh
   javac BankSimulation.java
   ```
2. Run the program using:
   ```sh
   java BankSimulation
   ```
3. The output will demonstrate both unsynchronized and synchronized withdrawal scenarios.

## File Structure
- `BankSimulation.java`: The main class that runs the banking simulation.
- `BankAccount.java`: A class representing the bank account and withdrawal methods.
- `NonSynchronizedWithdrawal.java`: A thread class for withdrawals without synchronization.
- `SynchronizedWithdrawal.java`: A thread class for thread-safe withdrawals.

## Example Output
```
===== Demonstrating Unsynchronized Withdrawal (Overdraw Problem) =====
User 1 is withdrawing ₹800
User 2 is withdrawing ₹700
User 1 successfully withdrew ₹800. Remaining Balance: ₹200
User 2 attempted to withdraw ₹700 but insufficient funds. Balance: ₹200

===== Demonstrating Synchronized Withdrawal (Thread-Safe) =====
User 1 is withdrawing ₹800
User 1 successfully withdrew ₹800. Remaining Balance: ₹200
User 2 attempted to withdraw ₹700 but insufficient funds. Balance: ₹200
```

## Future Enhancements
- Implement deposit functionality.
- Introduce an interactive user interface (GUI).
- Store transactions in a database for persistence.
- Add logging mechanisms to track transactions.

## License
This project is released under the MIT License.