var number:Int=1

fun changeNumber():Unit{
//    val internalNumber:Int=2
    number=20  //하위 범위의 변수가 상위범위의 변수를 재정의

    var number:Int=100
    println(number)
}

changeNumber()
println(number)

//internalNumber:20  상위 스코프에서 하위 스코프 재정의/접근 안됨

class Number constructor(private var number:Int=10){
    fun changeNumber(){
        this.number=100
    }
    fun returnNumber():Int{
        return this.number
    }
}

val numbers=Number()
numbers.changeNumber()
println(numbers.returnNumber())
