package racingcar.view

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.io.ByteArrayInputStream

class InputViewTest : StringSpec({

    "입력값을 받으면 그대로 출력한다." {
        // given
        val input = 5
        System.setIn(ByteArrayInputStream(input.toString().toByteArray()))
        val inputView = InputView()

        // when
        val result = inputView.getInput()

        // then
        result shouldBe input
    }
})
