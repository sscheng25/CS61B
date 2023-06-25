package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T> {
    private int size = 8;
    private int actSize;
    private T a[];
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(T item) {
        a = (T[]) new Object[size];
        nextFirst = 4;
        nextLast = 6;
        a[nextFirst + 1] = item;
        actSize = 1;
    }

    public ArrayDeque() {
        a = (T[]) new Object[size];
        nextFirst = 4;
        nextLast = 5;
        actSize = 0;
    }

    @Override
    public int size() {
        return actSize;
    }

    private void resize(int s) {
        T temp[] = (T[]) new Object[s];
        if (size < s) {
            // resize factor s is larger than previous size
            if (nextFirst == size -1) {
                for (int i=0; i<size; i+=1) {
                    temp[i] = a[i];
                }
                nextFirst = s-1;
            } else {
                for (int i = s-size+nextFirst; i<s; i+=1) {
                    temp[i] = a[i+size-s];
                }
                for(int m = 0; m<nextLast; m+=1) {
                    temp[m] = a[m];
                }
                nextFirst = s-size+nextFirst;
            }
        } else {
            // resize factor s is smaller than previous size
            if (nextFirst < nextLast) {
                for (int i=0; i < nextLast-nextFirst-1; i+=1) {
                    temp[i] = a[nextFirst+1+i];
                }
            } else {
                for (int i=0; i<size-nextFirst-1; i+=1) {
                    temp[i] = a[nextFirst+1+i];
                }
                for(int m=size-nextFirst-1; m<size-nextFirst-1+nextLast; m+=1) {
                    temp[m] = a[m-(size-nextFirst-1)];
                }
            }
            nextFirst = s-1;
            nextLast = actSize-1;
        }
        a = temp;
    }

    @Override
    public boolean isEmpty() {
        return actSize == 0;
    }

    @Override
    public void addFirst(T item) {
        if (actSize + 2 <= size) {
            actSize += 1;
        } else {
            // resize
            resize(size * 2);
            size *=2;
            actSize +=1;
        }
        a[nextFirst] = item;
        if (nextFirst == 0) {
            nextFirst = size - 1;
        } else {
            nextFirst -= 1;
        }

    }

    @Override
    public void addLast(T item) {
        if (actSize + 2 <= size) {
            actSize += 1;
        } else {
            // resize
            resize(size * 2);
            size *=2;
            actSize +=1;
        }

        a[nextLast] = item;
        if(nextLast == size - 1) {
            nextLast = 0;
        } else {
            nextLast +=1;
        }
    }

    @Override
    public T removeFirst() {
        T temp;
        if (nextFirst == size - 1) {
            temp = a[0];
            nextFirst = 0;
        } else {
            temp = a[nextFirst + 1];
            nextFirst +=1;
        }

        if (size <= 16 || (actSize-1)*4 >= size) {
            actSize-=1;
        } else {
            // resize
            resize(size / 2);
            size /=2;
            actSize -=1;
        }
        return temp;
    }

    @Override
    public T removeLast() {
        T temp;
        if (nextLast == 0) {
            temp = a[size - 1];
            nextLast = size - 1;
        } else {
            temp = a[nextLast - 1];
            nextLast -=1;
        }

        if (size <= 16 || (actSize-1)*4 >= size) {
            actSize-=1;
        } else {
            // resize
            resize(size / 2);
            size /=2;
            actSize -=1;
        }
        return temp;
    }

    @Override
    public void printDeque(){
        if (nextFirst < nextLast) {
            for (int i=nextFirst+1; i< nextLast-1; i+=1) {
                System.out.println(a[i]);
            }
        } else {
            for(int i=nextFirst+1; i<size; i+=1) {
                System.out.println(a[i]);
            }
            for (int m=0; m<nextLast-1; m+=1) {
                System.out.println(a[m]);
            }
        }
    }

    @Override
    public T get(int index) {
        if (actSize == 0 || index > size - 1) {
            return null;
        }
        if (nextFirst<nextLast && (index<=nextFirst || index>=nextLast)) {
            return null;
        }
        if (nextFirst>nextLast && (index>=nextLast && index<=nextFirst)) {
            return null;
        }
        return a[index];
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ArrayDeque == false) {
            return false;
        }
        ArrayDeque test = (ArrayDeque) o;

        if (this.size != test.size || this.actSize != test.actSize) {
            return false;
        }

        for (int i = 0; i < size; i+=1) {
            if (this.get(i) != test.get(i)) {
                return false;
            }
        }

        return true;
    }

    private class arrayDequeIterator implements Iterator<T> {
        private int wizPos;
        public arrayDequeIterator() { wizPos = 0; }

        public boolean hasNext() {
            return wizPos < actSize;
        }

        public T next() {
            T returnItem;

            if (nextFirst + wizPos + 1 < size) {
                returnItem = a[nextFirst + wizPos + 1];
            } else {
                returnItem = a[nextFirst + wizPos + 1 - size];
            }
            wizPos += 1;
            return returnItem;
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new arrayDequeIterator();
    }

    public int getNextFirst() {
        return nextFirst;
    }

    public static void main(String[] args) {

    }
}
