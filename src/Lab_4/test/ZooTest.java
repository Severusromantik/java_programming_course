//package Lab_4.test;

import Lab_4.main.zoo.Zoo;
import Lab_4.main.zoo.animals.*;
import Lab_4.main.zoo.cages.*;
import Lab_4.main.zoo.exceptions.AnimalNotFoundException;
import Lab_4.main.zoo.exceptions.CageIsFullException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ZooTest {

    @Test
    void testCageFunctionalityAndGenerics() {
        // Створення вольєрів
        LionCage lionCage = new LionCage(2);
        // HoofedCage параметризований конкретними типами, що відповідають Hoofed
        HoofedCage<Zebra> zebraCage = new HoofedCage<>(3);
        HoofedCage<Giraffe> giraffeCage = new HoofedCage<>(1);
        BirdCage eagleCage = new BirdCage(5);

        // Створення тварин
        Lion simba = new Lion("Сімба");
        Lion nala = new Lion("Нала");
        Zebra marty = new Zebra("Марті");
        Giraffe melman = new Giraffe("Мелман");
        Eagle eddie = new Eagle("Едді");

        // 1. Тестування типової безпеки (Generics)
        // Компілятор НЕ ДОЗВОЛИТЬ: lionCage.addAnimal(marty); // Marty це Zebra, а не Lion
        // Компілятор НЕ ДОЗВОЛИТЬ: zebraCage.addAnimal(simba); // Simba це Lion, а не Hoofed

        // 2. Тестування додавання
        assertDoesNotThrow(() -> lionCage.addAnimal(simba));
        assertDoesNotThrow(() -> zebraCage.addAnimal(marty));
        assertDoesNotThrow(() -> giraffeCage.addAnimal(melman));
        assertDoesNotThrow(() -> eagleCage.addAnimal(eddie));

        // 3. Тестування CageIsFullException
        assertDoesNotThrow(() -> lionCage.addAnimal(nala));
        assertEquals(2, lionCage.getCurrentCount()); // Вольєр заповнений

        assertThrows(CageIsFullException.class, () -> {
            Lion scar = new Lion("Шрам");
            lionCage.addAnimal(scar); // Спроба додати 3-го лева
        }, "Повинно викликати виняток, якщо вольєр заповнений");

        // 4. Тестування AnimalNotFoundException
        assertThrows(AnimalNotFoundException.class, () -> {
            lionCage.removeAnimal(new Lion("Капітан")); // Капітана немає
        }, "Повинно викликати виняток, якщо тварини немає");

        // 5. Тестування Zoo (Wildcard та підрахунок)
        Zoo zoo = new Zoo();
        zoo.addCage(lionCage);
        zoo.addCage(zebraCage);
        zoo.addCage(eagleCage);
        zoo.addCage(giraffeCage);

        // Поточний підрахунок: 2 (Lion) + 1 (Zebra) + 1 (Giraffe) + 1 (Eagle) = 5
        assertEquals(5, zoo.getCountOfAnimals(), "Загальна кількість тварин має бути 5");

        // 6. Тестування вилучення та повторного підрахунку
        assertDoesNotThrow(() -> lionCage.removeAnimal(simba)); // Вилучаємо Сімбу

        // Новий підрахунок: 1 (Lion) + 1 (Zebra) + 1 (Giraffe) + 1 (Eagle) = 4
        assertEquals(4, zoo.getCountOfAnimals(), "Загальна кількість тварин має бути 4 після вилучення");
    }
}