package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarsTest : StringSpec({

    "Cars는 여러 대의 자동차를 가질 수 있다" {
        // given
        val cars = Cars(listOf(Car("pobi"), Car("crong")))

        // when & then
        cars.getCars().size shouldBe 2
    }

    "Cars는 콤마(,)를 기준으로 자동차를 구분하고, 이름을 부여한다." {
        // given
        val carNames = "pobi,crong"
        val cars = Cars.joined(carNames)

        // when & then
        cars.getCars().size shouldBe 2
        cars.getCars().get(0).getName() shouldBe "pobi"
        cars.getCars().get(1).getName() shouldBe "crong"
    }

    "Cars는 숫자 생성 전략에 의해 움직임이 결정된다" {
        // Cars.move의 테스트 시나리오를 무엇이
    }

    "Cars의 print는 자동차의 이름과 전진한 거리를 출력한다" {
        // 테스트 시나리오의 일부로 되어야 하는지
        // 고민: 값을 반환해서 테스트 가능하도록 변경해야 하는것인지
    }

    "Cars의 getWinners는 우승자를 출력한다. (단일 우승자)" {
        // given
        val cars = Cars(listOf(Car("pobi", 1), Car("crong", 2)))

        // when
        val winners = cars.getWinners()

        // then
        winners.size shouldBe 1
        winners.get(0).getName() shouldBe "crong"
    }

    "Cars의 getWinners는 우승자를 출력한다. (다수 우승자)" {
        // given
        val cars = Cars(listOf(Car("pobi", 2), Car("crong", 2)))

        // when
        val winners = cars.getWinners()

        // then
        winners.size shouldBe 2
        winners.get(0).getName() shouldBe "pobi"
        winners.get(1).getName() shouldBe "crong"
    }
})
