package custom_array_list;

/**
 * Интерфейс, описывающий базовые методы.
 * @param <A> Тип элементов, которые будут храниться в списке.
 */
public interface CustomList<A> {
    /**
     * Добавляет элемент в конец списка.
     * @param element Элемент для добавления.
     */
    void add(A element);

    /**
     * Получает элемент по указанному индексу.
     * @param index Индекс элемента.
     * @return Элемент на указанном индексе.
     */
    A get(int index);

    /**
     * Удаляет элемент по индексу.
     * @param index Индекс элемента.
     */
    void remove(int index);
}
