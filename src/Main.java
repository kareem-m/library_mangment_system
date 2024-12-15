import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of books you have: ");
        int bookCount = sc.nextInt();

        String[] bookTitles = new String[bookCount];
        String[] bookDescriptions = new String[bookCount];
        boolean[] bookIssued = new boolean[bookCount];

        for (int i = 0; i < bookCount; i++) {
            System.out.print("Enter the title of book " + (i + 1) + ": ");
            bookTitles[i] = sc.next();

            System.out.print("Enter the description of book " + (i + 1) + ": ");
            bookDescriptions[i] = sc.next();

            bookIssued[i] = false; // available
        }

        System.out.println("Welcome to the library management System!");

        System.out.println("1. Add a book");
        System.out.println("2. Search for a book (by title or ID)");
        System.out.println("3. Isseue a book (by ID)");
        System.out.println("4. Return a book (by ID)");
        System.out.println("5. Delete a book (by ID)");
        System.out.println("6. Edit book detailes (title / description by ID)");
        System.out.println("7. View all books");
        System.out.println("8. Exit");

        System.out.println("Enter your choice");
        int choice = sc.nextInt();

        switch (choice) {
            case 1: // add
                bookCount++;
                String[] newBookTitles = new String[bookCount];
                String[] newBookDescriptions = new String[bookCount];
                boolean[] newBookIssued = new boolean[bookCount];
                for (int i = 0; i < bookCount; i++) {
                    if (i < (bookCount - 1)) {
                        newBookTitles[i] = bookTitles[i];
                        newBookDescriptions[i] = bookDescriptions[i];
                        newBookIssued[i] = bookIssued[i];
                    } else if (i == (bookCount - 1)) {
                        System.out.print("Enter the title of book " + (i + 1) + ": ");
                        newBookTitles[i] = sc.next();

                        System.out.print("Enter the description of book " + (i + 1) + ": ");
                        newBookDescriptions[i] = sc.next();

                        newBookIssued[i] = false;
                    }
                    System.out.println(newBookTitles[i]);
                }
                break;
            case 2: // search
                System.out.print("Search using title or ID ? ");
                String titleID = sc.next();
                if (titleID.equals("title")) {
                    System.out.print("Enter the book title: ");
                    String title = sc.next();
                    for (int i = 0; i < bookCount; i++) {
                        if (bookTitles[i].equals(title)) {
                            System.out.println(bookTitles[i]);
                            System.out.println(bookDescriptions[i]);
                            if (bookIssued[i] == false) {
                                System.out.println("available");
                            } else if (bookIssued[i] == true) {
                                System.out.println("issued");
                            }
                        }
                    }
                } else if (titleID.equals("ID")) {
                    int ID = sc.nextInt();
                    System.out.println(bookTitles[ID]);
                    System.out.println(bookDescriptions[ID]);
                    if (bookIssued[ID] == false) {
                        System.out.println("available");
                    } else if (bookIssued[ID] == true) {
                        System.out.println("issued");
                    }
                }
                break;
            case 3: // isseue
                System.out.print("Enter the ID: ");
                int ID = sc.nextInt();
                if (bookIssued[ID] == false) {
                    System.out.println("the book " + bookTitles[ID] + " is available and you can borrow it");
                    bookIssued[ID] = true;
                } else if (bookIssued[ID] == true) {
                    System.out.print("The book is already unavailable");
                }
                break;
            case 4: // return
                System.out.print("Enter the ID: ");
                ID = sc.nextInt();
                if (bookIssued[ID] == true) {
                    System.out.println("the book " + bookTitles[ID] + " is now available and you can borrow it");
                    bookIssued[ID] = true;
                } else if (bookIssued[ID] == false) {
                    System.out.print("The book is already available");
                }
                break;
            case 5: // delete
                break;
            case 6: // edit
                System.out.print("Enter the ID of the book that you need to edit: ");
                ID = sc.nextInt();

                System.out.print("Enter the new name of the book: ");
                bookTitles[ID] = sc.next();

                System.out.print("Enter the new description of the book: ");
                bookDescriptions[ID] = sc.next();

                System.out.println("The new title is " + bookTitles[ID] + " and the new description is " + bookDescriptions[ID]);
                break;
            case 7: // View
                for (int i = 0; i < bookCount; i++) {
                    System.out.println("The name of book is " + bookTitles[i]);
                    System.out.println("The description of book is " + bookDescriptions[i]);
                    if (bookIssued[i] == false) {
                        System.out.println("available");
                    } else if (bookIssued[i] == true) {
                        System.out.println("issued");
                    }
                }
                break;
            case 8: // exit
                sc.close();
                break;
            default:
                System.out.println("Invalid input");
                break;
        }

    }
}