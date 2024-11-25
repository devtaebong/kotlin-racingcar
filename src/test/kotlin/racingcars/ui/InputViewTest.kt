package racingcars.ui

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows

class InputViewTest : DescribeSpec({
    describe("Input from user") {
        context("when user provides invalid input") {
            it("number of car input value less than 1, should throw exception") {
                val sut = InputView { "0" }

                // when, then
                val exception =
                    shouldThrow<IllegalArgumentException> {
                        sut.getNumberOfCars()
                    }

                exception.message shouldBe "유효한 값을 입력해주세요"
            }

            it("number of car input value is not Int, should throw exception") {
                // given
                val sut = InputView { "ABC" }

                // when, then
                val exception =
                    shouldThrow<IllegalArgumentException> {
                        sut.getNumberOfCars()
                    }

                exception.message shouldBe "유효한 값을 입력해주세요"
            }
        }
    }

    describe("Input Car Names") {
        context("accept names separated by commas") {
            it("should convert to List") {
                val sut = InputView { "pobi,crong,honux" }
                val actual = sut.getCarNames()
                actual[0] shouldBe "pobi"
                actual[1] shouldBe "crong"
                actual[2] shouldBe "honux"
            }
        }

        context("when input is blank") {
            it("should be throw an exception") {
                val sut = InputView { "   " }
                assertThrows<IllegalArgumentException> {
                    sut.getCarNames()
                }
            }
        }

        context("when invalid characters") {
            it("should be throw an exception") {
                val sut = InputView { "포비,크롱" }
                assertThrows<IllegalArgumentException> {
                    sut.getCarNames()
                }
            }
        }

        context("when input length greater than five") {
            it("should be throw an exception") {
                val sut = InputView { "abcdefg" }
                assertThrows<IllegalArgumentException> {
                    sut.getCarNames()
                }
            }
        }
    }
})
