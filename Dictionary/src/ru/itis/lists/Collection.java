package ru.itis.lists;

/**
 * 15.02.2018
 * Collection
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
/* интерфейс, который описывает
какой-либо контейнер для хранения данных
 */
public interface Collection<T> {
    /**
     * Добавить в начало
     * @param element
     */
    void addToBegin(T element);

    /**
     * Добавить в конец
     * @param element
     */
    void add(T element);

    /**
     * Удалить элемент
     * @param element
     */
    void remove(T element);

    /**
     * Проверить, есть ли элемент в коллекции
     * @param element
     * @return true, если элемент есть, false - в противном случае
     */
    boolean contains(T element);

    /**
     * Количество элементов в коллекции
     * @return
     */
    int size();
}
