//Range ==> 실무에서 많이 사용한다
var range1=1..10
println(range1)

var range2=1 until 10
println(range2)

var range3='A'..'Z'
println(range3)
var range33='ㄱ'..'ㅎ'

//Progression==>실무에서 거의 사용 안한다
var range4=1..10 step 2 //==>(1,2,3,4,5,6,7,8,9,10) -> (1,3,5,7,9)
println(range4)
var range5=10 downTo 1 step 2
println(range5)

//Conllection
var collection1=listOf<Int>(1,2,3,4,5)
