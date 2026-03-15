# Library Management System (Java)

A simple console-based Library Management System built using Java.

## Features
- Add books
- View all books
- Issue books to users
- Return books
- Search books by ID
- File persistence using books.txt

## Technologies Used
- Java
- OOP (Classes & Objects)
- HashMap
- File Handling

## Project Structure
library-management-system/
│
├── Main.java
├── model/
│   └── Book.java
├── service/
│   └── LibraryService.java
└── books.txt

## How to Run

Compile:

javac Main.java model/Book.java service/LibraryService.java

Run:

java Main

## Sample Menu

1 Add Book  
2 Show Books  
3 Issue Book  
4 Return Book  
5 Search Book  
6 Exit