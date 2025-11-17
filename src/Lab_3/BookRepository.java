package Lab_3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookRepository {
    private Book[] books;
    private final int MIN = 10;

    private static final String[] TITLES = {"Дракула", "1984", "Портрет Доріана Грея", "Кобзар", "Заповіт", "Три товариші", "Дюна", "Черниця", "Гордість і упередження", "Гамлет"};
    private static final String[] AUTHORS = {"Стокер", "Орвелл", "Вайльд", "Шевченко", "Шевченко", "Ремарк", "Герберт", "Дідро", "Остін", "Шекспір"};
    private static final String[] PUBLISHERS = {"Книголав", "Наш Формат", "КСД", "А-БА-БА-ГА-ЛА-МА-ГА", "Основа", "Фоліо", "Ще одну сторінку", "Наш Формат", "Основа", "КСД"};

    public BookRepository() {
        initializeBooks();
    }

    private void initializeBooks() {
        this.books = new Book[MIN];
        for (int i = 0; i < MIN; i++) {
            String title = TITLES[i % TITLES.length];
            String author = AUTHORS[i % AUTHORS.length];
            String publisher = PUBLISHERS[i % PUBLISHERS.length];
            int year = 1990 + (i * 5) % 30;
            int pages = 100 + i * 50;
            double price = 150.0 + i * 25.5;

            this.books[i] = new Book(title, author, publisher, year, pages, price);
        }
    }

    public Book[] getBooks() {
        return books;
    }

    public List<Book> getBooksByAuthor(String author) {
        return Arrays.stream(books)
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public List<Book> getBooksByPublisher(String publisher) {
        return Arrays.stream(books)
                .filter(book -> book.getPublisher().equalsIgnoreCase(publisher))
                .collect(Collectors.toList());
    }

    public List<Book> getBooksAfterYear(int year) {
        return Arrays.stream(books)
                .filter(book -> book.getYear() > year)
                .collect(Collectors.toList());
    }

    public void sortBooksByPublisher() {
        Comparator<Book> publisherComparator = new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                return book1.getPublisher().compareTo(book2.getPublisher());
            }
        };
        Arrays.sort(books, publisherComparator);
    }
}
