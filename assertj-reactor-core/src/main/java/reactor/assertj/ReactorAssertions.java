package reactor.assertj;

import reactor.assertj.util.function.Tuple2Assert;
import reactor.assertj.util.function.Tuple3Assert;
import reactor.assertj.util.function.Tuple4Assert;
import reactor.assertj.util.function.Tuple5Assert;
import reactor.assertj.util.function.Tuple6Assert;
import reactor.assertj.util.function.Tuple7Assert;
import reactor.assertj.util.function.Tuple8Assert;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuple3;
import reactor.util.function.Tuple4;
import reactor.util.function.Tuple5;
import reactor.util.function.Tuple6;
import reactor.util.function.Tuple7;
import reactor.util.function.Tuple8;

/**
 * Entry points for reactor-core and reactor-test AssertJ assertions.
 *
 * @author Simon Baslé
 */
public final class ReactorAssertions {

	public static <T1, T2> Tuple2Assert<T1, T2> assertThat(Tuple2<T1, T2> actual) {
		return new Tuple2Assert<>(actual);
	}

	public static <T1, T2, T3> Tuple3Assert<T1, T2, T3> assertThat(Tuple3<T1, T2, T3> actual) {
		return new Tuple3Assert<>(actual);
	}

	public static <T1, T2, T3, T4> Tuple4Assert<T1, T2, T3, T4> assertThat(Tuple4<T1, T2, T3, T4> actual) {
		return new Tuple4Assert<>(actual);
	}

	public static <T1, T2, T3, T4, T5> Tuple5Assert<T1, T2, T3, T4, T5> assertThat(Tuple5<T1, T2, T3, T4, T5> actual) {
		return new Tuple5Assert<>(actual);
	}

	public static <T1, T2, T3, T4, T5, T6> Tuple6Assert<T1, T2, T3, T4, T5, T6> assertThat(Tuple6<T1, T2, T3, T4, T5, T6> actual) {
		return new Tuple6Assert<>(actual);
	}

	public static <T1, T2, T3, T4, T5, T6, T7> Tuple7Assert<T1, T2, T3, T4, T5, T6, T7> assertThat(Tuple7<T1, T2, T3, T4, T5, T6, T7> actual) {
		return new Tuple7Assert<>(actual);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8> Tuple8Assert<T1, T2, T3, T4, T5, T6, T7, T8> assertThat(Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> actual) {
		return new Tuple8Assert<>(actual);
	}

}
