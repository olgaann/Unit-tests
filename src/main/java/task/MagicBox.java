package task;

import java.util.Random;

public class MagicBox<T> {
    private String boxName;
    private int qty; //кол-во абстрактных объектов, которое можно записать в экземпляр класса
    private final T[] items; // массив, в котором мы будем хранить эти абстрактные объекты экземпляра класса
    private int count = 0; //показывает, сколько ячеек массива заполнено
    private Random random = new Random();

    public MagicBox(String boxName, int qty) {
        this.boxName = boxName;
        this.items = (T[]) new Object[qty];
    }

    public T[] getItems() {
        return items;
    }

    public String getBoxName() {
        return boxName;
    }

    public boolean add(T item) {
        if (count < items.length) { //если есть пустые ячейки массива
            items[count] = item; //то добавляем новый элемент в массив
            count++;//и увеличиваем счетчик
            return true;
        }
        return false;
    }

    public T pick() throws RuntimeException {
        if (count < items.length) {
            int empty = items.length - count;
            throw new RuntimeException("Необходимо заполнить все ячейки массива " + this.boxName + ". Сейчас незаполненных ячеек: " + empty + " шт.");
        }
        int randomInt = random.nextInt(items.length); // определяем случайное число в диапазоне [0; items.length)
        return items[randomInt];
    }
}
