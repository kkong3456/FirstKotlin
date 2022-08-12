//기본자료형의 타입캐스팅
val number:Int=10
var numberString:String=number.toString()
//println("nuberString is $numberString")
val stringToNumber:Int=numberString.toInt()
println("stringToNumber is $stringToNumber")

val numberF:Double=10.5
var numberFToString:String=numberF.toString()
println("numberFToString is $numberFToString")
var numberFToInt:Int=numberF.toInt()
println("numberFToString is $numberFToInt")

//상속한 클래스간의 캐스팅
open class Warrior(var name:String,var power:Int,var type:String){
    open fun attack(){
        println("복잡한 코드 + 공격")
    }

}

class DefenseWarrior(name:String,power:Int):Warrior(name,power,"고블린"){
    fun defense(){
        println("방어")
    }
}

//is
//타입체크, true,false를 리턴
// 스카트 캐스팅을 해준다
// warrior 변수선언시 val로 선언해야 함
val warrior:Warrior=DefenseWarrior("방어형 전사",100)
warrior.attack()
//warrior.defense() 에러발생

if(warrior is DefenseWarrior){
    println("YES")
    //스마트 캐스팅, if블록 내에서는 DefenseWarrior로 사용가능하게 해준다.
    warrior.defense() //동작함, 단 warrior 변수 선언시 val로 해야지 var로 선언하면 에러발생
}

//as
// 지정한 타입으로 캐스팅을 시도하고, 불가능한 경우에는 예외발생 시킴
val warrior2:DefenseWarrior=warrior as DefenseWarrior
warrior2.defense()