package reactor.assertj.util.function;

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

}
