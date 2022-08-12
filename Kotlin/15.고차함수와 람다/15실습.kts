fun addTwoNumbers(number1:Int,number2:Int):Int{
    return number1+number2
}

//고차함수
fun addTenNine(function:(Int,Int)->Int){
    var result:Int=function(10,9)
    println("결과는 $result 입니다.")
}

addTenNine(::addTwoNumbers)

//람다
//풀버젼
val addTenNine2:(Int,Int)->Int={number1:Int,number2:Int ->
//    val result=number1+number2
//    result
    number1+number2
}

addTenNine(addTenNine2) //::람다함수는 고차함수이므로 ::가 필요없다

//생략버전1
val addTenNine3:(Int,Int)->Int={number1,number2->
    number1+number2
}
addTenNine(addTenNine3)

//생략버전2
val addTenNine4={number1:Int,number2:Int ->
    number1+number2
}
addTenNine(addTenNine4)

//고차함수가 너무 간단한 경우 직접
addTenNine{number1,number2->number1+number2}
println("---------------------------")
//파라미터가 없는 람다 함수
val addTenNine5:()->Int={
    10+9
}
addTenNine(addTenNine5)  //type mismatch error

//파라미터가 한개인 경우 기본적으로 it을 사용한다.(인자명을 바꿀수있다)
val addTenNine6:(Int)->Int={
    10+9
}