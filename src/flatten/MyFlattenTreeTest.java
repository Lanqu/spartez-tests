package flatten;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class MyFlattenTreeTest {
    @Test(expected = IllegalArgumentException.class)
    public void test0() {
        MyFlattenTree<Integer> flattenTree = new MyFlattenTree<Integer>();
        flattenTree.flattenInOrder(null);
    }

    @Test
    public void test() {
        Tree<Integer> left = Tree.Leaf.leaf(1);
        Tree<Integer> middle = Tree.Node.tree(5, 4, 9);
        Tree<Integer> right = Tree.Leaf.leaf(6);

        Tree.Node<Integer> topNode = new Tree.Node<Integer>(left, middle, right);

        MyFlattenTree<Integer> flattenTree = new MyFlattenTree<Integer>();

        List<Integer> list = flattenTree.flattenInOrder(topNode);

        assertTrue(list.size() == 5);

        List<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(5);
        expected.add(4);
        expected.add(9);
        expected.add(6);
        for (int i = 0; i < list.size(); i++) {
            assertTrue(expected.get(i).equals(list.get(i)));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNull() {
        Tree<Integer> left = Tree.Leaf.leaf(1);
        Tree<Integer> middle = Tree.Node.tree(5, null, 9);
        Tree<Integer> right = Tree.Leaf.leaf(6);

        Tree.Node<Integer> topNode = new Tree.Node<Integer>(left, middle, right);

        MyFlattenTree<Integer> flattenTree = new MyFlattenTree<Integer>();

        List<Integer> list = flattenTree.flattenInOrder(topNode);

        assertTrue(list.size() == 5);

        List<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(5);
        expected.add(4);
        expected.add(9);
        expected.add(6);
        for (int i = 0; i < list.size(); i++) {
            assertTrue(expected.get(i).equals(list.get(i)));
        }
    }

    @Test
    public void test2() {
        Tree<Integer> left = Tree.Leaf.leaf(1);
        MyFlattenTree<Integer> flattenTree = new MyFlattenTree<Integer>();

        List<Integer> list = flattenTree.flattenInOrder(left);

        assertTrue(list.size() == 1);

        List<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        for (int i = 0; i < list.size(); i++) {
            assertTrue(expected.get(i).equals(list.get(i)));
        }
    }

    @Test
    public void test3() {
        Tree<Integer> left = Tree.Node.tree(5, 4, 9);
        Tree<Integer> middle = Tree.Leaf.leaf(1);
        Tree<Integer> right = Tree.Leaf.leaf(6);

        Tree.Node<Integer> topNode = new Tree.Node<Integer>(left, middle, right);

        MyFlattenTree<Integer> flattenTree = new MyFlattenTree<Integer>();

        List<Integer> list = flattenTree.flattenInOrder(topNode);

        assertTrue(list.size() == 5);

        List<Integer> expected = new ArrayList<Integer>();
        expected.add(5);
        expected.add(4);
        expected.add(9);
        expected.add(1);
        expected.add(6);
        for (int i = 0; i < list.size(); i++) {
            assertTrue(expected.get(i).equals(list.get(i)));
        }
    }

    @Test
    public void test4() {
        Tree<Integer> left = Tree.Node.tree(5, 4, 9);
        Tree<Integer> middle = Tree.Leaf.leaf(1);
        Tree<Integer> right = Tree.Node.tree(2, 3, 6);
        Tree.Node<Integer> top1 = new Tree.Node<Integer>(left, middle, right);

        Tree<Integer> left2 = Tree.Node.tree(11, 12, 13);
        Tree<Integer> middle2 = Tree.Node.tree(14, 15, 16);

        Tree.Node<Integer> right2 = new Tree.Node<Integer>(left2, middle2, top1);

        MyFlattenTree<Integer> flattenTree = new MyFlattenTree<Integer>();

        List<Integer> list = flattenTree.flattenInOrder(right2);

        assertTrue(list.size() == 13);

        List<Integer> expected = new ArrayList<Integer>();
        expected.add(11);
        expected.add(12);
        expected.add(13);
        expected.add(14);
        expected.add(15);
        expected.add(16);
        expected.add(5);
        expected.add(4);
        expected.add(9);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(6);
        for (int i = 0; i < list.size(); i++) {
            assertTrue(expected.get(i).equals(list.get(i)));
        }
    }

}