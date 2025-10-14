package Lab_3;

import java.util.List;
import java.util.Random;

public class BookController {
    private BookRepository model;
    private BookView view;

    public BookController(BookRepository model, BookView view) {
        this.model = model;
        this.view = view;
    }

    public void startApp() {
        view.displayBooks(model.getBooks(), "Початковий список книг");

        String[] sampleAuthors = {"Шевченко", "Шекспір", "Дідро"};
        String[] samplePublishers = {"КСД", "Фоліо", "Основа"};
        int[] sampleYears = {1990, 2010, 2020};
        Random random = new Random();

        String choice;
        boolean running = true;

        while (running) {
            view.displayMenu();
            choice = view.getUserInput("").trim();

            try {
                switch (choice) {
                    case "1":
                        String authorToFind = sampleAuthors[random.nextInt(sampleAuthors.length)];
                        view.displayMessage("Шукаємо книги автора: " + authorToFind);

                        List<Book> booksByAuthor = model.getBooksByAuthor(authorToFind);
                        view.displayBooks(booksByAuthor, "Результат пошуку за автором: " + authorToFind);
                        break;

                    case "2":
                        String publisherToFind = samplePublishers[random.nextInt(samplePublishers.length)];
                        view.displayMessage("Шукаємо книги видавництва: " + publisherToFind);

                        List<Book> booksByPublisher = model.getBooksByPublisher(publisherToFind);
                        view.displayBooks(booksByPublisher, "Результат пошуку за видавництвом: " + publisherToFind);
                        break;

                    case "3":
                        int yearToFind = sampleYears[random.nextInt(sampleYears.length)];
                        view.displayMessage("Шукаємо книги, видані пізніше: " + yearToFind + " року");

                        List<Book> booksAfterYear = model.getBooksAfterYear(yearToFind);
                        view.displayBooks(booksAfterYear, "Результат пошуку після " + yearToFind + " року");
                        break;

                    case "4":
                        view.displayMessage("Сортування книг за видавництвами...");
                        model.sortBooksByPublisher();
                        view.displayBooks(model.getBooks(), "Відсортований список книг (за видавництвом)");
                        break;

                    case "5":
                        view.displayBooks(model.getBooks(), "Поточний список книг");
                        break;

                    case "0":
                        view.displayMessage("Додаток завершує роботу. Бувайте!");
                        running = false;
                        break;

                    default:
                        view.displayMessage("Невідома опція. Спробуйте ще раз.");
                }
            } catch (Exception e) {
                view.displayMessage("Помилка під час виконання операції: " + e.getMessage());
            }
        }
    }
}
