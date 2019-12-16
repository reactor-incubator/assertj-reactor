package reactor.assertj;

import reactor.assertj.util.context.ContextAssert;
import reactor.test.StepVerifier;
import reactor.util.context.Context;

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

}
