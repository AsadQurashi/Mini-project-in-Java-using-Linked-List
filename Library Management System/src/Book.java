import java.time.LocalDate;
import java.time.LocalTime;
public class Book {
    private int id;
    private String title;
    private String author;
    private int bookEdition;
    private int noOfCopies;
    private String bookBorrowName;
    private LocalDate bookIssueDate;
    private LocalTime bookIssueTime;

    private LocalDate bookReturnedDate;
    private LocalTime bookReturnedTime;

    //Constructor for add book.
    public Book(int id, String title, String author, int edition, int noOfCopies) {
        setId(id);
        setTitle(title);
        setAuthor(author);
        setBookEdition(edition);
        setNoOfCopies(noOfCopies);
        LocalDate bookAddingDate = LocalDate.now();
    }

    //Constructor for issue book.
    public Book(int id, String title, String author,int edition, String borrowingName , LocalDate bookIssueDate, LocalTime bookIssueTime) {
        setId(id);
        setTitle(title);
        setAuthor(author);
        setBookEdition(edition);
        setBookBorrowName(borrowingName);
        setBookIssueDate(bookIssueDate);
        setBookIssueTime(bookIssueTime);
    }

    //Constructor for return book.
    public Book(int id, String title, String author,int edition, String borrowingName , LocalDate bookIssueDate,
                LocalTime bookIssueTime, LocalDate bookReturnedDate, LocalTime bookReturnedTime) {
        setId(id);
        setTitle(title);
        setAuthor(author);
        setBookEdition(edition);
        setBookBorrowName(borrowingName);
        setBookIssueDate(bookIssueDate);
        setBookIssueTime(bookIssueTime);
        setBookReturnedDate(bookReturnedDate);
        setBookReturnedTime(bookReturnedTime);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
          this.title = (title.isEmpty())? "Null" : title;
    }

    public void setAuthor(String author) {
        this.author = (author.isEmpty())? "Null" : author;
    }

    public void setNoOfCopies(int noOfCopies) {
        this.noOfCopies = (noOfCopies>0) ? noOfCopies : 0;
    }

    public void setBookEdition(int bookEdition) {
        this.bookEdition = (bookEdition>1) ? bookEdition : 1;
    }

    public void setBookIssueDate(LocalDate bookIssueDate) {
        this.bookIssueDate=bookIssueDate;
    }

    public void setBookBorrowName(String bookBorrowName) {
        this.bookBorrowName = bookBorrowName;
    }

    public void setBookIssueTime(LocalTime bookIssueTime) {
        this.bookIssueTime = bookIssueTime;
    }

    public void setBookReturnedTime(LocalTime bookReturnedTime) {
        this.bookReturnedTime = bookReturnedTime;
    }
    public void setBookReturnedDate(LocalDate bookReturnedDate) {
        this.bookReturnedDate = bookReturnedDate;
    }
    public LocalTime getBookIssueTime() {
        return bookIssueTime;
    }
    public LocalDate getBookIssueDate() {
        return bookIssueDate;
    }


    public int getBookEdition() {
        return bookEdition;
    }
    public int getNoOfCopies() {
        return noOfCopies;
    }
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookBorrowName() {
        return bookBorrowName;
    }

    public LocalTime getBookReturnedTime() {
        return bookReturnedTime;
    }

    public LocalDate getBookReturnedDate() {
        return bookReturnedDate;
    }
}
