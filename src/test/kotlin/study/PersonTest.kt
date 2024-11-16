package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

data class Person(
    val name: String,
    val age: Int,
    val nickname: String? = name,
)

class PersonTest {
    @Test
    fun isPerson() {
        val person = Person(name = "홍길동", age = 42, nickname = "홍")
        val person2 = Person(age = 42, name = "홍길동", nickname = "홍")
        assertThat(person.name).isEqualTo("홍길동")
        assertThat(person2.name).isEqualTo("홍길동")
    }

    @Test
    fun `널 타입`() {
        val person = Person(name = "홍길동", age = 42, nickname = null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person(name = "홍길동", age = 42)
        assertThat(person.nickname).isEqualTo("홍길동")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "홍길동", age = 30)
        val person2 = Person(name = "홍길동", age = 30)
        assertThat(person1).isEqualTo(person2)
    }
}
