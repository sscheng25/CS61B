public class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode first;

    public SLList() {
        first = null;
    }

    public SLList(int f) {
        first = new IntNode(f, null);
    }

    public void addFirst(int f) {
        first =  new IntNode(f, first);
    }

    public int getFirst() {
        return first.item;
    }

    public void addLast(int l) {
        IntNode p = first;
        if (p == null) {
            first = new IntNode(l, null);
        } else {
            while(p.next != null) {
                p = p.next;
            }
            p.next = new IntNode(l, null);
        }

    }

    private static int size(IntNode in) {
        // IntNode p = first;
        if (in.next == null) {
            return 1;
        } else {
            return 1 + size(in.next);
        }
    }

    public int size() {
        return size(first);
    }

    public static void main(String[] args) {
        SLList l = new SLList();
        l.addLast(15);

        System.out.println(l.getFirst());
        System.out.println(l.size());
    }
}
