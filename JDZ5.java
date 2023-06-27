
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class JDZ5{
    public static void main(String[] args){
        runAplication();
    }
    public static void runAplication(){
        HashMap <String, ArrayList<String>> userMap = new HashMap<>();
        boolean run = true;
        while(run){
            System.out.println("Подсказка");
            System.out.println("Введите \"ADD Фамилия Номер телефона\" для добавления контакта");
            System.out.println("Введите \"GET Фамилия\" для получения информации о контакте");
            System.out.println("Введите \"LIST\", чтобы показать список контактов");
            System.out.println("Введите \"REMOVE Фамилия\", чтобы очистить номера по фамилии");
            System.out.println("Введите \"EXIT\" для выхода");
            Scanner scan = new Scanner(System.in);
            String userString = scan.nextLine();
            String[] move = userString.split(" ");
            switch (move[0]) {
                case "ADD":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    addContact(userMap, move);
                    System.out.println();
                    break;
                case "GET":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    getContact(userMap, move);
                    System.out.println();
                    break;
                case "LIST":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    listContacts(userMap);
                    System.out.println();
                    break;
                case "REMOVE":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    removeContacts(userMap, move);
                    System.out.println();
                    break;
                case "EXIT":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    scan.close();
                    run = false;
                    break;
                default:
                    System.out.println("ОШИБКА! Введите существующее действие!");
                    break;
            }
        }
    }
    public static void addContact(HashMap <String, ArrayList<String>> directMap, String[] array) {
        ArrayList<String> contacts = new ArrayList<>();
        if(directMap.get(array[1])!= null){
            contacts.addAll(directMap.get(array[1]));
        }
        contacts.add(array[2]);
        directMap.put(array[1], contacts);        
    }
    public static void listContacts(HashMap <String, ArrayList<String>> directMap) {
        System.out.println(directMap);
    }
    public static void getContact(HashMap <String, ArrayList<String>> directMap, String[] array) {
        if(directMap.get(array[1])!= null){
            System.out.println(directMap.get(array[1]));
        } else{
            System.out.println("Не найдена запись с фамилией " + array[1]);
        }
    }
    public static void removeContacts(HashMap <String, ArrayList<String>> directMap, String[] array) {
        if(directMap.get(array[1])!= null){
            directMap.remove(array[1]);
        } else{
            System.out.println("Не найдена запись с фамилией " + array[1]);
        }

    }
}
