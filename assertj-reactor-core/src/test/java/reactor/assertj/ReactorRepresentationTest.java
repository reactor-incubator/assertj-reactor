package reactor.assertj;

import java.util.AbstractMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import reactor.util.context.Context;

import static org.assertj.core.api.Assertions.assertThat;

class ReactorRepresentationTest {

	private ReactorRepresentation representation = new ReactorRepresentation();

	@Test
	void directlyRepresentContext1AsToString() {
		Context context1 = Context.of("key", "value");
		Assumptions.assumeTrue("Context1".equals(context1.getClass().getSimpleName())
				&& !(context1 instanceof Map.Entry), "is Context1, not Map.Entry");

		assertThat(representation.toStringOf(context1))
				.isEqualTo("Context1{key=value}")
				.isEqualTo(context1.toString());
	}

	@Test
	void representContext1StreamAsKeyValue() {
		Context context1 = Context.of("key", "value");
		Stream<Map.Entry<Object, Object>> stream = context1.stream();

		Assumptions.assumeTrue("Context1".equals(context1.getClass().getSimpleName())
				&& !(context1 instanceof Map.Entry), "is Context1, not Map.Entry");

		assertThat(representation.toStringOf(stream.toArray()))
				.isEqualTo("[key=value]")
				.isNotEqualTo("[" + context1.toString() +"]");
	}

	@Test
	void directlyRepresentOldMapEntryContext1AsKeyValue() {
		OldStyleContext1 context1 = new OldStyleContext1("key", "value");

		assertThat(representation.toStringOf(context1))
				.isEqualTo("key=value")
				.isNotEqualTo(context1.toString());
	}

	@Test
	void representOldMapEntryContext1StreamAsKeyValue() {
		OldStyleContext1 context1 = new OldStyleContext1("key", "value");
		Stream<Map.Entry<Object, Object>> stream = context1.stream();

		assertThat(representation.toStringOf(stream.toArray()))
				.isEqualTo("[key=value]")
				.isNotEqualTo("[" + context1.toString() +"]");
	}

	private static class OldStyleContext1
			extends AbstractMap.SimpleImmutableEntry<Object, Object>
			implements Context {

		public OldStyleContext1(Object key, Object value) {
			super(key, value);
		}

		@Override
		public <T> T get(Object key) {
			if (key.equals(getKey())) {
				return (T) getValue();
			}
			throw new NoSuchElementException(key.toString());
		}

		@Override
		public boolean hasKey(Object key) {
			return getKey().equals(key);
		}

		@Override
		public Context put(Object key, Object value) {
			throw new UnsupportedOperationException();
		}

		@Override
		public Context delete(Object key) {
			throw new UnsupportedOperationException();
		}

		@Override
		public int size() {
			return 1;
		}

		@Override
		public Stream<Map.Entry<Object, Object>> stream() {
			return Stream.of(this);
		}

		@Override
		public String toString() {
			return "BadToString";
		}
	}

}