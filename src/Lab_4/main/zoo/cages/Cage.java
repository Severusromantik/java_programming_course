package Lab_4.main.zoo.cages;

import Lab_4.main.zoo.animals.Animal;
import Lab_4.main.zoo.exceptions.AnimalNotFoundException;
import Lab_4.main.zoo.exceptions.CageIsFullException;

import java.util.ArrayList;
import java.util.List;

// Базовий узагальнений клас вольєра
public abstract class Cage<T extends Animal> {
    private final int capacity;
    protected final List<T> animals;

    public Cage(int capacity) {
        this.capacity = capacity;
        this.animals = new ArrayList<>();
    }

    public void addAnimal(T animal) throws CageIsFullException {
        if (animals.size() >= capacity) {
            throw new CageIsFullException("Вольєр заповнений. Неможливо додати " + animal.getName());
        }
        animals.add(animal);
        System.out.println(animal.getName() + " доданий у вольєр.");
    }

    public void removeAnimal(T animal) throws AnimalNotFoundException {
        if (!animals.contains(animal)) {
            throw new AnimalNotFoundException("Тварини " + animal.getName() + " немає у вольєрі.");
        }
        animals.remove(animal);
        System.out.println(animal.getName() + " вилучений з вольєра.");
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentCount() {
        return animals.size();
    }
}
