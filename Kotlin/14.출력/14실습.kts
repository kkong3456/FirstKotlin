//2. 변수를 출력하는 방법
val name = "이름"
val myName = "홍길동"

println("내 $name 은 $myName 입니다.")

val number1 = 10
var number2 = 100
println("$number1 더하기 $number2 는 ${number1 + number2}")

//특수믄지
println("\$myName")
println("${myName}")
println("${"myName"}")
println("${"$myName"}")

//java style
println(""+number1+" 더하기 "+number2+" 는 "+(number1+number2))//맨앞의 ""는 문자열+다른타입 형태로 만들기 위해서 추가한 것이다.

println("안녕하세요"+10)  //문자열+다른타입 ==>문자열  "안녀하세요10"
println(10+"안녕하세요")  //에러