import java.util.Arrays;
import java.util.Objects;


public class ArrayList<E> implements List<E> {

    /**
     * The initial array size when first initialised.
     */
    private static final int DEFAULT_CAPACITY = 3;

    /**
     * Define how much space will be allocated for,
     * after resizing when the array is full.
     */
    private static final int RESIZE_FACTOR = 2;

    /**
     * The array for storing the elements,
     * will be resized dynamically when full.
     */
    private Object[] elementData;

    /**
     * The number of elements stored in the array,
     * used to determine where to place the appended element.
     * Every element in {@code elementData} stored after index {@code size} is garbage value.
     */
    private int size;

    /**
     * Constructor.
     * Create an empty array to preallocate space,
     * containing only garbage values ({@code null}),
     * inaccessible from outside of the class.
     */
    public ArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Java does not support generic array.
     * This method is a wrapper to access elements stored in the array.
     * The casting will not raise any error, as all added elements are of type {@code E}.
     * @param index The index of the desired element.
     * @return The element at {@code index}.
     */
    @SuppressWarnings("unchecked")
    private E elementData(int index) {
        return (E) elementData[index];
    }

    /**
     * Return the element stored at the specified position in the list.
     * @param index The index of the element to return.
     * @return The element at the specified position.
     */
    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        return elementData(index);
    }

    /**
     * Update the element stored at the specified position in the list.
     * @param index The position to store {@code element} in.
     * @param element The element to be stored.
     */
    @Override
    public void set(int index, E element) {
        Objects.checkIndex(index, size+1);
        elementData[index] = element;
    }

    /**
     * Insert an element at a specified position.
     * @param index The position to insert the element.
     * @param element The element to be inserted.
     */
    @Override
    public void insert(int index, E element) {
        Objects.checkIndex(index, size+1);
        if (isFull())
            resize();
        shuffleRight(index);
        set(index, element);
        size++;
    }

    /**
     * Append {@code element} to the end of the list.
     * @param element The element to be appended.
     */
    @Override
    public void add(E element) {
        insert(size, element);
    }

    /**
     * Return the index of {@code element} in the list, if it is present.
     * Return {@code -1} otherwise.
     * @param element The element to look for.
     * @return The index of {@code element}. {@code -1} if not found.
     */
    @Override
    public int indexOf(E element) {
        for (int i=0; i<size; i++) {
            if (element == null && get(i) == null ||
                    get(i).equals(element))
                return i;
        }
        return -1;
    }

    /**
     * Remove the element at the specified position.
     * @param index The index of the element to be removed.
     * @return The removed element.
     */
    @Override
    public E remove(int index) {
        Objects.checkIndex(index, size);
        E oldItem = elementData(index);
        shuffleLeft(index);
        size--;
        return oldItem;
    }

    /**
     * Remove {@code element} from the list.
     * @param element The element to be removed.
     * @return {@code true} if {@code element} is successfully removed.
     */
    @Override
    public boolean remove(E element) {
        int index = indexOf(element);
        if (index >= 0)
            remove(index);
        return index >= 0;
    }

    /**
     * Empty the list.
     */
    @Override
    public void clear() {
        size = 0;
    }

    /**
     * Return {@code true} if {@code element} is in the list.
     * @param element The element to test for.
     * @return {@code true} if element is in the list.
     */
    @Override
    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    /**
     * Return the number of elements stored in the list.
     * @return The number of elements stored.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Return {@code true} if the list is empty.
     * @return {@code true} if the list is empty.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return {@code true} if the array is full.
     * This means the array needs to be sized up.
     * @return {@code true} if the array is full.
     */
    private boolean isFull() {
        return size == elementData.length;
    }

    /**
     * Shuffle every element starting from {@code index} by one to the left.
     * @param index The index to start shuffling from.
     */
    private void shuffleLeft(int index) {
        Objects.checkIndex(index, size);
        for (int i=index; i<size-1; i++)
            set(i, get(i+1));
    }

    /**
     * Shuffle every element starting from {@code index} by one to the right.
     * @param index The index to start shuffling from.
     */
    private void shuffleRight(int index) {
        Objects.checkIndex(index, size+1);
        for (int i=size; i>index; i--)
            set(i, get(i-1));
    }

    /**
     * Called when the array is full.
     * Resize the array to fit more elements.
     */
    private void resize() {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity * RESIZE_FACTOR;
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    /**
     * Convert the list to string, for logging.
     * @return The list in string representation.
     */
    @Override
    public String toString() {
        Object[] arraySlice = Arrays.copyOf(elementData, size);
        return Arrays.toString(arraySlice);
    }

}
