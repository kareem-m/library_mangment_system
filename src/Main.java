import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Library Management System!");
        System.out.print("Enter the maximum number of books the library can store: ");
        int maxBooks = sc.nextInt();
        sc.nextLine();

        String[] bookTitles = new String[maxBooks];
        String[] bookDescriptions = new String[maxBooks];
        boolean[] bookIssued = new boolean[maxBooks];

        int bookCount = 0;

        boolean app = true;
        while (app) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a book");
            System.out.println("2. Search for a book (by title or ID)");
            System.out.println("3. Issue a book (by ID)");
            System.out.println("4. Return a book (by ID)");
            System.out.println("5. Delete a book (by ID)");
            System.out.println("6. Edit book details (title/description by ID)");
            System.out.println("7. View all books");
            System.out.println("8. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: // Add a book
                    if (bookCount < maxBooks) {
                        System.out.print("Enter the title of the book: ");
                        String newTitle = sc.nextLine();

                        if (newTitle.isEmpty()) {
                            while (newTitle.isEmpty()) {
                                System.out.println("The title can't be empty");
                                System.out.print("Enter the title of the book: ");
                                newTitle = sc.nextLine();
                            }
                        }

                        System.out.print("Enter the description of the book: ");
                        String newDescription = sc.nextLine();

                        bookTitles[bookCount] = newTitle;
                        bookDescriptions[bookCount] = newDescription;
                        bookIssued[bookCount] = false; // Available

                        bookCount++;
                        System.out.println("Book added successfully!");

                        System.out.println("\nThe books in your library now :");
                        for (int i = 0; i < bookCount; i++) {
                            System.out.println("Book ID: " + (i + 1));
                            System.out.println("Title: " + bookTitles[i]);
                            System.out.println("Description: " + bookDescriptions[i]);
                            if (bookIssued[i] == false) {
                                System.out.println("Status: Available\n");
                            } else if (bookIssued[i] == true) {
                                System.out.println("Status: Issued\n");
                            }
                        }

                    } else {
                        System.out.println("Library is full! Cannot add more books");
                    }
                    break;

                case 2: // Search for a book
                    if (bookCount == 0) {
                        System.out.println("No books in the library to search.");
                        break;
                    }

                    System.out.print("Search by (title/ID): ");
                    String searchType = sc.nextLine();

                    if (searchType.equals("title")) {
                        System.out.print("Enter the book title: ");
                        String title = sc.nextLine();
                        for (int i = 0; i < bookCount; i++) {
                            if (bookTitles[i].equals(title)) {
                                System.out.println("\nBook ID: " + (i + 1));
                                System.out.println("Title: " + bookTitles[i]);
                                System.out.println("Description: " + bookDescriptions[i]);
                                if (bookIssued[i] == false) {
                                    System.out.println("Status: Available");
                                } else if (bookIssued[i] == true) {
                                    System.out.println("Status: Issued");
                                }
                            } else {
                                System.out.println("No book in the library with this name");
                                break;
                            }
                        }
                    } else if (searchType.equals("ID") || searchType.equals("id")) {
                        System.out.print("Enter the book ID: ");
                        int id = sc.nextInt();
                        id--;
                        sc.nextLine();
                        if (id >= 0 && id < bookCount) {
                            System.out.println("\nTitle: " + bookTitles[id]);
                            System.out.println("Description: " + bookDescriptions[id]);
                            if (bookIssued[id] == false) {
                                System.out.println("Status: Available");
                            } else if (bookIssued[id] == true) {
                                System.out.println("Status: Issued");
                            }
                        } else {
                            System.out.println("Invalid ID.");
                        }
                    } else {
                        System.out.println("Invalid search type.");
                    }
                    break;

                case 3: // Issue a book
                    if (bookCount == 0) {
                        System.out.println("No books in the library to issue.");
                        break;
                    }

                    System.out.print("Enter the book ID to issue: ");
                    int issueID = sc.nextInt();
                    sc.nextLine();
                    issueID--;

                    if (issueID >= 0 && issueID < bookCount) {
                        if (bookIssued[issueID] == false) {
                            bookIssued[issueID] = true;
                            System.out.println("You have issued the book: " + bookTitles[issueID]);
                        } else {
                            System.out.println("Book is already issued.");
                        }
                    } else {
                        System.out.println("Invalid ID.");
                    }
                    break;

                case 4: // Return a book
                    if (bookCount == 0) {
                        System.out.println("No books in the library to return.");
                        break;
                    }

                    System.out.print("Enter the book ID to return: ");
                    int returnID = sc.nextInt();
                    sc.nextLine();
                    returnID--;

                    if (returnID >= 0 && returnID < bookCount) {
                        if (bookIssued[returnID] == true) {
                            bookIssued[returnID] = false;
                            System.out.println("You have returned the book: " + bookTitles[returnID]);
                        } else {
                            System.out.println("Book was not issued.");
                        }
                    } else {
                        System.out.println("Invalid ID.");
                    }
                    break;

                case 5: // Delete a book
                    if (bookCount == 0) {
                        System.out.println("No books in the library to delete.");
                        break;
                    }

                    System.out.print("Enter book ID to delete: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();
                    deleteId--;

                    if (deleteId >= 0 && deleteId < bookCount) {
                        for (int i = deleteId; i < bookCount - 1; i++) {
                            bookTitles[i] = bookTitles[i + 1];
                            bookDescriptions[i] = bookDescriptions[i + 1];
                            bookIssued[i] = bookIssued[i + 1];
                        }
                        bookCount--;
                        System.out.println("Book deleted successfully!");
                    } else {
                        System.out.println("Invalid ID.");
                    }
                    break;

                case 6: // Edit a book
                    if (bookCount == 0) {
                        System.out.println("No books in the library to edit.");
                        break;
                    }

                    System.out.print("Enter the book ID to edit: ");
                    int editID = sc.nextInt();
                    sc.nextLine();
                    editID--;

                    if (editID >= 0 && editID < bookCount) {
                        System.out.print("Enter the new title: ");
                        bookTitles[editID] = sc.nextLine();
                        System.out.print("Enter the new description: ");
                        bookDescriptions[editID] = sc.nextLine();
                        System.out.println("Book details updated.");
                    } else {
                        System.out.println("Invalid ID.");
                    }
                    break;

                case 7: // View all books
                    if (bookCount == 0) {
                        System.out.println("No books in the library.");
                        break;
                    }

                    for (int i = 0; i < bookCount; i++) {
                        System.out.println("Book ID: " + (i + 1));
                        System.out.println("Title: " + bookTitles[i]);
                        System.out.println("Description: " + bookDescriptions[i]);
                        if (bookIssued[i] == false) {
                            System.out.println("Status: Available\n");
                        } else if (bookIssued[i] == true) {
                            System.out.println("Status: Issued\n");
                        }
                    }
                    break;

                case 8: // Exit
                    System.out.println("Thank you for using the Library Management System");
                    app = false;
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
