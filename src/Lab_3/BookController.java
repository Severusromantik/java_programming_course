package Lab_3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.List;
import java.util.Random;

public class BookController {
    private BookRepository model;
    private BookView view;

    private BookFileHandler fileHandler;

    public BookController(BookRepository model, BookView view) {
        this.model = model;
        this.view = view;

        this.fileHandler = new BookFileHandler();
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

                    case "6":
                        String saveFileName = view.getFileNameFromUser();
                        fileHandler.saveBooks(model.getBooks(), saveFileName);
                        view.displayMessage("Успішно збережено " + model.getBooks().length + " книг у файл: " + saveFileName);
                        break;

                    case "7":
                        String loadFileName = view.getFileNameFromUser();
                        Book[] loadedBooks = fileHandler.loadBooks(loadFileName);

                        if (loadedBooks.length > 0) {
                            model.setBooks(loadedBooks);
                            view.displayBooks(model.getBooks(), "Успішно завантажено " + loadedBooks.length + " книг з файлу: " + loadFileName);
                        } else {
                            view.displayMessage("Попередження: Файл порожній або не містив коректних даних.");
                        }
                        break;

                    case "0":
                        view.displayMessage("Додаток завершує роботу. Бувайте!");
                        running = false;
                        break;

                    default:
                        view.displayMessage("Невідома опція. Спробуйте ще раз (0-7).");
                }
            } catch (InvalidPathException e) {
                view.displayMessage("Помилка введення імені файлу: " + e.getReason());
            } catch (FileNotFoundException e) {
                view.displayMessage("Помилка: Файл '" + e.getMessage() + "' не знайдено.");
            } catch (ClassNotFoundException e) {
                view.displayMessage("Критична помилка: Не вдалося знайти клас Book при завантаженні.");
            } catch (IOException e) {
                view.displayMessage("Помилка I/O під час роботи з файлом: " + e.getMessage());
            } catch (Exception e) {
                view.displayMessage("Невідома помилка під час виконання операції: " + e.getMessage());
            }
        }
    }
}