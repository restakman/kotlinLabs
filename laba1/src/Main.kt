//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    //Task 1
    print("Введите перевод: ")
    val input = readln()
    val money = input.toDouble()
    val commision_min = 35.0
    val result = if(money * 0.0075 < commision_min) commision_min else money * 0.0075
    val comission_final = money - result
    println("Переведено: $comission_final руб., комиссия: $result руб.")
    //Task 2
    print("input number of likes: ")
    val people_inp = readln()
    if(people_inp.toInt()>1)
        println("$people_inp people liked this post")
    else if(people_inp.toInt()==1)
        println("$people_inp person liked this post")
    else
        println("Nobody liked this post")

    //Task 3
    print("Введите количество покупок: ")
    val goods_inp = readln()
    val goods_int = goods_inp.toInt()
    val painment:Double = (goods_int * 100 ).toDouble()
    val isRegularCustomer: Boolean = kotlin.random.Random.nextBoolean()
    val final_painment : Double
    if(painment>=10001)
        final_painment = painment* 0.95
    else if (painment>=1001 && painment<=10000)
        final_painment = painment - 100
    else
        final_painment = painment
    if(isRegularCustomer)
    {
        val painment_forRegulars = final_painment*0.99
        println("Вы постоянный покупатель! \n Итоговая цена для постоянного покупателя $painment_forRegulars")
    }
    else
        println("Итоговая цена: $final_painment")
}
