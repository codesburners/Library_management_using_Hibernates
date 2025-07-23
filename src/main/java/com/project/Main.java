package com.project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);

        // Configure Hibernate
        Configuration config = new Configuration();
        config.configure(); // Loads hibernate.cfg.xml
        config.addAnnotatedClass(Book.class);
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();

        int choice;
        do {
            System.out.println("\n===============================");
            System.out.println("📚 Library Management System");
            System.out.println("===============================");
            System.out.println("1️⃣  Add Book");
            System.out.println("2️⃣  Remove Book");
            System.out.println("3️⃣  Search Book");
            System.out.println("4️⃣  Display All Books");
            System.out.println("5️⃣  Exit");
            System.out.print("👉 Enter your choice (1-5): ");
            while (!s1.hasNextInt()) {
                System.out.print("❗ Invalid input. Please enter a number between 1 and 5: ");
                s1.next(); // Consume invalid input
            }
            choice = s1.nextInt();
            s1.nextLine(); // Clear newline

            switch (choice) {
                case 1: {
                    Transaction tx = session.beginTransaction();
                    System.out.print("📖 Enter Book Title: ");
                    String name = s1.nextLine();

                    System.out.print("✍️ Enter Book Author: ");
                    String author = s1.nextLine();

                    System.out.print("💰 Enter Book Price: ");
                    while (!s1.hasNextDouble()) {
                        System.out.print("❗ Invalid price. Enter a valid number: ");
                        s1.next();
                    }
                    double price = s1.nextDouble();
                    s1.nextLine(); // Clear newline

                    Book book = new Book();
                    book.setTitle(name);
                    book.setAuthor(author);
                    book.setCost(price);

                    session.persist(book);
                    tx.commit();

                    System.out.println("✅ Book added successfully!");
                    pause(s1);
                    break;
                }
                case 2: {
                    System.out.print("🗑️ Enter Book ID to remove: ");
                    int id = s1.nextInt();
                    s1.nextLine(); // Clear newline

                    Transaction tx = session.beginTransaction();
                    Book bookToDelete = session.get(Book.class, id);

                    if (bookToDelete != null) {
                        session.remove(bookToDelete);
                        tx.commit();
                        System.out.println("✅ Book removed successfully!");
                    } else {
                        System.out.println("❌ Book not found with ID: " + id);
                        tx.rollback();
                    }

                    pause(s1);
                    break;
                }
                case 3: {
                    System.out.print("🔍 Enter Book ID to search: ");
                    int id = s1.nextInt();
                    s1.nextLine(); // Clear newline

                    Book bookFound = session.get(Book.class, id);

                    if (bookFound != null) {
                        System.out.println("✅ Book Found:");
                        System.out.println("📘 Title: " + bookFound.getTitle());
                        System.out.println("✍️ Author: " + bookFound.getAuthor());
                        System.out.println("💰 Price: ₹" + bookFound.getCost());
                    } else {
                        System.out.println("❌ No book found with ID: " + id);
                    }

                    pause(s1);
                    break;
                }
                case 4: {
                    System.out.println("📚 All Books in Library:");
                    List<Book> books = session.createQuery("from Book", Book.class).list();

                    if (books.isEmpty()) {
                        System.out.println("📭 No books available.");
                    } else {
                        for (Book b : books) {
                            System.out.println("📘 Title: " + b.getTitle() +
                                    ", Author: " + b.getAuthor() + ", Price: ₹" + b.getCost());
                        }
                    }

                    pause(s1);
                    break;
                }
                case 5:
                    System.out.println("👋 Exiting... Thank you!");
                    break;
                default:
                    System.out.println("❗ Invalid choice. Please select between 1 to 5.");
                    pause(s1);
                    break;
            }
        } while (choice != 5);

        // Cleanup
        session.close();
        factory.close();
        s1.close();
    }

    // Pause function for better interaction
    private static void pause(Scanner s) {
        System.out.print("\n🔁 Press Enter to continue...");
        s.nextLine();
    }
}
