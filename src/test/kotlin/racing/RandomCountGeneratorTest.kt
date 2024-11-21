package racing

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeBetween
import racing.infrastructure.RandomNumberGenerator

class RandomCountGeneratorTest : StringSpec({
    "0 ~ 9 사이의 임의의 숫자를 생성할 수 있다" {
        val countGenerator = RandomNumberGenerator()

        val actual = countGenerator.generate()

        actual.shouldBeBetween(0, 9)
    }
})
