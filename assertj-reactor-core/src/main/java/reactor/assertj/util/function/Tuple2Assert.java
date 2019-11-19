package reactor.assertj.util.function;

import org.assertj.core.api.AbstractAssert;

import reactor.util.function.Tuple2;

/**
 * @author Simon Baslé
 */
public class Tuple2Assert<T1, T2> extends AbstractAssert<Tuple2Assert<T1, T2>, Tuple2<T1, T2>> {

	public Tuple2Assert(Tuple2<T1, T2> tuple2) {
		super(tuple2, Tuple2Assert.class);
	}

	public Tuple2Assert<T1, T2> hasPair(T1 expectedLeft, T2 expectedRight) {
		isNotNull();
		if (!actual.getT1().equals(expectedLeft)) {
			failWithMessage("Expected Tuple2 left part to be <%s> but was <%s>", expectedLeft, actual.getT1());
		}
		if (!actual.getT2().equals(expectedRight)) {
			failWithMessage("Expected Tuple2 right part to be <%s> but was <%s>", expectedRight, actual.getT2());
		}
		return this;
	}

	public Tuple2Assert<T1, T2> hasT1(T1 expected) {
		isNotNull();
		if (!actual.getT1().equals(expected)) {
			failWithMessage("Expected Tuple2 to have left part <%s> but was <%s>", expected, actual.getT1());
		}
		return this;
	}

	public Tuple2Assert<T1, T2> hasT2(T2 expected) {
		isNotNull();
		if (!actual.getT2().equals(expected)) {
			failWithMessage("Expected Tuple2 to have right part <%s> but was <%s>", expected, actual.getT2());
		}
		return this;
	}
}
