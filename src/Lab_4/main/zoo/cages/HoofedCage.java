package Lab_4.main.zoo.cages;

import Lab_4.main.zoo.animals.Hoofed;

public class HoofedCage<T extends Hoofed> extends MammalCage<T> {
    public HoofedCage(int capacity) {
        super(capacity);
    }
}