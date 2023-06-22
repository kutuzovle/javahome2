// Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class JDZ2 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        FileReader fReader = new FileReader("javahome3/file.json");
        Scanner scan = new Scanner(fReader);
        HashMap<String,String> userMap = new HashMap<>();
        String str = scan.nextLine().replace("{", "").replaceAll("}", "").replaceAll("\"", "").replaceAll(",", "").replaceAll(" ", ":");
        fReader.close();
        scan.close();
        String[] strArray = str.split(":");
        for (int i = 0; i < strArray.length; i+=2) {
            userMap.put(strArray[i],strArray[i+1]);
        }
        for (Map.Entry<String,String> entry : userMap.entrySet()) {
            if(!entry.getValue().equals("null")){
                sb.append(entry.getKey()+" = '"+entry.getValue()+"' ");
            }
        }
        System.out.println(sb);
    }
}