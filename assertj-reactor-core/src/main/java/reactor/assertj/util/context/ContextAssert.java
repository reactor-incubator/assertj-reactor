package reactor.assertj.util.context;

import java.util.AbstractMap;
import java.util.Map;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.internal.Iterables;

import reactor.test.StepVerifier;
import reactor.util.context.Context;

/**
 * Assert a {@link Context}. This assertion is intended as an AssertJ standalone that mirrors the corresponding
 * expectation builder built-in in {@link StepVerifier} (see {@link StepVerifier.Step#expectAccessibleContext()}).
 *
 * @author Simon Baslé
 */
public class ContextAssert extends AbstractAssert<ContextAssert, Context> {

	protected final Iterables iterables = Iterables.instance();

	/**
	 * Workaround because Context1 implements {@link java.util.Map.Entry} and implements {@link Context#stream()}
	 * as {@code Stream.of(this)}, which throws the toString off in message formatters.
	 *
	 * @param context the context to properly convert to entry stream
	 * @return a stream of {@link java.util.AbstractMap.SimpleImmutableEntry}
	 */
	private static Stream<Map.Entry<Object, Object>> fixContext1EntryStream(Context context) {
		if (context instanceof Map.Entry) {
			@SuppressWarnings("unchecked") final Map.Entry<Object, Object> contextAsEntry = (Map.Entry<Object, Object>) context;
			return Stream.of(new AbstractMap.SimpleImmutableEntry<>(contextAsEntry));
		}
		return context.stream();
	}

	public ContextAssert(Context context) {
		super(context, ContextAssert.class);
	}

	/**
	 * Verifies that the {@link Context} contains an entry with the provided key.
	 *
	 * @param key the key to look for
	 * @return {@code this} assertion object
	 */
	public ContextAssert hasKey(Object key) {
		isNotNull();
		if (!actual.hasKey(key)) {
			failWithMessage("Expected context to have key <%s> but it didn't", key);
		}
		return this;
	}

	/**
	 * Verifies that the {@link Context} has the expected size.
	 *
	 * @param size the expected size
	 * @return {@code this} assertion object
	 */
	public ContextAssert hasSize(int size) {
		isNotNull();
		int actualSize = actual.size();
		if (actualSize != size) {
			failWithMessage("Expected context size of <%s> entries, but was <%s>", size, actualSize);
		}
		return this;
	}

	/**
	 * Verifies that the {@link Context} contains the provided key-value pair.
	 *
	 * @param key the key to look for
	 * @param value the value expected for that key
	 * @return {@code this} assertion object
	 */
	public ContextAssert contains(Object key, Object value) {
		isNotNull();
		if (!actual.hasKey(key)) {
			failWithMessage("Expected context to contain pair <%s>:<%s> but that key was not found", key, value);
		}
		Object actualValue = actual.get(key);
		if (!actualValue.equals(value)) {
			failWithMessage("Expected context to contain pair <%s>:<%s> but value for that key was <%s>", key, value, actualValue);
		}
		return this;
	}

	/**
	 * Verifies that the {@link Context} contains at least all of the entries in another {@link Context}.
	 *
	 * @param other the other {@link Context} that is expected to be entirely contained in the evaluated context.
	 * @return {@code this} assertion object
	 */
	public ContextAssert containsAllOf(Context other) {
		iterables.assertContainsAll(info,
				fixContext1EntryStream(actual).collect(Collectors.toList()),
				fixContext1EntryStream(other).collect(Collectors.toList()));
		return this;
	}

	/**
	 * Verifies that the {@link Context} contains at least all of the entries in a {@link Map}.
	 *
	 * @param other the {@link Map} which entries are expected to be all contained in the evaluated context.
	 * @return {@code this} assertion object
	 */
	public ContextAssert containsAllOf(Map<?, ?> other) {
		iterables.assertContainsAll(info,
				fixContext1EntryStream(actual).collect(Collectors.toList()),
				other.entrySet());
		return this;
	}

	/**
	 * Verifies that the {@link Context} contains all of the entries in another {@link Context} and nothing else.
	 *
	 * @param other the other {@link Context} which entries are expected to be all contained in the evaluated context.
	 * @return {@code this} assertion object
	 */
	public ContextAssert containsOnly(Context other) {

		Map.Entry<Object, Object>[] otherArray = fixContext1EntryStream(other).toArray(ARRAY_GENERATOR);
		//we use containsOnly and not containsExactlyInAnyOrder because we don't care about duplicates
		iterables.assertContainsOnly(info,
				fixContext1EntryStream(actual).collect(Collectors.toList()),
				otherArray);
		return this;
	}

	/**
	 * Verifies that the {@link Context} contains all of the entries in a {@link Map} and nothing else.
	 *
	 * @param other the {@link Map} which entries are expected to be all contained in the evaluated context.
	 * @return {@code this} assertion object
	 */
	public ContextAssert containsOnly(Map<?, ?> other) {
		Map.Entry<?, ?>[] otherArray = new Map.Entry[other.size()];
		other.entrySet().toArray(otherArray);
		//we use containsOnly and not containsExactlyInAnyOrder because we don't care about duplicates
		iterables.assertContainsOnly(info,
				fixContext1EntryStream(actual).collect(Collectors.toList()),
				otherArray);
		return this;
	}

	static final IntFunction<Map.Entry<Object, Object>[]> ARRAY_GENERATOR = Map.Entry[]::new;
}