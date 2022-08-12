//break
for(i in 1..3){
    println("i : "+i)
    for(j in 1..3){
        if(j==2) break
        else println("j : "+j)
    }
}


println("-----------------------")
//continue
for(i in 1..3){
    println("i : "+i)
    for(j in 1..3){
        if(j==2) continue
        else println("j : "+j)
    }
}
println("--------------------------")
//return
fun returnFunction():Unit{
    for(i in 1..3){
        println("i : "+i)
        for(j in 1..3){
            if(j==2) {
                return
            }else {println("j : "+j)}
        }
    }
}
returnFunction()

println("-------------------------------")
loop@for(i in 1..3){
    println("i : "+i)
    for(j in 1..3){
        if(j==2) break@loop
        else println("j : "+j)
    }
}

println("---------------------------------")
kkong@for(i in 1..3){
    println("i : "+i)
    for(j in 1..3){
        if(j==2) continue@kkong
        else println("j : "+j)
    }
}

println("forEach----------------------------")
//forEach는 continue, break를 사용할 수 없다
listOf<Int>(1,2,3).forEach kkong@{
    if(it==2) return@kkong
    println(it)
}