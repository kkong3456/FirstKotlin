// 상속이 없는 경우
class Warrior(){
    fun attack(){
        println("복잡한코드 +  공격")
    }
}
class DefenseWarrior(){
    fun attack(){
        println("복잡한코드 + 공격")
    }
    fun defense(){
        println("방어")
    }
}
class HardAttackWarrior(){
    fun attack(){
        println("복잡한코드 + 공격")
    }
    fun hardAttack(){
        println("강하게 공격")
    }
}

//상속을 사용한 경우
open class Warrior1 constructor(var name:String,var power:Int,var type:String){
    open fun attack(){
        println("복잡한코드 +  공격")
    }
}
//주생성자가 부모클래스를 생성한는 경우
class DefenseWarrior1 constructor(name:String,power:Int):Warrior1(name,power,"고블린"){
    fun defense(){
        println("방어 : ${name}은 파워가 ${power}이고, 타입은 ${type}이다")
    }

    override fun attack(){  //override 됨, 부모클래스의 attack 앞에 open
        println("간단한 공격")
    }
}

//주생성자가 없는경우, 부생성자가 부모클래스를 생성
class HardAttackWarrior1:Warrior1{
    var bonusPower:Int=0
    constructor(name:String,power:Int,bonusPower:Int):super(name,power,type="고랭"){
        this.bonusPower=bonusPower
    }
    fun hardAttack(){
        println("강하게 공격 ${name}은 power가 ${power}이고 타입은 ${type}이다")
    }
}

val defenseWarrior1:DefenseWarrior1= DefenseWarrior1("똑똑한 고블린",20)

defenseWarrior1.attack()
defenseWarrior1.defense()

val hardAttackWarrior1:HardAttackWarrior1= HardAttackWarrior1("멍청한 고랭",20,20)
hardAttackWarrior1.attack()
hardAttackWarrior1.hardAttack()
