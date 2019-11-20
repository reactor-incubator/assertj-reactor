package reactor.assertj;

import reactor.assertj.util.context.ContextAssert;
import reactor.assertj.util.function.Tuple2Assert;
import reactor.assertj.util.function.Tuple8Assert;
import reactor.test.StepVerifier;
import reactor.util.context.Context;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuple8;

/**
 * Entry points for reactor-core and reactor-test AssertJ assertions.
 *
 * @author Simon Baslé
 */
public final class ReactorAssertions {

	/**
	 * Assert a {@link Context}. This assertion is intended as an AssertJ standalone that mirrors the corresponding
	 * expectation builder built-in in {@link StepVerifier} (see {@link StepVerifier.Step#expectAccessibleContext()}).
	 *
	 * @param actual the {@link Context} to assert
	 * @return a {@link ContextAssert} assertion class
	 */
	public static ContextAssert assertThat(Context actual) {
		return new ContextAssert(actual);
	}

	public static <T1, T2> Tuple2Assert<T1, T2> assertThat(Tuple2<T1, T2> actual) {
		return new Tuple2Assert<>(actual);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8> Tuple8Assert<T1, T2, T3, T4, T5, T6, T7, T8> assertThat(Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> actual) {
		return new Tuple8Assert<>(actual);
	}

}
