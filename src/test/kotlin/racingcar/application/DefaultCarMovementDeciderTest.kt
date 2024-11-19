package racingcar.application

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlin.random.Random

class DefaultCarMovementDeciderTest : StringSpec({
    "랜덤값이 임계값보다 클 경우 true 반환한다" {
        val customRandom =
            object : Random() {
                override fun nextBits(bitCount: Int): Int = 0

                override fun nextInt(
                    from: Int,
                    until: Int,
                ): Int = 4
            }
        val decider = DefaultCarMovementDecider(random = customRandom)
        decider.canMove() shouldBe true
    }

    "랜덤값이 임계값보다 작을 경우 false 반환한다" {
        val customRandom =
            object : Random() {
                override fun nextBits(bitCount: Int): Int = 0

                override fun nextInt(
                    from: Int,
                    until: Int,
                ): Int = 3
            }
        val decider = DefaultCarMovementDecider(random = customRandom)
        decider.canMove() shouldBe false
    }
})
