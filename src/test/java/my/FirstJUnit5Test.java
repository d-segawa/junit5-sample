package my;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// ユーザガイド
// https://oohira.github.io/junit5-doc-jp/user-guide/#writing-tests-classes-and-methods
// https://junit.org/junit5/docs/current/user-guide/#writing-tests-classes-and-methods

// publicクラスじゃなくても良い
@DisplayName("基本的なアノテーション")
class FirstJUnit5Test {
	
	// publicメソッド出なくても良い
	// メソッド名は、test始まりじゃなくても良い
	// @Testがついているメソッドをテストメソッドとして扱う
	@Test
	void frist() {
		Calculator cl = new Calculator();
		assertEquals(3, cl.add(1, 2));
		System.out.println("   TestCase1 : hashCode" + this.hashCode());
	}

	// @Disabledをつけたテストケースは実行されない
	// 無効化にした理由を書いておくと良い
	@Test
	@Disabled("不具合対応が完了するまで無効化")
	void noTest() {
		fail();
	}

	@Test
	@DisplayName("正常系のレスポンスのパターン😀")
	void displayName() {
		assertTrue(true);
		System.out.println("   TestCase2 : hashCode" + this.hashCode());
	}

	
	// 全てのテストメソッドの前に1回だけ実行される
	// static メソッド
	@BeforeAll
	static void beforeAll() {
		System.out.println("Before All");
		System.err.println(""); // 表示調整用
	}

	// テストメソッドの前に毎回実行される
	// テストメソッドと同じオブジェクト上で実行される
	@BeforeEach
	void beforeEach() {
		System.out.println("  Before Each : hashCode" + this.hashCode());
	}

	// テストメソッドの後に毎回実行される
	// テストメソッドと同じオブジェクト上で実行される
	@AfterEach
	void afterEach() {
		System.out.println("  After Each : hashCode" + this.hashCode());
		System.err.println(""); // 表示調整用
	}

	// 全てのテストメソッドの後に1回だけ実行される
	// static メソッド
	@AfterAll
	static void afterAll() {
		System.out.println("After All");
	}
	
}
