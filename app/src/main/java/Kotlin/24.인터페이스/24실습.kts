interface Tiger{
    fun bite()
    fun goToBox()
}

class BakDuSanTiger:Tiger{
    override fun bite(){}
    override fun goToBox(){}
}

val bakDuSanTiger:BakDuSanTiger= BakDuSanTiger()
bakDuSanTiger.goToBox()

interface Person{
    //멤버들의 구현부가 없다
    var dress:String
    fun eat()
    fun sleep(){  //구현부가 있으면 구현하는 클래스에서 굳이 구현할 필요가 없고, 오버라이딩 할수 있다.
        println("잠을 잔다")
    }
}

open class Student:Person{
    override var dress: String
        get() = "옷"
        set(value){}

    override fun eat() {
        println("밥을 먹는다")
    }
    fun study(){
        println("공부를 한다")
    }
}
class Teacher:Person{
    override var dress: String
        get() = "정장"
        set(value){}

    final override fun eat() { //인터페이스는 open이 기본이고 상속을 못하게(오버라이드 못하게)하려면 final 키워드 사용
                                // 상속은 기본적으로 final이고 상속필요시 open키워드 사용해야함
        println("밥을 먹는다")
    }
}


val student:Student=Student()
student.eat()
student.sleep()

class GoodStudent:Student(){
    override fun sleep() {
        super.sleep()
    }

    override var dress: String
        get() = super.dress
        set(value) {}

    override fun eat() {
        super.eat()
    }
}