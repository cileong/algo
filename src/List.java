public interface List<E> {

    /**
     * Return the element stored at the specified position in the list.
     * @param index The index of the element to return.
     * @return The element at the specified position.
     */
    E get(int index);

    /**
     * Update the element stored at the specified position in the list.
     * @param index The position to store {@code element} in.
     * @param element The element to be stored.
     */
    void set(int index, E element);

    /**
     * Insert an element at a specified position.
     * @param index The position to insert the element.
     * @param element The element to be inserted.
     */
    void insert(int index, E element);

    /**
     * Append {@code element} to the end of the list.
     * @param element The element to be appended.
     */
    void add(E element);

    /**
     * Return the index of {@code element} in the list, if it is present.
     * Return {@code -1} otherwise.
     * @param element The element to look for.
     * @return The index of {@code element}. {@code -1} if not found.
     */
    int indexOf(E element);

    /**
     * Remove the element at the specified position.
     * @param index The index of the element to be removed.
     * @return The removed element.
     */
    E remove(int index);

    /**
     * Remove {@code element} from the list.
     * @param element The element to be removed.
     * @return {@code true} if {@code element} is successfully removed.
     */
    boolean remove(E element);

    /**
     * Empty the list.
     */
    void clear();

    /**
     * Return {@code true} if {@code element} is in the list.
     * @param element The element to test for.
     * @return {@code true} if element is in the list.
     */
    boolean contains(E element);

    /**
     * Return the number of elements stored in the list.
     * @return The number of elements stored.
     */
    int size();

    /**
     * Return {@code true} if the list is empty.
     * @return {@code true} if the list is empty.
     */
    boolean isEmpty();

}
