val numbers=intArrayOf(1,2,3)
//값만 필요할때
for(number in numbers){  //forEach와 동일
    println(number)
}

println("----------------------------------")
//인덱스와 값이 필요할 때
for((index,number) in numbers.withIndex()){ //forEachIndexed 와 동일
    println(index)
    println(number)
}
println("----------------------------------")
//인덱스만 필요할때
for(index in numbers.indices){
    println(index)
}

println("-----------------------------------")
numbers.forEachIndexed{
    index,i->println(""+index+" : "+i)
}