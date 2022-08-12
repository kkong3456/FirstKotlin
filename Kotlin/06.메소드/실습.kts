fun plusNumbers(first_num: Int, second_num: Int):Int {
    val result: Int = first_num + second_num
    return result
}

val xxx: Int = plusNumbers(5, 3)
println(xxx)

fun plusNumbersWithDefault(first_num:Int,second_num:Int=10):Int{
    return first_num+second_num
}

println(plusNumbersWithDefault(10))
val yyy:Int=plusNumbersWithDefault(15)
println(yyy)

println(plusNumbersWithDefault(10,20))

//반환값이 없는 함수
fun plusNumbersWithNoReturn(first_num:Int,second_num:Int):Unit{
    val result:Int=first_num+second_num
    println(result)
}

plusNumbersWithNoReturn(5,5)

fun plusNumbersWithNoReturn2(first_num:Int,second_num:Int){
    val result:Int=first_num+second_num
    println(result)
    return
}

plusNumbersWithNoReturn2(10,55)


//함수선언을 간단하게 하는 방법
fun shortPlusNumber(firstNum:Int,secondNum:Int) = firstNum + secondNum
val result10:Int=shortPlusNumber(firstNum=55,secondNum=55)
println(result10)

//가변 인자를 갖는 함수
fun plusMultipleNumbers(vararg numbers:Int):Unit{
    for(number in numbers){
        println(number)
    }
}

//plusMultipleNumbers(...numbers:1,2,3,4,5)  ==> 안됨??