
class EmptyListException extends Exception {}

abstract class List<E> {
    abstract boolean isEmpty ();
    abstract boolean isSingleton();
    abstract E getFirst() throws EmptyListException;
    abstract List<E> getRest() throws EmptyListException;
    abstract E get (int index) throws EmptyListException;
    abstract int length ();
    abstract List<E> append (List<E> other);
    abstract boolean contains (E elem);
    abstract boolean equalTo(List<E> other) throws EmptyListException;
}

class EmptyL<E> extends List<E> {
    public EmptyL() {

    }
    boolean isEmpty() {
        return true;
    }
    boolean isSingleton() {
        return false;
    }
    E getFirst() throws EmptyListException {
        throw new EmptyListException();
    }
    List<E> getRest() throws EmptyListException {
        throw new EmptyListException();
    }
    E get(int index) {
        throw new IndexOutOfBoundsException();
    }
    int length() {
        return 0;
    }
    List<E> append(List<E> other) {
        return null;
    }
    boolean contains(E element) {
        return false;
    }
    public String toString() {
        return "--end";
    }
    boolean equalTo(List<E> other){
        return other instanceof EmptyL;
    }
}

class NodeL<E> extends List<E> {
    public E value;
    public List<E> next;

    public NodeL(E value, List<E> next) {
        this.value = value;
        this.next = next;
    }

    boolean isEmpty() {
        return false;
    }
    boolean isSingleton() {
        return (next instanceof EmptyL);
    }
    E getFirst() {
        return value;
    }
    List<E> getRest() {
        return next;
    }
    E get(int index) throws EmptyListException {
        if (index == 0)
            return value;
        else
            return next.get(index - 1);
    }
    int length() {
        return 1 + (next instanceof EmptyL ? 0 : next.length());
    }
    List<E> append(List<E> other) {
        if (next instanceof EmptyL) {
            next = other;
            return this;
        }
        else {
            return next.append(other);
        }
    }
    boolean contains(E element) {
        return value.equals(element) || next.contains(element);
    }
    public String toString() {
        return value + " " + next;
    }
    boolean equalTo(List<E> other) throws EmptyListException {
        if (!value.equals(other.getFirst())) {
            System.out.println(value + " does not equal " + other.getFirst());
            return false;
        }
        else
            return next.equalTo(other.getRest());
    }
}

