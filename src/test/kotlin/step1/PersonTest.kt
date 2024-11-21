package step1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


class PersonTest {
	@DisplayName("이름, 나이, 별명을 가진 사람을 생성할 수 있다")
	@Test
	fun createPersonTest() {
		val expected = Person(name = "홍길동", age = 30, nickname = "길동")
		assertThat(expected.name).isEqualTo("홍길동")
		assertThat(expected.age).isEqualTo(30)
		assertThat(expected.nickname).isEqualTo("길동")
	}

	@DisplayName("닉네임이 없는 경우 null로 초기화한다")
	@Test
	fun initialNicknameIsNull() {
		val expected = Person(name = "홍길동", age = 30, nickname = null)
		assertThat(expected.nickname).isNull()
	}

	@DisplayName("닉네임이 없어도 생성할 수 있다")
	@Test
	fun createPersonWithoutNickname() {
		val expected = Person(name = "홍길동", age = 30)
		assertThat(expected.nickname).isEqualTo(null)
	}

	@DisplayName("데이터 클래스")
	@Test
	fun createDataClass() {
		val person1 = DataPerson(name = "홍길동", age = 30)
		val person2 = DataPerson(name = "홍길동", age = 30)
		assertThat(person1).isEqualTo(person2)
	}
}