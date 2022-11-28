import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.simple.SimpleLogger;
import java.util.logging.*;



public class Main {

	public static void main(String[] args) throws Exception {

		/* Задание 1 В файле содержится строка с исходными данными в такой форме: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
		Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
		SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";
		Для разбора строки используйте String.split. Сформируйте новую строку, используя StringBuilder. Значения null не включаются в запрос.*/


		StringToSQL n = new StringToSQL("st.json");
		System.out.println(n.getTemp());

		/* Задание 2 Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.*/

		int[] newArr = new int[] {3,1,14,5,11,0};
		SortArray t = new SortArray();
		t.setArray(newArr);
		for(int item: t.getSortedArray()) System.out.print(item + " ");
		System.out.println();

		/* Задание 3 В файле содержится строка с данными:
		[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
		 {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
		  {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
		  Напишите метод, который разберёт её на составные части и, используя StringBuilder создаст массив строк такого вида:

			Студент Иванов получил 5 по предмету Математика.
			Студент Петрова получил 4 по предмету Информатика.
			Студент Краснов получил 5 по предмету Физика.

		 */
		ParseTable a = new ParseTable("table.txt");
		for(String item: a.getString()) System.out.println(item);

	}
}
