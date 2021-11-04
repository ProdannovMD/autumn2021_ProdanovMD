package october29.homework;

import october29.homework.products.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Farm<Fruit> fruitFarm = new Farm<>();

        List<Apple> appleTree = new ArrayList<>();
        List<Apricot> apricotTree = new ArrayList<>();
        List<Orange> orangeTree = new ArrayList<>();
        List<Pear> pearTree = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            appleTree.add(new Apple());
            apricotTree.add(new Apricot());
            orangeTree.add(new Orange());
            pearTree.add(new Pear());
        }
        fruitFarm.plantTree(appleTree);
        fruitFarm.plantTree(apricotTree);
        fruitFarm.plantTree(orangeTree);
        fruitFarm.plantTree(pearTree);

        Store<Fruit> fruitStore = new Store<>(fruitFarm);

        System.out.println(fruitStore.buyProduct(Apple.class));
        System.out.println(fruitStore.buyProduct(Apple.class));
        System.out.println(fruitStore.buyProduct(Pear.class));
        System.out.println(fruitStore.buyProduct(Apricot.class));
        System.out.println(fruitStore.buyProduct(Apricot.class));
        System.out.println(fruitStore.buyProduct(Fruit.class));


    }
}
