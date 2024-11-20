package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import racingcar.domain.Round

class RoundTest : StringSpec({

    "Round는 1 미만이면 IllegalArgumentException가 발생합니다." {
        // when & then
        shouldThrow<IllegalArgumentException> {
            Round(0)
        }.shouldHaveMessage("라운드는 1 이상이어야 합니다. input = 0")
    }

    "Round는 1 이상이면 생성됩니다." {
        // when
        val round = Round(1)

        // then
        round.value shouldBe 1
    }

    "Round의 end는 하나의 라운드가 종료될 때마다 남은 라운드 수를 차감합니다." {
        // given
        val round = Round(3)

        // when
        round.end()

        // then
        round.value shouldBe 2
    }

    "Round의 isFinished는 마지막 라운드가 종료되면 true를 발생합니다." {
        // given
        val round = Round(1)
        round.end()

        // when & then
        val finished = round.isFinished()
        finished shouldBe true
    }
})
