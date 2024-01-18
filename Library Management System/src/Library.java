import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class Library {
    private LinkedList<Book> books;
    private static ArrayList<Book> borrowBooks = new ArrayList<>();
    private static ArrayList<Book> returnedBooks = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    public Library() {
        books = new LinkedList<>();
    }

    //Method for Adding Book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.\n");
    }

    //get new data from user to edit book information Method
    private int getIdFromUser() {
        boolean check;
        int id;
        do {
            check = false;
            System.out.print("Enter book ID: ");
            id = FormatClass.getIntegerFromUser();
            if (isIdAlreadyExist(id)) {
                System.out.println("This ID is Already exists. Try another ID.");
                check = true;
            }
        } while (check);
        return id;
    }

    private String getTitleFromUser() {
        System.out.print("Enter book title: ");
        return FormatClass.getStringFromUser();
    }

    private String getAuthorFromUser() {
        System.out.print("Enter book author: ");
        return FormatClass.getStringFromUser();
    }

    private int getEditionFromUser() {
        System.out.print("Enter book edition : ");
        return FormatClass.getIntegerFromUser();
    }

    private int getCopiesFromUser() {
        System.out.print("Enter no of copies do you want to add : ");
        return FormatClass.getIntegerFromUser();
    }

    //Method for editing Book information
    private void editBookById(int id) {
        boolean edit = false;
        for (Book book : books) {
            if (book.getId() == id) {
                System.out.println("\n\nCurrent book information:");
                showBookById(id);
                String choice;
                do {
                    System.out.print("Do really want to edit book information. \nPress 'Y' / 'N' : ");
                    choice = FormatClass.getStringFromUser();
                } while (choice.charAt(0) != 'N' && choice.charAt(0) != 'Y');
                if (choice.charAt(0) == 'N') {
                    return;
                }
                int tempId = book.getId();
                book.setId(0);
                System.out.println("Enter new Data :");
                book.setId(getIdFromUser());
                book.setTitle(getTitleFromUser());
                book.setAuthor(getAuthorFromUser());
                book.setBookEdition(getEditionFromUser());
                book.setNoOfCopies(getCopiesFromUser());
                for (Book borrow : borrowBooks) {
                    if (borrow.getId() == tempId) {
                        borrow.setId(book.getId());
                        borrow.setTitle(book.getTitle());
                        borrow.setAuthor(book.getAuthor());
                        borrow.setBookEdition(book.getBookEdition());
                    }
                }
                edit = true;
                System.out.println("Book information edited successfully.\n");
                break;
            }
        }
        if (!edit) {
            System.out.println("Book not found.\n");
        }
    }

    private void editBookByTitle(String title) {
        boolean edit = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("\n\nCurrent book information:");
                showBookByTitle(title);
                String choice;
                do {
                    System.out.println("Do really want to edit book information. ");
                    System.out.println("Press 'Y': For Yes");
                    System.out.println("Press 'N': For No");
                    System.out.println("Press 'C': Continue searching");
                    System.out.print("Choice : ");
                    choice = FormatClass.getStringFromUser();
                } while (choice.charAt(0) != 'N' && choice.charAt(0) != 'Y' && choice.charAt(0) != 'C');
                if (choice.charAt(0) == 'N') {
                    return;
                }
                else if (choice.charAt(0) == 'C') {
                    continue;
                }
                int tempId = book.getId();
                book.setId(0);
                System.out.println("Enter new Data :");
                book.setId(getIdFromUser());
                book.setTitle(getTitleFromUser());
                book.setAuthor(getAuthorFromUser());
                book.setBookEdition(getEditionFromUser());
                book.setNoOfCopies(getCopiesFromUser());
                for (Book borrow : borrowBooks) {
                    if (borrow.getId() == tempId) {
                        borrow.setId(book.getId());
                        borrow.setTitle(book.getTitle());
                        borrow.setAuthor(book.getAuthor());
                        borrow.setBookEdition(book.getBookEdition());
                    }
                }
                edit = true;
                System.out.println("Book information edited successfully.\n");
                break;
            }
        }
        if (!edit) {
            System.out.println("Book not found.\n");
        }
    }

    private void editBookByAuthor(String author) {
        boolean edit = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(author)) {
                System.out.println("\n\nCurrent book information:");
                showBookByTitle(author);
                String choice;
                do {
                    System.out.println("Do really want to edit book information. ");
                    System.out.println("Press 'Y': For Yes");
                    System.out.println("Press 'N': For No");
                    System.out.println("Press 'C': Continue searching");
                    System.out.print("Choice : ");
                    choice = FormatClass.getStringFromUser();
                } while (choice.charAt(0) != 'N' && choice.charAt(0) != 'Y' && choice.charAt(0) != 'C');
                if (choice.charAt(0) == 'N') {
                    return;
                }
                else if (choice.charAt(0) == 'C') {
                    continue;
                }
                int tempId = book.getId();
                book.setId(0);
                System.out.println("Enter new Data :");
                book.setId(getIdFromUser());
                book.setTitle(getTitleFromUser());
                book.setAuthor(getAuthorFromUser());
                book.setBookEdition(getEditionFromUser());
                book.setNoOfCopies(getCopiesFromUser());
                for (Book borrow : borrowBooks) {
                    if (borrow.getId() == tempId) {
                        borrow.setId(book.getId());
                        borrow.setTitle(book.getTitle());
                        borrow.setAuthor(book.getAuthor());
                        borrow.setBookEdition(book.getBookEdition());
                    }
                }
                edit = true;
                System.out.println("Book information edited successfully.\n");
                break;
            }
        }
        if (!edit) {
            System.out.println("Book not found.\n");
        }
    }

    public void editBook() {
        if (books.isEmpty()) {
            System.out.println("Library is Empty...");
            return;
        }
        int choice;
        do {
            System.out.println("PRESS 1. To edit by ID");
            System.out.println("PRESS 2. To edit by Title");
            System.out.println("PRESS 3. To edit by Author");
            System.out.println("PRESS 4. Exit To Main Menu");
            System.out.print("Choice: ");
            choice = FormatClass.getIntegerFromUser();
            if (choice < 1 || choice > 4) {
                System.out.println("Invalid Choice. Try Again");
            }
        } while (choice < 1 || choice > 4);
        switch (choice) {
            case 1:
                System.out.print("Enter book ID to search for edit: ");
                int editId = FormatClass.getIntegerFromUser();
                editBookById(editId);
                break;

            case 2:
                System.out.print("Enter book Title to search for edit: ");
                String editTitle = FormatClass.getStringFromUser();
                editBookByTitle(editTitle);
                break;

            case 3:
                System.out.print("Enter book author name to search for edit: ");
                String editAuthor = FormatClass.getStringFromUser();
                editBookByAuthor(editAuthor);
                break;

            case 4:
                System.out.println("Return to Main menu...\n");
                break;
        }
    }

    //Method for Remove book from library
    private void removeBookById(int id) {
        boolean removed = false;
        for (Book book : books) {
            if (book.getId() == id) {
                showBookById(id);
                String choice;
                do {
                    System.out.print("Do really want to remove this book. \nPress 'Y' / 'N' : ");
                    choice = FormatClass.getStringFromUser();
                } while (choice.charAt(0) != 'N' && choice.charAt(0) != 'Y');
                if (choice.charAt(0) == 'N') {
                    return;
                }
                removeBookFromBorrow(book.getId());
                books.remove(book);
                removed = true;
                System.out.println("Book removed successfully.\n");
                break;
            }
        }
        if (!removed) {
            System.out.println("Book not found.\n");
        }
    }

    private void removeBookByTitle(String title) {
        boolean removed = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                showBookByTitle(title);
                String choice;
                do {
                    System.out.println("Do really want to remove this book. ");
                    System.out.println("Press 'Y': For Yes");
                    System.out.println("Press 'N': For No");
                    System.out.println("Press 'C': Continue searching");
                    System.out.print("Choice : ");
                    choice = FormatClass.getStringFromUser();
                } while (choice.charAt(0) != 'N' && choice.charAt(0) != 'Y' && choice.charAt(0) != 'C');
                if (choice.charAt(0) == 'N') {
                    return;
                }
                else if (choice.charAt(0) == 'C') {
                    continue;
                }
                removeBookFromBorrow(book.getId());
                books.remove(book);
                removed = true;
                System.out.println("Book removed successfully.\n");
                break;
            }
        }
        if (!removed) {
            System.out.println("Book not found.\n");
        }
    }

    private void removeBookByAuthor(String author) {
        boolean removed = false;
        for (Book book : books) {
            if ((book.getAuthor().equalsIgnoreCase(author))) {
                showBookByAuthor(author);
                String choice;
                do {
                    System.out.println("Do really want to remove this book. (Also removed from issue book history) ");
                    System.out.println("Press 'Y': For Yes");
                    System.out.println("Press 'N': For No");
                    System.out.println("Press 'C': Continue searching");
                    System.out.print("Choice : ");
                    choice = FormatClass.getStringFromUser();
                } while (choice.charAt(0) != 'N' && choice.charAt(0) != 'Y' && choice.charAt(0) != 'C');
                if (choice.charAt(0) == 'N') {
                    return;
                }
                else if (choice.charAt(0) == 'C') {
                    continue;
                }
                removeBookFromBorrow(book.getId());
                books.remove(book);
                removed = true;
                System.out.println("Book removed successfully.\n");
                break;
            }
        }
        if (!removed) {
            System.out.println("Book not found.\n");
        }
    }

    public void removeBook() {
        if (books.isEmpty()) {
            System.out.println("Library is Empty...");
            return;
        }
        int choice;
        do {
            System.out.println("PRESS 1. To remove by ID");
            System.out.println("PRESS 2. To remove by Title");
            System.out.println("PRESS 3. To remove by Author");
            System.out.println("PRESS 4. Exit To Main Menu");
            System.out.print("Choice: ");
            choice = FormatClass.getIntegerFromUser();
            if (choice < 1 || choice > 4) {
                System.out.println("Invalid Choice. Try Again");
            }
        } while (choice < 1 || choice > 4);
        switch (choice) {
            case 1:
                System.out.print("Enter book ID to search for remove: ");
                int removeId = FormatClass.getIntegerFromUser();
                removeBookById(removeId);
                break;

            case 2:
                System.out.print("Enter book Title to search for remove: ");
                String removeTitle = FormatClass.getStringFromUser();
                removeBookByTitle(removeTitle);
                break;

            case 3:
                System.out.print("Enter book author name to search for remove: ");
                String removeAuthor = FormatClass.getStringFromUser();
                removeBookByAuthor(removeAuthor);
                break;

            case 4:
                System.out.println("Return to Main menu...\n");
                break;
        }
    }

    //Method for Issue book to user.
    private void issueBookById(int id) {
        boolean issued = false;
        for (Book book : books) {
            if (book.getId() == id) {
                if (book.getNoOfCopies() < 1) {
                    System.out.println("Book Copy Not Available.\n");
                    return;
                }
                showBookById(id);
                String choice;
                do {
                    System.out.print("Do really want to issue this book. \nPress 'Y' / 'N' : ");
                    choice = FormatClass.getStringFromUser();
                } while (choice.charAt(0) != 'N' && choice.charAt(0) != 'Y');
                if (choice.charAt(0) == 'N') {
                    return;
                }
                System.out.print("Enter the name of borrowing book : ");
                String name = FormatClass.getStringFromUser();
                LocalDate issueDate = getDateFromUser();
                LocalTime issueTime = getTimeFromUser();
                Book issuebook = new Book(book.getId(), book.getTitle(), book.getAuthor(), book.getBookEdition(), name, issueDate, issueTime);
                borrowBooks.add(issuebook);
                book.setNoOfCopies(book.getNoOfCopies() - 1);
                issued = true;
                System.out.println("Book issued successfully.\n");
                break;
            }
        }
        if (!issued) {
            System.out.println("Book not found.\n");
        }
    }

    private void issueBookByTitle(String title) {
        boolean issued = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.getNoOfCopies() < 1) {
                    System.out.println("Book Copy Not Available.\n");
                    return;
                }
                showBookByTitle(title);
                String choice;
                do {
                    System.out.println("Do really want to issue this book. ");
                    System.out.println("Press 'Y': For Yes");
                    System.out.println("Press 'N': For No");
                    System.out.println("Press 'C': Continue searching");
                    System.out.print("Choice : ");
                    choice = FormatClass.getStringFromUser();
                } while (choice.charAt(0) != 'N' && choice.charAt(0) != 'Y' && choice.charAt(0) != 'C');
                if (choice.charAt(0) == 'N') {
                    return;
                }
                else if (choice.charAt(0) == 'C') {
                    continue;
                }
                System.out.print("Enter the name of borrowing book : ");
                String name = FormatClass.getStringFromUser();
                LocalDate issueDate = getDateFromUser();
                LocalTime issueTime = getTimeFromUser();
                Book issuebook = new Book(book.getId(), book.getTitle(), book.getAuthor(), book.getBookEdition(), name, issueDate, issueTime);
                borrowBooks.add(issuebook);
                book.setNoOfCopies(book.getNoOfCopies() - 1);
                issued = true;
                System.out.println("Book issued successfully.");
                break;
            }
        }
        if (!issued) {
            System.out.println("Book not found.");
        }
    }

    private void issueBookByAuthor(String author) {
        boolean issued = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                if (book.getNoOfCopies() < 1) {
                    System.out.println("Book Copy Not Available.\n");
                    return;
                }
                showBookByAuthor(author);
                String choice;
                do {
                    System.out.println("Do really want to issue this book. ");
                    System.out.println("Press 'Y': For Yes");
                    System.out.println("Press 'N': For No");
                    System.out.println("Press 'C': Continue searching");
                    System.out.print("Choice : ");
                    choice = FormatClass.getStringFromUser();
                } while (choice.charAt(0) != 'N' && choice.charAt(0) != 'Y' && choice.charAt(0) != 'C');
                if (choice.charAt(0) == 'N') {
                    return;
                }
                else if (choice.charAt(0) == 'C') {
                    continue;
                }
                System.out.print("Enter the name of borrowing book : ");
                String name = FormatClass.getStringFromUser();
                LocalDate issueDate = getDateFromUser();
                LocalTime issueTime = getTimeFromUser();
                Book issuebook = new Book(book.getId(), book.getTitle(), book.getAuthor(), book.getBookEdition(), name, issueDate, issueTime);
                borrowBooks.add(issuebook);
                book.setNoOfCopies(book.getNoOfCopies() - 1);
                issued = true;
                System.out.println("Book issued successfully.\n");
                break;
            }
        }
        if (!issued) {
            System.out.println("Book not found.\n");
        }
    }

    public void issueBook() {
        if (books.isEmpty()) {
            System.out.println("Library is Empty...");
            return;
        }
        int choice;
        do {
            System.out.println("PRESS 1. To issue by ID");
            System.out.println("PRESS 2. To issue by Title");
            System.out.println("PRESS 3. To issue by Author");
            System.out.println("PRESS 4. Exit To Main Menu");
            System.out.print("Choice: ");
            choice = FormatClass.getIntegerFromUser();
            if (choice < 1 || choice > 4) {
                System.out.println("Invalid Choice. Try Again");
            }
        } while (choice < 1 || choice > 4);
        switch (choice) {
            case 1:
                System.out.print("Enter book ID to search for issue: ");
                int issueId = FormatClass.getIntegerFromUser();
                issueBookById(issueId);
                break;

            case 2:
                System.out.print("Enter book Title to search for issue: ");
                String issueTitle = FormatClass.getStringFromUser();
                issueBookByTitle(issueTitle);
                break;

            case 3:
                System.out.print("Enter book author name to search for issue: ");
                String issueAuthor = FormatClass.getStringFromUser();
                issueBookByAuthor(issueAuthor);
                break;

            case 4:
                System.out.println("Return to Main menu...\n");
                break;
        }
    }

    //Method for Return book.
    private void returnBookById(int id) {
        boolean isReturned = false;
        for (Book book : books) {
            if (book.getId() == id) {
                if (!isReturningBookIsIssue(book.getId())) {
                    System.out.println("This book is not issue to anyone. ");
                    return;
                }
                showBookById(id);
                String choice;
                do {
                    System.out.print("Do really want to return this book. \nPress 'Y' / 'N' : ");
                    choice = FormatClass.getStringFromUser();
                } while (choice.charAt(0) != 'N' && choice.charAt(0) != 'Y');
                if (choice.charAt(0) == 'N') {
                    return;
                }
                book.setNoOfCopies(book.getNoOfCopies() + 1);
                isReturned = true;
                getReturnedBookDetail(book.getId());
                removeBookFromBorrow(book.getId());
                System.out.println("Book is Returned successfully.");
                break;
            }
        }
        if (!isReturned) {
            System.out.println("ERROR...  Maybe you entered invalid id.");
        }
    }

    private void returnBookByTitle(String title) {
        boolean isReturned = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!isReturningBookIsIssue(book.getId())) {
                    System.out.println("This book is not issue to anyone. ");
                    return;
                }
                showBookByTitle(title);
                String choice;
                do {
                    System.out.println("Do you want return this book. ");
                    System.out.println("Press 'Y': For Yes");
                    System.out.println("Press 'N': For No");
                    System.out.println("Press 'C': Continue searching");
                    System.out.print("Choice : ");
                    choice = FormatClass.getStringFromUser();
                } while (choice.charAt(0) != 'N' && choice.charAt(0) != 'Y' && choice.charAt(0) != 'C');
                if (choice.charAt(0) == 'N') {
                    return;
                }
                else if (choice.charAt(0) == 'C') {
                    continue;
                }
                book.setNoOfCopies(book.getNoOfCopies() + 1);
                isReturned = true;
                removeBookFromBorrow(book.getId());
                System.out.println("Book is Returned successfully.");
                break;
            }
        }
        if (!isReturned) {
            System.out.println("ERROR...  Maybe you entered invalid title name.");
        }
    }

    private void returnBookByAuthor(String author) {
        boolean isReturned = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                if (!isReturningBookIsIssue(book.getId())) {
                    System.out.println("This book is not issue to anyone. ");
                    return;
                }
                showBookByAuthor(author);
                String choice;
                do {
                    System.out.println("Do you want return this book. ");
                    System.out.println("Press 'Y': For Yes");
                    System.out.println("Press 'N': For No");
                    System.out.println("Press 'C': Continue searching");
                    System.out.print("Choice : ");
                    choice = FormatClass.getStringFromUser();
                } while (choice.charAt(0) != 'N' && choice.charAt(0) != 'Y' && choice.charAt(0) != 'C');
                if (choice.charAt(0) == 'N') {
                    return;
                }
                else if (choice.charAt(0) == 'C') {
                    continue;
                }
                book.setNoOfCopies(book.getNoOfCopies() + 1);
                isReturned = true;
                removeBookFromBorrow(book.getId());
                System.out.println("Book is Returned successfully.\n");
                break;
            }
        }
        if (!isReturned) {
            System.out.println("ERROR...  Maybe you entered invalid author name.\n");
        }
    }

    public void returnBook() {
        if (books.isEmpty()) {
            System.out.println("Library is Empty...");
            return;
        }
        int choice;
        do {
            System.out.println("PRESS 1. To return by ID");
            System.out.println("PRESS 2. To return by Title");
            System.out.println("PRESS 3. To return by Author");
            System.out.println("PRESS 4. Exit To Main Menu");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            if (choice < 1 || choice > 4) {
                System.out.println("Invalid Choice. Try Again");
            }
        } while (choice < 1 || choice > 4);
        switch (choice) {
            case 1:
                System.out.print("Enter book ID to search for return: ");
                int returnId = sc.nextInt();
                returnBookById(returnId);
                break;

            case 2:
                System.out.print("Enter book Title to search for return: ");
                String returnTitle = FormatClass.getStringFromUser();
                returnBookByTitle(returnTitle);
                break;

            case 3:
                System.out.print("Enter book author name to search for return: ");
                String returnAuthor = FormatClass.getStringFromUser();
                returnBookByAuthor(returnAuthor);
                break;

            case 4:
                System.out.println("Return to Main menu...\n");
                break;
        }
    }

    //Method for Search Method.
    private void showBookById(int id) {
        boolean search = false;
        for (Book book : books) {
            if (book.getId() == id) {
                System.out.println("ID: " + book.getId());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Edition: " + book.getBookEdition());
                System.out.println("Number of copies available: " + book.getNoOfCopies());
                System.out.println("--------------------\n");
                search = true;
                break;
            }
        }
        if (!search) {
            System.out.println("Book not found.\n");
        }
    }

    private void showBookByTitle(String title) {
        boolean search = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("ID: " + book.getId());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Edition: " + book.getBookEdition());
                System.out.println("Number of copies available: " + book.getNoOfCopies());
                System.out.println("--------------------\n");
                search = true;
            }
        }
        if (!search) {
            System.out.println("Book not found.\n");
        }
    }

    private void showBookByAuthor(String author) {
        boolean search = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println("ID: " + book.getId());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Edition: " + book.getBookEdition());
                System.out.println("Number of copies available: " + book.getNoOfCopies());
                System.out.println("--------------------\n");
                search = true;
            }
        }
        if (!search) {
            System.out.println("Book not found.\n");
        }
    }

    public void showBook() {
        int choice;
        do {
            System.out.println("PRESS 1. To return by ID");
            System.out.println("PRESS 2. To return by Title");
            System.out.println("PRESS 3. To return by Author");
            System.out.println("PRESS 4. Exit To Main Menu");
            System.out.print("Choice: ");
            choice = FormatClass.getIntegerFromUser();
            if (choice < 1 || choice > 4) {
                System.out.println("Invalid Choice. Try Again");
            }
        } while (choice < 1 || choice > 4);
        switch (choice) {
            case 1:
                System.out.print("Enter book ID to search: ");
                int searchId = FormatClass.getIntegerFromUser();
                showBookById(searchId);
                break;

            case 2:
                System.out.print("Enter book Title to search: ");
                String searchTitle = FormatClass.getStringFromUser();
                showBookByTitle(searchTitle);
                break;

            case 3:
                System.out.print("Enter book author name to search: ");
                String searchAuthor = FormatClass.getStringFromUser();
                showBookByAuthor(searchAuthor);
                break;

            case 4:
                System.out.println("Return to Main menu...\n");
                break;
        }
    }

    //Method for Display all Books.
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("\nNo books available in the library.");
        } else {
            System.out.println("\nBooks in the library:");
            System.out.println("---------------------");
            int bookNo=1;
            for (Book book : books) {
                System.out.println("Serial No :" + bookNo++);
                System.out.println("ID: " + book.getId());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Edition: " + book.getBookEdition());
                System.out.println("Number of copies available: " + book.getNoOfCopies());
                System.out.println("--------------------");
            }
        }
    }

    //Method for Display all Borrow books.
    public void displayIssueBooks() {
        if (borrowBooks.isEmpty()) {
            System.out.println("\nBooks are not issued to someone.");
        } else {
            System.out.println("\nIssue Books :");
            System.out.println("-------------");
            int bookNo=1;
            for (Book book : borrowBooks) {
                System.out.println("Serial No : " + bookNo++);
                System.out.println("ID: " + book.getId());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Edition: " + book.getBookEdition());
                System.out.println("Book issue to: " + book.getBookBorrowName());
                System.out.println("Book issue date: " + book.getBookIssueDate());
                System.out.println("Book issue time: " + book.getBookIssueTime());
                System.out.println("--------------------");
            }
        }
    }

    //Method for Display returned books history.
    public void displayReturnedBooks() {
        if (returnedBooks.isEmpty()) {
            System.out.println("\nReturn Book history is empty.");
        } else {
            System.out.println("\nReturned Books :");
            System.out.println("----------------");
            int bookNo=1;
            for (Book book : returnedBooks) {
                System.out.println("Serial No : " + bookNo++);
                System.out.println("ID: " + book.getId());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Edition: " + book.getBookEdition());
                System.out.println("Book issue to: " + book.getBookBorrowName());
                System.out.println("Book issue date: " + book.getBookIssueDate());
                System.out.println("Book issue time: " + book.getBookIssueTime());
                System.out.println("Book returned date: " + book.getBookReturnedDate());
                System.out.println("Book returned time: " + book.getBookReturnedTime());
                System.out.println("--------------------");
            }
        }
    }


    //Book Searching Methods
    public boolean isIdAlreadyExist(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return true;
            }
        }
        return false;
    }

    protected boolean isBookAlreadyExist(String title, String author, int edition) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author) && book.getBookEdition() == edition) {
                return true;
            }
        }
        return false;
    }

    //Method for get date from user.
    private LocalDate getDateFromUser() {
        int choice;
        do {
            System.out.println("Press 1. For Current Date : ");
            System.out.println("Press 2. For Enter Date : ");
            System.out.print("Choice : ");
            choice = FormatClass.getIntegerFromUser();
            switch (choice) {
                case 1:
                    return LocalDate.now();

                case 2:
                    int day;
                    do {
                        System.out.print("Enter day no (1 - 31): ");
                        day = FormatClass.getIntegerFromUser();
                    } while (day < 1 || day > 31);
                    int month;
                    do {
                        System.out.println("Enter month no (1 - 12): ");
                        month = FormatClass.getIntegerFromUser();
                    } while (month < 1 || month > 12);
                    int year;
                    do {
                        System.out.println("Enter year : ");
                        year = FormatClass.getIntegerFromUser();
                    } while (year < 1);

                    return LocalDate.of(year, month, day);

                default:
                    System.out.println("Invalid choice...");
            }
        } while (choice != 1 && choice != 2);
        return LocalDate.now();
    }

    //Method for get time from user.
    private LocalTime getTimeFromUser() {
        int choice;
        do {
            System.out.println("Press 1. For Current Time : ");
            System.out.println("Press 2. For Enter Time : ");
            System.out.print("Choice : ");
            choice = FormatClass.getIntegerFromUser();
            switch (choice) {
                case 1:
                    return LocalTime.now();

                case 2:
                    int hour;
                    do {
                        System.out.print("Enter hour (0 - 23): ");
                        hour = FormatClass.getIntegerFromUser();
                    } while (hour < 0 || hour > 23);
                    int minutes;
                    do {
                        System.out.print("Enter minutes (0 - 59): ");
                        minutes = FormatClass.getIntegerFromUser();
                    } while (minutes < 0 || minutes > 59);
                    int seconds;
                    do {
                        System.out.print("Enter seconds (0 - 59): ");
                        seconds = FormatClass.getIntegerFromUser();
                    } while (seconds < 0 || seconds > 59);

                    return LocalTime.of(hour, minutes, seconds);

                default:
                    System.out.println("Invalid choice...");
            }
        } while (choice != 1 && choice != 2);
        return LocalTime.now();
    }

    //Method for delete library data.
    public void deleteAllLibraryData() {
        int choice;
        do {
            System.out.println("PRESS 1. For delete all enter books. ");
            System.out.println("PRESS 2. For clear returned book history. ");
            System.out.println("PRESS 3. For delete all library data (Enter book, issue book history, returned book history). ");
            System.out.println("PRESS 4. Exit To Main Menu");
            System.out.print("Choice: ");
            choice = FormatClass.getIntegerFromUser();
            if (choice < 1 || choice > 4) {
                System.out.println("Invalid Choice. Try Again");
            }
        } while (choice < 1 || choice > 4);
        switch (choice)
        {
            case 1:
                String choice1;
                do {
                    System.out.print("Do really want to delete all the enter book data (data cannot be recovered) : ");
                    choice1 = FormatClass.getStringFromUser();
                    if (choice1.charAt(0) == 'Y') {
                        books.clear();
                        System.out.println("All the Entered book data is deleted successfully... ");
                    }
                } while (choice1.charAt(0) != 'N' && choice1.charAt(0) != 'Y');
                break;

            case 2:
                String choice2;
                do {
                    System.out.print("Do really want to clear all the returned book data (data cannot be recovered) : ");
                    choice2 = FormatClass.getStringFromUser();
                    if (choice2.charAt(0) == 'Y') {
                        returnedBooks.clear();
                        System.out.println("Returned book history is clear successfully... ");
                    }
                } while (choice2.charAt(0) != 'N' && choice2.charAt(0) != 'Y');
                break;

            case 3:
                String choice3;
                do {
                    System.out.print("Do really want to delete all the book data (data cannot be recovered) : ");
                    choice3 = FormatClass.getStringFromUser();
                    if (choice3.charAt(0) == 'Y') {
                        books.clear();
                        borrowBooks.clear();
                        returnedBooks.clear();
                        System.out.println("All the book data is deleted successfully... ");
                    }
                } while (choice3.charAt(0) != 'N' && choice3.charAt(0) != 'Y');
                break;

            case 4:
                System.out.println("Return to Main menu...\n");
                break;
        }

    }

    //Method to check is returning book is issued or not.
    private boolean isReturningBookIsIssue(int id) {
        for (Book book : borrowBooks) {
            if (book.getId() == id) {
                return true;
            }
        }
        return false;
    }


    // Method for remove book return book from issue book list.
    // And also used to remove book from issue book when book removed from library.
    private void removeBookFromBorrow(int id)
    {
        for (Book book:borrowBooks)
        {
            if (book.getId()==id)
            {
                borrowBooks.remove(book);
                return;
            }
        }
    }


    //Method for get detail from user and add to return book history.
    private void getReturnedBookDetail(int id)
    {
        for (Book book:borrowBooks)
        {
            if (book.getId()==id)
            {
                LocalDate returnDate = getDateFromUser();
                LocalTime returnTime = getTimeFromUser();
                Book returnBook=new Book(book.getId(),book.getTitle(),book.getAuthor(),book.getBookEdition(),
                        book.getBookBorrowName(),book.getBookIssueDate(),book.getBookIssueTime(),returnDate, returnTime);
                returnedBooks.add(returnBook);
                return;
            }
        }
    }


}
