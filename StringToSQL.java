import java.io.*;


public class StringToSQL {

	private static final String WHERE = "WHERE ";
	private static final String AND = "AND ";
	private String mainStr;
	private String[] temp;
	private String[] temp1;
	private StringBuilder builderStr = new StringBuilder();
	private StringBuilder selectFromStudents = new StringBuilder("SELECT * FROM students ");

	//Входные данные
	StringToSQL(String nameOfFile) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(nameOfFile));
		while ((mainStr = br.readLine()) != null) {
			builderStr.append(mainStr);
		}
		br.close();
	}

	//Преобразование строки
	String getTemp() {

		StringBuilder s = new StringBuilder();
		String delimeter = ", ";
		//удаляем {,  создаем массив через запятую
		temp = builderStr.deleteCharAt(0).deleteCharAt(builderStr.length() - 1).toString().split(delimeter);
		//убираем кавычки добавляем запятую
		for (int i = 0; i < temp.length; i++) {
			s.append(temp[i].replaceAll("\"", "") + delimeter);
		}
		// создаем массив из name:name
		temp = s.toString().split(delimeter);
		int count = 0;
		for (int j = 0; j < temp.length; j++) {
			temp1 = temp[j].split(":");

			if (temp1[1].equalsIgnoreCase("null")) {
				selectFromStudents.append("");
			} else if (count == 0) {
				selectFromStudents.append(WHERE + temp[j] + " ");
				count++;
			} else if (count >= 1) {
				selectFromStudents.append(AND + temp[j] + " ");
				count++;
			}
		}
		//Вывод запроса
		return selectFromStudents.toString();
	}
}