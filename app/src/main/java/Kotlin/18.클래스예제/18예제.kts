class Bank {
    fun save(account: Account, money: Int):Unit{
        if (money >= 0) account.balance += money
        else println("마이너스 금액은 예금할수 없습니다.")
    }
    fun withdraw(account:Account,money:Int):Unit{
        if(account.balance>=money) account.balance-=money
        else println("잔액이 부족합니다.")
    }
}

class Account constructor(
    val initialBalance: Int = 0
) {
    var balance: Int

    init {
        this.balance = initialBalance
    }

    fun checkBalance(): Int {
        return this.balance
    }
}

val account=Account(1000)
val bank=Bank()
println(account.checkBalance())

bank.save(account,1000)
println(account.checkBalance())

bank.withdraw(account,2000)
println(account.checkBalance())

bank.withdraw(account,1000)
println(account.checkBalance())

val account_B=Account(10000)
bank.save(account_B,1000)
println(account_B.checkBalance())