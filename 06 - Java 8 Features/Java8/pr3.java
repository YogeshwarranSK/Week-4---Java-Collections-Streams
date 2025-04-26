package Day22.Java8;
import java.util.*;
import java.util.stream.*;

public class pr3 {

    public static class Book {
         String title;
         String author;
         String genre;
         double rating;

        public Book(String title, String author, String genre, double rating) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.rating = rating;
        }

        public String getTitle() { return title; }
        public String getAuthor() { return author; }
        public String getGenre() { return genre; }
        public double getRating() { return rating; }
    }

    public static class BookRecommendation {
        private String title;
        private double rating;

        public BookRecommendation(String title, double rating) {
            this.title = title;
            this.rating = rating;
        }

        public String getTitle() { return title; }
        public double getRating() { return rating; }

        @Override
        public String toString() {
            return title + " (Rating: " + rating + ")";
        }
    }

    public static List<List<BookRecommendation>> recommendBooks(List<Book> books) {
        List<BookRecommendation> top10 = books.stream()
                .filter(b -> "Science Fiction".equalsIgnoreCase(b.getGenre()) && b.getRating() > 4.0)
                .map(b -> new BookRecommendation(b.getTitle(), b.getRating()))
                .sorted(Comparator.comparingDouble(BookRecommendation::getRating).reversed())
                .limit(10)
                .collect(Collectors.toList());

        List<List<BookRecommendation>> pages = new ArrayList<>();
        for (int i = 0; i < top10.size(); i += 5) {
            pages.add(top10.subList(i, Math.min(i + 5, top10.size())));
        }
        return pages;
    }

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Dune", "Frank Herbert", "Science Fiction", 4.5),
                new Book("Neuromancer", "William Gibson", "Science Fiction", 4.2),
                new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.1),
                new Book("Snow Crash", "Neal Stephenson", "Science Fiction", 4.3),
                new Book("Hyperion", "Dan Simmons", "Science Fiction", 4.6),
                new Book("The Martian", "Andy Weir", "Science Fiction", 4.4),
                new Book("2001: A Space Odyssey", "Arthur C. Clarke", "Science Fiction", 4.0),
                new Book("Ender's Game", "Orson Scott Card", "Science Fiction", 4.3),
                new Book("Red Mars", "Kim Stanley Robinson", "Science Fiction", 4.2),
                new Book("The Left Hand of Darkness", "Ursula K. Le Guin", "Science Fiction", 4.1),
                new Book("Brave New World", "Aldous Huxley", "Dystopian", 4.3)
        );

        List<List<BookRecommendation>> paginated = recommendBooks(books);

        for (int i = 0; i < paginated.size(); i++) {
            System.out.println("Page " + (i + 1) + ":");
            paginated.get(i).forEach(System.out::println);
            System.out.println();
        }
    }
}
