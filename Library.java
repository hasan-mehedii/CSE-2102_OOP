import java.util.*;

interface User {
    void borrowBook(Book book);
    void returnBook(Book book);
    void getBorrowedBooks();
}

abstract class Book {
    String title;
    String author;
    boolean isAvailable;

    Book(String title, String author, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    abstract void getDetails();
}

class PrintedBook extends Book {
    PrintedBook(String title, String author) {
        super(title, author, true);
    }

    void getDetails() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

class EBook extends Book {
    EBook(String title, String author) {
        super(title, author, true);
    }

    void getDetails() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

class Student implements User {
    String name;
    int roll;
    Book[] borrow = new Book[3];

    Student(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable) {
            for (int i = 0; i < borrow.length; i++) {
                if (borrow[i] == null) {
                    borrow[i] = book;
                    book.isAvailable = false;
                    System.out.println("book borrowed done :(");
                    return;
                }
            }
            System.out.println("already borrowed 3 book");
        } else {
            System.out.println("Book is not available");
        }
    }

    public void returnBook(Book book) {
        for (int i = 0; i < borrow.length; i++) {
            if (borrow[i] == book) {
                borrow[i] = null;
                book.isAvailable = true;
                System.out.println("Book returned done");
                return;
            }
        }
        System.out.println("You have not borrowed this book.");
    }

    public void getBorrowedBooks() {
        for (Book b : borrow) {
            if (b != null) {
                b.getDetails();
            }
        }
    }
}

class Faculty implements User {
    String name;
    int teacherId;
    Book[] borrow = new Book[10];

    Faculty(String name, int teacherId) {
        this.name = name;
        this.teacherId = teacherId;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable) {
            for (int i = 0; i < borrow.length; i++) {
                if (borrow[i] == null) {
                    borrow[i] = book;
                    book.isAvailable = false;
                    System.out.println("book borrowed done");
                    return;
                }
            }
            System.out.println("already borrowed 10 book");
        } else {
            System.out.println("Book is not available");
        }
    }

    public void returnBook(Book book) {
        for (int i = 0; i < borrow.length; i++) {
            if (borrow[i] == book) {
                borrow[i] = null;
                book.isAvailable = true;
                System.out.println("Book returned done :)");
                return;
            }
        }
        System.out.println("You have not borrowed this book.");
    }

    public void getBorrowedBooks() {
        for (Book b : borrow) {
            if (b != null) {
                b.getDetails();
            }
        }
    }
}

public class Roll_22 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        PrintedBook pb1 = new PrintedBook("OOP", "Mehedi");
        PrintedBook pb2 = new PrintedBook("DSA", "Hasan");
        PrintedBook pb3 = new PrintedBook("OOP2", "Mehedi");
        PrintedBook pb4 = new PrintedBook("OOP3", "Mehedi");

        EBook eb1 = new EBook("Online", "Dr.Mehedi");
        EBook eb2 = new EBook("Offline", "Dr.Hasan");

        Student st1 = new Student("name1", 1);
        Faculty f1 = new Faculty("teacher1", 2);

        st1.borrowBook(pb1);
        st1.borrowBook(pb2);
        st1.borrowBook(pb3);
        st1.borrowBook(pb4);
        st1.getBorrowedBooks();
        f1.borrowBook(pb1);
        st1.returnBook(pb2);
        f1.borrowBook(pb2);

        scan.close();
    }
}
