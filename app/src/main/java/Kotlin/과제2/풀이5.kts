//val grades=arrayOf<Int>(70,71,72,77,78,79,80,82,90,99)
//
//val passOrNot=Array<Boolean>(10,{true})
//fun passOrNot():Unit{
//    for ((index,grade) in grades.withIndex()){
//        if(grade>=80){
//            passOrNot[index]=true
//        }else{
//            passOrNot[index]=false
//        }
//    }
//
//    for (i in 0 until passOrNot.size){
//        println(passOrNot[i])
//    }
//}
//
//passOrNot()

val grades:List<Int> = listOf<Int>(70,71,72,77,78,79,80,82,90,99)
fun checkPassOrNot(examScore:List<Int>):BooleanArray{
    val resultArray:BooleanArray=BooleanArray(examScore.size,{false})
    examScore.forEachIndexed { index, score ->
        if(score>=80) resultArray[index]=true
    }
    return resultArray
}

val result:BooleanArray=checkPassOrNot(grades)
result.forEach{
    println(it)
}

