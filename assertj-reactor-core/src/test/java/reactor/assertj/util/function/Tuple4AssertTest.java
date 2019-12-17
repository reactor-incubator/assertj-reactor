package reactor.assertj.util.function;

import org.junit.jupiter.api.Test;

import reactor.assertj.ReactorAssertions;
import reactor.util.function.Tuple4;
import reactor.util.function.Tuples;

import static org.assertj.core.api.Assertions.*;

class Tuple4AssertTest {

	final Tuple4<String, Integer, Long, String>       testData  = Tuples.of("example", 123, 45L, "fourth");
	final Tuple4Assert<String, Integer, Long, String> assertion = ReactorAssertions.assertThat(testData);

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
		).withMessage("Expected Tuple4 to have first part <examples> but was <example>");
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
		).withMessage("Expected Tuple4 to have second part <1234> but was <123>");
	}

	@Test
	void hasT3() {
		assertThatCode(() ->
				assertion.hasT3(45L)
		).doesNotThrowAnyException();
	}

	@Test
	void hasT3Fails() {
		assertThatExceptionOfType(AssertionError.class).isThrownBy(() ->
				assertion.hasT3(46L)
		).withMessage("Expected Tuple4 to have third part <46> but was <45>");
	}

	@Test
	void hasT4() {
		assertThatCode(() ->
				assertion.hasT4("fourth")
		).doesNotThrowAnyException();
	}

	@Test
	void hasT4Fails() {
		assertThatExceptionOfType(AssertionError.class).isThrownBy(() ->
				assertion.hasT4("foorth")
		).withMessage("Expected Tuple4 to have fourth part <foorth> but was <fourth>");
	}

	@Test
	void hasT1Satisfying() {
		assertThatCode(() ->
				assertion.hasT1Satisfying(s -> assertThat(s).startsWith("examp"))
		).doesNotThrowAnyException();
	}

	@Test
	void hasT1SatisfyingFails() {
		assertThatExceptionOfType(AssertionError.class).isThrownBy(() ->
				assertion.hasT1Satisfying(s -> assertThat(s).startsWith("foo"))
		).withMessage("Expected Tuple4 first part to satisfy requirements, but didn't.\nDetails: " +
				"\nExpecting:\n <\"example\">\nto start with:\n <\"foo\">\n");
	}

	@Test
	void hasT2Satisfying() {
		assertThatCode(() ->
				assertion.hasT2Satisfying(v -> assertThat(v).isGreaterThan(100))
		).doesNotThrowAnyException();
	}

	@Test
	void hasT2SatisfyingFails() {
		assertThatExceptionOfType(AssertionError.class).isThrownBy(() ->
				assertion.hasT2Satisfying(v -> assertThat(v).isGreaterThan(1000))
		).withMessageStartingWith("Expected Tuple4 second part to satisfy requirements, but didn't.\nDetails: " +
				"\nExpecting:\n <123>\nto be greater than:\n <1000>");
	}

	@Test
	void hasT3Satisfying() {
		assertThatCode(() ->
				assertion.hasT3Satisfying(v -> assertThat(v).isLessThan(50))
		).doesNotThrowAnyException();
	}

	@Test
	void hasT3SatisfyingFails() {
		assertThatExceptionOfType(AssertionError.class).isThrownBy(() ->
				assertion.hasT3Satisfying(v -> assertThat(v).isLessThan(40))
		).withMessageStartingWith("Expected Tuple4 third part to satisfy requirements, but didn't.\nDetails: " +
				"\nExpecting:\n <45L>\nto be less than:\n <40L>");
	}

	@Test
	void hasT4Satisfying() {
		assertThatCode(() ->
				assertion.hasT4Satisfying(v -> assertThat(v).hasSize(6))
		).doesNotThrowAnyException();
	}

	@Test
	void hasT4SatisfyingFails() {
		assertThatExceptionOfType(AssertionError.class).isThrownBy(() ->
				assertion.hasT4Satisfying(v -> assertThat(v).hasSize(100))
		).withMessage("Expected Tuple4 fourth part to satisfy requirements, but didn't.\nDetails: " +
				"\nExpected size:<100> but was:<6> in:\n<\"fourth\">");
	}
}
