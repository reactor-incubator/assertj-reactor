package reactor.assertj.util.function;

import java.util.function.Consumer;

import org.assertj.core.api.AbstractAssert;

import reactor.util.function.Tuple6;

/**
 * @author Simon Baslé
 */
public class Tuple6Assert<T1, T2, T3, T4, T5, T6>
		extends AbstractAssert<Tuple6Assert<T1, T2, T3, T4, T5, T6>,
								Tuple6<T1, T2, T3, T4, T5, T6>> {

	public Tuple6Assert(Tuple6<T1, T2, T3, T4, T5, T6> tuple) {
		super(tuple, Tuple6Assert.class);
	}

	public Tuple6Assert<T1, T2, T3, T4, T5, T6> hasT1(T1 expected) {
		isNotNull();
		if (!actual.getT1().equals(expected)) {
			failWithMessage("Expected Tuple6 to have first part <%s> but was <%s>", expected, actual.getT1());
		}
		return this;
	}

	public Tuple6Assert<T1, T2, T3, T4, T5, T6> hasT2(T2 expected) {
		isNotNull();
		if (!actual.getT2().equals(expected)) {
			failWithMessage("Expected Tuple6 to have second part <%s> but was <%s>", expected, actual.getT2());
		}
		return this;
	}

	public Tuple6Assert<T1, T2, T3, T4, T5, T6> hasT3(T3 expected) {
		isNotNull();
		if (!actual.getT3().equals(expected)) {
			failWithMessage("Expected Tuple6 to have third part <%s> but was <%s>", expected, actual.getT3());
		}
		return this;
	}

	public Tuple6Assert<T1, T2, T3, T4, T5, T6> hasT4(T4 expected) {
		isNotNull();
		if (!actual.getT4().equals(expected)) {
			failWithMessage("Expected Tuple6 to have fourth part <%s> but was <%s>", expected, actual.getT4());
		}
		return this;
	}

	public Tuple6Assert<T1, T2, T3, T4, T5, T6> hasT5(T5 expected) {
		isNotNull();
		if (!actual.getT5().equals(expected)) {
			failWithMessage("Expected Tuple6 to have fifth part <%s> but was <%s>", expected, actual.getT5());
		}
		return this;
	}

	public Tuple6Assert<T1, T2, T3, T4, T5, T6> hasT6(T6 expected) {
		isNotNull();
		if (!actual.getT6().equals(expected)) {
			failWithMessage("Expected Tuple6 to have sixth part <%s> but was <%s>", expected, actual.getT6());
		}
		return this;
	}

	public Tuple6Assert<T1, T2, T3, T4, T5, T6> hasT1Satisfying(Consumer<T1> t1Requirements) {
		isNotNull();
		try {
			t1Requirements.accept(actual.getT1());
		}
		catch (AssertionError details) {
			failWithMessage("Expected Tuple6 first part to satisfy requirements, but didn't.%nDetails: %s", details.getMessage());
		}
		return this;
	}

	public Tuple6Assert<T1, T2, T3, T4, T5, T6> hasT2Satisfying(Consumer<T2> t2Requirements) {
		isNotNull();
		try {
			t2Requirements.accept(actual.getT2());
		}
		catch (AssertionError details) {
			failWithMessage("Expected Tuple6 second part to satisfy requirements, but didn't.%nDetails: %s", details.getMessage());
		}
		return this;
	}

	public Tuple6Assert<T1, T2, T3, T4, T5, T6> hasT3Satisfying(Consumer<T3> t3Requirements) {
		isNotNull();
		try {
			t3Requirements.accept(actual.getT3());
		}
		catch (AssertionError details) {
			failWithMessage("Expected Tuple6 third part to satisfy requirements, but didn't.%nDetails: %s", details.getMessage());
		}
		return this;
	}

	public Tuple6Assert<T1, T2, T3, T4, T5, T6> hasT4Satisfying(Consumer<T4> t4Requirements) {
		isNotNull();
		try {
			t4Requirements.accept(actual.getT4());
		}
		catch (AssertionError details) {
			failWithMessage("Expected Tuple6 fourth part to satisfy requirements, but didn't.%nDetails: %s", details.getMessage());
		}
		return this;
	}

	public Tuple6Assert<T1, T2, T3, T4, T5, T6> hasT5Satisfying(Consumer<T5> t5Requirements) {
		isNotNull();
		try {
			t5Requirements.accept(actual.getT5());
		}
		catch (AssertionError details) {
			failWithMessage("Expected Tuple6 fifth part to satisfy requirements, but didn't.%nDetails: %s", details.getMessage());
		}
		return this;
	}

	public Tuple6Assert<T1, T2, T3, T4, T5, T6> hasT6Satisfying(Consumer<T6> t6Requirements) {
		isNotNull();
		try {
			t6Requirements.accept(actual.getT6());
		}
		catch (AssertionError details) {
			failWithMessage("Expected Tuple6 sixth part to satisfy requirements, but didn't.%nDetails: %s", details.getMessage());
		}
		return this;
	}

}
