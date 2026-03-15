import java.util.*;
import model.Book;
import service.LibraryService;

public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        LibraryService library = new LibraryService();
        library.loadBooks();

        while(true){

            System.out.println("\n1 Add Book");
            System.out.println("2 Show Books");
            System.out.println("3 Issue Book");
            System.out.println("4 Return Book");
            System.out.println("5 Search Book");
            System.out.println("6 Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){

                case 1:
                     System.out.print("Enter Book ID: ");
                     String id = sc.nextLine();

                     System.out.print("Enter Book Title: ");
                     String title = sc.nextLine();

                if(id.trim().isEmpty() || title.trim().isEmpty()){
                     System.out.println("Book ID and Title cannot be empty");
                     break;
                     }

                    library.addBook(new Book(id,title));
                     break;

                case 2:
                    library.showBooks();
                    break;

               case 3:
    System.out.print("Enter Book ID: ");
    String bookId = sc.nextLine();

    System.out.print("Enter User Name: ");
    String user = sc.nextLine();

    library.issueBook(bookId, user);
    break;

                case 4:
                    System.out.print("Enter Book ID: ");
                    library.returnBook(sc.nextLine());
                    break;

                case 5:
                    System.out.print("Enter Book ID: ");
                    library.searchBook(sc.nextLine());
                    break;

                case 6:
                    library.saveBooks();
                    System.out.println("Data saved. Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}