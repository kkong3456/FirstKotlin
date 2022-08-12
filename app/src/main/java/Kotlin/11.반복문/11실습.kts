//Range
for(value in 3..5){
    println("반복-"+value)
}
println()
//Progression
for(value in 0..3 step 2){
    println("반복1-"+value)
}
println()
for(value in 5 downTo 1 step 2){
    println("반복2-"+value)
}
println()
//Collection
val numbers=listOf<Int>(5,6,7,8,9)
for(number in numbers){
    println("반복3-"+number)
}
println()
for(number in 0..numbers.size){
    println("반복3")
}
println()
for(number in 0 until numbers.size){
    println("반복4")
}
println()
for((index,number) in numbers.withIndex()){
    println(""+index+"|"+number)
}
println()
numbers.forEach{
    println(it)
}
println()
numbers.forEach{
    number->println(number+10)
}