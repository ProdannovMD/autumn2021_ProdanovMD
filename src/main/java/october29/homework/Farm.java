package october29.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Farm<T> {
    List<List<? extends T>> trees;

    public Farm() {
        trees = new ArrayList<>();
    }

    public void plantTree(List<? extends T> tree) {
        trees.add(tree);
    }

    public <E extends T> boolean fillTruck(Stack<T> truck, Class<E> eClass) {
        for (List<? extends T> tree : trees) {
            if (tree.size() == 0 || !eClass.isAssignableFrom(tree.get(0).getClass()))
                continue;

            while (tree.size() != 0) {
                truck.add(tree.remove(0));
            }
            return true;

        }
        return false;
    }
}
