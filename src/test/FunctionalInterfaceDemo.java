package test;

import java.util.function.Predicate;

public interface FunctionalInterfaceDemo extends Predicate {
	public abstract boolean filter(int a);
}
