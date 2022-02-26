
#Junit5

```
JUnit 5 User Guide
https://junit.org/junit5/docs/current/user-guide/#overview-what-is-junit-5

JUnit 5 User Guide 日本語訳 oohiraさん
https://oohira.github.io/junit5-doc-jp/user-guide/#overview-what-is-junit-5

Junit5の色々なサンプルプロジェクト
https://github.com/junit-team/junit5-samples

```



## junit5 = junit platform + junit jupiter + junit vintage

## Junit Platform
- junitを実行するプラットフォーム
- TestEngineAPI・・・テストフレームワークを開発できる
- ConsoleLancher・・・コマンドラインから実行できる
- Gradle、Mavenプラグイン
- junit4ベースのテストランナー

## Junit jupiter
- junit5でテストを書くためのライブラリ
- Jupiterベースのテストを実行するためのTestEngineを提供する

## Junit vintage
- junit3, junit4を実行するためのTestEngieを提供する

## ライブラリ
- ライブラリが複数あり、依存関係があるが、まとめているbom.xmlがあるので、mavenで使う場合はそちらを指定すれば良い

```
	<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.junit</groupId>
				<artifactId>junit-bom</artifactId>
				<version>5.8.2</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>
	
	<dependencies>
		<dependency>
			<groupId>org.junit.jupiter</groupId>
			<artifactId>junit-jupiter</artifactId>
			<scope>test</scope>
		</dependency>
		
		<!-- junit5でjunit4を実行するためにjunit-vintage-engineが必要 -->
		<dependency>
			<groupId>org.junit.vintage</groupId>
			<artifactId>junit-vintage-engine</artifactId>
			<scope>test</scope>
		</dependency>

		<!-- assertj -->
		<dependency>
			<groupId>org.assertj</groupId>
			<artifactId>assertj-core</artifactId>
			<version>3.22.0</version>
			<scope>test</scope>
		</dependency>

		<!-- Junit4 -->
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.13.2</version>
			<scope>test</scope>
		</dependency>
	</dependencies>

```

- SpringBootは,spring-boot-starter-testに, junit-jupiter、assertjが含まれている

```
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.6.4</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>


	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
```

## サンプルテストケースの説明
- FirstJUnit5Test.java
	- テストを実行するための基本的なアノテーション


- ConditionJunit5Test.java
	- テストの実行条件を設定するサンプル


- AssertionJunit5Test.java
	- Junit5のAssertionの説明


- AssertJJunit5Test.java
	- サードパーティのライブラリassertj


- ParameterJunit5Test.java
	- テストケースで引数を受け取るサンプル


- NestedJunit5Test.java
	- テストケースをグループ化するサンプル


- Junit4Test.java
	- Junit5上で、Junit4を実行する



