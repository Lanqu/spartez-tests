package iteration;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertTrue;

public class MyFolderTest {

    private Function2 f;
    private Folder<Integer, String> folder1;
    private Folder<Integer, String> folder2;

    @Before
    public void setUp() throws Exception {
        f = new Function2Impl();


        folder1 = new MyFolder<Integer, String>();
        folder2 = new OldFolder<Integer, String>();
    }

    @Test
    public void test() {
        String result1 = folder1.fold("Starting", getIntegers(), f);

        String result2 = folder2.fold("Starting", getIntegers(), f);

        assertTrue(result1.equals(result2));
    }

    @Test
    public void test2() {
        String result1 = folder1.fold("Starting", new LinkedList<Integer>(), f);

        String result2 = folder2.fold("Starting", new LinkedList<Integer>(), f);

        assertTrue(result1.equals(result2));
    }

    private Queue<Integer> getIntegers() {
        Queue<Integer> list = new LinkedList<Integer>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        return list;
    }

}