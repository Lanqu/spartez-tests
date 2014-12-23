package findcommonancestor;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Illia on 20.12.14.
 */
public class MyFindCommonAncestorTest {

    @Test
    public void test() {
        FindCommonAncestor ancestor = new MyFindCommonAncestor();
        String[] commitHashes = {"I","G"," J" , "F", "E", "D", "V" , "Y", "X", "B", "A"};
        String[][] parentHashes = {{"G", "J"}, {"D"}, {"F"}, {"E"}, {"B"}, {"V", "Y"}, {"B"}, {"X"}, {"A"}, {"A"}, null};
        String commitHash1 = "D";
        String commitHash2 = "F";
        String commonAncestor = ancestor.findCommonAncestor(commitHashes, parentHashes, commitHash1, commitHash2);
        assertTrue(commonAncestor.equals("B"));
    }

    @Test
    public void test2() {
        FindCommonAncestor ancestor = new MyFindCommonAncestor();
        String[] commitHashes = {"I","G"," J" , "F", "E", "D", "V" , "Y", "X", "B", "A"};
        String[][] parentHashes = {{"G", "J"}, {"D"}, {"F"}, {"E"}, {"B"}, {"V", "Y"}, {"B"}, {"X"}, {"A"}, {"A"}, null};
        String commitHash1 = "G";
        String commitHash2 = "X";
        String commonAncestor = ancestor.findCommonAncestor(commitHashes, parentHashes, commitHash1, commitHash2);
        assertTrue(commonAncestor.equals("X"));
    }

    @Test
    public void test3() {
        FindCommonAncestor ancestor = new MyFindCommonAncestor();
        String[] commitHashes = {"I","G","J" , "F", "E", "D", "V" , "Y", "X", "B", "A"};
        String[][] parentHashes = {{"G", "J"}, {"D"}, {"F"}, {"E"}, {"B"}, {"V", "Y"}, {"B"}, {"X"}, {"A"}, {"A"}, null};
        String commitHash1 = "J";
        String commitHash2 = "F";
        String commonAncestor = ancestor.findCommonAncestor(commitHashes, parentHashes, commitHash1, commitHash2);
        assertTrue(commonAncestor.equals("F"));
    }

    @Test
    public void test4() {
        FindCommonAncestor ancestor = new MyFindCommonAncestor();
        String[] commitHashes = {"I","G","J" , "F", "E", "D", "V" , "Y", "X", "B", "A"};
        String[][] parentHashes = {{"G", "J"}, {"D"}, {"F"}, {"E"}, {"B"}, {"V", "Y"}, {"B"}, {"X"}, {"A"}, {"A"}, null};
        String commitHash1 = "A";
        String commitHash2 = "A";
        String commonAncestor = ancestor.findCommonAncestor(commitHashes, parentHashes, commitHash1, commitHash2);
        assertTrue(commonAncestor.equals("A"));
    }

    @Test
    public void test5() {
        FindCommonAncestor ancestor = new MyFindCommonAncestor();
        String[] commitHashes = {"I","G","J" , "F", "E", "D", "V" , "Y", "X", "B", "A"};
        String[][] parentHashes = {{"G", "J"}, {"D"}, {"F"}, {"E"}, {"B"}, {"V", "Y"}, {"B"}, {"X"}, {"A"}, {"A"}, null};
        String commitHash1 = "J";
        String commitHash2 = "Y";
        String commonAncestor = ancestor.findCommonAncestor(commitHashes, parentHashes, commitHash1, commitHash2);
        assertTrue(commonAncestor.equals("A"));
    }

    @Test
    public void testCommon() {
        FindCommonAncestor ancestor = new MyFindCommonAncestor();
        String[] commits = {"G", "F", "E", "D", "C", "B", "A"};
        String[][] parents ={{"F","D"},{"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null};
        String commitHash1 = "D";
        String commitHash2 = "F";
        String commonAncestor = ancestor.findCommonAncestor(commits, parents, commitHash1, commitHash2);
        assertTrue(commonAncestor.equals("B"));
    }

}
