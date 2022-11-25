import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.simple.SimpleLogger;



public class Main {

	public static void main(String[] args) throws Exception {
		StringToSQL n = new StringToSQL("st.json");
		n.getTemp();
	}
}
