package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringTest {
    @Test
    fun isEmpty() {
        assertThat("".isEmpty()).isTrue()
        assertThat(" ".isEmpty()).isFalse()
        assertThat("a".isEmpty()).isFalse()
        assertThat(" ".isBlank()).isTrue()
        assertThat("".isBlank()).isTrue()
        assertThat("".isNotBlank()).isFalse()
    }
}
