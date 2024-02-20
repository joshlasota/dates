import java.time.LocalDate
import java.time.temporal.ChronoUnit

fun main() {
    val currentDate = LocalDate.now()
    val nextFullMoon = findNextFullMoon(currentDate)
    println("The next full moon will be on: $nextFullMoon")
}

fun findNextFullMoon(currentDate: LocalDate): LocalDate {
    var date = currentDate
    while (!isFullMoon(date)) {
        date = date.plusDays(1)
    }
    return date
}

fun isFullMoon(date: LocalDate): Boolean {
    val daysSinceEpoch = ChronoUnit.DAYS.between(LocalDate.of(2000, 1, 6), date)
    val phase = (daysSinceEpoch + 20.4) % 29.53058868
    return phase in 14.9..15.1
}
