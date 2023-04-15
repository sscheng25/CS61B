public class Sort {
    public static void sort(String[] str) {
        sort(str, 0);
    }

    public static void sort(String[] str, int k) {
        if (k == str.length) {
            return;
        }
        int smallest = getSmallest(str, k);
        // System.out.println("! "+ smallest);
        swap(str, k, smallest);

        sort(str, k+1);
    }

    public static void swap(String[] str, int startIndex, int currentSmallest) {
        String temp = str[startIndex];
        str[startIndex] = str[currentSmallest];
        str[currentSmallest] = temp;
    }

    public static int getSmallest(String[] str, int startIndex) {
        String curSma = str[startIndex];
        int smaIndex = startIndex;
        for (int i = startIndex; i<str.length; i +=1) {
            int result = curSma.compareTo(str[i]);
            if(result > 0) {
                curSma = str[i];
                smaIndex = i;
            }
        }
        return smaIndex;
    }
    public static void main(String[] args) {
        String[] str = {"is", "test", "a", "this"};

        sort(str);

        for (String s :str) {
            System.out.println(s);
        }

    }
}
