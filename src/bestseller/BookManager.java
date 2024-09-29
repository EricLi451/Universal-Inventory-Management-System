package bestseller;

import java.io.File;
import java.util.Scanner;

public class BookManager {
    private BookList books = new BookList();

    public void showMenu() {
        System.out.println("================================");
        System.out.println("|| Menu - Best Sellers MakeUp ||");
        System.out.println("================================");
        System.out.println("0. Exit application");
        System.out.println("1. Create Booklist");
        System.out.println("2. Show Booklist");
        System.out.println("3. Add book");
        System.out.println("4. Edit a book");
        System.out.println("5. Delete a book");
        System.out.println("6. Save booklist");
        System.out.println("7. Search in the list");
        System.out.println("8. Classify books with stars");
        System.out.println("9. Switch positions");
        System.out.print("Choose an option: ");
    }

    public void createBookList() throws BookException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name of file to create booklist: ");
        String fileName = scanner.nextLine();

        File file = new File(fileName);
        System.out.println("Attempting to read file from: " + file.getAbsolutePath());

        books.createList(fileName);
        System.out.println("Book list created successfully!");
    }

    public void displayBookList() {
        books.printList();
    }

    public void addBook() throws BookException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Book data:");
        System.out.print("- Name: ");
        String name = scanner.nextLine();
        System.out.print("- Author: ");
        String author = scanner.nextLine();
        System.out.print("- Original Language: ");
        String originalLanguage = scanner.nextLine();
        System.out.print("- First Published: ");
        int firstPublished = Integer.parseInt(scanner.nextLine());
        System.out.print("- Million of Sales: ");
        float millionSales = Float.parseFloat(scanner.nextLine());
        System.out.print("- Genre: ");
        String genre = scanner.nextLine();
        System.out.print("- Star Review: ");
        float starReview = Float.parseFloat(scanner.nextLine());
        Book book = new Book(books.size(), name, author, originalLanguage, firstPublished, millionSales, genre, starReview);
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void editBook() throws BookException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the index for the book to Edit: ");
        int index = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the Book data:");
        System.out.print("- Name: ");
        String name = scanner.nextLine();
        System.out.print("- Author: ");
        String author = scanner.nextLine();
        System.out.print("- Original Language: ");
        String originalLanguage = scanner.nextLine();
        System.out.print("- First Published: ");
        int firstPublished = Integer.parseInt(scanner.nextLine());
        System.out.print("- Million of Sales: ");
        float millionSales = Float.parseFloat(scanner.nextLine());
        System.out.print("- Genre: ");
        String genre = scanner.nextLine();
        System.out.print("- Star Review: ");  
        float starReview = Float.parseFloat(scanner.nextLine());
        Book book = new Book(index, name, author, originalLanguage, firstPublished, millionSales, genre, starReview);
        books.edit(index, book);
        System.out.println("Book edited successfully.");
    }

    public void deleteBook() throws BookException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the index for the book to Delete: ");
        int index = Integer.parseInt(scanner.nextLine());
        books.delete(index);
        System.out.println("Book deleted successfully.");
    }

    public void saveBookList() throws BookException {
        books.saveBookList();
        System.out.println("Book list saved successfully.");
    }

    public void classifyBooksByStars() {
        books.sortBooksByStarReview();
        System.out.println("Books have been classified by star review.");
    }

    public void switchBookPositions(int index1, int index2) throws BookException {
        books.switchBookPositions(index1, index2);
        System.out.println("Books at positions " + index1 + " and " + index2 + " have been swapped.");
    }
    public void exit() {
        System.out.println("================================");
        System.out.println("||    [Application ended]     ||");
        System.out.println("================================");
        System.exit(0);  // Exiting the application
    }


    public void searchBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Search by:");
        System.out.println("1. Name");
        System.out.println("2. Author");
        System.out.println("3. Star Review");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter the book name: ");
                String name = scanner.nextLine();
                books.searchByName(name);
                break;
            case 2:
                System.out.print("Enter the author name: ");
                String author = scanner.nextLine();
                books.searchByAuthor(author);
                break;
            case 3:
                System.out.print("Enter the star review: ");
                float starReview = scanner.nextFloat();
                books.searchByStarReview(starReview);
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }

    public static void main(String[] args) throws BookException {
        BookManager bookManager = new BookManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            bookManager.showMenu();
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 0:
                    bookManager.exit();
                    break;
                case 1:
                    try {
                        bookManager.createBookList();
                    } catch (BookException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    bookManager.displayBookList();
                    break;
                case 3:
                    try {
                        bookManager.addBook();
                    } catch (BookException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        bookManager.editBook();
                    } catch (BookException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        bookManager.deleteBook();
                    } catch (BookException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        bookManager.saveBookList();
                    } catch (BookException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    bookManager.searchBook();
                    break;
                case 8:
                    bookManager.classifyBooksByStars();
                    break;
                case 9:
                    System.out.println("Enter first position:");
                    int index1 = scanner.nextInt();
                    System.out.println("Enter second position:");
                    int index2 = scanner.nextInt();
                    bookManager.switchBookPositions(index1, index2);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 0);
    }

}
