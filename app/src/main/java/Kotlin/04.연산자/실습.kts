val number1:Int=1+10
val number2:Int=2-10
val number3:Int=2*40
val number4:Int=40/2
val number5:Int=45%7
println(number5)

val number6=10*427/73+108  //타입을 예상하기 어려울때는 옆에와 같이 변수를 정의해도 된다.
println(number6)

var number7:Int=22
println(number7)
number7=100
println(number7)

var number8:Int=12
number8+=8
number8-=10
number8*=2
number8/=5
println(number8)

var number9:Int=9
println(number9++) //9
println(number9)  //10

println(++number9)  //11

//비교연산자
val number10:Int=1
val number11:Int=2
val result:Boolean=number10>number11
println(result)

val result2:Boolean=number10==number11
println(result2)

val result3:Boolean=number10!=number11
println(result3)

//===.!==  잘사용하지 않는다, 주소값이 같은지 물어보는 연산자
//==,!= 값이 같은지 물어보는 연산자
// 변수/인스턴스 생성시 값은 메모리 어디엔가 저장되어 있고, 변수/인스턴스명은 그 메로리의 주소값을 가리키고(가지고)있다.

//논리연산자
val boolean1:Boolean=true
val boolean2:Boolean=false
val result4:Boolean=boolean1 && boolean2
println(result4)

var result5:Boolean=boolean1 || boolean2
println(result5)