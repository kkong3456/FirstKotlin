class FootballPlayer constructor(uniform:String,ball:String){
    val uniform:String
    val ball:String

    init{
        this.uniform=uniform
        this.ball=ball
    }
    fun kick(){
        println("공을 찼다")
    }
    fun pass(){
        println("패스를 했다")
    }
}

val footballPlayer=FootballPlayer("빨간색 유니폼","축구공")
println(footballPlayer.uniform)
println(footballPlayer.kick())