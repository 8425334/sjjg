public interface IList<E> {
    E get(int index);
    int indexOf(E e);
    int remove(int index);
    int size();
    void add(int index, E e);

}
