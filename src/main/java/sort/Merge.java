package sort;

public class Merge {
    private int[] numbers;
    private int[] helper;

    private int number;

    public long countingInvertions(int[] values) {
        this.numbers = values;
        number = values.length;
        this.helper = new int[number];
        return mergesort(0, number - 1);
    }

    private long mergesort(int low, int high) {
        if (low >= high)
            return 0L;
        long count = 0L;
        int middle = low + (high - low) / 2;
        count += mergesort(low, middle);
        count += mergesort(middle + 1, high);
        count += merge(low, middle, high);
        return count;
    }

    private long merge(int low, int middle, int high) {

        System.arraycopy(numbers, low, helper, low, high + 1 - low);

        long count = 0L;
        int i = low;
        int j = middle + 1;
        int k = low;
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                count += middle + 1 - i;
                j++;
            }
            k++;
        }
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }
        return count;
    }
}
