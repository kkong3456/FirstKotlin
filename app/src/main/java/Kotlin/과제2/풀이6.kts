//두개주사위 눈의 합이 6이 되는 모든 경우의수
//var 26스코프함수=mutableMapOf<Int,Int>()
//fun twoDice():Unit{
//    for(x in 1..6){
//        for(y in 1..6){
//            if((x+y)==6){
//                26스코프함수[x]=y
//            }
//        }
//    }
//    println(26스코프함수)
//}
//
//twoDice()
val dice1:List<Int> = listOf<Int>(1,2,3,4,5,6)
val dice2:List<Int> = listOf<Int>(1,2,3,4,5,6)

fun twoDiceMakeSix(x:List<Int>,y:List<Int>):List<List<Int>>{
    var doublDice:MutableList<MutableList<Int>> = mutableListOf()
    for(i in 1..x.size){
        for( j in 1..y.size){
            if((i+j)==6){
                doublDice.add(mutableListOf(i,j))
            }
        }
    }
    return doublDice
}

var result=twoDiceMakeSix(dice1,dice2)
println(result)
