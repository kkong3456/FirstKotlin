//오버로딩

class Sum{
    fun sum():Int{return 10}
    fun sum(number1:Int):Int{
        return number1+10
    }
    fun sum(number1:String):String{
        return number1
    }
    fun sum(number1:Int,number2:Int):Int{
        return number1+number2+10
    }
}

val sum=Sum()
println("sum.sum() : ${sum.sum()}")
println("sum.sum(10) : ${sum.sum(10)}")
println("sum.sum('26스코프함수') : ${sum.sum("XXX")}")
println("sum.sum(10,10) : ${sum.sum(10,10)}")

//오버라이딩
open class Warriror(var name:String,var power:Int,var type:String){
    open fun attack(){
        println("복잡한 코드 + 공격")
    }
    open fun getDefensePower():Int{
        return 10
    }
}
class DefenseWarrior constructor(name:String,power:Int):Warriror(name,power,"고블린"){
    fun defense(){
        println("방어")
    }

    override fun attack() {
//        super.attack()
        println("간단한 코드")
    }

    override fun getDefensePower():Int{
        val defaultDefensePower=super.getDefensePower()+5
        return defaultDefensePower
    }
}
val defenseWarriror=DefenseWarrior("홍길동",100)
defenseWarriror.attack()
println(defenseWarriror.getDefensePower())