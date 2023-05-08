package deque;

public class LinkedListDeque<T> {
    /* Sentinel Node video: List 2, Video 6 */
    private Node<Integer> sentinel = new Node<Integer>(11, null, null);
    private Node<Integer> last = new Node<Integer>(22, null, null);
    private int size;

    /* Generic list video: List 3, Video 4 */
    private class Node<T> {
        private T first;
        private Node next;
        private Node prev;
        public Node(T a, Node b, Node c) {
            first = a;
            prev = b;
            next = c;
        }
    }

    /* Construct LinkedListDeque */
    public LinkedListDeque(T item) {
        sentinel.next = new Node(item, sentinel, null);
        last.prev = sentinel.next;
        size = 1;
    }

    /* Construct empty LinkedListDeque */
    public LinkedListDeque() {
        sentinel.next = null;
        last.prev = sentinel.next;
        size = 0;
    }

    public void addFirst(T item) {
        sentinel.next = new Node(item, null, sentinel.next);
    }

    public void addLast(T item) {
        last.prev = new Node(item, last.prev, null);
    }

    public boolean isEmpty() {
        return sentinel.next == null;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {

    }
}
