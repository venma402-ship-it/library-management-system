package model;

public class Book {

    private String bookId;
    private String title;
    private boolean issued;
    private String borrower;

    public Book(String bookId, String title){
        this.bookId = bookId;
        this.title = title;
        this.issued = false;
        this.borrower = "";
    }

    public String getBookId(){
        return bookId;
    }

    public String getTitle(){
        return title;
    }

    public boolean isIssued(){
        return issued;
    }

    public String getBorrower(){
        return borrower;
    }

    public void issueBook(String user){
        issued = true;
        borrower = user;
    }

    public void returnBook(){
        issued = false;
        borrower = "";
    }
}