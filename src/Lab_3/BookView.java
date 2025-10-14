package Lab_3;

import java.util.List;
import java.util.Scanner;

public class BookView {
    public void displayBooks(Book[] books, String header) {
        System.out.println("\n=========================================================================================================================");
        System.out.println(header);
        System.out.println("=========================================================================================================================");
        System.out.printf("| %-30s | %-15s | %-15s | %-4s | %-4s | %-11s |\n",
                "Назва", "Автор", "Видавництво", "Рік", "Стор.", "Ціна");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");

        if (books != null && books.length > 0) {
            for (Book book : books) {
                System.out.println(book);
            }
        } else {
            System.out.println("||| Список порожній.                                                                                               |||");
        }
        System.out.println("=========================================================================================================================");
    }

    public void displayBooks(List<Book> bookList, String header) {
        displayBooks(bookList.toArray(new Book[0]), header);

        if (bookList.isEmpty()) {
            System.out.println("\n*** Згідно з критерієм, книг не знайдено. ***");
        }
    }

    public void displayMenu() {
        System.out.println("\n--- МЕНЮ ОБРОБКИ МАСИВУ ---");
        System.out.println("1. Отримати список книг зазначеного автора.");
        System.out.println("2. Отримати список книг, які видані зазначеним видавництвом.");
        System.out.println("3. Отримати список книг, виданих пізніше вказаного року.");
        System.out.println("4. Відсортувати книги за видавництвами.");
        System.out.println("5. Показати поточний масив.");
        System.out.println("0. Вихід.");
        System.out.print("Оберіть опцію: ");
    }

    public String getUserInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
