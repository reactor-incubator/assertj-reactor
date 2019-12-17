package reactor.assertj.util.function;

import java.util.function.Consumer;

import org.assertj.core.api.AbstractAssert;

import reactor.util.function.Tuple4;
import reactor.util.function.Tuple4;

/**
 * @author Simon Baslé
 */
public class Tuple4Assert<T1, T2, T3, T4>
		extends AbstractAssert<Tuple4Assert<T1, T2, T3, T4>, Tuple4<T1, T2, T3, T4>> {

	public Tuple4Assert(Tuple4<T1, T2, T3, T4> tuple) {
		super(tuple, Tuple4Assert.class);
	}

	public Tuple4Assert<T1, T2, T3, T4> hasT1(T1 expected) {
		isNotNull();
		if (!actual.getT1().equals(expected)) {
			failWithMessage("Expected Tuple4 to have first part <%s> but was <%s>", expected, actual.getT1());
		}
		return this;
	}

	public Tuple4Assert<T1, T2, T3, T4> hasT2(T2 expected) {
		isNotNull();
		if (!actual.getT2().equals(expected)) {
			failWithMessage("Expected Tuple4 to have second part <%s> but was <%s>", expected, actual.getT2());
		}
		return this;
	}

	public Tuple4Assert<T1, T2, T3, T4> hasT3(T3 expected) {
		isNotNull();
		if (!actual.getT3().equals(expected)) {
			failWithMessage("Expected Tuple4 to have third part <%s> but was <%s>", expected, actual.getT3());
		}
		return this;
	}

	public Tuple4Assert<T1, T2, T3, T4> hasT4(T4 expected) {
		isNotNull();
		if (!actual.getT4().equals(expected)) {
			failWithMessage("Expected Tuple4 to have fourth part <%s> but was <%s>", expected, actual.getT4());
		}
		return this;
	}

	/**
	 * Verifies that this tuple's {@link Tuple4#getT1() first part} satisfies the given requirements.
	 *
	 * @param t1Requirements the requirements for the first part, expressed in a {@link Consumer} in which further assertions can be applied
	 * @return {@code this} assertion object
	 */
	public Tuple4Assert<T1, T2, T3, T4> hasT1Satisfying(Consumer<T1> t1Requirements) {
		isNotNull();
		try {
			t1Requirements.accept(actual.getT1());
		}
		catch (AssertionError details) {
			failWithMessage("Expected Tuple4 first part to satisfy requirements, but didn't.%nDetails: %s", details.getMessage());
		}
		return this;
	}

	/**
	 * Verifies that this tuple's {@link Tuple4#getT2() second part} satisfies the given requirements.
	 *
	 * @param t2Requirements the requirements for the second part, expressed in a {@link Consumer} in which further assertions can be applied
	 * @return {@code this} assertion object
	 */
	public Tuple4Assert<T1, T2, T3, T4> hasT2Satisfying(Consumer<T2> t2Requirements) {
		isNotNull();
		try {
			t2Requirements.accept(actual.getT2());
		}
		catch (AssertionError details) {
			failWithMessage("Expected Tuple4 second part to satisfy requirements, but didn't.%nDetails: %s", details.getMessage());
		}
		return this;
	}

	/**
	 * Verifies that this tuple's {@link Tuple4#getT3() third part} satisfies the given requirements.
	 *
	 * @param t3Requirements the requirements for the third part, expressed in a {@link Consumer} in which further assertions can be applied
	 * @return {@code this} assertion object
	 */
	public Tuple4Assert<T1, T2, T3, T4> hasT3Satisfying(Consumer<T3> t3Requirements) {
		isNotNull();
		try {
			t3Requirements.accept(actual.getT3());
		}
		catch (AssertionError details) {
			failWithMessage("Expected Tuple4 third part to satisfy requirements, but didn't.%nDetails: %s", details.getMessage());
		}
		return this;
	}

	/**
	 * Verifies that this tuple's {@link Tuple4#getT4() fourth part} satisfies the given requirements.
	 *
	 * @param t4Requirements the requirements for the fourth part, expressed in a {@link Consumer} in which further assertions can be applied
	 * @return {@code this} assertion object
	 */
	public Tuple4Assert<T1, T2, T3, T4> hasT4Satisfying(Consumer<T4> t4Requirements) {
		isNotNull();
		try {
			t4Requirements.accept(actual.getT4());
		}
		catch (AssertionError details) {
			failWithMessage("Expected Tuple4 fourth part to satisfy requirements, but didn't.%nDetails: %s", details.getMessage());
		}
		return this;
	}

}
