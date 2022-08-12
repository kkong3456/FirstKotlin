val number: Int? = null  //null이 들어갈수 있는 변수 , nullalbe 하다
//val number2:Int=null //null이 들어갈수 없는 변수, non-null
println(number)

val num1: Int = 2 + 5
val num2: Int = 10
val num3: Int = num1 + num2
println(num3) //잘 출력됨


val number2: Int? = 2 + 5
val number3: Int? = 10
//val number4:Int?=number2+number3
//println(number4)  //에러남, number2, number3가 nullable하므로

val number5: Int? = number2!! + number3!!
println(number5)
//!!로 null이 아님을 개발작 보장할수 있다.
//하지만 실제로 null인 경우에는 NPE(NullPointException) 에러가 발생
//결론 : 정말 100% 확신이 있는 경우가 아니면 사용하지 말자