package task;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        MagicBox<String> box1 = new MagicBox<>("box1", 3); // cоздаем MagicBox<String>
        System.out.println(Arrays.toString(box1.getItems()));
        //заполняем ее:
        System.out.println(box1.add("один"));
        System.out.println(box1.add("два"));
        System.out.println(box1.add("три"));
        System.out.println(box1.add("четыре"));
        System.out.println(Arrays.toString(box1.getItems()));
        System.out.println("Случайное значение коробки " + box1.getBoxName() + ": " + box1.pick()); //выбираем случайное значение

        System.out.println("");

        MagicBox<Integer> box2 = new MagicBox<>("box2", 3); // cоздаем MagicBox<Integer>
        System.out.println(Arrays.toString(box2.getItems()));
        //заполняем ее
        for (int i = 0; i < 3; i++) {
            box2.add(i + 1);
        }
        System.out.println(Arrays.toString(box2.getItems()));
        System.out.println("Случайное значение коробки " + box2.getBoxName() + ": " + box2.pick()); //выбираем случайное значение
    }
}
