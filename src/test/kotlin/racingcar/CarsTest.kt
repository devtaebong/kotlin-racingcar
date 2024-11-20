package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.Car
import racingcar.domain.CarName
import racingcar.domain.CarNames
import racingcar.domain.Cars
import racingcar.domain.NumberGenerator

class CarsTest : StringSpec({

    fun constant(value: Int): NumberGenerator {
        return object : NumberGenerator {
            override fun generate(): Int = value
        }
    }

    "Cars는 여러 대의 자동차를 가질 수 있다" {
        // given
        val cars = Cars(listOf(Car(CarName("pobi")), Car(CarName("crong"))))

        // when & then
        cars.cars.size shouldBe 2
    }

    "Cars는 콤마(,)를 기준으로 자동차를 구분하고, 이름을 부여한다." {
        // given
        val cars = Cars.joined(CarNames.from(listOf("pobi", "crong")))

        // when & then
        cars.cars.size shouldBe 2
        cars.cars.get(0).getCarNameValue() shouldBe "pobi"
        cars.cars.get(1).getCarNameValue() shouldBe "crong"
    }

    "Cars는 숫자 생성 전략에 의해 움직임이 결정된다 (4 이상이면 전진)" {
        // given
        val cars = Cars.joined(CarNames.from(listOf("pobi", "crong")))

        // when
        cars.move(constant(4))

        // then
        cars.cars[0].distance shouldBe 1
        cars.cars[1].distance shouldBe 1
    }

    "Cars는 숫자 생성 전략에 의해 움직임이 결정된다 (4 미만이면 멈춤)" {
        // given
        val cars = Cars.joined(CarNames.from(listOf("pobi", "crong")))

        // when
        cars.move(constant(3))

        // then
        cars.cars[0].distance shouldBe 0
        cars.cars[1].distance shouldBe 0
    }

    "Cars의 getWinners는 우승자를 출력한다. (단일 우승자)" {
        // given
        val cars = Cars(listOf(Car(CarName("pobi"), 1), Car(CarName("crong"), 2)))

        // when
        val winners = cars.getWinners()

        // then
        winners.size shouldBe 1
        winners.get(0) shouldBe "crong"
    }

    "Cars의 getWinners는 우승자를 출력한다. (다수 우승자)" {
        // given
        val cars = Cars(listOf(Car(CarName("pobi"), 2), Car(CarName("crong"), 2)))

        // when
        val winners = cars.getWinners()

        // then
        winners.size shouldBe 2
        winners.get(0) shouldBe "pobi"
        winners.get(1) shouldBe "crong"
    }
})
