# Mini Search Engine

## Project Description

This project is a keyword-based Mini Search Engine developed in Java. It uses a HashMap to build an inverted index for efficient searching of multiple text files.

The search engine reads all text files from the documents folder, processes the text, creates an index, and allows users to search keywords quickly using a console-based menu.

---

## Features

- Read multiple text files
- Build an inverted index using HashMap
- Efficient keyword searching
- Single Keyword Search
- AND Search
- OR Search
- Stop-word removal
- Case-insensitive search
- Console-based user interface

---

## Technologies Used

- Java
- HashMap
- HashSet
- File Handling
- BufferedReader
- String Processing

---

## Project Structure

MiniSearchEngine/

├── src/

│   ├── Main.java

│   ├── Indexer.java

│   ├── SearchEngine.java

│   └── FileReaderUtil.java

│

└── documents/

    ├── java.txt

    ├── python.txt

    ├── cricket.txt

    ├── cooking.txt

    └── technology.txt

---

## How to Run

1. Open the project in Visual Studio Code.
2. Make sure JDK is installed.
3. Open Main.java.
4. Run Main.java.
5. Select a menu option.
6. Enter keywords to search.

---

## Sample Output

========== MINI SEARCH ENGINE ==========

1. Single Keyword Search

2. AND Search

3. OR Search

4. Exit

---

## Time Complexity

| Operation | Complexity |
|-----------|------------|
| Build Index | O(N × M) |
| Single Search | O(1) Average |
| AND Search | O(k × s) |
| OR Search | O(k) |

Where:

- N = Number of files
- M = Average words per file
- k = Number of keywords
- s = Smallest result set

---

## Future Improvements

- GUI using Java Swing
- Search result ranking
- Phrase searching
- File preview
- Save index to disk

---

## Author

Name: Pooja Suthar

Course: B.Tech CSE

Project: Mini Search Engine

Language: Java