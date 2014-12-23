package findarray;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MyFindArrayTest {

    int[] array;
    int[] subarray;

    @Test
    public void test() {
        array = new int[]{1, 2, 1, 1, 3};
        subarray = new int[]{1, 1, 3};

        FindArray findArray = new MyFindArray();
        int idx = findArray.findArray(array, subarray);

        assertTrue(idx == 2);
    }

    @Test
    public void test2() {
        array = new int[]{1};
        subarray = new int[]{1};

        FindArray findArray = new MyFindArray();
        int idx = findArray.findArray(array, subarray);

        assertTrue(idx == 0);
    }

    @Test
    public void test3() {
        array = new int[]{};
        subarray = new int[]{1};

        FindArray findArray = new MyFindArray();
        int idx = findArray.findArray(array, subarray);

        assertTrue(idx == -1);
    }

    @Test
    public void test4() {
        array = new int[]{2, 1, 3};
        subarray = new int[]{4, 5};

        FindArray findArray = new MyFindArray();
        int idx = findArray.findArray(array, subarray);

        assertTrue(idx == -1);
    }

    @Test
    public void test5() {
        array = new int[]{4, 1, 5};
        subarray = new int[]{4, 5};

        FindArray findArray = new MyFindArray();
        int idx = findArray.findArray(array, subarray);

        assertTrue(idx == -1);
    }

    @Test
    public void test6() {
        array = new int[]{1, 1, 1, 1};
        subarray = new int[]{1, 1};

        FindArray findArray = new MyFindArray();
        int idx = findArray.findArray(array, subarray);

        assertTrue(idx == 0);
    }

    @Test
    public void test7() {
        array = new int[]{4,9,3,7,8};
        subarray = new int[]{3, 7};

        FindArray findArray = new MyFindArray();
        int idx = findArray.findArray(array, subarray);

        assertTrue(idx == 2);
    }

    @Test
    public void test8() {
        array = new int[]{1, 3, 5};
        subarray = new int[]{1};

        FindArray findArray = new MyFindArray();
        int idx = findArray.findArray(array, subarray);

        assertTrue(idx == 0);
    }

    @Test
    public void test9() {
        array = new int[]{7,8,9};
        subarray = new int[]{8, 9, 10};

        FindArray findArray = new MyFindArray();
        int idx = findArray.findArray(array, subarray);

        assertTrue(idx == -1);
    }

}