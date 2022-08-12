val number1:Int=30

//간단하게
if(number1==10) println("10 입니다.")
else if(number1==20) println("20입니다.")
else println("30입니다.")

val number2:Int=10+20
val number3:Int=if(number2>30) 40 else 50

println(number3)

val number4:Int=8
when(number4){
    5->{
        println("5입니다.")
    }
    6->{
        println("6입니다.")
    }
    else->{
        println("모르겠습니다.")
    }
}

when(number4){
    5->println("26스코프함수")
    6->println("YYY")
    else->println("kkk")
}

//when(number4){
//    5->println("ooo")
//    "안녕하세요"->println("hi")
//    is Boolean->println("boolean")
//} 안됨

when(number4){
    in 1..5->println("ok")
    in 5..10->println("nok")
}