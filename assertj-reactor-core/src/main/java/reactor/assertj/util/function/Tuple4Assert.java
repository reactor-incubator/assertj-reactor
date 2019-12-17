package reactor.assertj.util.function;

import org.assertj.core.api.AbstractAssert;

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

}