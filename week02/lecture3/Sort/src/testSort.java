public class testSort {
    public static void main(String[] args) {
        // testSort();
    }

    @org.junit.Test
    public void testSort() {
        String[] input = {"they", "change", "the", "system"};
        String[] expect = {"change", "system", "the", "they"};

        Sort.sort(input);

        org.junit.Assert.assertArrayEquals(expect, input);
    }
}
