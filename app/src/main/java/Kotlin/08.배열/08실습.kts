var array1=arrayOf(true,"Hi",10,2.0,null)
println(array1)
var array2=arrayOf<Int>(1,2,3,4,5)
println(array2)
var array3=intArrayOf(1,2,3,4,5)
println(array3)


var array4=Array(10,{0})
println(array4[0])
println(array4[2])
println(array4[9])
var array5=IntArray(10,{0})
println(array5[0])


var array6=Array(10,{0})
var array7=Array<String>(10,{""})

var array8=arrayOf<Int>(10,20,30)
println(array8[2])
println(array8.get(2))

array8.set(0,100)
println(array8[0])