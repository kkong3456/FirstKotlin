fun returnGrade(grade:Int):String{
    if(grade>=90){
        return "A"
    }else if(grade>=80){
        return "B"
    }else if(grade>=70){
        return "C"
    }else{
        return "F"
    }
}

println(returnGrade(99))

fun checkGrade(score:Int):String{
    when(score){
        in 90..100->return "A"
        in 80..89 -> return "B"
        in 70..79 -> return "C"
        else -> return "F"
    }
}

println(checkGrade(55))