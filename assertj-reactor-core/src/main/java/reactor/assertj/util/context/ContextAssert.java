package reactor.assertj.util.context;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.internal.Failures;
import org.assertj.core.internal.Iterables;
import org.assertj.core.presentation.StandardRepresentation;

import reactor.assertj.ReactorRepresentation;
import reactor.test.StepVerifier;
import reactor.util.context.Context;

import static org.assertj.core.error.ShouldContainKeys.shouldContainKeys;
import static org.assertj.core.error.ShouldContainOnlyKeys.shouldContainOnlyKeys;
import static org.assertj.core.error.ShouldNotContain.shouldNotContain;
import static org.assertj.core.error.ShouldNotContainValue.shouldNotContainValue;

/**
 * Assert a {@link Context}. This assertion is intended as an AssertJ standalone that mirrors the corresponding
 * expectation builder built-in in {@link StepVerifier} (see {@link StepVerifier.Step#expectAccessibleContext()}).
 *
 * @author Simon Baslé
 */
public class ContextAssert extends AbstractAssert<ContextAssert, Context> {

	protected final Iterables iterables = Iterables.instance();
	protected final Failures failures = Failures.instance();

	protected final List<Map.Entry<Object, Object>> actualAsList;

	public ContextAssert(Context context) {
		super(context, ContextAssert.class);
		this.actualAsList = context == null ? Collections.emptyList() : context.stream().collect(Collectors.toList());
//		Workaround because Context1 implements Context#stream() as Stream.of(this),
//		so the representation leaks in message formatters.
		StandardRepresentation representation = new ReactorRepresentation();
		getWritableAssertionInfo().useRepresentation(representation);
	}

