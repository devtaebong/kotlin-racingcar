package racingcar

import racingcar.domain.NumberGenerator

class StubNumberGenerator : NumberGenerator {
    // 0~9 사이의 값들을 유연하게 테스트 하기 위해서는..
    override fun generate(): Int {
        return 4
    }
}
