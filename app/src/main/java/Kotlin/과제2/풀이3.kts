//7의 배수 합
fun sevenSum():Int{
    var result:Int=0
    for(i in 1..100){
        if(i%7==0){
            result+=i
        }
    }
    return result
}

println(sevenSum())