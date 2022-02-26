package my;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

// ユーザガイド
// https://oohira.github.io/junit5-doc-jp/user-guide/#writing-tests-nested
// https://junit.org/junit5/docs/current/user-guide/#writing-tests-nested
@DisplayName("ネストしたテストケース")
class NestedJunit5Test {

	private Calculator calc = new Calculator();

	
	@Nested
	@DisplayName("addメソッドのテスト")
	class AddTest {

		@Test
		@DisplayName("正の値")
		void test() {
			assertEquals(3, calc.add(1, 2));
		}

		@Test
		@DisplayName("負の値")
		void test2() {
			assertEquals(-3, calc.add(-1, -2));
		}
	}

	
	@Nested
	@DisplayName("minusメソッドのテスト")
	class MinusTest {

		@Test
		@DisplayName("正の値")
		void test() {
			assertEquals(1, calc.minus(2, 1));
		}

		@Test
		@DisplayName("負の値")
		void test2() {
			assertEquals(1, calc.minus(-1, -2));
		}
	}

}
