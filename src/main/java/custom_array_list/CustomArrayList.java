package custom_array_list;

import java.util.Arrays;

public class CustomArrayList<A> implements CustomList<A> {
    private Object[] elements;
    private int size = 0;

    /**
     * Конструктор по умолчанию.
     * @param capacity Размер массива.
     */
    public CustomArrayList(int capacity) {
        elements = new Object[capacity];
    }

    /**
     * Добавляет элемент в конец списка.
     * @param element Элемент для добавления.
     */
    @Override
    public void add(A element) {
        if (element == null) {
            throw new IllegalArgumentException("Element can't be null");
        }
        if (size == elements.length) {
            resize();
        }
        elements[size++] = element;
    }

    /**
     * Получает элемент по указанному индексу.
     * @param index Индекс элемента.
     * @return Элемент на указанном индексе.
     */
    @Override
    public A get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        return (A) elements[index];
    }

    /**
     * Удаляет элемент по указанному индексу.
     * @param index Индекс элемента.
     */
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        for (int i = index; i < size - 1; ++i) {
            elements[i] = elements[i + 1];
        }
    }

    /**
     * Динамически расширяет массив.
     */
    private void resize() {
        elements = Arrays.copyOf(elements, 2 * size);
    }
}