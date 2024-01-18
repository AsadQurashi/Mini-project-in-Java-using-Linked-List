    import java.util.Scanner;
    public class LibraryManagementSystem {
    public static Scanner sc = new Scanner(System.in);
    private static Library library = new Library();

    // Admin Interface
    private static void admin()
    {
        int choice;
        do {
            System.out.println("\n\t Admin Profile");
            System.out.println("\t -------------\n");
            System.out.println("PRESS 1. Add book");
            System.out.println("PRESS 2. Edit book Information");
            System.out.println("PRESS 3. Remove book");
            System.out.println("PRESS 4. Issue books");
            System.out.println("PRESS 5. Return books");
            System.out.println("PRESS 6. Search books");
            System.out.println("PRESS 7. Display books");
            System.out.println("PRESS 8. Display Issue books");
            System.out.println("PRESS 9. Display returned books history");
            System.out.println("PRESS 10. Delete All data of Library");
            System.out.println("PRESS 0. Exit");
            System.out.print("Enter your choice: ");
            choice = FormatClass.getIntegerFromUser();
            System.out.println("--------------------\n");

            switch (choice) {
                case 1:
                    boolean isIdExist;
                    int id;
                    do {
                        isIdExist=false;
                        System.out.print("Enter book ID: ");
                        id = FormatClass.getIntegerFromUser();
                        if (library.isIdAlreadyExist(id))
                        {
                            System.out.println("This ID is Already exists. Try another ID.");
                            isIdExist=true;
                        }
                    }while (isIdExist);

                    System.out.print("Enter book title: ");
                    String title = FormatClass.getStringFromUser();

                    System.out.print("Enter book author: ");
                    String author = FormatClass.getStringFromUser();

                    System.out.print("Enter book edition : ");
                    int edition= FormatClass.getIntegerFromUser();

                    if (library.isBookAlreadyExist(title,author,edition))
                    {
                        System.out.println("This book already Exist. ");
                        break;
                    }

                    System.out.print("Enter no of copies do you want to add : ");
                    int noOfCopies= FormatClass.getIntegerFromUser();

                    Book newBook = new Book(id, title, author, edition, noOfCopies);
                    library.addBook(newBook);
                    break;

                case 2:
                    library.editBook();
                    break;

                case 3:
                    library.removeBook();
                    break;

                case 4:
                    library.issueBook();
                    break;

                case 5:
                    library.returnBook();
                    break;

                case 6:
                    library.showBook();
                    break;

                case 7:
                    library.displayBooks();
                    break;

                case 8:
                    library.displayIssueBooks();
                    break;

                case 9:
                    library.displayReturnedBooks();
                    break;

                case 10:
                    library.deleteAllLibraryData();
                    break;

                case 0:
                    System.out.println("Admin Exiting... ");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }while (choice!=0);
    }

    // User Interface.
    private static void user()
    {
        int choice;
        do {
            System.out.println("\n\t User Profile");
            System.out.println("\t ------------\n");
            System.out.println("PRESS 1. Display all books");
            System.out.println("PRESS 2. Search book");
            System.out.println("PRESS 3. Borrow book");
            System.out.println("PRESS 4. Return books");
            System.out.println("PRESS 0. Exit.");
            System.out.print("Choice : ");
            choice=FormatClass.getIntegerFromUser();
            switch (choice)
            {
                case 1:
                    library.displayBooks();
                    break;

                case 2:
                    library.showBook();
                    break;

                case 3:
                    library.issueBook();
                    break;

                case 4:
                    library.returnBook();
                    break;

                case 0:
                    System.out.println(" Exiting... ");
                    break;
            }
        }while (choice!=0);
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n\t Welcome to Library Management System");
            System.out.println("\t ------------------------------------\n");
            System.out.println("Press 1: For Admin.");
            System.out.println("Press 2: For User.");
            System.out.println("Press 0: For Exit.");
            System.out.print("Choice : ");
            choice=FormatClass.getIntegerFromUser();
            switch (choice)
            {
                case 1:
                    admin();
                    break;

                case 2:
                    user();
                    break;

                case 0:
                    System.out.println(" Exiting... ");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }while (choice!=0);
        sc.close();
        System.exit(0);
    }
}
