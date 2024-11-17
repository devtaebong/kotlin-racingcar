package racingcar.application

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.ints.shouldBeInRange
import racingcar.application.DefaultRandomGenerator.generate

class RandomNumberGeneratorTest : StringSpec({
    "until을 제외한 수까지 생성한다" {
        listOf(1, 2, 3, 4, 5).forAll {
            generate(it) shouldBeInRange 0..<it
        }
    }
})
