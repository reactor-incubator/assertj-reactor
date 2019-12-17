package reactor.assertj.util.function;

import java.util.function.Consumer;

import org.assertj.core.api.AbstractAssert;

import reactor.util.function.Tuple8;

/**
 * @author Simon Baslé
 */
public class Tuple8Assert<T1, T2, T3, T4, T5, T6, T7, T8>
		extends AbstractAssert<Tuple8Assert<T1, T2, T3, T4, T5, T6, T7, T8>,
								Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> {

	public Tuple8Assert(Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> tuple) {
		super(tuple, Tuple8Assert.class);
	}

	public Tuple8Assert<T1, T2, T3, T4, T5, T6, T7, T8> hasT1(T1 expected) {
		isNotNull();
		if (!actual.getT1().equals(expected)) {
			failWithMessage("Expected Tuple8 to have first part <%s> but was <%s>", expected, actual.getT1());
		}
		return this;
	}

	public Tuple8Assert<T1, T2, T3, T4, T5, T6, T7, T8> hasT2(T2 expected) {
		isNotNull();
		if (!actual.getT2().equals(expected)) {
			failWithMessage("Expected Tuple8 to have second part <%s> but was <%s>", expected, actual.getT2());
		}
		return this;
	}

	public Tuple8Assert<T1, T2, T3, T4, T5, T6, T7, T8> hasT3(T3 expected) {
		isNotNull();
		if (!actual.getT3().equals(expected)) {
			failWithMessage("Expected Tuple8 to have third part <%s> but was <%s>", expected, actual.getT3());
		}
		return this;
	}

	public Tuple8Assert<T1, T2, T3, T4, T5, T6, T7, T8> hasT4(T4 expected) {
		isNotNull();
		if (!actual.getT4().equals(expected)) {
			failWithMessage("Expected Tuple8 to have fourth part <%s> but was <%s>", expected, actual.getT4());
		}
		return this;
	}

	public Tuple8Assert<T1, T2, T3, T4, T5, T6, T7, T8> hasT5(T5 expected) {
		isNotNull();
		if (!actual.getT5().equals(expected)) {
			failWithMessage("Expected Tuple8 to have fifth part <%s> but was <%s>", expected, actual.getT5());
		}
		return this;
	}

	public Tuple8Assert<T1, T2, T3, T4, T5, T6, T7, T8> hasT6(T6 expected) {
		isNotNull();
		if (!actual.getT6().equals(expected)) {
			failWithMessage("Expected Tuple8 to have sixth part <%s> but was <%s>", expected, actual.getT6());
		}
		return this;
	}

	public Tuple8Assert<T1, T2, T3, T4, T5, T6, T7, T8> hasT7(T7 expected) {
		isNotNull();
		if (!actual.getT7().equals(expected)) {
			failWithMessage("Expected Tuple8 to have seventh part <%s> but was <%s>", expected, actual.getT7());
		}
		return this;
	}

	public Tuple8Assert<T1, T2, T3, T4, T5, T6, T7, T8> hasT8(T8 expected) {
		isNotNull();
		if (!actual.getT8().equals(expected)) {
			failWithMessage("Expected Tuple8 to have eighth part <%s> but was <%s>", expected, actual.getT8());
		}
		return this;
	}

	public Tuple8Assert<T1, T2, T3, T4, T5, T6, T7, T8> hasT1Satisfying(
			Consumer<T1> t1Requirements) {
		isNotNull();
		try {
			t1Requirements.accept(actual.getT1());
		}
		catch (AssertionError details) {
			failWithMessage("Expected Tuple8 first part to satisfy requirements, but didn't.%nDetails: %s", details.getMessage());
		}
		return this;
	}

	public Tuple8Assert<T1, T2, T3, T4, T5, T6, T7, T8> hasT2Satisfying(Consumer<T2> t2Requirements) {
		isNotNull();
		try {
			t2Requirements.accept(actual.getT2());
		}
		catch (AssertionError details) {
			failWithMessage("Expected Tuple8 second part to satisfy requirements, but didn't.%nDetails: %s", details.getMessage());
		}
		return this;
	}

	public Tuple8Assert<T1, T2, T3, T4, T5, T6, T7, T8> hasT3Satisfying(Consumer<T3> t3Requirements) {
		isNotNull();
		try {
			t3Requirements.accept(actual.getT3());
		}
		catch (AssertionError details) {
			failWithMessage("Expected Tuple8 third part to satisfy requirements, but didn't.%nDetails: %s", details.getMessage());
		}
		return this;
	}

	public Tuple8Assert<T1, T2, T3, T4, T5, T6, T7, T8> hasT4Satisfying(Consumer<T4> t4Requirements) {
		isNotNull();
		try {
			t4Requirements.accept(actual.getT4());
		}
		catch (AssertionError details) {
			failWithMessage("Expected Tuple8 fourth part to satisfy requirements, but didn't.%nDetails: %s", details.getMessage());
		}
		return this;
	}

	public Tuple8Assert<T1, T2, T3, T4, T5, T6, T7, T8> hasT5Satisfying(Consumer<T5> t5Requirements) {
		isNotNull();
		try {
			t5Requirements.accept(actual.getT5());
		}
		catch (AssertionError details) {
			failWithMessage("Expected Tuple8 fifth part to satisfy requirements, but didn't.%nDetails: %s", details.getMessage());
		}
		return this;
	}

	public Tuple8Assert<T1, T2, T3, T4, T5, T6, T7, T8> hasT6Satisfying(Consumer<T6> t6Requirements) {
		isNotNull();
		try {
			t6Requirements.accept(actual.getT6());
		}
		catch (AssertionError details) {
			failWithMessage("Expected Tuple8 sixth part to satisfy requirements, but didn't.%nDetails: %s", details.getMessage());
		}
		return this;
	}

	public Tuple8Assert<T1, T2, T3, T4, T5, T6, T7, T8> hasT7Satisfying(Consumer<T7> t7Requirements) {
		isNotNull();
		try {
			t7Requirements.accept(actual.getT7());
		}
		catch (AssertionError details) {
			failWithMessage("Expected Tuple8 seventh part to satisfy requirements, but didn't.%nDetails: %s", details.getMessage());
		}
		return this;
	}

	public Tuple8Assert<T1, T2, T3, T4, T5, T6, T7, T8> hasT8Satisfying(Consumer<T8> t8Requirements) {
		isNotNull();
		try {
			t8Requirements.accept(actual.getT8());
		}
		catch (AssertionError details) {
			failWithMessage("Expected Tuple8 eighth part to satisfy requirements, but didn't.%nDetails: %s", details.getMessage());
		}
		return this;
	}
}
