//getter/setter

class Book(){
    var title:String="모름"
        get(){
            println("getter")
            return field   //title 대신 지시어 field를 리턴한다
        }
        set(value){
            println("setter")
            field=value  //title 대신 field에 값을 대입한다.
        }
}

var book=Book()
//println(book.title)
book.title="제목변경"
//println(book.title)


//lateinit
class MasterBook(){
    lateinit var title:String

    fun nextpage(){
        if(::title.isInitialized){
            println("페이지가 넘어간다")
        }else{
            println("초기화 필요")
        }
    }
}
val book2=MasterBook()
book2.title="책이름" //초기화
book2.nextpage()

val book22=MasterBook()
book22.nextpage()

//Lazy
//- by lazy로 정의 하고 호출시점에 초기화됨
//- val에서만 사용이 가능하다.


class Book3{
    var title:String by lazy{  //title 값을 얻기위해 엄청 복잡한 작업이 필요할때 , 또 어떤 인스턴스에서는 title변구사 필요 없을때 lazy를 사용한다??
        println("lazy 초기화")
        //title="책제목"  ==> 에러
        //return "책제목" ==> 에러
        "책제목"  //람다식과 마찬가지로 맨마지막 내용이 리턴된다.
    }
}
val book3=Book3()
println(book3.title)
