package iteration;

import java.util.Queue;

public class MyFolder<T, U> implements Folder<T, U> {

    @Override
    public U fold(U u, Queue<T> ts, Function2<T, U, U> function) {
        if (u == null || ts == null || function == null)
            throw new IllegalArgumentException();

        T poll;
        U applyResult = u;

        while (!ts.isEmpty()) {
            poll = ts.poll();
            applyResult = function.apply(poll, applyResult);
        }

        return applyResult;
    }
}