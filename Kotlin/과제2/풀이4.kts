//인수가 100보다 작으면 1증가, 100넘으면 종료
var result:Int=0
fun hundreadLiveOrDead(num:Int):Unit{
    if(num<100){
        result++
        println(result)
    }else{
        return
    }

}

hundreadLiveOrDead(5)
hundreadLiveOrDead(5)
hundreadLiveOrDead(4)
hundreadLiveOrDead(100)