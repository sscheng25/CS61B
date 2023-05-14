package deque;

public class LinkedListDeque<T> {
    /* Sentinel Node video: List 2, Video 6 */
    private Node<Integer> sentinel = new Node<Integer>(11, null, null);
    private Node<Integer> last = new Node<Integer>(22, null, null);
    private int size;

    /* Generic list video: List 3, Video 4 */
    private class Node<T> {
        public T first;
        private Node next;
        private Node prev;
        public Node(T a, Node b, Node c) {
            first = a;
            prev = b;
            next = c;
        }

        public T giveT() {
            return first;
        }
    }

    /* Construct LinkedListDeque */
    public LinkedListDeque(T item) {
        sentinel.next = new Node(item, sentinel, last);
        last.prev = sentinel.next;
        size = 1;
    }

    /* Construct empty LinkedListDeque */
    public LinkedListDeque() {
        sentinel.next = last;
        last.prev = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        sentinel.next = new Node(item, null, sentinel.next);
        sentinel.next.prev = sentinel;

        if (sentinel.next.next == null) {
            sentinel.next.next = last;

        }

        sentinel.next.next.prev = sentinel.next;

        if (last.prev.prev == null) {
            last.prev = sentinel.next;
        }


        size +=1;
    }

    public void addLast(T item) {
        last.prev = new Node(item, last.prev, last);
        // last.prev.next = last;

        if (last.prev.prev == null) {
            last.prev.prev = sentinel;
        }

        last.prev.prev.next = last.prev;

        if (sentinel.next.next == null) {
            sentinel.next = last.prev;
        }
        size +=1;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T temp = (T) sentinel.next.giveT();
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -=1;
        return temp;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T temp = (T) last.prev.giveT();
        last.prev = last.prev.prev;
        last.prev.next = last;
        size -=1;
        return temp;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node t = sentinel.next;
        while (t != last) {
            System.out.println(t.giveT());
            t = t.next;
        }
    }

    public T get(int index) {
        int i = 0;
        Node t = sentinel.next;
        while (i < index) {
            t = t.next;
            i+=1;
        }
        return (T) t.giveT();
    }

    public T getRecursive(int index) {
        if (index == 0) {
            return (T) sentinel.next.giveT();
        } else {
             return getRecursive(index - 1);
        }
    }

    public boolean equals(Object o) {
        if (o instanceof LinkedListDeque == false) {
            return false;
        }
        LinkedListDeque test = (LinkedListDeque) o;

        if (this.size != test.size) {
            return false;
        }

        for (int i = 0; i < size; i+=1) {
            if (this.get(i) != test.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
