package bestseller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class BookList {
    private static final int MAX_SIZE = 100;
    private Book[] books;
    private int size;

    public BookList() {
        this.books = new Book[MAX_SIZE];
        this.size = 0;
    }

    public void createList(String fileName) throws BookException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            reader.readLine(); 
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 7) {
                    try {
                        String name = fields[0].trim();
                        String author = fields[1].trim();
                        String originalLanguage = fields[2].trim();
                        int firstPublished = Integer.parseInt(fields[3].trim());
                        float millionSales = Float.parseFloat(fields[4].trim());
                        String genre = fields[5].trim();
                        float starReview = Float.parseFloat(fields[6].trim());

                        Book book = new Book(size, name, author, originalLanguage, firstPublished, millionSales, genre, starReview);
                        add(book);
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping line due to invalid number format: " + line);
                    }
                } else {
                    System.out.println("Skipping line due to invalid number of fields: " + line);
                }
            }
            System.out.println("Book list created from " + fileName);
        } catch (IOException e) {
            throw new BookException("Error reading book list: " + e.getMessage());
        }
    }

    public void add(Book book) {
        if (size < MAX_SIZE) {
            books[size] = book;
            size++;
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Book list is full. Cannot add more books.");
        }
    }

    public void edit(int index, Book book) throws BookException {
        if (index >= 0 && index < size) {
            books[index] = book;
            System.out.println("Book edited successfully.");
        } else {
            throw new BookException("Invalid index for editing book.");
        }
    }

    public void delete(int index) throws BookException {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                books[i] = books[i + 1];
            }
            size--;
            System.out.println("Book deleted successfully.");
        } else {
            throw new BookException("Invalid index for deleting book.");
        }
    }

    public void printList() {
        if (size == 0) {
            System.out.println("The book list is empty.");
        } else {
            for (int i = 0; i < size; i++) {
                System.out.println(books[i]);
            }
        }
    }

    public void saveBookList() throws BookException {
        try (FileWriter writer = new FileWriter("best-selling-books.csv")) {
            writer.write("Name,Author,Original Language,First Published,Million of Sales,Genre,Star Review\n");
            for (int i = 0; i < size; i++) {
                Book book = books[i];
                writer.write(String.format("%s,%s,%s,%d,%.1f,%s,%.1f\n",
                        book.getName(), book.getAuthor(), book.getOriginalLanguage(),
                        book.getFirstPublished(), book.getMillionSales(), book.getGenre(), book.getStarReview()));
            }
            System.out.println("Book list saved to best-selling-books.csv");
        } catch (IOException e) {
            throw new BookException("Error saving book list: " + e.getMessage());
        }
    }

    public int size() {
        return size;
    }

    public void searchByName(String name) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (books[i].getName().equalsIgnoreCase(name)) {
                System.out.println(books[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No book found with the name: " + name);
        }
    }

    public void searchByAuthor(String author) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (books[i].getAuthor().equalsIgnoreCase(author)) {
                System.out.println(books[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No book found with the author: " + author);
        }
    }

    public void searchByStarReview(float starReview) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (books[i].getStarReview() == starReview) {
                System.out.println(books[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No book found with the star review: " + starReview);
        }
    }

    public void sortBooksByStarReview() {
        Book[] sortedBooks = new Book[size];
        System.arraycopy(books, 0, sortedBooks, 0, size);
        Arrays.sort(sortedBooks, Comparator.comparing(Book::getStarReview).reversed());
        for (Book book : sortedBooks) {
            System.out.println(book);
        }
    }

    public void switchBookPositions(int index1, int index2) throws BookException {
        if (index1 >= 0 && index1 < size && index2 >= 0 && index2 < size) {
            Book temp = books[index1];
            books[index1] = books[index2];
            books[index2] = temp;
            System.out.println("Books at positions " + index1 + " and " + index2 + " have been swapped.");
        } else {
            throw new BookException("Invalid indices for switching book positions.");
        }
    }
}
