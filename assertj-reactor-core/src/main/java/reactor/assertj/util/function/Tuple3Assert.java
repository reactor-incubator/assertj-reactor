package reactor.assertj.util.function;

import org.assertj.core.api.AbstractAssert;

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

}
