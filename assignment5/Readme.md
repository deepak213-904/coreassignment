# Serialization and Deserialization in Java

This project demonstrates how to serialize and deserialize a list of objects in Java. The objects include `Learner` and `Location`, which are analogous to `Student` and `Address` but with different naming conventions.

## Features
- Serialization of a list of `Learner` objects into a file (`learners.ser`)
- Deserialization of `Learner` objects from the file and printing them

## Classes Overview
### `Location`
Represents the location details of a learner, including city, state, postal code, and country.

### `Learner`
Stores the learner's name, date of birth, and associated location.

### `SerializationDemo`
Handles the serialization process, saving a list of `Learner` objects to a file.

### `DeserializationDemo`
Handles the deserialization process, reading and displaying the `Learner` objects from the file.

## How to Run
1. Compile the Java files:
   ```sh
   javac SerializationDemo.java DeserializationDemo.java
   ```
2. Run the serialization program:
   ```sh
   java SerializationDemo
   ```
3. Run the deserialization program:
   ```sh
   java DeserializationDemo
   ```
   This should display the stored `Learner` objects.

## Requirements
- Java JDK 8 or later

## License
This project is open-source and free to use.