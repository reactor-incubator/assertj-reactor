package reactor.assertj.util.function;

import java.util.function.Consumer;

import org.assertj.core.api.AbstractAssert;

import reactor.util.function.Tuple3;
import reactor.util.function.Tuple3;

/**
 * @author Simon Baslé
 */
public class Tuple3Assert<T1, T2, T3>
		extends AbstractAssert<Tuple3Assert<T1, T2, T3>, Tuple3<T1, T2, T3>> {

	public Tuple3Assert(Tuple3<T1, T2, T3> tuple) {
		super(tuple, Tuple3Assert.class);
	}

	public Tuple3Assert<T1, T2, T3> hasT1(T1 expected) {
		isNotNull();
		if (!actual.getT1().equals(expected)) {
			failWithMessage("Expected Tuple3 to have first part <%s> but was <%s>", expected, actual.getT1());
		}
		return this;
	}

	public Tuple3Assert<T1, T2, T3> hasT2(T2 expected) {
		isNotNull();
		if (!actual.getT2().equals(expected)) {
			failWithMessage("Expected Tuple3 to have second part <%s> but was <%s>", expected, actual.getT2());
		}
		return this;
	}

	public Tuple3Assert<T1, T2, T3> hasT3(T3 expected) {
		isNotNull();
		if (!actual.getT3().equals(expected)) {
			failWithMessage("Expected Tuple3 to have third part <%s> but was <%s>", expected, actual.getT3());
		}
		return this;
	}

	/**
	 * Verifies that this tuple's {@link Tuple3#getT1() first part} satisfies the given requirements.
	 *
	 * @param t1Requirements the requirements for the first part, expressed in a {@link Consumer} in which further assertions can be applied
	 * @return {@code this} assertion object
	 */
	public Tuple3Assert<T1, T2, T3> hasT1Satisfying(Consumer<T1> t1Requirements) {
		isNotNull();
		try {
			t1Requirements.accept(actual.getT1());
		}
		catch (AssertionError details) {
			failWithMessage("Expected Tuple3 first part to satisfy requirements, but didn't.%nDetails: %s", details.getMessage());
		}
		return this;
	}

	/**
	 * Verifies that this tuple's {@link Tuple3#getT2() second part} satisfies the given requirements.
	 *
	 * @param t2Requirements the requirements for the second part, expressed in a {@link Consumer} in which further assertions can be applied
	 * @return {@code this} assertion object
	 */
	public Tuple3Assert<T1, T2, T3> hasT2Satisfying(Consumer<T2> t2Requirements) {
		isNotNull();
		try {
			t2Requirements.accept(actual.getT2());
		}
		catch (AssertionError details) {
			failWithMessage("Expected Tuple3 second part to satisfy requirements, but didn't.%nDetails: %s", details.getMessage());
		}
		return this;
	}

	/**
	 * Verifies that this tuple's {@link Tuple3#getT3() third part} satisfies the given requirements.
	 *
	 * @param t3Requirements the requirements for the third part, expressed in a {@link Consumer} in which further assertions can be applied
	 * @return {@code this} assertion object
	 */
	public Tuple3Assert<T1, T2, T3> hasT3Satisfying(Consumer<T3> t3Requirements) {
		isNotNull();
		try {
			t3Requirements.accept(actual.getT3());
		}
		catch (AssertionError details) {
			failWithMessage("Expected Tuple3 third part to satisfy requirements, but didn't.%nDetails: %s", details.getMessage());
		}		return this;
	}

}
