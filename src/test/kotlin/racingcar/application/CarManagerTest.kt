package racingcar.application

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarManagerTest : StringSpec({
    "입력받은 수만큼 차를 생성한다" {
        CarManager.createCars(5).size shouldBe 5
    }
})
