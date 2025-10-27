package Lab_4.main.zoo.cages;

import Lab_4.main.zoo.animals.Mammal;

public abstract class MammalCage<T extends Mammal> extends Cage<T> {
    public MammalCage(int capacity) {
        super(capacity);
    }
}
