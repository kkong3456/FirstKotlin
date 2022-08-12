fun addTwoNum(num1:Int?,num2:Int?):Int{
  //함수에서 받은 인자 num1,num2 는 val 로 재 초기화 안됨
//    if(num1==null){
//        num1=0
//    }
//    if(num2==null){
//        num2=0
//    }
//    return num1+num2

    val first:Int=if(num1==null) 0 else num1
    val second:Int=if(num2==null) 0 else num2
    return first+second
}

println(addTwoNum(null,1))