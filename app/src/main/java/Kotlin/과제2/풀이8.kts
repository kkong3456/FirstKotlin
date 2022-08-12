var army1 = mutableListOf("A","B","C","D","E")
var army2:MutableList<String> = mutableListOf("A","B","C")


fun minusString(x:MutableList<String>,y:MutableList<String>,num:Int):Unit{
    var z:MutableList<MutableList<String>> = mutableListOf()

    if(x.size-1<num || y.size-1<num){
        return
    }
    x.removeAt(num)
    y.removeAt(num)

    z.add(0, x)
    z.add(1, y)
    print(z)

}
minusString(army1,army2,0)