package reactor.assertj.util.context;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import reactor.assertj.ReactorAssertions;
import reactor.util.context.Context;

import static org.assertj.core.api.Assertions.*;

class ContextAssertTest {

	private Context testData;
	private ContextAssert assertion;

	@BeforeEach
	void init() {
		testData = Context.of("key1", "value1", "key2", "value2");
		assertion = new ContextAssert(testData);
	}

	@Nested
	class AllSatisfies {

		@Test
		void succeeds() {
			assertThatCode(
					() -> assertion.allSatisfy((k, v) -> assertThat(k).asString().startsWith("key"))
			).doesNotThrowAnyException();
		}

		@Test
		void fails() {
			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> assertion.allSatisfy((k, v) -> assertThat(k).asString().startsWith("keyo"))
			).withMessageStartingWith("\nExpecting all elements of:\n  <[key1=value1, key2=value2]>\nto satisfy given requirements, but this element did not:" +
					"\n  <key1=value1> \nDetails: \"\nExpecting:\n <\"key1\">\nto start with:\n <\"keyo\">");
		}
	}

	@Nested
	class ContainsKeys {

		@Test
		void succeeds() {
			assertThatCode(
					() -> assertion.containsKeys("key1")
			).doesNotThrowAnyException();
		}

		@Test
		void failsOneNotFound() {
			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> assertion.containsKeys("key1", "key3")
			).withMessage("\nExpecting:\n <Context2{key1=value1, key2=value2}>\nto contain key:\n <\"key3\">");
		}

		@Test
		void failsOnNull() {
			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> ReactorAssertions.assertThat(null).containsKeys("key1")
			).withMessage("\nExpecting actual not to be null");
		}
	}

	@Nested
	class ContainsOnlyKeys {

		@Test
		public void isNotNull() {
			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> ReactorAssertions.assertThat(null).containsOnlyKeys("key1")
			).withMessage("\nExpecting actual not to be null");
		}

		@Test
		public void emptyContextAndEmptyKeys() {
			assertThatCode(
					() -> ReactorAssertions.assertThat(Context.empty()).containsOnlyKeys()
			).doesNotThrowAnyException();
		}

		@Test
		void succeeds() {
			assertThatCode(
					() -> assertion.containsOnlyKeys("key1", "key2")
			).doesNotThrowAnyException();
		}

		@Test
		void failsSomeNotFound() {
			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> assertion.containsOnlyKeys("key1", "key2", "key3")
			).withMessage("\nExpecting:\n  <Context2{key1=value1, key2=value2}>\nto contain only following keys:\n  <[\"key1\", \"key2\", \"key3\"]>\nbut could not find the following keys:\n  <[\"key3\"]>\n");
		}

		@Test
		void failsSomeNotExpected() {
			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> assertion.containsOnlyKeys("key1")
			).withMessage("\nExpecting:\n  <Context2{key1=value1, key2=value2}>\nto contain only following keys:\n  <[\"key1\"]>\nkeys not found:\n  <[]>\nand keys not expected:\n  <[key2=value2]>\n");
		}

		@Test
		void failsSomeNotFoundAndNotExpected() {
			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> assertion.containsOnlyKeys("key1", "key3")
			).withMessage("\nExpecting:\n  <Context2{key1=value1, key2=value2}>\nto contain only following keys:\n  <[\"key1\", \"key3\"]>\nkeys not found:\n  <[\"key3\"]>\nand keys not expected:\n  <[key2=value2]>\n");
		}
	}

	@Nested
	class DoesNotContain {

		@Test
		public void isNotNull() {
			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> ReactorAssertions.assertThat(null).doesNotContain("key", "value")
			).withMessage("\nExpecting actual not to be null");
		}

		@Test
		void succeedsKnownKeyButInconsistentValue() {
			assertThatCode(
					() -> assertion.doesNotContain("key1", "value2")
			).doesNotThrowAnyException();
		}

		@Test
		void succeedsUnknownKey() {
			assertThatCode(
					() -> assertion.doesNotContain("key3", "whatever")
			).doesNotThrowAnyException();
		}

		@Test
		public void failsContainedEntry() {
			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> assertion.doesNotContain("key1", "value1")
			).withMessage("\nExpecting\n <Context2{key1=value1, key2=value2}>\nnot to contain\n <key1=value1>\nbut found\n <key1=value1>\n");
		}
	}

	@Nested
	class DoesNotContainKeys {

		@Test
		public void isNotNull() {
			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> ReactorAssertions.assertThat(null).doesNotContainKeys()
			).withMessage("\nExpecting actual not to be null");
		}

		@Test
		void succeedsSingle() {
			assertThatCode(
					() -> assertion.doesNotContainKey("key3")
			).doesNotThrowAnyException();
		}

		@Test
		void succeedsMultiple() {
			assertThatCode(
					() -> assertion.doesNotContainKeys("key3", "key4")
			).doesNotThrowAnyException();
		}

		@Test
		public void failsSingle() {
			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> assertion.doesNotContainKey("key1")
			).withMessage("\nExpecting\n <Context2{key1=value1, key2=value2}>\nnot to contain\n <[\"key1\"]>\nbut found\n <[key1=value1]>\n");
		}

		@Test
		public void failsMultipleAllContained() {
			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> assertion.doesNotContainKeys("key1", "key2")
			).withMessage("\nExpecting\n <Context2{key1=value1, key2=value2}>\nnot to contain\n <[\"key1\", \"key2\"]>\nbut found\n <[key1=value1, key2=value2]>\n");
		}

		@Test
		public void failsMultipleSomeContained() {
			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> assertion.doesNotContainKeys("key1", "key3")
			).withMessage("\nExpecting\n <Context2{key1=value1, key2=value2}>\nnot to contain\n <[\"key1\", \"key3\"]>\nbut found\n <[key1=value1]>\n");
		}
	}

	@Nested
	class DoesNotContainValue {

		@Test
		public void isNotNull() {
			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> ReactorAssertions.assertThat(null).doesNotContainValue("foo")
			).withMessage("\nExpecting actual not to be null");
		}

		@Test
		void succeeds() {
			assertThatCode(
					() -> assertion.doesNotContainValue("value12")
			).doesNotThrowAnyException();
		}

		@Test
		public void fails() {
			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> assertion.doesNotContainValue("value2")
			).withMessage("\nExpecting:\n  <Context2{key1=value1, key2=value2}>\nnot to contain value:\n  <\"value2\">");
		}
	}

	@Nested
	class HasEntrySatisfying {

		@Test
		void succeeds() {
			assertThatCode(
					() -> assertion.hasEntrySatisfying((k, v) -> assertThat(v).asString().isEqualTo("value2"))
			).doesNotThrowAnyException();
		}

		@Test
		void fails() {
			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> assertion.hasEntrySatisfying((k, v) -> assertThat(v).asString().startsWith(("notAValue")))
			).withMessage("\nExpecting any element of:\n  <[key1=value1, key2=value2]>\nto satisfy the given assertions requirements but none did.");
		}
	}

	@Nested
	class HasKey {

		@Test
		void succeeds() {
			assertThatCode(
					() -> assertion.hasKey("key1")
			).doesNotThrowAnyException();
		}

		@Test
		void fails() {
			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> assertion.hasKey("key3")
			).withMessage("Expected context to have key <key3> but it didn't");
		}
	}

	@Nested
	class HasKeySatisfying {

		@Test
		void succeeds() {
			assertThatCode(
					() -> assertion.hasKeySatisfying(k -> assertThat(k).asString().endsWith("2"))
			).doesNotThrowAnyException();
		}

		@Test
		void fails() {
			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> assertion.hasKeySatisfying(k -> assertThat(k).asString().endsWith("3"))
			).withMessage("\nExpecting any element of:\n  <[key1=value1, key2=value2]>\nto satisfy the given assertions requirements but none did.");
		}
	}

	@Nested
	class HasSize {

		@Test
		void same() {
			assertThatCode(
					() -> assertion.hasSize(2)
			).doesNotThrowAnyException();
		}

		@Test
		void different() {
			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> assertion.hasSize(3)
			).withMessage("Expected context size of <3> entries, but was <2>");
		}
	}

	@Nested
	class HasValueSatisfying {

		@Test
		void succeeds() {
			assertThatCode(
					() -> assertion.hasValueSatisfying(v -> assertThat(v).asString().endsWith("2"))
			).doesNotThrowAnyException();
		}

		@Test
		void fails() {
			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> assertion.hasValueSatisfying(v -> assertThat(v).asString().endsWith("3"))
			).withMessage("\nExpecting any element of:\n  <[key1=value1, key2=value2]>\nto satisfy the given assertions requirements but none did.");
		}
	}

	@Nested
	class Contains {

		@Test
		void succeeds() {
			assertThatCode(
					() -> assertion.contains("key2", "value2")
			).doesNotThrowAnyException();
		}

		@Test
		void keyNotFound() {
			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> assertion.contains("key3", "value3")
			).withMessage("Expected context to contain pair <key3>:<value3> but that key was not found");
		}

		@Test
		void valueDifferent() {
			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> assertion.contains("key2", "value3")
			).withMessage("Expected context to contain pair <key2>:<value3> but value for that key was <value2>");
		}

	}

	@Nested
	class ContainsAllOf {

		@Test
		void contextExactMatch() {
			Context exactMatch = Context.empty().putAll(testData);
			assertThatCode(
					() -> assertion.containsAllOf(exactMatch)
			).doesNotThrowAnyException();
		}

		@Test
		void contextSubset() {
			Context smaller = testData.delete("key1");
			assertThatCode(
					() -> assertion.containsAllOf(smaller)
			).doesNotThrowAnyException();
		}

		@Test
		void contextBigger() {
			Context bigger = testData.put("key3", "value3");
			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> assertion.containsAllOf(bigger)
			).withMessage("\nExpecting:\n <[key1=value1, key2=value2]>\nto contain:\n <[key1=value1, key2=value2, key3=value3]>\n"
					+ "but could not find:\n <[key3=value3]>\n");
		}

		@Test
		void contextSameSizePartialMatch() {
			Context partial = testData.delete("key1").put("key3", "value3");

			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> assertion.containsAllOf(partial)
			).withMessage("\nExpecting:\n <[key1=value1, key2=value2]>\nto contain:\n <[key2=value2, key3=value3]>\n"
					+ "but could not find:\n <[key3=value3]>\n");
		}

		@Test
		void contextSameSizeNoMatch() {
			Context none =  Context.of("key3", "value3", "key4", "value4");

			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> assertion.containsAllOf(none)
			).withMessage("\nExpecting:\n <[key1=value1, key2=value2]>\nto contain:\n <[key3=value3, key4=value4]>\n"
					+ "but could not find:\n <[key3=value3, key4=value4]>\n");
		}

		@Test
		void mapExactMatch() {
			Map<Object, Object> exactMatch = new HashMap<>();
			exactMatch.put("key1", "value1");
			exactMatch.put("key2", "value2");

			assertThatCode(
					() -> assertion.containsAllOf(exactMatch)
			).doesNotThrowAnyException();
		}

		@Test
		void mapSubset() {
			Map<Object, Object> smaller = new HashMap<>();
			smaller.put("key2", "value2");

			assertThatCode(
					() -> assertion.containsAllOf(smaller)
			).doesNotThrowAnyException();
		}

		@Test
		void mapBigger() {
			Map<Object, Object> bigger = new HashMap<>();
			bigger.put("key1", "value1");
			bigger.put("key2", "value2");
			bigger.put("key3", "value3");

			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> assertion.containsAllOf(bigger)
			).withMessage("\nExpecting:\n <[key1=value1, key2=value2]>\nto contain:\n <[key1=value1, key2=value2, key3=value3]>\n"
					+ "but could not find:\n <[key3=value3]>\n");
		}

		@Test
		void mapSameSizePartialMatch() {
			Map<Object, Object> partial = new HashMap<>();
			partial.put("key2", "value2");
			partial.put("key3", "value3");

			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> assertion.containsAllOf(partial)
			).withMessage("\nExpecting:\n <[key1=value1, key2=value2]>\nto contain:\n <[key2=value2, key3=value3]>\n"
					+ "but could not find:\n <[key3=value3]>\n");
		}

		@Test
		void mapSameSizeNoMatch() {
			Map<Object, Object> none = new HashMap<>();
			none.put("key3", "value3");
			none.put("key4", "value4");

			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> assertion.containsAllOf(none)
			).withMessage("\nExpecting:\n <[key1=value1, key2=value2]>\nto contain:\n <[key3=value3, key4=value4]>\n"
					+ "but could not find:\n <[key3=value3, key4=value4]>\n");
		}
	}

	@Nested
	class ContainsOnly {

		@Test
		void contextExactMatch() {
			Context exactMatch = Context.empty().putAll(testData);
			assertThatCode(
					() -> assertion.containsOnly(exactMatch)
			).doesNotThrowAnyException();
		}

		@Test
		void contextSubset() {
			Context smaller = testData.delete("key1");
			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> assertion.containsOnly(smaller)
			).withMessage("\nExpecting:\n  <[key1=value1, key2=value2]>\nto contain only:\n  <[key2=value2]>\n" +
					"but the following elements were unexpected:\n  <[key1=value1]>\n");
		}

		@Test
		void contextBigger() {
			Context bigger = testData.put("key3", "value3");
			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> assertion.containsOnly(bigger)
			).withMessage("\nExpecting:\n  <[key1=value1, key2=value2]>\nto contain only:\n  <[key1=value1, key2=value2, key3=value3]>\n"
					+ "but could not find the following elements:\n  <[key3=value3]>\n");
		}

		@Test
		void contextSameSizePartialMatch() {
			Context partial = testData.delete("key1").put("key3", "value3");

			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> assertion.containsOnly(partial)
			).withMessage("\nExpecting:\n  <[key1=value1, key2=value2]>\nto contain only:\n  <[key2=value2, key3=value3]>\n"
					+ "elements not found:\n  <[key3=value3]>\nand elements not expected:\n  <[key1=value1]>\n");
		}

		@Test
		void contextSameSizeNoMatch() {
			Context none =  Context.of("key3", "value3", "key4", "value4");

			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> assertion.containsOnly(none)
			).withMessage("\nExpecting:\n  <[key1=value1, key2=value2]>\nto contain only:\n  <[key3=value3, key4=value4]>\n"
					+ "elements not found:\n  <[key3=value3, key4=value4]>\nand elements not expected:\n  <[key1=value1, key2=value2]>\n");
		}

		@Test
		void mapExactMatch() {
			Map<Object, Object> exactMatch = new HashMap<>();
			exactMatch.put("key1", "value1");
			exactMatch.put("key2", "value2");

			assertThatCode(
					() -> assertion.containsOnly(exactMatch)
			).doesNotThrowAnyException();
		}

		@Test
		void mapSubset() {
			Map<Object, Object> smaller = new HashMap<>();
			smaller.put("key2", "value2");

			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> assertion.containsOnly(smaller)
			).withMessage("\nExpecting:\n  <[key1=value1, key2=value2]>\nto contain only:\n  <[key2=value2]>\n" +
					"but the following elements were unexpected:\n  <[key1=value1]>\n");
		}

		@Test
		void mapBigger() {
			Map<Object, Object> bigger = new HashMap<>();
			bigger.put("key1", "value1");
			bigger.put("key2", "value2");
			bigger.put("key3", "value3");

			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> assertion.containsOnly(bigger)
			).withMessage("\nExpecting:\n  <[key1=value1, key2=value2]>\nto contain only:\n  <[key1=value1, key2=value2, key3=value3]>\n"
					+ "but could not find the following elements:\n  <[key3=value3]>\n");
		}

		@Test
		void mapSameSizePartialMatch() {
			Map<Object, Object> partial = new HashMap<>();
			partial.put("key2", "value2");
			partial.put("key3", "value3");

			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> assertion.containsOnly(partial)
			).withMessage("\nExpecting:\n  <[key1=value1, key2=value2]>\nto contain only:\n  <[key2=value2, key3=value3]>\n"
					+ "elements not found:\n  <[key3=value3]>\nand elements not expected:\n  <[key1=value1]>\n");
		}

		@Test
		void mapSameSizeNoMatch() {
			Map<Object, Object> none = new HashMap<>();
			none.put("key3", "value3");
			none.put("key4", "value4");

			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> assertion.containsOnly(none)
			).withMessage("\nExpecting:\n  <[key1=value1, key2=value2]>\nto contain only:\n  <[key3=value3, key4=value4]>\n"
					+ "elements not found:\n  <[key3=value3, key4=value4]>\nand elements not expected:\n  <[key1=value1, key2=value2]>\n");
		}
	}

	@Nested
	class Empty {

		@Test
		void isEmpty() {
			assertThatCode(
					() -> new ContextAssert(Context.empty()).isEmpty()
			).doesNotThrowAnyException();
		}

		@Test
		void isEmptyFails() {
			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> assertion.isEmpty()
			).withMessage("\nExpecting empty but was:<[key1=value1, key2=value2]>");
		}

		@Test
		void isNotEmpty() {
			assertThatCode(
					() -> assertion.isNotEmpty()
			).doesNotThrowAnyException();
		}

		@Test
		void isNotEmptyFails() {
			assertThatExceptionOfType(AssertionError.class).isThrownBy(
					() -> new ContextAssert(Context.empty()).isNotEmpty()
			).withMessage("\nExpecting actual not to be empty");
		}
	}

	@Test
	void context1StreamStringRepresentation() {
		assertThatExceptionOfType(AssertionError.class)
				.isThrownBy(() -> Assertions.assertThat(Context.of(1, 10).stream()).containsOnly(new AbstractMap.SimpleEntry<>("foo", "bar")))
				.withMessage("\nExpecting:\n  <[1=10]>\nto contain only:\n  <[foo=bar]>\nelements not found:" +
						"\n  <[foo=bar]>\nand elements not expected:\n  <[1=10]>\n");
	}
}