package my;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// junit5上で、junit4を実行するために、pom.xmlにorg.junit.vintageを追加する
public class Junit4Test {

	// Juinit4からの移行のヒント
    // https://junit.org/junit5/docs/current/user-guide/#migrating-from-junit4-tips
    // https://oohira.github.io/junit5-doc-jp/user-guide/#migrating-from-junit4-tips

	@Test
	public void test() {
		assertEquals(0, 0);
	}

}
