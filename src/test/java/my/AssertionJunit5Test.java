package my;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// ユーザガイド
// https://oohira.github.io/junit5-doc-jp/user-guide/#writing-tests-assertions
// https://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions
@DisplayName("アサーション")
class AssertionJunit5Test {

	@Test
	@DisplayName("グループ化 失敗をまとめてレポート")
	void assertAll1() {
		assertAll("person", () -> assertTrue(false), () -> assertTrue(false));
	}

	@Test
	@DisplayName("グループ化されたメッセージは、それぞれが独立して実行される")
	void assertAll2() {
		assertAll("messageTest", () -> {

			String message = null;
			assertNotNull(message);
		}, () -> {

			String message2 = "testMessage";
			assertEquals("abc", message2);
		});
	}

	@Test
	@DisplayName("Exceptionテスト")
	void assert3() {

		assertThrows(RuntimeException.class, () -> {
			
			this.throwException();

			// テスト失敗
//			throw new IOException();
		});
	}

	void throwException() {
		throw new RuntimeException();
	}
	
	
	
	@Test
	@DisplayName("Timeoutのテスト")
	void assert4() {
		
		assertTimeout(Duration.ofSeconds(2), () -> {
			// 2秒以内に処理が終われば成功
			sleep(1);
		});
	}

	
	
	
	void sleep(int i) {
		try {
			TimeUnit.SECONDS.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
