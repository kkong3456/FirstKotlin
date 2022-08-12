import java.lang.IllegalArgumentException

val numbers: List<Int> = listOf<Int>(1, 2, 3)
try{
    numbers.get(5)
}catch(yyy:Exception){
    println(yyy)
}

try{
    numbers.get(6)
}catch(exception:IllegalArgumentException){
    println("예외발생 A")
}catch(exception:ArrayIndexOutOfBoundsException){
    println("예외발생 B")
}finally {
    println("프로그램 종료")
}