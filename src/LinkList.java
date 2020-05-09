import org.w3c.dom.ranges.Range;

import java.util.List;

public class LinkList<E> implements IList<E>{

    Node<E> head;
    int size;

    public LinkList(){
        head = new Node<>();
    }

    @Override
    public E get(int index) {
        BoundsCheck(index);
        int temp = 0;
        Node<E> node = head;
        while (temp < index){
            node = node.next;
            temp ++;
        }
        return node.data;
    }

    @Override
    public int indexOf(E e) {
        return 0;
    }

    @Override
    public int remove(int index) {
        return 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int index, E e) {
        //查询边界
        BoundsCheck(index);
        Node<E> node = head;
        if (size() == 0){
            head = new Node<>(e);
            size++;
            return;
        }
        int i = 0;
        while (i < index && node.next != null){
            node = node.next;
            i++;
        }
        Node<E> temp = node.next;
        node = new Node<>(e);
        node.next = temp;
        size++;
    }

    private void BoundsCheck(int index) {
        if (index < 0 || index > size()){
            throw new IndexOutOfBoundsException("超出边界");
        }
    }
}
