package bestseller;

public class Book {
    private int index;
    private String name;
    private String author;
    private String originalLanguage;
    private int firstPublished;
    private float millionSales;
    private String genre;
    private float starReview;

    public Book(int index, String name, String author, String originalLanguage, int firstPublished, float millionSales, String genre, float starReview) {
        this.index = index;
        this.name = name;
        this.author = author;
        this.originalLanguage = originalLanguage;
        this.firstPublished = firstPublished;
        this.millionSales = millionSales;
        this.genre = genre;
        this.starReview = starReview;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public int getFirstPublished() {
        return firstPublished;
    }

    public void setFirstPublished(int firstPublished) {
        this.firstPublished = firstPublished;
    }

    public float getMillionSales() {
        return millionSales;
    }

    public void setMillionSales(float millionSales) {
        this.millionSales = millionSales;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public float getStarReview() {
        return starReview;
    }

    public void setStarReview(float starReview) {
        this.starReview = starReview;
    }

    @Override
    public String toString() {
        return String.format("Index=%d, Title='%s', Author='%s', Language='%s', FirstPublished=%d, MillionSales=%.1f, Genre='%s', StarReview=%.1f",
                index, name, author, originalLanguage, firstPublished, millionSales, genre, starReview);
    }
}
