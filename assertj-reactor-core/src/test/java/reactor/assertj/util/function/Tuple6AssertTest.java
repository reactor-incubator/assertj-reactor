package reactor.assertj.util.function;

import org.junit.jupiter.api.Test;

import reactor.assertj.ReactorAssertions;
import reactor.util.function.Tuple6;
import reactor.util.function.Tuples;

import static org.assertj.core.api.Assertions.*;

class Tuple6AssertTest {

	final Tuple6<String, Integer, Long, String, Integer, Integer>       testData  = Tuples.of("example", 123, 45L, "fourth", 5, 6);
	final Tuple6Assert<String, Integer, Long, String, Integer, Integer> assertion = ReactorAssertions.assertThat(testData);

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
		).withMessage("Expected Tuple6 to have first part <examples> but was <example>");
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
		).withMessage("Expected Tuple6 to have second part <1234> but was <123>");
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
		).withMessage("Expected Tuple6 to have third part <46> but was <45>");
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
		).withMessage("Expected Tuple6 to have fourth part <foorth> but was <fourth>");
	}

	@Test
	void hasT5() {
		assertThatCode(() ->
				assertion.hasT5(5)
		).doesNotThrowAnyException();
	}

	@Test
	void hasT5Fails() {
		assertThatExceptionOfType(AssertionError.class).isThrownBy(() ->
				assertion.hasT5(6)
		).withMessage("Expected Tuple6 to have fifth part <6> but was <5>");
	}

	@Test
	void hasT6() {
		assertThatCode(() ->
				assertion.hasT6(6)
		).doesNotThrowAnyException();
	}

	@Test
	void hasT6Fails() {
		assertThatExceptionOfType(AssertionError.class).isThrownBy(() ->
				assertion.hasT6(7)
		).withMessage("Expected Tuple6 to have sixth part <7> but was <6>");
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
		).withMessage("Expected Tuple6 first part to satisfy requirements, but didn't.\nDetails: " +
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
		).withMessageStartingWith("Expected Tuple6 second part to satisfy requirements, but didn't.\nDetails: " +
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
		).withMessageStartingWith("Expected Tuple6 third part to satisfy requirements, but didn't.\nDetails: " +
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
		).withMessage("Expected Tuple6 fourth part to satisfy requirements, but didn't.\nDetails: " +
				"\nExpected size:<100> but was:<6> in:\n<\"fourth\">");
	}

	@Test
	void hasT5Satisfying() {
		assertThatCode(() ->
				assertion.hasT5Satisfying(v -> assertThat(v).isGreaterThan(1))
		).doesNotThrowAnyException();
	}

	@Test
	void hasT5SatisfyingFails() {
		assertThatExceptionOfType(AssertionError.class).isThrownBy(() ->
				assertion.hasT5Satisfying(v -> assertThat(v).isGreaterThan(100))
		).withMessage("Expected Tuple6 fifth part to satisfy requirements, but didn't.\nDetails: " +
				"\nExpecting:\n <5>\nto be greater than:\n <100> ");
	}

	@Test
	void hasT6Satisfying() {
		assertThatCode(() ->
				assertion.hasT6Satisfying(v -> assertThat(v).isGreaterThan(1))
		).doesNotThrowAnyException();
	}

	@Test
	void hasT6SatisfyingFails() {
		assertThatExceptionOfType(AssertionError.class).isThrownBy(() ->
				assertion.hasT6Satisfying(v -> assertThat(v).isGreaterThan(100))
		).withMessage("Expected Tuple6 sixth part to satisfy requirements, but didn't.\nDetails: " +
				"\nExpecting:\n <6>\nto be greater than:\n <100> ");
	}
}
