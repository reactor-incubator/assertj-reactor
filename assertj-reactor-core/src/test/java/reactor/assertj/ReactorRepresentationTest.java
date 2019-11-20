package reactor.assertj;

import org.junit.jupiter.api.Test;

import reactor.util.context.Context;

import static org.assertj.core.api.Assertions.assertThat;

class ReactorRepresentationTest {

	private ReactorRepresentation representation = new ReactorRepresentation();

	@Test
	void representContext1AsKeyValue() {
		Context context1 = Context.of("key", "value");

		assertThat(representation.toStringOf(context1))
				.isEqualTo("key=value")
				.isNotEqualTo(context1.toString());
	}

}