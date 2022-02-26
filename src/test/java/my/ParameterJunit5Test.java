package my;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

//ユーザガイド
//https://oohira.github.io/junit5-doc-jp/user-guide/#writing-tests-parameterized-tests
//https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests
class ParameterJunit5Test {

	@ParameterizedTest
	@ValueSource(ints = { 100, 200, 300 })
	@DisplayName("@ValueSourceで直に引数を指定")
	void test(int p) {
		Assertions.assertThat(p).isGreaterThanOrEqualTo(100);
	}

	@ParameterizedTest
	@CsvSource({
		"123,abc,2022-02-14T12:34:56",
		"456,efg,2022-02-14T12:34:57",
		"789,hij,2022-02-14T12:34:58"
		})
	@DisplayName("CSV形式で引数を指定")
	// 型変換も自動でやってくれる
	// https://oohira.github.io/junit5-doc-jp/user-guide/#writing-tests-parameterized-tests-argument-conversion-implicit
	void test4(int i, String message, LocalDateTime ldt) {
		Assertions.assertThat(i).isNotNull();
		Assertions.assertThat(message).isNotNull();
		Assertions.assertThat(ldt).isNotNull();
	}
	
	
	@ParameterizedTest
	@MethodSource("parameter1")
	@DisplayName("他のメソッドの戻り値を指定")
	void test2(InputParameter p) {
		Assertions.assertThat(p.name).isNotEmpty();
	}

	@ParameterizedTest
	@MethodSource("parameter2")
	@DisplayName("引数を2個以上受け取る場合")
	void test3(InputParameter p, String memo) {
		Assertions.assertThat(p.name).isNotEmpty();
		Assertions.assertThat(memo).isNotEmpty();
	}



	
	static Stream<InputParameter> parameter1() {
		List<InputParameter> list = new ArrayList<>();
		
		{
			InputParameter ip = new InputParameter();
			ip.name = "taro";
			ip.old = 30;
			list.add(ip);
		}
		{
			InputParameter ip = new InputParameter();
			ip.name = "tailer";
			ip.old = 25;
			list.add(ip);
		}
		{
			InputParameter ip = new InputParameter();
			ip.name = "white";
			ip.old = 35;
			list.add(ip);
		}
		return list.stream();
	}

	static Stream<Arguments> parameter2() {
		List<Arguments> list = new ArrayList<>();
		
		{
			InputParameter ip = new InputParameter();
			ip.name = "taro";
			ip.old = 30;
			
			String memo = "1番目の引数";
			
			list.add(Arguments.of(ip, memo));
		}
		{
			InputParameter ip = new InputParameter();
			ip.name = "tailer";
			ip.old = 25;
			
			String memo = "2番目の引数";
			
			list.add(Arguments.of(ip, memo));
		}
		return list.stream();
	}

	
	static class InputParameter {
		public String name;
		public Integer old;
		@Override
		public String toString() {
			return "InputParameter [name=" + name + ", old=" + old + "]";
		}
	}

}
