package Lab_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {
    private static List<CuratorJournal> journal = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Журнал Куратора.");

        while (true) {
            displayMenu();
            String choice = scanner.nextLine();

            switch (choice.trim()) {
                case "1":
                    addEntry();
                    break;
                case "2":
                    displayAllEntries();
                    break;
                case "3":
                    System.out.println("Роботу завершено.");
                    return;
                default:
                    System.out.println("Неправильний вибір. Спробуйте ще раз.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n--- МЕНЮ ---");
        System.out.println("1. Додати новий запис");
        System.out.println("2. Відобразити всі записи");
        System.out.println("3. Вийти");
        System.out.print("Ваш вибір: ");
    }

    private static void displayAllEntries() {
        if (journal.isEmpty()) {
            System.out.println("\nЖурнал порожній. Додайте перший запис!");
            return;
        }

        System.out.println("\n---------------------------------");
        System.out.println("          ВСІ ЗАПИСИ В ЖУРНАЛІ          ");
        System.out.println("---------------------------------");

        for (CuratorJournal entry : journal) {
            System.out.println(entry.toString());
            System.out.println("---------------------------------");
        }
    }

    private static void addEntry() {
        System.out.println("\n--- Створення нового запису ---");

        String lastName = promptForInput("Введіть прізвище студента: ", data ->
                data.matches("[а-яА-ЯёЁіІїЇєЄa-zA-Z\\s-]+"));

        String firstName = promptForInput("Введіть ім'я студента: ", data ->
                data.matches("[а-яА-ЯёЁіІїЇєЄa-zA-Z\\s-]+"));

        String birthDate = promptForInput("Введіть дату народження (ДД.ММ.РРРР): ", data -> {
            try {
                LocalDate.parse(data, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                return true;
            } catch (DateTimeParseException e) {
                return false;
            }
        });

        String phoneNumber = promptForInput("Введіть телефон (+380...): ", data ->
                data.matches("^\\+[0-9]{10,15}$"));

        System.out.println("\n--- Введення домашньої адреси ---");
        String city = promptForInput("Місто: ", data -> true);
        String street = promptForInput("Вулиця: ", data -> true);
        String house = promptForInput("Будинок: ", data -> true);
        String apartment = promptForInput("Квартира (Н/Д, якщо немає): ", data -> true);

        Address address = new Address(city, street, house, apartment);

        CuratorJournal newEntry = new CuratorJournal(
                lastName, firstName, birthDate, phoneNumber, address);

        journal.add(newEntry);

        System.out.println("\n!!! Запис успішно додано до журналу !!!");
    }

    private static String promptForInput(String prompt, Validator validator) {
        String input;
        boolean isValid = false;

        do{
            System.out.print(prompt);
            input = scanner.nextLine().trim();

            if (input.isEmpty()){
                System.out.println("Помилка: поле не можу бути пустим.");
                continue;
            }

            if (validator.validate(input)) {
                isValid = true;
            } else {
                System.out.println("Помилка. Неправильний формат даних. Спробуйте ще раз.");
            }
        } while (!isValid);
        return input;
    }
}
