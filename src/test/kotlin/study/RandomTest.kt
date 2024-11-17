package study

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlin.random.Random

class RandomTest : StringSpec({
    "Random.nextInt() until 파라미터를 넣는 경우 0 부터 until 을 제외한 수까지 생성한다" {
        Random.nextInt(until = 1) shouldBe 0
    }

    "Random.nextInt() from until 파라미터를 넣는 경우 from 을 포함한 수부터  until 을 제외한 수까지 생성한다" {
        Random.nextInt(from = 1, until = 2) shouldBe 1
    }

    "Random.nextInt() from 과 until 에 같은 수를 넣는 경우 예외 발생한다" {
        shouldThrowWithMessage<IllegalArgumentException>("bound must be greater than origin") {
            Random.nextInt(from = 1, until = 1)
        }
    }
})
