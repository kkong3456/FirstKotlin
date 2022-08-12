//?
val number: Int = 10 //Non-nullable
val number: Int? = null //Nullable

//!!
val nullableNumberList: List<Int?> = listOf<Int?>(1, 2, 3, 4, 5)
var result: Int = 0
nullableNumberList.forEach {
    result += it!!
}

//가능하다면 !!는 사용하지 않는걸 권장
println("result is $result")

//?.
val text: String? = "text"
println("text가 널이 아니면 text.length를 실행 : ${text?.length}")
val text1: String? = null
println("text1가 널이면 널을 출력한다 : ${text1?.length}")
println("text!!.length : ${text!!.length}")  //이런식도 가능하면 사용하지 않는게...

// as?
class Warrior(var name: String, var power: Int, var type: String) {
    fun attack() {
        println("복잡한 코드 + 공격")
    }
}

class DefenseWarrior(name: String, power: Int) {
    fun defense() {
        println("방어")
    }
}

val defenseWarrior = DefenseWarrior("", 10)
//val warrior=defenseWarrior as Warrior  //상속관계가 아니므로 에러가 발생
val warrior = defenseWarrior as? Warrior  //null값
println("warrior is $warrior")

// ?: 엘비스 연산
val text2: String? = "123"
val nullText:String?=null

var len1:Int=if(text2!=null) text2.length else 0
var len2:Int=text2?.length ?: 0

println("len1 is $len1")
println("len2 is $len2")