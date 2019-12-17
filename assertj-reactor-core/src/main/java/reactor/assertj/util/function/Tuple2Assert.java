package reactor.assertj.util.function;

import java.util.function.Consumer;

import org.assertj.core.api.AbstractAssert;

import reactor.util.function.Tuple2;

/**
 * @author Simon Baslé
 */
public class Tuple2Assert<T1, T2> extends AbstractAssert<Tuple2Assert<T1, T2>, Tuple2<T1, T2>> {

	public Tuple2Assert(Tuple2<T1, T2> tuple2) {
		super(tuple2, Tuple2Assert.class);
	}

	/**
	 * Verifies that this {@link Tuple2} represents the given left-right pair of values.
	 *
	 * @param expectedLeft the expected left part of the pair, {@link Tuple2#getT1()}
	 * @param expectedRight the expected right part of the pair, {@link Tuple2#getT2()}
	 * @return {@code this} assertion object
	 */
	public Tuple2Assert<T1, T2> hasPair(T1 expectedLeft, T2 expectedRight) {
		isNotNull();
		if (!actual.getT1().equals(expectedLeft) && !actual.getT2().equals(expectedRight)) {
			failWithMessage("Expected Tuple2 to contain pair <%s>-<%s> but was <%s>-<%s>", expectedLeft, expectedRight,
					actual.getT1(), actual.getT2());
		}
		if (!actual.getT1().equals(expectedLeft)) {
			failWithMessage("Expected Tuple2 left part to be <%s> but was <%s>", expectedLeft, actual.getT1());
		}
		if (!actual.getT2().equals(expectedRight)) {
			failWithMessage("Expected Tuple2 right part to be <%s> but was <%s>", expectedRight, actual.getT2());
		}
		return this;
	}

	/**
	 * Verifies that this tuple's {@link Tuple2#getT1() first part} is equal to the provided value.
	 *
	 * @param expected the expected value
	 * @return {@code this} assertion object
	 */
	public Tuple2Assert<T1, T2> hasT1(T1 expected) {
		isNotNull();
		if (!actual.getT1().equals(expected)) {
			failWithMessage("Expected Tuple2 to have left part <%s> but was <%s>", expected, actual.getT1());
		}
		return this;
	}

	/**
	 * Verifies that this tuple's {@link Tuple2#getT2() second part} is equal to the provided value.
	 *
	 * @param expected the expected value
	 * @return {@code this} assertion object
	 */
	public Tuple2Assert<T1, T2> hasT2(T2 expected) {
		isNotNull();
		if (!actual.getT2().equals(expected)) {
			failWithMessage("Expected Tuple2 to have right part <%s> but was <%s>", expected, actual.getT2());
		}
		return this;
	}

	/**
	 * Verifies that this tuple's {@link Tuple2#getT1() first part} satisfies the given requirements.
	 *
	 * @param t1Requirements the requirements for the first part, expressed in a {@link Consumer} in which further assertions can be applied
	 * @return {@code this} assertion object
	 */
	public Tuple2Assert<T1, T2> hasT1Satisfying(Consumer<T1> t1Requirements) {
		isNotNull();
		try {
			t1Requirements.accept(actual.getT1());
		}
		catch (AssertionError details) {
			failWithMessage("Expected Tuple2 left part to satisfy requirements, but didn't.%nDetails: %s", details.getMessage());
		}
		return this;
	}

	/**
	 * Verifies that this tuple's {@link Tuple2#getT2() second part} satisfies the given requirements.
	 *
	 * @param t2Requirements the requirements for the second part, expressed in a {@link Consumer} in which further assertions can be applied
	 * @return {@code this} assertion object
	 */
	public Tuple2Assert<T1, T2> hasT2Satisfying(Consumer<T2> t2Requirements) {
		isNotNull();
		try {
			t2Requirements.accept(actual.getT2());
		}
		catch (AssertionError details) {
			failWithMessage("Expected Tuple2 right part to satisfy requirements, but didn't.%nDetails: %s", details.getMessage());
		}
		return this;
	}

}
