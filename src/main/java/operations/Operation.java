package operations;

public interface Operation<T> {
	T apply(T a, T b);
}

