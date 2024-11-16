package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringTest {
    @Test
    fun isBlank() {
        val str = " "
        assertThat(str.isBlank()).isEqualTo(true)
    }

    @Test
    fun isNotBlank() {
        val str2 = "a"
        assertThat(str2.isBlank()).isEqualTo(false)
    }
}
