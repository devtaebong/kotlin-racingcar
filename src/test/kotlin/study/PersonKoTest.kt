package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙은 함수" {
        val person = Person("jae", 20)

        person.name shouldBe "jae"
        person.age shouldBe 20
        person.nickname shouldBe "jae"
    }
})
