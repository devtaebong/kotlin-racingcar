package racingcar.view

import racingcar.domain.history.CarHistories

data class CarsInfoResultViewModel(val carsInfo: List<CarHistories>)

data class GameWinnerResultViewModel(val winners: List<String>)
