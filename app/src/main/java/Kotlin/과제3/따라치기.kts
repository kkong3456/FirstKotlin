open class Warrior1 constructor(hp: Int, var power: Int, var armor: Int) {
    var killCount: Int = 0
    var isAlive: Boolean = true
        get() {
            if (field == true) println("Warrior는 살아있다 체력 : ${this.hp}")
            else println("Warrior는 죽었다")
            return field
        }
    var hp: Int = 100
        set(value) {
            if (value <= 10) {
                field = 0
                this.isAlive = false
            } else field = value
        }

    init {
        this.hp = hp
    }

    open fun attack(monster: Monster1) {
        println("Warrior가 공격을 했습니다.")
        if (!monster.defense(this)) {
            this.killCount += 1
            println("몬스터를 처치했습니다. 현재까지 총 ${this.killCount} 해치웠습니다.")
        }
    }

    fun defense(monster: Monster1):Boolean {
        var damage = monster.power - this.armor
        this.hp -= if(damage>0) damage else 0
        return this.isAlive
    }

    fun levelUp(): Knight1? {
        if (this.killCount >= 5) {
            println("Knight로 레벨업!!!")
            return Knight1(this)
        } else {
            println("Knight로 레벨업 불가!!! 현재 킬타운트는 ${this.killCount}")
            return null
        }
    }
}

class Knight1 constructor(warrior1: Warrior1) : Warrior1(warrior1.hp, warrior1.power, warrior1.armor) {
    var energy: Int = 0

    init {
        this.hp = warrior1.hp
        this.power = warrior1.power + 2
        this.armor = warrior1.armor + 1
    }

    override fun attack(monster: Monster1) {
        super.attack(monster)
        this.energy += 1
    }

    fun hardAttack(monster: Monster1) {
        if (this.isAlive && this.energy >= 3) {
            monster.hp -= this.power + 30
            this.power -= 3
        } else {
            println("에너기자 부족합니다. 현재 에너지는 :${this.energy}")
        }
    }
}

class Monster1 constructor(hp: Int, var power: Int, var armor: Int) {
    var isAlive: Boolean = true
        get() {
            if (field == true) println("몬스터는 아직 살아있다 체력 : ${this.hp}")
            else println("몬스터는 주었다")
            return field
        }
    var hp: Int = 100
        set(value) {
            if (value <= 0) {
                field = 0
                this.isAlive = false
            } else {
                field = value
            }
        }

    init {
        this.hp = hp
    }

    fun bite(warrior: Warrior1) {
        println("Monster가 공격합니다.")
        warrior.defense(this)
    }

    fun defense(warrior: Warrior1): Boolean {
        val damage: Int = warrior.power - this.armor
        this.hp -= if(damage>0) damage else 0
        return this.isAlive
    }
}

val warrior1 = Warrior1(100, 10, 10)
xxx@ while(warrior1.killCount<10)
{
    val monster1 = Monster1(10, 5, 1)
    while (monster1.isAlive) {
        warrior1.attack(monster1)
        monster1.bite(warrior1)

        if (!warrior1.isAlive) {
            break@xxx
        }
    }
}

val monster2:Monster1=Monster1(10,5,1,)

val knight: Knight1? = warrior1.levelUp()
knight?.attack(monster2)
println("kngith.energy is ${knight?.energy}")


