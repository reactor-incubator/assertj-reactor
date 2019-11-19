package reactor.assertj;

import org.junit.jupiter.api.Test;

import reactor.assertj.util.function.Tuple8Assert;
import reactor.util.function.Tuple8;
import reactor.util.function.Tuples;

import static org.assertj.core.api.Assertions.assertThat;

class ReactorAssertionsTest {

	@Test
	void assertThatTupleSelectsCorrectImplementation() {
		Tuple8 t8 = Tuples.of(1, 2, 3, 4, 5, 6, 7, 8);

		assertThat(ReactorAssertions.assertThat(t8)).isExactlyInstanceOf(Tuple8Assert.class);

		ReactorAssertions.assertThat(Tuples.of(1, 2, 3, 4, 5, 6, 7, 8))
		                 .hasT3(42);
	}

}