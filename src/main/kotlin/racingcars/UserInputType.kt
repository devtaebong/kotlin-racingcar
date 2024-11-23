package racingcars

enum class UserInputType(val message: String) {
    CAR_NAME("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    NUMBER_OF_CARS("자동차 대수는 몇 대인가요?"),
    ATTEMPT_COUNT("시도할 횟수는 몇 회인가요?"),
}