	/**
	 * Verifiers that all the entries in the {@link Context} verify the provided assertions,
	 * as applied through the {@link BiConsumer}.
	 *
	 * @param entryRequirements a {@link BiConsumer} that applies assertions to each entry
	 * @return {@code this} assertion object
	 */
	public ContextAssert allSatisfy(BiConsumer<Object, Object> entryRequirements) {
		iterables.assertAllSatisfy(info, actualAsList, e -> entryRequirements.accept(e.getKey(), e.getValue()));
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
				actualAsList,
				other.stream().collect(Collectors.toList()));
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
				actualAsList,
				other.entrySet());
		return this;
	}

	/**
	 * Verifiers that the {@link Context} contains at least all the provided keys.
	 *
	 * @param keys an array of keys that are expected to be contained by the {@link Context}
	 * @return {@code this} assertion object
	 */
	public ContextAssert containsKeys(Object... keys) {
		isNotNull();
		Set<Object> notFound = new LinkedHashSet<>();
		for (Object key : keys) {
			if (!actual.hasKey(key)) {
				notFound.add(key);
			}
		}
		if (notFound.isEmpty()) return this;
		throw failures.failure(info, shouldContainKeys(actual, notFound));
	}

	/**
	 * Verifies that the {@link Context} contains all of the entries in another {@link Context} and nothing else.
	 *
	 * @param other the other {@link Context} which entries are expected to be all contained in the evaluated context.
	 * @return {@code this} assertion object
	 */
	public ContextAssert containsOnly(Context other) {

		Map.Entry<Object, Object>[] otherArray = other.stream().toArray(ARRAY_GENERATOR);
		//we use containsOnly and not containsExactlyInAnyOrder because we don't care about duplicates
		iterables.assertContainsOnly(info,
				actualAsList,
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
				actualAsList,
				otherArray);
		return this;
	}

	/**
	 * Verifiers that the {@link Context} contains only the given keys, and nothing else.
	 * The values are ignored in the assertion.
	 *
	 * @param keys the keys that are expected in the {@link Context}, barring any other key
	 * @return {@code this} assertion object
	 */
	public ContextAssert containsOnlyKeys(Object... keys) {
		isNotNull();
		if (actual.isEmpty() && keys.length == 0) {
			return this;
		}

		Set<Object> notFound = new LinkedHashSet<>();
		Context notExpectedImmutable = actual;

		for (Object key : keys) {
			if (actual.hasKey(key)) {
				// this is an expected key
				notExpectedImmutable = notExpectedImmutable.delete(key);
			} else {
				// this is a not found key
				notFound.add(key);
			}
		}
		// All remaining keys from actual copy are not expected entries.
		List<Object> notExpected = notExpectedImmutable.stream().collect(Collectors.toList());

		if (!notFound.isEmpty() || !notExpected.isEmpty())
			throw failures.failure(info, shouldContainOnlyKeys(actual, keys, notFound, notExpected));

		return this;
	}

	/**
	 * Verifies that the {@link Context} does not contain the given entry, ie either the
	 * {@code key} is not contained in the context or the associated value is not equal to
	 * {@code value}.
	 *
	 * @param key the key of the unexpected entry
	 * @param value the value of the unexpected entry
	 * @return {@code this} assertion object
	 */
	public ContextAssert doesNotContain(Object key, Object value) {
		isNotNull();
		if (actual.hasKey(key)) {
			if (value.equals(actual.get(key))) {
				Map.Entry<Object, Object> entry = new AbstractMap.SimpleImmutableEntry<>(key, value);
				throw failures.failure(info, shouldNotContain(actual, entry, entry));
			}
		}
		return this;
	}

	/**
	 * Verifies that the {@link Context} does not contain the given key.
	 *
	 * @param key the key that is unexpected in the {@link Context}
	 * @return {@code this} assertion object
	 */
	public ContextAssert doesNotContainKey(Object key) {
		return doesNotContainKeys(key);
	}

	/**
	 * Verifies that the {@link Context} does not contain any of the given keys.
	 *
	 * @param keys an array of keys that are unexpected in the {@link Context}
	 * @return {@code this} assertion object
	 */
	public ContextAssert doesNotContainKeys(Object... keys) {
		isNotNull();
		Set<Map.Entry<Object, Object>> found = new LinkedHashSet<>();
		for (Object key : keys) {
			if (actual.hasKey(key)) {
				found.add(new AbstractMap.SimpleImmutableEntry<>(key, actual.get(key)));
			}
		}
		if (found.isEmpty()) return this;
		throw failures.failure(info, shouldNotContain(actual, keys, found));
	}

	/**
	 * Verifies that the {@link Context} does not contain a given value, for any of its keys.
	 *
	 * @param value the value that the {@link Context} should not contain.
	 * @return {@code this} assertion object
	 */
	public ContextAssert doesNotContainValue(Object value) {
		isNotNull();
		if (actual.stream()
		      .map(Map.Entry::getValue)
		      .anyMatch(value::equals)) {
			throw failures.failure(info, shouldNotContainValue(actual, value));
		}
		return this;
	}

	/**
	 * Verifies that the {@link Context} has at least one entry that satisfies the given requirements,
	 * provided as a {@link BiConsumer} that applies further assertions on each key-value pair.
	 *
	 * @param entryRequirements a {@link BiConsumer} that applies assertions to each entry
	 * @return {@code this} assertion object
	 */
	public ContextAssert hasEntrySatisfying(BiConsumer<Object, Object> entryRequirements) {
		iterables.assertAnySatisfy(info, actualAsList, e -> entryRequirements.accept(e.getKey(), e.getValue()));
		return this;
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
	 * Verifies that the {@link Context} has at least one entry which key satisfies the given requirements,
	 * provided as a {@link Consumer} that applies further assertions on each key.
	 *
	 * @param keyRequirements a {@link Consumer} that applies assertions to each key
	 * @return {@code this} assertion object
	 */
	public ContextAssert hasKeySatisfying(Consumer<Object> keyRequirements) {
		iterables.assertAnySatisfy(info, actualAsList, e -> keyRequirements.accept(e.getKey()));
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
	 * Verifies that the {@link Context} has at least one entry which value satisfies the given requirements,
	 * provided as a {@link Consumer} that applies further assertions on each value.
	 *
	 * @param valueRequirements a {@link Consumer} that applies assertions to each value
	 * @return {@code this} assertion object
	 */
	public ContextAssert hasValueSatisfying(Consumer<Object> valueRequirements) {
		iterables.assertAnySatisfy(info, actualAsList, e -> valueRequirements.accept(e.getValue()));
		return this;
	}

	/**
	 * Verifies that the {@link Context} is empty.
	 *
	 * @return {@code this} assertion object
	 */
	public ContextAssert isEmpty() {
		iterables.assertEmpty(info, actualAsList);
		return this;
	}

	/**
	 * Verifies that the {@link Context} is not empty.
	 *
	 * @return {@code this} assertion object
	 */
	public ContextAssert isNotEmpty() {
		iterables.assertNotEmpty(info, actualAsList);
		return this;
	}

	static final IntFunction<Map.Entry<Object, Object>[]> ARRAY_GENERATOR = Map.Entry[]::new;
}
