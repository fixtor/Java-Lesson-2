import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ParseTable {
	private String income;
	private StringBuilder toBuilder = new StringBuilder();

	private String[] temp;
	private String[] temp1;
	private String tempString;
	private int count = 0; // считаем количество строк

	ParseTable(String nameOfFile) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(nameOfFile));
		while ((income = br.readLine()) != null) {
			toBuilder.append(income);
			count ++;
		}
		br.close();
	}

	public String[] getString(){

		temp = toBuilder.toString().split("},");

		for(int i = 0; i < count; i++){
		StringBuilder tempBuilder = new StringBuilder(temp[i]);
		temp[i] = tempBuilder.deleteCharAt(0).toString();
		temp[i] = temp[i].replaceAll("оценка", "получил").replaceAll("\"", "").replaceAll(":"," ")
				.replaceAll("фамилия", "студент").replaceAll("предмет", "по предмету")
				.replaceAll(",", " ").replaceAll("}","");

		}
		return temp;
	}
}
