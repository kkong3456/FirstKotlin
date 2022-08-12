open class Warrior constructor(hp: Int, var power: Int, var armor: Int) {
    var killCount: Int = 0
    var isAlive: Boolean = true
        get() {
            if (field == true) println("Warrior는 살아있다 체력 : ${this.hp}")
            else println("Warrior는 죽었다")
            return field
        }
    var hp: Int = 100
        set(value) {
            if (value <= 0) {
                field = 0
                this.isAlive = false
            } else field = value
        }

    init {
        this.hp = hp
    }

    open fun attack(monster: Monster) {
        println("Warrior가 공격을 했습니다.")
        if (!monster.defense(this)) {
            //Monster dead
            this.killCount += 1
            println("Monster를 처치했습니다. 현재 킬카운트는 : ${this.killCount}")

        }
    }

    fun defense(monster: Monster): Boolean {
        var damage: Int = monster.power - this.armor
        this.hp -= if (damage > 0) damage else 0
        return this.isAlive
    }

    fun levelUp(): Knight? {
        if (this.killCount >= 5) {
            println("Knight로 레벨업!!!")
            return Knight(this)
        } else {
            println("Knight로 레벨업 불가!!! 현재 킬카운드는 ${this.killCount}")
            return null
        }
    }
}

class Knight constructor(warrior: Warrior) : Warrior(warrior.hp, warrior.power, warrior.armor) {
    var energy: Int = 0

    init {
        this.hp = warrior.hp
        this.power = warrior.power + 2
        this.armor = warrior.armor + 1
    }

    override fun attack(monster: Monster) {
        super.attack(monster)
        this.energy += 1
    }

    fun hardAttack(monster: Monster) {
        if (this.isAlive && this.energy >= 3) {
            monster.hp -= this.power + 30
            this.power -= 3
        } else {
            println("에너지가 부족합니다. 현재 에너지는 : ${this.energy}")
        }
    }
}

class Monster constructor(hp: Int, var power: Int, var armor: Int) {
    var isAlive: Boolean = true
        get() {
            if (field == true) println("Monster는 아직 살아 있다 체력 : ${this.hp}")
            else println("Monster는 죽었다")
            return field
        }
    var hp: Int = 100
        set(value) {
            if (value <= 0) {
                field = 0
                this.isAlive = false
            } else field = value
        }

    init {
        this.hp = hp
    }

    fun bite(warrior: Warrior) {
        println("Monster가 공격합니다.")
        warrior.defense(this)
    }

    fun defense(warrior: Warrior): Boolean {
        val damage: Int = warrior.power - this.armor
        this.hp -= if (damage > 0) damage else 0
        return this.isAlive

    }
}

val warrior = Warrior(100, 10, 10)

loop@ while (warrior.killCount < 10) {
    val monster = Monster(10, 5, 1)
    while (monster.isAlive) {
        warrior.attack(monster)
        monster.bite(warrior)

        if (!warrior.isAlive) {
            break@loop
        }
    }
}

val knight: Knight? = warrior.levelUp()