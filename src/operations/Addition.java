package operations;

public class Addition implements Operation<Float> {
    @Override
    public Float apply(Float a, Float b) {
        return a + b;
    }
}
