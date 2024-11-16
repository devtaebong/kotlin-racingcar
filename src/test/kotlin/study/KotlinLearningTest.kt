package study

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class KotlinLearningTest {
    @Test
    fun `named arguments`() {
        val people = listOf(
            Person("김설영", 100, "딱구"),
            Person("김설영", 100, nickname = "딱구"),
            Person(nickname = "딱구", name = "김설영", age = 100)
        )

        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("김설영")
            assertThat(it.age).isEqualTo(100)
            assertThat(it.nickname).isEqualTo("딱구")
        }
    }

    @Test
    fun `nullable type`() {
        val person = Person("김설영", null, null)

        assertAll(
            { assertThat(person.name).isEqualTo("김설영") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() },
        )
    }

    @Test
    fun `default arguments`() {
        val person = Person("김설영")

        assertAll(
            { assertThat(person.name).isEqualTo("김설영") },
            { assertThat(person.age).isEqualTo(0) },
            { assertThat(person.nickname).isEmpty() },
        )
    }

    @Test
    fun `data classes`() {
        val dataPerson1 = DataPerson("김설영", 100, "딱구")
        val dataPerson2 = DataPerson("김설영", 100, "딱구")
        val dataPerson3 = DataPerson("김설영", 10000, "딱구")

        assertAll(
            { assertThat(dataPerson1).isEqualTo(dataPerson2) },
            { assertThat(dataPerson1).isNotEqualTo(dataPerson3) },
        )
    }
}

