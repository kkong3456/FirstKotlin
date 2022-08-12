class Person(var name:String?=null, var age:Int?=null){}

//apply ,  변수초기화
val gildong:Person=Person().apply{
    name="길동"
    age=20
}
//위 정의는 아래 정의와 완전히 동일한 내용이다.
//val gildong=Person()
//gildong.name="길동"
//gildong.age=20


//also , 생성된 인스턴스를 it로 받는다
val gildong2:Person=Person("gildong").also{
    println(it.name)
}
//run, 기본적으로 apply와 동일하고 람다함수처럼 맨 마지만 라인이 리턴된다.
val ageAfter10Year=Person("gildong",30).run{
    age!!+10
}

//with와 run은 동일하고, with는 nullable type의 인자를 받지 못한다.
val ageAfter10Year2=with(Person("gildong",25)){
    age!!+10
}
val gildong4:Person?=Person("xxx",33)
//var ageAfter10Year3=with(gildong4){  ==>에러발생
//    age!!+10
//}
println(ageAfter10Year)
println(ageAfter10Year2)
//println(ageAfter10Year3)

//let , 기본벅으로 also와 동일
//차이점은 마지막 라인이 리턴된다.
val gildong5=Person("victor").let{

}
