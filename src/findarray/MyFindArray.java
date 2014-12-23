package findarray;

public class MyFindArray implements FindArray {
    public int findArray(int[] array, int[] subArray) {

        if (array.length < subArray.length) return -1;

        int count_to = array.length - subArray.length + 1;
        for (int i = 0; i < count_to; i++) {
            int idx = check(array, i, subArray);
            if (idx != -1) {
                return idx;
            }
        }

        return -1;
    }

    private int check(int[] array, int idx, int[] subArray) {
        for (int i = 0; i < subArray.length; i++) {
            if (array[i + idx] != subArray[i]) {
                return -1;
            }
        }

        return idx;
    }
}