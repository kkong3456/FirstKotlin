//클래스 선언방법
class Person{}

//주생성자
//클래스 이름 옆에 명시
//객체생성시 재료, 한개만 만들수 있고, constructor 키워드 생략 가능
class User1 constructor(name:String){
    val userName:String   //변수 초기화는 init블록에서 해주었기 때문에 에러가 발생하지 않는다.
    init{
        userName=name
        println(userName)
    }
}
val user1=User1("홍길동")

//주생성자- init블럭 생략
class User2 constructor(name:String){
    val userName:String=name
}
val user2=User2("비니")
println(user2.userName)

//주생성자-constructor 키워드 생략
class User3(name:String){
    val userName:String=name
}
val user3=User3("하니")
println(user3.userName)

//주생성자-모든걸 생략 버전
class User33(val userName:String){}
val user33=User33("후니")
println(user33.userName)

//주생성자-기본값 지정
class User4(name:String="하나"){
    val userName:String=name
}
val user4=User4()
println(user4.userName)
val user44=User4("몽실")
println(user44.userName)

//주생성자-속성이 여러개 있는경우
class User5(age:Int,name:String){
    val age:Int=age
    val name:String=name
    init{
//        this.age=age
//        this.name=name
    }
}

//////////////// 부생성자
//constructor 키워드를 생략할 수 없다.
//주생성자에는 필수 인자가 와야 하고, 부 생성자의 인자는 비 필수 인자임
//그래서 주생성자의 인자는 반드시 부생성자의 인자에도 포함되어야 한다
class User6 constructor(name:String){
    var age:Int=0
    var nickName:String=""
    val name:String


    init{
        println("주생성자 호출")
        this.name=name
    }

    //부생성자, 클래스 내부에 존재, this(name)은 부생성자가 주생성자에게 생성을 위임
    constructor(name:String,age:Int): this(name){
        println("부생성자 호출")
        this.age=age
    }
    //부생성자는 여러개 만들수 있다
    constructor(name:String,age:Int,nickName:String):this(name){
        this.age=age
        this.nickName=nickName
    }
}
//val user6=User6("가나다")
//println(user6.name)

//부생성자 호출
val user66=User6("가나다다",50)
println(user66.age)

//실행순서: 부생성자를 호출해도 주생성자가 먼저 호출된다.
//부생성자 호출 ->부생성자 안에 있는 주생성자 호출 ->init 블록 호출->부생성자 본문 호출
//클래스 속성을 초기화 하지 않아도 되는 이유
//-초기화블록에서 초기화를 보장 ->클래스 생성시 초기화블록이 반드시 실행됨
//-초기화블록에 없는 속성은 선언할때 초기화 해야 됨

var user667=User6("dkdkd",10,"kkkk")
println(user667.nickName)

//주생성자가 없는경우 코틀린이 자동으로 내부적으로 생성한다
//this통해 주생성자에게 생성을 위임할 필요가 없다.
class User7{
    var name:String
    var age:Int

    constructor(name:String,age:Int){
        this.name=name
        this.age=age
    }
}

val user7=User7("kkong",20)
println(user7.name)


