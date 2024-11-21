package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class GameRoundTest : StringSpec({

    "게임 판수는 인자가 널이면 예외를 던진다.." {
        shouldThrow<IllegalArgumentException> { GameRound(null) }
    }

    "게임 판수는 인자가 숫자가 아니면 초기화 시 예외를 던진다." {
        shouldThrow<IllegalArgumentException> { GameRound("number") }
    }

    "게임 판수는 인자가 음수면 초기화시 예외를 던진다." {
        shouldThrow<IllegalArgumentException> { GameRound("-1") }
    }

    "게임 판수는 음수로 감소 시킬 수 없다." {
        val gameRound = GameRound("2")

        shouldThrow<IllegalStateException> {
            repeat(3) {
                gameRound.proceed()
            }
        }
    }
})
