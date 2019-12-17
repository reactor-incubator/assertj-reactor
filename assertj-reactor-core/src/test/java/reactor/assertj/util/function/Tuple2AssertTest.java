package reactor.assertj.util.function;

import org.junit.jupiter.api.Test;

import reactor.assertj.ReactorAssertions;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class Tuple2AssertTest {

	final Tuple2<String, Integer> testData = Tuples.of("example", 123);
	final Tuple2Assert<String, Integer> assertion = ReactorAssertions.assertThat(testData);

	@Test
	void hasPair() {
		assertThatCode(() ->
				assertion.hasPair("example", 123)
		).doesNotThrowAnyException();
	}

	@Test
	void hasPairFailsLeft() {
		assertThatExceptionOfType(AssertionError.class).isThrownBy(() ->
				assertion.hasPair("not", 123)
		).withMessage("Expected Tuple2 left part to be <not> but was <example>");
	}

	@Test
	void hasPairFailsRight() {
		assertThatExceptionOfType(AssertionError.class).isThrownBy(() ->
				assertion.hasPair("example", 1234)
		).withMessage("Expected Tuple2 right part to be <1234> but was <123>");
	}

	@Test
	void hasPairFailsBoth() {
		assertThatExceptionOfType(AssertionError.class).isThrownBy(() ->
				assertion.hasPair("examples", 1234)
		).withMessage("Expected Tuple2 to contain pair <examples>-<1234> but was <example>-<123>");
	}

	@Test
	void hasT1() {
		assertThatCode(() ->
				assertion.hasT1("example")
		).doesNotThrowAnyException();
	}

	@Test
	void hasT1Fails() {
		assertThatExceptionOfType(AssertionError.class).isThrownBy(() ->
				assertion.hasT1("examples")
		).withMessage("Expected Tuple2 to have left part <examples> but was <example>");
	}

	@Test
	void hasT2() {
		assertThatCode(() ->
				assertion.hasT2(123)
		).doesNotThrowAnyException();
	}

	@Test
	void hasT2Fails() {
		assertThatExceptionOfType(AssertionError.class).isThrownBy(() ->
				assertion.hasT2(1234)
		).withMessage("Expected Tuple2 to have right part <1234> but was <123>");
	}
}