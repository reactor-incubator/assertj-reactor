package reactor.assertj.util.function;

import org.assertj.core.api.AbstractAssert;

import reactor.util.function.Tuple8;

/**
 * @author Simon Baslé
 */
public class Tuple8Assert<T1, T2, T3, T4, T5, T6, T7, T8>
		extends AbstractAssert<Tuple8Assert<T1, T2, T3, T4, T5, T6, T7, T8>,
								Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> {

	public Tuple8Assert(Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> tuple8) {
		super(tuple8, Tuple8Assert.class);
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
}
