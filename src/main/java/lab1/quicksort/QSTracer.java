package lab1.quicksort;

import java.util.List;

public final class QSTracer {

    public static final String Q1 = "Q1"; // вход
    public static final String Q2 = "Q2"; // проверка базового случая
    public static final String Q3 = "Q3"; // выбор pivot
    public static final String Q4 = "Q4"; // вход в цикл partition
    public static final String Q5 = "Q5"; // сдвиг i
    public static final String Q6 = "Q6"; // сдвиг j
    public static final String Q7 = "Q7"; // обмен
    public static final String Q8 = "Q8"; // рекурсия влево
    public static final String Q9 = "Q9"; // рекурсия вправо
    public static final String Q10 = "Q10"; // выход

    public static void add(List<String> trace, String point) {
        if (trace != null) {
            trace.add(point);
        }
    }
}
