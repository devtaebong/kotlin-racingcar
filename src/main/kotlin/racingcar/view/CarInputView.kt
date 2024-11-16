package racingcar.view

class CarInputView(
    private val input: InputView,
) {
    fun inputView(text: String): Int {
        println(text)
        return input.getInput()
    }
}
