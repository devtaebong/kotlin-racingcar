package racingcar.domain

import java.security.SecureRandom

class SecureNumberGenerator : NumberGenerator {
    override fun generate(): Int {
        return SecureRandom.getInstanceStrong().nextInt(RANDOM_ORIGIN, RANDOM_BOUND)
    }

    companion object {
        const val RANDOM_ORIGIN = 0
        const val RANDOM_BOUND = 10
    }
}
