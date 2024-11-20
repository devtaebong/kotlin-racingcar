# kotlin-racingcar

### TODO
- private val로 선언하고 필요에 따라 getter를 사용하는 방법으로 하는게 권장되는게 맞는지 알아보기
  - 공식 문서에 있으려나..?
- 주생성자 부생성자(단점) 정리하기
  - 팩터리 메서드를 권장하는데 사용 방법이 여러가지가 있는듯
- companion object vs object class in Kotlin 정리하기
- data class를 적극 사용하기
- var를 val로 웬만해선 전부 변경하기

## 5단계

### 피드백

- [x] 가변 프로퍼티(var)를 외부에 공개해야 한다면 setter는 private으로 제한
```kotlin
class Car(val name: String) {
    var position: Int = 0
        private set
}
```
- [x] domain에 view와 관련된 내용을 분리
- [x] maxOf 분리


### 요구사항 분석

- MVC 패턴으로 구현
  - Model: VO
  - View: InputView, OutputView
  - Controller: RacingGame
- 테스트 가능한 부분과 테스트 하기 힘든 부분을 분리해 테스트 가능한 부분에 대해서만 단위 테스트 진행


---

## 4단계

### 피드백

- [x] 멤버변수의 값을 노출해야 한다면 가시성을 private이 아닌 public으로 변경
- [x] Car, Cars에 VIEW에 해당하는 정보들에 대해서 어떻게 처리해야할지 고민
  - ex) Car.getDisplayDistance()."-"
  - ex) Cars.print()
- [ ] kotest 피드백
  - https://kotest.io/docs/framework/datatesting/data-driven-testing.html
- [ ] 익명함수로 테스트에서 인터페이스를 구현하는 방법 숙지



### 요구사항 분석

- [x] 각 자동차에 이름을 부여한다. 단, 자동차의 이름은 5글자를 초과할 수 없다.
- [x] 자동차의 상태를 출력할 때 자동차의 이름도 함께 출력한다.
- [x] 자동차의 이름은 쉼표(,)를 기준으로 구분한다.
  - ex) pobi,crong,honux
  - 궁금: 만약 인풋 테스트도 해야 한다면 테스트 케이스에 '.' 또는 쉼표가 없는 경우에 대해서도 테스트 시나리오에 포함되어야 하는가?
  - -> 자문자답: 당연. 클라이언트에서 벨리데이션을 안할수도있고, 악의적인 사용자의 요청이 올수도 있기 때문
- [x] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- [ ] indent depth가 2를 넘지 않도록 구현한다
- [ ] 함수의 길이가 15라인을 넘지않도록 구현한다
- [ ] 기능을 구현하기전에 README에 명세서를 작성하고, 기능별로 커밋한다 
  - 다음 미션부터는 구현 기능별로 커밋하기..!
- [ ] 모든 로직에 단위 테스트를 구현한다
  - [ ] UI 로직과 비즈니스 로직을 분리한다

---

## 3단계

### 셀프 피드백

- if로 validate를 하기보다 코틀린 표준 라이브러리를 사용하기
  - require, checkNotNull 등
- 람다 인자에 사용되는 방법이 여러가지 알아보고 어느때 사용해야 하는지 정리하기
  - 메서드 레퍼런스 사용 (::)
  - 암시적 변수 사용 (it)
  - 명시적 변수 사용 (car -> car.move())
- 특정 횟수만큼 단순 반복일때 for-loop보다 repeat 함수 사용하기 (코틀린 표준 라이브러리)
  - inline 함수가 무엇인지 알아보기
  - https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/repeat.html
```kotlin
@kotlin.internal.InlineOnly
public inline fun repeat(times: Int, action: (Int) -> Unit) {
    contract { callsInPlace(action) }

    for (index in 0 until times) {
        action(index)
    }
}
```


### 피드백

- 2단계의 Expression은 의미를 가지는 객체로 분리
  - Calculator에서의 Expression은 충분한 의미를 가지는 개념이기 때문에 ok ! [피드백](https://github.com/next-step/kotlin-racingcar/pull/1653#discussion_r1844950653)
- 상수 또는 변수의 이름으로 조금 더 의미를 부여하도록 변경
  - as-is: WHITE_SPACE
  - to-be: TOKEN_DELIMITER
- for-loop를 내재화 시켜보기
  - 

---

## 2단계

### 피드백

- class로 선언하는 것과 object로 선언하는 것의 차이
  - class는 다중 인스턴스 생성이 가능한 반면, object는 싱글톤으로 생성됨
    - *상태를 가지지 않는다는 의미는 아직 잘 이해하지 못함
    - *object에 fun이 class.method의 형태로 호출해서 static 메서드인줄 알았는데 그렇지 않음
  - 
- companion object
  - 클래스 정의와 동시에 객체를 생성
- 구체적인 자료형 (Name, Money 등)
- !! 연산자 사용을 지양
  - requireNotNull, checkNotNull