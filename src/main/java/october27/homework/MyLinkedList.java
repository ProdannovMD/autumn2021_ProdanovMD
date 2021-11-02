package october27.homework;

import java.util.*;

public class MyLinkedList<T> implements List<T> {

    private static class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> prev;

        public Node() {
            this.element = null;
            this.next = this;
            this.prev = this;
        }

        public Node(E element, Node<E> header) {
            this.element = element;
            this.next = header;
            this.prev = header;
        }

        public Node(E element, Node<E> next, Node<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }

    private static class ListIteratorImpl<E> implements ListIterator<E> {
        private final MyLinkedList<E> myList;
        private Node<E> current;
        private int currIndex;

        public ListIteratorImpl(MyLinkedList<E> myList) {
            this.myList = myList;
            this.current = myList.header;
            this.currIndex = -1;
        }

        public ListIteratorImpl(MyLinkedList<E> myList, int nextIndex) {
            this(myList);
            for (int i = 0; i < nextIndex; i++) {
                next();
            }
        }

        @Override
        public boolean hasNext() {
            return current.getNext() != myList.header;
        }

        @Override
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();
            current = current.getNext();
            currIndex++;

            return current.getElement();
        }

        @Override
        public boolean hasPrevious() {
            return current != myList.header && current.getPrev() != myList.header;
        }

        @Override
        public E previous() {
            if (!hasPrevious())
                throw new NoSuchElementException();
            current = current.getPrev();
            currIndex--;
            return current.getElement();
        }

        @Override
        public int nextIndex() {
            return currIndex + 1;
        }

        @Override
        public int previousIndex() {
            return Math.max(-1, currIndex - 1);
        }

        @Override
        public void remove() {
            myList.remove(currIndex);
        }

        @Override
        public void set(E e) {
            myList.set(currIndex, e);
        }

        @Override
        public void add(E e) {
            myList.add(currIndex, e);
        }
    }

    private Node<T> header = new Node<>();


    @Override
    public int size() {
        Node<T> current = header.getNext();
        if (current == header) {
            return 0;
        }
        int cnt = 1;
        while (header != current.getNext()) {
            cnt++;
            current = current.getNext();
        }

        return cnt;
    }

    @Override
    public boolean isEmpty() {
        return header == header.getNext();
    }

    @Override
    public boolean contains(Object o) {
        Node<T> current = header.getNext();
        if (current == header) {
            return false;
        }
        while (header != current.getNext()) {
            if (current.getElement().equals(o))
                return true;
            current = current.getNext();
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIteratorImpl<>(this);
    }

    @Override
    public Object[] toArray() {
        int size = size();
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = get(i);
        }
        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        int size = size();
        Object[] objectArray = toArray();
        if (a.length < size)
            return (T1[]) Arrays.copyOf(objectArray, size, a.getClass());

        System.arraycopy(objectArray, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;

        return a;
    }

    @Override
    public boolean add(T t) {
        Node<T> node = new Node<T>(t, header);
        if (header.getNext() == header) {
            header.setNext(node);
            header.setPrev(node);
        } else {
            Node<T> prev = header.getPrev();
            node.setPrev(prev);
            prev.setNext(node);
            header.setPrev(node);
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int idx = indexOf(o);
        if (idx == -1)
            return false;

        remove(idx);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return c.stream().allMatch(this::contains);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        int size = size();
        c.forEach(this::add);

        return size != size();
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        int size = size();
        Object[] objects = c.toArray();
        for (int i = objects.length - 1; i >= 0; i--) {
            add(index, (T) objects[i]);
        }
        return size != size();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int size = size();
        c.forEach(this::remove);
        return size != size();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int size = size();
        removeIf(element -> !c.contains(element));
        return size != size();
    }

    @Override
    public void clear() {
        header = new Node<>();
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        Node<T> current = header.getNext();
        while (index > 0) {
            current = current.getNext();
            index--;
        }
        return current.getElement();
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        Node<T> current = header.getNext();
        while (index > 0) {
            current = current.getNext();
            index--;
        }
        T prevElement = current.getElement();
        current.setElement(element);

        return prevElement;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        Node<T> current = header.getNext();
        while (index > 0) {
            current = current.getNext();
            index--;
        }

        Node<T> newNode = new Node<>(element, header);
        if (current.getPrev() == header) {
            current.setPrev(newNode);
            newNode.setNext(current);
            header.setNext(newNode);
            return;
        }

        Node<T> currentPrev = current.getPrev();
        currentPrev.setNext(newNode);
        current.setPrev(newNode);
        newNode.setPrev(currentPrev);
        newNode.setNext(current);
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        Node<T> current = header.getNext();
        while (index > 0) {
            current = current.getNext();
            index--;
        }
        T currentElement = current.getElement();
        if (size() == 1) {
            clear();
            return currentElement;
        }

        Node<T> curPrev = current.getPrev();
        Node<T> curNext = current.getNext();
        if (curPrev == current) {
            curNext.setPrev(header);
            header.setNext(curNext);
        } else if (curNext == current) {
            curPrev.setNext(header);
            header.setPrev(curPrev);
        } else {
            curNext.setPrev(curPrev);
            curPrev.setNext(curNext);
        }

        return currentElement;
    }

    @Override
    public int indexOf(Object o) {
        Node<T> current = header.getNext();
        if (current == header) {
            return -1;
        }
        int i = 0;
        do {
            if (current.getElement().equals(o)) {
                return i;
            }
            i++;
            current = current.getNext();
        } while (header != current.getNext());

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node<T> current = header.getPrev();
        if (current == header) {
            return -1;
        }

        int i = size() - 1;
        do {
            if (current.getElement().equals(o)) {
                return i;
            }
            i--;
            current = current.getPrev();
        } while (header != current.getPrev());

        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new ListIteratorImpl<>(this);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException();
        return new ListIteratorImpl<>(this, index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size() || fromIndex > toIndex)
            throw new IndexOutOfBoundsException();

        MyLinkedList<T> newList = new MyLinkedList<>();

        for (int i = fromIndex; i < toIndex; i++) {
            newList.add(get(i));
        }

        return newList;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
