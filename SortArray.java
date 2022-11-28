import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.logging.*;

public class SortArray {
	private int array[];
	SortArray() {}
	void setArray(int[] array) {
		this.array = array;
	}
	public int[] getSortedArray() throws IOException {//Пузыриковая сортировка
		String logToFile = null;
		Logger logger = Logger.getLogger(SortArray.class.getName());
		//ConsoleHandler con = new ConsoleHandler();
		//SimpleFormatter sFormat = new SimpleFormatter();
		//XMLFormatter xml = new XMLFormatter();
		//file.setFormatter(xml);
		SimpleFormatter sFormat = new SimpleFormatter();
		FileHandler file = new FileHandler("log.xml");
		logger.addHandler(file);
		logger.setUseParentHandlers(false); //отключает вывод в консоль по умолчанию
		
		file.setFormatter(sFormat);

		try {
			for (int j = 0; j < this.array.length; j++) {
				int checkFlag = this.array[0];
				for (int i = 0; i < this.array.length - 1; i++) {
					logger.log(Level.WARNING, String.valueOf(array[i]));
					if (checkFlag >= this.array[i + 1]) {
						this.array[i] = this.array[i + 1];
						this.array[i + 1] = checkFlag;
					} else checkFlag = this.array[i + 1];
				}
				logger.log(Level.INFO, String.valueOf(array[j])); //считаем итерации
			}

			return this.array;
		} catch (ArrayIndexOutOfBoundsException array) {
			logger.log(Level.WARNING, "array out of Index");
		}
		return this.array;
	}
}
