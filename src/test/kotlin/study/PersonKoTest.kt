package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val actual = Person(name = "김보라", nickname = "보라", age = 20)
        actual.name shouldBe "김보라"
        actual.age shouldBe 20
        actual.nickname shouldBe "보라"
    }

    "널 타입" {
        val actual = Person(name = "김보라", age = 20, nickname = null)
        actual.nickname.shouldBeNull()
    }

    "기본 인자" {
        val actual = Person(name = "김보라", age = 20)
        actual.nickname shouldBe "김보라"
    }

    "데이터 클래스" {
        val person1 = Person(name = "김보라", age = 20)
        val person2 = Person(name = "김보라", age = 20)
        person1 shouldBe person2
    }
})
