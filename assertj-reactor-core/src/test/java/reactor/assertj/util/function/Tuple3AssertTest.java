package reactor.assertj.util.function;

import org.junit.jupiter.api.Test;

import reactor.assertj.ReactorAssertions;
import reactor.util.function.Tuple3;
import reactor.util.function.Tuples;

import static org.assertj.core.api.Assertions.*;

class Tuple3AssertTest {

	final Tuple3<String, Integer, Long>       testData  = Tuples.of("example", 123, 45L);
	final Tuple3Assert<String, Integer, Long> assertion = ReactorAssertions.assertThat(testData);

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
		).withMessage("Expected Tuple3 to have first part <examples> but was <example>");
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
		).withMessage("Expected Tuple3 to have second part <1234> but was <123>");
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
		).withMessage("Expected Tuple3 to have third part <46> but was <45>");
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
		).withMessage("Expected Tuple3 first part to satisfy requirements, but didn't.\nDetails: " +
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
		).withMessageStartingWith("Expected Tuple3 second part to satisfy requirements, but didn't.\nDetails: " +
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
		).withMessageStartingWith("Expected Tuple3 third part to satisfy requirements, but didn't.\nDetails: " +
				"\nExpecting:\n <45L>\nto be less than:\n <40L>");
	}
}
