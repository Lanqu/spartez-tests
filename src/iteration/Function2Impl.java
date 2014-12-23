package iteration;

/**
 * Created by Illia on 18.12.2014.
 */
public class Function2Impl implements Function2<Integer, String, String> {

    @Override
    public String apply(Integer i, String s) {
        StringBuilder b = new StringBuilder();
        b.append(s);
        b.append("...");
        b.append(i);

        return b.toString();
    }
}
