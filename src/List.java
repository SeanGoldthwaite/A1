
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
    E get(int index) throws EmptyListException {
        throw new EmptyListException();
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
}

class NodeL<E> extends List<E> {
    public E value;
    public List<E> next;

    public NodeL(E value, List<E> next) {
        this.value = value;
        this.next = next;
    }

    boolean isEmpty() {
        return value == null && next == null;
    }
    boolean isSingleton() {
        return value != null && next == null;
    }
    E getFirst() {
        return value;
    }
    List<E> getRest() {
        return next;
    }
    E get(int index) throws EmptyListException{
        if (index == 0)
            return value;
        else
            return next.get(index - 1);
    }
    int length() {
        /*if (next == null)
            return 1;
        else
            return 1 + next.length();*/
        return 1 + (next == null ? 0 : next.length());
    }
    List<E> append(List<E> other) {
        if (next == null) {
            next = other;
            return this;
        }
        else {
            return next.append(other);
        }
    }
    boolean contains(E element) {
        /*if (value.equals(element))
            return true;
        else
            return next.contains(element);*/
        /*return value.equals(element) ? true : next.contains(element);*/
        return value.equals(element) || next.contains(element);
    }
}
class Test {
    public static void main(String[] args) {

    }
}

