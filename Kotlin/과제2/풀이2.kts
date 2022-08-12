fun plusArth(num:Int):Int{
    var arthSum:Int=0
    for(i in 1..num){
        arthSum+=i
    }
    return arthSum
}
println(plusArth(10))