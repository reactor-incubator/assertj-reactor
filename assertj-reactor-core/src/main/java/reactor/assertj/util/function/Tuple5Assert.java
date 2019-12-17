package reactor.assertj.util.function;

import org.assertj.core.api.AbstractAssert;

import reactor.util.function.Tuple5;

/**
 * @author Simon Baslé
 */
public class Tuple5Assert<T1, T2, T3, T4, T5>
		extends AbstractAssert<Tuple5Assert<T1, T2, T3, T4, T5>,
								Tuple5<T1, T2, T3, T4, T5>> {

	public Tuple5Assert(Tuple5<T1, T2, T3, T4, T5> tuple) {
		super(tuple, Tuple5Assert.class);
	}

	public Tuple5Assert<T1, T2, T3, T4, T5> hasT1(T1 expected) {
		isNotNull();
		if (!actual.getT1().equals(expected)) {
			failWithMessage("Expected Tuple5 to have first part <%s> but was <%s>", expected, actual.getT1());
		}
		return this;
	}

	public Tuple5Assert<T1, T2, T3, T4, T5> hasT2(T2 expected) {
		isNotNull();
		if (!actual.getT2().equals(expected)) {
			failWithMessage("Expected Tuple5 to have second part <%s> but was <%s>", expected, actual.getT2());
		}
		return this;
	}

	public Tuple5Assert<T1, T2, T3, T4, T5> hasT3(T3 expected) {
		isNotNull();
		if (!actual.getT3().equals(expected)) {
			failWithMessage("Expected Tuple5 to have third part <%s> but was <%s>", expected, actual.getT3());
		}
		return this;
	}

	public Tuple5Assert<T1, T2, T3, T4, T5> hasT4(T4 expected) {
		isNotNull();
		if (!actual.getT4().equals(expected)) {
			failWithMessage("Expected Tuple5 to have fourth part <%s> but was <%s>", expected, actual.getT4());
		}
		return this;
	}

	public Tuple5Assert<T1, T2, T3, T4, T5> hasT5(T5 expected) {
		isNotNull();
		if (!actual.getT5().equals(expected)) {
			failWithMessage("Expected Tuple5 to have fifth part <%s> but was <%s>", expected, actual.getT5());
		}
		return this;
	}

}
