package my;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("AssertThatなどを使うために、サードパーティのライブラリを使う")
class AssertJJunit5Test {

	// AssertJ
	// https://assertj.github.io/doc/#assertj-overview

	@Test
	@DisplayName("AssertJ")
	void test() {
		String message = "Message";

		Assertions.assertThat(message).isEqualTo("Message");

		Assertions.assertThat(message).startsWith("M").endsWith("e").isEqualToIgnoringCase("message");

	}

}
