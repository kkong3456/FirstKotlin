val arr:List<Int> = listOf<Int>(1,3,5)
var arr1:List<Int> = listOf<Int>(2,6,8,10)
fun mapArth(arr:List<Int>,arr1:List<Int>):Unit{
    var mapOddEven:MutableMap<String,MutableList<Int>> = mutableMapOf()
    var oddList:MutableList<Int> = mutableListOf<Int>()
    var evenList:MutableList<Int> = mutableListOf<Int>()

    for (i in arr){
        if(i%2==0){
            evenList.add(i)
        }else{
            oddList.add(i)
        }
    }
    for (i in arr1){
        if(i%2==0){
            evenList.add(i)
        }else{
            oddList.add(i)
        }
    }

    mapOddEven["짝수"]=evenList
    mapOddEven["홀수"]=oddList
    println(mapOddEven)
}

mapArth(arr,arr1)

