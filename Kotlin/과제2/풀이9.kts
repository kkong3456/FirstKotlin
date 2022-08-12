fun productArth(num:Int):MutableList<Int>{
    var z:MutableList<Int> = mutableListOf()
    for (i in 1..9){
        z.add(num*i)
    }

    return z
}

val xxx=productArth(9)
print(xxx)