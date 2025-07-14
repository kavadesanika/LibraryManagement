package com.library;

import com.library.dao.BookDao;
import com.library.dao.MemberDao;
import com.library.model.Book;
import com.library.model.Member;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookDao bookDao = new BookDao();
        MemberDao memberDao = new MemberDao();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Library System ===");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Delete Book");
            System.out.println("4. Add Member");
            System.out.println("5. View Members");
            System.out.println("6. Delete Member");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    bookDao.addBook(new Book(title, author));
                }
                case 2 -> {
                    List<Book> books = bookDao.getAllBooks();
                    books.forEach(b -> System.out.println(b.getId() + ": " + b.getTitle() + " by " + b.getAuthor()));
                }
                case 3 -> {
                    System.out.print("Enter book ID to delete: ");
                    int id = sc.nextInt();
                    bookDao.deleteBook(id);
                }
                case 4 -> {
                    System.out.print("Enter member name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    memberDao.addMember(new Member(name, email));
                }
                case 5 -> {
                    List<Member> members = memberDao.getAllMembers();
                    members.forEach(m -> System.out.println(m.getId() + ": " + m.getName() + " - " + m.getEmail()));
                }
                case 6 -> {
                    System.out.print("Enter member ID to delete: ");
                    int id = sc.nextInt();
                    memberDao.deleteMember(id);
                }
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
        sc.close();
    }
}
