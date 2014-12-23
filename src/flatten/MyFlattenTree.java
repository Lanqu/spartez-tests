package flatten;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Illia on 18.12.2014.
 */
public class MyFlattenTree<T> implements FlattenTree<T> {

    @Override
    public List<T> flattenInOrder(Tree<T> tree) {
        if (tree == null)
            throw new IllegalArgumentException();

        Either<T, Triple<Tree<T>>> either = tree.get();
        IfLeftFunction<T> ifLeftFunction = new IfLeftFunction<T>();
        IfRightFunction<T> ifRightFunction = new IfRightFunction<T>();
        List<T> result = new ArrayList<T>();

        if (either.isLeft()) {
            T value = either.ifLeft(ifLeftFunction);
            result.add(value);
        } else {
            List<? extends T> all = either.ifRight(ifRightFunction);
            result.addAll(all);
        }

        return result;
    }

    private static class IfLeftFunction<R> implements Function<R, R> {
        @Override
        public R apply(R t) {
            return t;
        }
    }

    private static class IfRightFunction<R> implements Function<Triple<Tree<R>>, List<? extends R>> {
        @Override
        public List<? extends R> apply(Triple<Tree<R>> treeTriple) {
            List<Tree<R>> command = new ArrayList<Tree<R>>();
            command.add(treeTriple.left());
            command.add(treeTriple.middle());
            command.add(treeTriple.right());

            IfLeftFunction<R> ifLeftFunction = new IfLeftFunction<R>();
            IfRightFunction<R> ifRightFunction = new IfRightFunction<R>();

            List<R> result = new ArrayList<R>();
            for (Tree<R> tree : command) {
                Either<R, Triple<Tree<R>>> either = tree.get();
                if (either.isLeft()) {
                    R value = either.ifLeft(ifLeftFunction);
                    result.add(value);
                } else {
                    List<? extends R> all = either.ifRight(ifRightFunction);
                    result.addAll(all);
                }
            }
            return result;
        }
    }

}
