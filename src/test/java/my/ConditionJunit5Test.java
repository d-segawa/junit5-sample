package my;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

//ユーザガイド
//https://oohira.github.io/junit5-doc-jp/user-guide/#writing-tests-conditional-execution
//https://junit.org/junit5/docs/current/user-guide/#writing-tests-conditional-execution
@DisplayName("前提条件")
class ConditionJunit5Test {

	@Test
	@DisplayName("AssumeTest")
	void test() {
		// 条件に一致した場合のみ、後続を行う
		assumeTrue("DEV".equals(System.getenv("env")));
		
		// テストはNGにならない
		fail();
	}

	@Test
	@DisplayName("JVMシステムプロパティの値が存在する場合、実行する")
	@EnabledIfSystemProperty(named = "env", matches = "DEV")
	void test2() {
		// JVMシステムプロパティにenv=DEVが存在しないので、実行されない
		fail();
	}

	@Test
	@DisplayName("JVMシステムプロパティの値が存在しない場合、実行する")
	@DisabledIfSystemProperty(named = "env", matches = "DEV")
	void test3() {
		// JVMシステムプロパティにenv=DEVが存在しないので、実行される
		assertTrue(true);
	}
	
	@Test
	@DisplayName("環境変数に値が存在する場合、実行する")
	@EnabledIfEnvironmentVariable(named = "env", matches = "STG")
	void test4() {
		// 環境変数にenv=STGが存在しないので、実行されない
		fail();
	}

	@Test
	@DisplayName("環境変数に値が存在しない場合、実行する")
	@DisabledIfEnvironmentVariable(named = "env", matches = "STG")
	void test5() {
		// 環境変数にenv=STGが存在しないので、実行される
		assertTrue(true);
	}

}
