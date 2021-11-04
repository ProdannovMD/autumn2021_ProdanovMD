package october29.homework;

import october29.homework.exceptions.NoSuchProductException;
import october29.homework.products.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

public class Store<T> {
    private Stack<T> truck = new Stack<>();
    private Farm<T> farm;

    public Store(Farm<T> farm) {
        this.farm = farm;
    }

    private <E extends T> void fillTruck(Class<E> eClass) throws NoSuchProductException {
        truck = new Stack<>();
        if (!farm.fillTruck(truck, eClass))
            throw new NoSuchProductException();
    }

    public <E extends T> E buyProduct(Class<E> eClass) {
        try {
            if (truck.empty() || !eClass.isAssignableFrom(truck.peek().getClass())) {
                fillTruck(eClass);
            }
            if (!eClass.isAssignableFrom(truck.peek().getClass()))
                return null;

            return (E) truck.remove(0);

        } catch (NoSuchProductException e) {
            return null;
        }
    }
}
