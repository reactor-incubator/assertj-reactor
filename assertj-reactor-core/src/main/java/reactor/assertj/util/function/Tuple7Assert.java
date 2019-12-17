package reactor.assertj.util.function;

import java.util.function.Consumer;

import org.assertj.core.api.AbstractAssert;

import reactor.util.function.Tuple7;
import reactor.util.function.Tuple7;

/**
 * @author Simon Baslé
 */
public class Tuple7Assert<T1, T2, T3, T4, T5, T6, T7>
		extends AbstractAssert<Tuple7Assert<T1, T2, T3, T4, T5, T6, T7>,
								Tuple7<T1, T2, T3, T4, T5, T6, T7>> {

	public Tuple7Assert(Tuple7<T1, T2, T3, T4, T5, T6, T7> tuple) {
		super(tuple, Tuple7Assert.class);
	}

	public Tuple7Assert<T1, T2, T3, T4, T5, T6, T7> hasT1(T1 expected) {
		isNotNull();
		if (!actual.getT1().equals(expected)) {
			failWithMessage("Expected Tuple7 to have first part <%s> but was <%s>", expected, actual.getT1());
		}
		return this;
	}

	public Tuple7Assert<T1, T2, T3, T4, T5, T6, T7> hasT2(T2 expected) {
		isNotNull();
		if (!actual.getT2().equals(expected)) {
			failWithMessage("Expected Tuple7 to have second part <%s> but was <%s>", expected, actual.getT2());
		}
		return this;
	}

	public Tuple7Assert<T1, T2, T3, T4, T5, T6, T7> hasT3(T3 expected) {
		isNotNull();
		if (!actual.getT3().equals(expected)) {
			failWithMessage("Expected Tuple7 to have third part <%s> but was <%s>", expected, actual.getT3());
		}
		return this;
	}

	public Tuple7Assert<T1, T2, T3, T4, T5, T6, T7> hasT4(T4 expected) {
		isNotNull();
		if (!actual.getT4().equals(expected)) {
			failWithMessage("Expected Tuple7 to have fourth part <%s> but was <%s>", expected, actual.getT4());
		}
		return this;
	}

	public Tuple7Assert<T1, T2, T3, T4, T5, T6, T7> hasT5(T5 expected) {
		isNotNull();
		if (!actual.getT5().equals(expected)) {
			failWithMessage("Expected Tuple7 to have fifth part <%s> but was <%s>", expected, actual.getT5());
		}
		return this;
	}

	public Tuple7Assert<T1, T2, T3, T4, T5, T6, T7> hasT6(T6 expected) {
		isNotNull();
		if (!actual.getT6().equals(expected)) {
			failWithMessage("Expected Tuple7 to have sixth part <%s> but was <%s>", expected, actual.getT6());
		}
		return this;
	}

	public Tuple7Assert<T1, T2, T3, T4, T5, T6, T7> hasT7(T7 expected) {
		isNotNull();
		if (!actual.getT7().equals(expected)) {
			failWithMessage("Expected Tuple7 to have seventh part <%s> but was <%s>", expected, actual.getT7());
		}
		return this;
	}
	
	/**
	 * Verifies that this tuple's {@link Tuple7#getT1() first part} satisfies the given requirements.
	 *
	 * @param t1Requirements the requirements for the first part, expressed in a {@link Consumer} in which further assertions can be applied
	 * @return {@code this} assertion object
	 */
	public Tuple7Assert<T1, T2, T3, T4, T5, T6, T7> hasT1Satisfying(
			Consumer<T1> t1Requirements) {
		isNotNull();
		try {
			t1Requirements.accept(actual.getT1());
		}
		catch (AssertionError details) {
			failWithMessage("Expected Tuple7 first part to satisfy requirements, but didn't.%nDetails: %s", details.getMessage());
		}
		return this;
	}

	/**
	 * Verifies that this tuple's {@link Tuple7#getT2() second part} satisfies the given requirements.
	 *
	 * @param t2Requirements the requirements for the second part, expressed in a {@link Consumer} in which further assertions can be applied
	 * @return {@code this} assertion object
	 */
	public Tuple7Assert<T1, T2, T3, T4, T5, T6, T7> hasT2Satisfying(Consumer<T2> t2Requirements) {
		isNotNull();
		try {
			t2Requirements.accept(actual.getT2());
		}
		catch (AssertionError details) {
			failWithMessage("Expected Tuple7 second part to satisfy requirements, but didn't.%nDetails: %s", details.getMessage());
		}
		return this;
	}

	/**
	 * Verifies that this tuple's {@link Tuple7#getT3() third part} satisfies the given requirements.
	 *
	 * @param t3Requirements the requirements for the third part, expressed in a {@link Consumer} in which further assertions can be applied
	 * @return {@code this} assertion object
	 */
	public Tuple7Assert<T1, T2, T3, T4, T5, T6, T7> hasT3Satisfying(Consumer<T3> t3Requirements) {
		isNotNull();
		try {
			t3Requirements.accept(actual.getT3());
		}
		catch (AssertionError details) {
			failWithMessage("Expected Tuple7 third part to satisfy requirements, but didn't.%nDetails: %s", details.getMessage());
		}
		return this;
	}

	/**
	 * Verifies that this tuple's {@link Tuple7#getT4() fourth part} satisfies the given requirements.
	 *
	 * @param t4Requirements the requirements for the fourth part, expressed in a {@link Consumer} in which further assertions can be applied
	 * @return {@code this} assertion object
	 */
	public Tuple7Assert<T1, T2, T3, T4, T5, T6, T7> hasT4Satisfying(Consumer<T4> t4Requirements) {
		isNotNull();
		try {
			t4Requirements.accept(actual.getT4());
		}
		catch (AssertionError details) {
			failWithMessage("Expected Tuple7 fourth part to satisfy requirements, but didn't.%nDetails: %s", details.getMessage());
		}
		return this;
	}

	/**
	 * Verifies that this tuple's {@link Tuple7#getT5() fifth part} satisfies the given requirements.
	 *
	 * @param t5Requirements the requirements for the fifth part, expressed in a {@link Consumer} in which further assertions can be applied
	 * @return {@code this} assertion object
	 */
	public Tuple7Assert<T1, T2, T3, T4, T5, T6, T7> hasT5Satisfying(Consumer<T5> t5Requirements) {
		isNotNull();
		try {
			t5Requirements.accept(actual.getT5());
		}
		catch (AssertionError details) {
			failWithMessage("Expected Tuple7 fifth part to satisfy requirements, but didn't.%nDetails: %s", details.getMessage());
		}
		return this;
	}

	/**
	 * Verifies that this tuple's {@link Tuple7#getT6() sixth part} satisfies the given requirements.
	 *
	 * @param t6Requirements the requirements for the sixth part, expressed in a {@link Consumer} in which further assertions can be applied
	 * @return {@code this} assertion object
	 */
	public Tuple7Assert<T1, T2, T3, T4, T5, T6, T7> hasT6Satisfying(Consumer<T6> t6Requirements) {
		isNotNull();
		try {
			t6Requirements.accept(actual.getT6());
		}
		catch (AssertionError details) {
			failWithMessage("Expected Tuple7 sixth part to satisfy requirements, but didn't.%nDetails: %s", details.getMessage());
		}
		return this;
	}

	/**
	 * Verifies that this tuple's {@link Tuple7#getT7() seventh part} satisfies the given requirements.
	 *
	 * @param t7Requirements the requirements for the seventh part, expressed in a {@link Consumer} in which further assertions can be applied
	 * @return {@code this} assertion object
	 */
	public Tuple7Assert<T1, T2, T3, T4, T5, T6, T7> hasT7Satisfying(Consumer<T7> t7Requirements) {
		isNotNull();
		try {
			t7Requirements.accept(actual.getT7());
		}
		catch (AssertionError details) {
			failWithMessage("Expected Tuple7 seventh part to satisfy requirements, but didn't.%nDetails: %s", details.getMessage());
		}
		return this;
	}

}
