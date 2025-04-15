# WebPageWordCounter

## Overview
WebPageWordCounter is a Java program that counts occurrences of specific words from the content of web pages. It reads a list of URLs and words from text files and generates a report showing the top occurrences per URL and overall word counts across all URLs.

## Features
- Reads URLs from `urls.txt`.
- Reads words to search for from `words.txt`.
- Fetches web page content using **JSoup**.
- Counts occurrences of given words.
- Displays the top 3 words per URL.
- Outputs the total word count across all URLs, sorted in descending order.

## Prerequisites
Ensure you have the following installed:
- **Java 8 or higher**
- **JSoup library** (`jsoup-1.16.2.jar`)

## Setup Instructions
### 1. Install JSoup
If using **Maven**, add this dependency to `pom.xml`:
```xml
<dependency>
    <groupId>org.jsoup</groupId>
    <artifactId>jsoup</artifactId>
    <version>1.16.2</version>
</dependency>
```
If not using Maven, download `jsoup-1.16.2.jar` from [JSoup's official website](https://jsoup.org/download) and add it to your classpath.

### 2. Prepare Input Files
Create two text files in the same directory as your Java program:
- **urls.txt** (contains website URLs, one per line)
- **words.txt** (contains words to count, one per line)

Example:
#### urls.txt
```
https://example.com
https://anotherexample.com
```

#### words.txt
```
dog
cat
lion
```

### 3. Compile and Run
#### **Using an IDE (Eclipse/IntelliJ)**
- Add `jsoup-1.16.2.jar` to your project's build path.
- Run `WebPageWordCounter.java`.

#### **Using Command Line**
```sh
javac -cp .;jsoup-1.16.2.jar WebPageWordCounter.java
java -cp .;jsoup-1.16.2.jar WebPageWordCounter
```

## Expected Output
```
Word Count Per URL
==================
https://example.com
dog - 5
cat - 3
lion - 2

=================================

Total Word Count Across URLs
===========================
dog - 8
cat - 5
lion - 3
```

## Notes
- Ensure your internet connection is active when running the program.
- The program handles errors gracefully and prints messages if a URL cannot be fetched.
- Modify `words.txt` to search for different words as needed.

## License
This project is open-source. Feel free to modify and use it as needed.