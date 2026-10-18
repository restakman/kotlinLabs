//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    //Task 1
    print("Сколько секунд назад собесеник был в сети: ")
    val seconds: Long = readLine()!!.toLong()
    secondCounter(seconds)
    //Task 2
    print("Через какую систему ведтся оплата? (Mastercard/Maestro/Visa/Мир/VK pay): ")
    val paymetsSys : String = readLine()!!
    print("Сколько денег было в переводе: ")
    val pay = readLine()!!.toDouble()
    someFunction(paymetsSys, pay)
}

fun secondCounter(seconds: Long) {
        if (seconds >= 60)
            minuteCounter((seconds / 60).toLong())
        else
            println("Тольько что был в сети")
    }

fun minuteCounter(minutes: Long) {
        if (minutes >= 60)
            hourCounter((minutes / 60).toLong())
        else
            writer(minutes, "Minutes")
    }

fun hourCounter(hours: Long) {
        if (hours < 24)
            writer(hours, "Hour")
        else
            writer(hours / 24, "Day")
    }

fun writer(number: Long, Type: String) {
        val final: String
        if (number.toString()[number.toString().length - 1] == '1') {
            final = when (Type) {
                "Minute" -> "был в сети $number минуту назад"
                "Hour" -> "был в сети $number час назад"
                else -> "был в сети $number день назад"
            }
        } else if (number.toString()[number.toString().length - 1] == '2') {
            final = when (Type) {
                "Minute" -> "был в сети $number минуты назад"
                "Hour" -> "был в сети $number часа назад"
                else -> dayCounter(number)
            }
        } else {
            final = when (Type) {
                "Minute" -> "был в сети $number минут назад"
                "Hour" -> "был в сети $number часов назад"
                else -> dayCounter(number)
            }
        }
        println("$final")
    }

fun dayCounter(number: Long): String {
        if (number.toString()[number.toString().length - 1].toInt() >= 5)
            return "был в сети $number дней назад"
        else
            return "был в сети $number дня назад"
    }
fun someFunction(paySys : String, value: Double)
{
   when (paySys)
   {
        "Mastercard", "Maestro" ->
            {
                if(value>300 && value < 75000)
                {
                    print("Перевод без комиссии: $value")
                }
                else
                {
                    val kom: Double = value - (value* 0.006 + 20)
                    val itog: Double = value - kom
                    print("Перевод $itog руб., комиссия составила $kom руб.")
                }
            }
       "Visa", "Мир" ->
             {
                 if(value * 0.0075 >= 35)
                  {
                      val kom: Double = value - (value * 0.0075)
                      val itog: Double = value - kom
                      print("Перевод $itog руб., комиссия составила $kom руб.")
                  }
                 else
                 {
                     val itog = value - 35
                     print("Перевод $itog руб., комиссия составила 35 руб.")
                 }
             }
       "VK pay" ->
       {
           print("Перевод без комиссии: $value")
       }
       else -> println("Мы не знаем что такое")
   }
}