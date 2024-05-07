//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val name = "Kotlin"
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Hello, " + name + "!")

    for (i in 1..5) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        println("i = $i")
    }

    var calc = Calculator()
//#1
    //add를 호출하면서 인자를 1,2 호출하면 Int로 구성된 add 그게 결과를 저장
    var intResult = calc.add(1, 2)
    var doubleResult = calc.add(1.2, 2.2)
//인자를 double형으로 넣으면 add가 double로 구성된 것이 호출돼서 result에 반환
    println("정수 덧셈결과: ${intResult}")
    println("실수 덧셈결과: ${doubleResult}")

}

class Calculator { //Calculator라는 class를 만들었음
    //add를 두개 만듬 add라는 함수는 num1, num2라는 매개변수를 가지는데 둘 다 Int로 만듬
    // 둘 다 더한 값을 리턴한다.

    fun add(num1: Int, num2: Int): Int { // 구분하기 위해 출력문 추가
        println("int형 add 입니다.")
        return num1 + num2
    }
//오버로딩을 사용해서 함수를 다시 한번 정의하면서 이번에는 Double형으로 매개변수를 받음
    //더한 값을 return

    fun add(num1: Double, num2: Double): Double {
        println("double형 add 입니다.")
        return num1 + num2
        //이렇게 오버로딩을 하면 두가지로 정의할 수가 있고 #1 호출할 때마다 인자를 어떻게 넘겼는지에 따라서
        //각각 다른 함수가 호출이 된다.

    }
}
