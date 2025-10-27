package Lab_4.main.zoo;

import Lab_4.main.zoo.animals.Animal;
import Lab_4.main.zoo.cages.Cage;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

    public List<Cage<? extends Animal>> cages = new ArrayList<>();

    public void addCage(Cage<? extends Animal> cage) {
        cages.add(cage);
    }

    public int getCountOfAnimals() {
        int total = 0;
        for (Cage<? extends Animal> cage : cages) {
            total += cage.getCurrentCount();
        }
        return total;
    }
}
