
import java.util.*;

class Book {
    int id;
    String name;
    String author;
    boolean issued = false;

    Book(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }
}

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class Main {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Student> students = new ArrayList<>();

    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books.add(new Book(id, name, author));

        System.out.println("Book Added Successfully!");
    }

    static void viewBooks() {
        System.out.println("\n--- BOOK LIST ---");

        for (Book b : books) {
            System.out.println("ID: " + b.id);
            System.out.println("Name: " + b.name);
            System.out.println("Author: " + b.author);
            System.out.println("Status: " +
                (b.issued ? "Issued" : "Available"));
            System.out.println("----------------");
        }

        if (books.isEmpty()) {
            System.out.println("No Books Available");
        }
    }

    static void searchBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {
                System.out.println("Book Found!");
                System.out.println("Name: " + b.name);
                System.out.println("Author: " + b.author);
                return;
            }
        }

        System.out.println("Book Not Found!");
    }

    static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        students.add(new Student(id, name));

        System.out.println("Student Added Successfully!");
    }

    static void viewStudents() {
        System.out.println("\n--- STUDENT LIST ---");

        for (Student s : students) {
            System.out.println("ID: " + s.id);
            System.out.println("Name: " + s.name);
        }

        if (students.isEmpty()) {
            System.out.println("No Students Found");
        }
    }

    static void issueBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {
                if (!b.issued) {
                    b.issued = true;
                    System.out.println("Book Issued Successfully!");
                } else {
                    System.out.println("Book Already Issued!");
                }
                return;
            }
        }

        System.out.println("Book Not Found!");
    }

    static void returnBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {
                if (b.issued) {
                    b.issued = false;
                    System.out.println("Book Returned Successfully!");
                } else {
                    System.out.println("Book Was Not Issued!");
                }
                return;
            }
        }

        System.out.println("Book Not Found!");
    }

    static void deleteBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {
                books.remove(b);
                System.out.println("Book Deleted Successfully!");
                return;
            }
        }

        System.out.println("Book Not Found!");
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n================================");
            System.out.println("   LIBRARY MANAGEMENT SYSTEM");
            System.out.println("================================");

            System.out.println("1. Add New Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Add Student");
            System.out.println("5. View Students");
            System.out.println("6. Issue Book");
            System.out.println("7. Return Book");
            System.out.println("8. Delete Book");
            System.out.println("9. Exit");

            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addBook();
                    break;

                case 2:
                    viewBooks();
                    break;

                case 3:
                    searchBook();
                    break;

                case 4:
                    addStudent();
                    break;

                case 5:
                    viewStudents();
                    break;

                case 6:
                    issueBook();
                    break;

                case 7:
                    returnBook();
                    break;

                case 8:
                    deleteBook();
                    break;

                case 9:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 9);
    }
}
