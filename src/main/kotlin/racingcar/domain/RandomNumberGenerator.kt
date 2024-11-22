package racingcar.domain

import java.security.SecureRandom

class RandomNumberGenerator : NumberGenerator {
    override fun getNumber(): Int {
        val secureRandom = SecureRandom()
        return secureRandom.nextInt(MAX_NUMBER)
    }

    companion object {
        const val MAX_NUMBER = 9
    }
}
