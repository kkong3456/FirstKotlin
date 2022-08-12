open class Creature constructor(var health:Int,var attackPower:Int,var defensePower:Int){}
class Warrior1:Creature{

    constructor(health:Int,attackPower:Int,defenePower:Int):super(health,attackPower,defenePower){}
    fun attack(monster:Monster1){
        println("Warrior가 공격합니다.")
        monster.health-=10
        if(monster.health>0) println("Monster가 아직 살아있습니다. 체력 : ${monster.health}")
        else println("Monster가 죽었습니다.")
    }
}
class Knight1:Creature{
    var energy:Int
    constructor(health:Int,attackPower:Int,defensePower:Int,energy:Int):super(health,attackPower,defensePower){
        this.energy=energy
    }
    fun hardAttack(){
        if(energy>3) energy-=3
    }
}
class Monster1:Creature{

    constructor(health:Int,attackPower:Int,defensePower:Int):super(health,attackPower,defensePower){
        println("Monster 생성")
    }
    fun attack(warrior:Warrior1){
        println("Monster가 공격합니다.")
        warrior.health-=10

        if(warrior.health>0) println("Warrior가 아직 살아있습니다. 체력 : ${warrior.health}")
        else println("Warrior가 죽었습니다.")
    }

}
val warriorA=Warrior1(30,30,30)
val monsterA=Monster1(20,20,20)

warriorA.attack(monsterA)
warriorA.attack(monsterA)