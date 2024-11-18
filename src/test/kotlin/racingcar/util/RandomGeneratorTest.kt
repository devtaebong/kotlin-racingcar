package racingcar.util

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ranges.shouldBeIn

class RandomGeneratorTest : FunSpec({

    test("generate()는 인자로 들어온 구간의 난수를 반환한다.") {
        RandomGenerator().generate(1..9) shouldBeIn (1..9)
    }
})
