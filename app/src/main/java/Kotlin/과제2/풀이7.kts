fun eat(residueEatCnt:Int,doneEatCnt:Int):Unit{

    var xxx=residueEatCnt-doneEatCnt
    do{
        println("밥을 먹었다")

        xxx-=1

    }while(xxx>0)
    println("배가 부르다")
}

eat(10,5)