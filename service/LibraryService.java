package service;

import java.util.*;
import java.io.*;
import model.Book;

public class LibraryService {

    private HashMap<String, Book> books;

    public LibraryService(){
        books = new HashMap<>();
    }

    // Add Book
    public void addBook(Book book){

        if(books.containsKey(book.getBookId())){
            System.out.println("Book already exists!");
            return;
        }

        books.put(book.getBookId(), book);
        System.out.println("Book added successfully");
    }

    // Show Books
    public void showBooks(){

        if(books.isEmpty()){
            System.out.println("No books in library");
            return;
        }

        for(Book book : books.values()){

            String status = book.isIssued() ? "Issued" : "Available";
            String borrower = book.isIssued() ? book.getBorrower() : "None";

            System.out.println(
                "ID: " + book.getBookId() +
                " Title: " + book.getTitle() +
                " Status: " + status +
                " Borrower: " + borrower
            );
        }
    }

    // Issue Book
    public void issueBook(String bookId, String user){

        Book book = books.get(bookId);

        if(book == null){
            System.out.println("Book not found");
            return;
        }

        if(book.isIssued()){
            System.out.println("Book already issued to " + book.getBorrower());
            return;
        }

        book.issueBook(user);

        System.out.println("Book issued to " + user);
    }

    // Return Book
    public void returnBook(String bookId){

        Book book = books.get(bookId);

        if(book == null){
            System.out.println("Book not found");
            return;
        }

        if(!book.isIssued()){
            System.out.println("Book was not issued");
            return;
        }

        book.returnBook();
        System.out.println("Book returned successfully");
    }

    // Search Book
    public void searchBook(String bookId){

        Book book = books.get(bookId);

        if(book == null){
            System.out.println("Book not found");
            return;
        }

        String status = book.isIssued() ? "Issued" : "Available";
        String borrower = book.isIssued() ? book.getBorrower() : "None";

        System.out.println(
            "ID: " + book.getBookId() +
            " Title: " + book.getTitle() +
            " Status: " + status +
            " Borrower: " + borrower
        );
    }

    // Load books from file
    public void loadBooks(){

        try{
            BufferedReader br = new BufferedReader(new FileReader("books.txt"));
            String line;

            while((line = br.readLine()) != null){

                String[] data = line.split(",");

                String id = data[0];
                String title = data[1];
                boolean issued = Boolean.parseBoolean(data[2]);

                Book book = new Book(id,title);

                if(issued){
                    book.issueBook("Unknown");
                }

                books.put(id, book);
            }

            br.close();

        }catch(Exception e){
            System.out.println("No previous data found");
        }
    }

    // Save books to file
    public void saveBooks(){

        try{

            BufferedWriter bw = new BufferedWriter(new FileWriter("books.txt"));

            for(Book book : books.values()){

                bw.write(
                    book.getBookId() + "," +
                    book.getTitle() + "," +
                    book.isIssued()
                );

                bw.newLine();
            }

            bw.close();

        }catch(Exception e){
            System.out.println("Error saving books");
        }
    }
}