//계산기1
class Calculator1 {
    var result: Int = 0
        set(value) {
            field = value
            println("중간 계산 값 : $field")
        }

    fun plusArth(inputNumber: Int) {
        result += inputNumber
    }

    fun minusArth(inputNumber: Int) {
        result -= inputNumber
    }

    fun productArth(inputNumber: Int) {
        result *= inputNumber
    }

    fun divideArth(inputNumber: Int) {
        result /= inputNumber
    }
}

val xxx1 = Calculator1()
xxx1.plusArth(5)
xxx1.minusArth(3)


//println(xxx1.minusArth())
//println(xxx1.productArth())
//println(xxx1.divideArth())

println("1-----------------------------")
//계산기2
class Calculator2 constructor(initialValue: Int = 0) {
    var result: Int

    init {
        this.result = initialValue
    }

    fun calculator(operator: Char, num2: Int) {
//        if (operator == '+') {
//            return result += num2
//        } else if (operator == '-') {
//            return result -= num2
//        } else if (operator == '*') {
//            return result *= num2
//        } else if (operator == '/' && num2 != 0) {
//            return result /= num2
//        } else {
//            println("잘목된 연산입니다.")
//            return 0
//        }
        when (operator) {
            '+' -> this.result += num2
            '-' -> this.result -= num2
            '*' -> this.result *= num2
            '/' -> this.result /= num2
            else -> println("잘못된 연산입니다.")
        }
    }
}

val calculator2 = Calculator2(10)
calculator2.calculator('+', 10)
println(calculator2.result)



println("//22---------------------------------------------------")
//계산기3
//한번에 여러개의 연산을 입력받아야 함 vararg
class Calculator3 {
    var result: Int = 0

    fun calculate(operators:List<Char>,inputNumbers:List<I:q!nt>){
        operators.forEachIndexed { index, operator ->
            _calculate(operator,inputNumbers[index])
        }
    }

    fun _calculate(function: Char, inputNumber: Int) {
        when (function) {
            '+' -> this.result += inputNumber
            '-' -> this.result -= inputNumber
            '*' -> this.result *= inputNumber
            '/' -> this.result /= inputNumber
            else -> println("잘못된 연산입니다.")
        }
    }
}

val calculator3=Calculator3()
calculator3.calculate(listOf<Char>('+','-'),listOf<Int>(10,20))
println(calculator3.result)


