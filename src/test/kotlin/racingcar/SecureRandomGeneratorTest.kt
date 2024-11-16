package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeInRange
import racingcar.SecureRandomGenerator.Companion.RANDOM_BOUND
import racingcar.SecureRandomGenerator.Companion.RANDOM_ORIGIN

class SecureRandomGeneratorTest : StringSpec({

    "랜덤 숫자가 0이상 9이하인지 확인한다" {
        // given
        val secureRandomGenerator = SecureRandomGenerator()

        // when
        val result = secureRandomGenerator.generate()

        // then
        result shouldBeInRange RANDOM_ORIGIN..RANDOM_BOUND
    }
})
