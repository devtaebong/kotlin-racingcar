package step2

sealed class CalculationState {
    data class Success(val result: CalculationResult) : CalculationState()

    data class Error(val message: String) : CalculationState()
}
