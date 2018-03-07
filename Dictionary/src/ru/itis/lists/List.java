package ru.itis.lists;

/**
 * 15.02.2018
 * List
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */

/**
 * Частный случай коллекции, гарантирует определенный порядок элементов
 */
public interface List<T> extends Collection<T>, Iterable<T> {
    /**
     * Находит элемент в коллекции
     * @param element
     * @return индекс элемента, если он найден, -1 в противном случае
     */
    int indexOf(T element);

    /**
     * Получить элемент по индексу
     * @param index
     * @return элемент под заданным индексом
     */
    T get(int index);
}
