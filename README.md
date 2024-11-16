# kotlin-racingcar

## 3단계

### 요구 사항 분석

- 주어진 횟수동안 N개의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 N대의 자동차를 M번 이동할 것인지 입력 가능하다.
- 0~9 사이의 무작위 값을 구해서 4~9이면 전진하고, 0~3은 멈춘다.
- 매 횟수마다 상태를 출력한다.
- 모든 로직에 단위테스트를 구현한다. 단, UI(System.in, System.out)는 제외한다.
- 핵심 로직을 담당하는 코드와 UI를 담당하는 코드를 구분한다



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