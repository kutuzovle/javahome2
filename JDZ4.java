    
import java.util.ArrayList;
import java.util.Scanner;

public class JDZ4 {
    public static void main(String[] args) {
        RunAplication();
    }

    private static void RunAplication(){
        boolean run = true;
        ArrayList<String> userList = new ArrayList<>();
        while (run) {
            System.out.println("1. Ввести строку (Введите 1)");
            System.out.println("2. Вывести информацию(Введите \"print\")");
            System.out.println("3. Удалить последнюю строку(Введите \"revert\")");
            System.out.println("4. Выйти из программы (Введите \"exit\")");
            Scanner sc = new Scanner(System.in);
            String userString = sc.nextLine();
            
            switch (userString) {
                case "1":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    AddToList(userList);
                    System.out.println();
                    break;
                case "print":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    Print(userList);
                    System.out.println();
                    break;
                case "revert":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    RevFromList(userList);
                    System.out.println();
                    break;
                case "exit":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    run = false;
                    sc.close();
                    break;
                default:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Выберите правильный пункт меню");
                    break;
            }
        }
    }
    private static void Print(ArrayList<String> array) {
        ArrayList<String> newList = new ArrayList<>();
        for (int i = array.size()-1; i >=0; i--) {
            newList.add(array.get(i));
        }
        System.out.println(newList);
    }
    private static void AddToList(ArrayList<String> array){
        System.out.println("Вводите строку: ");
        Scanner scan = new Scanner(System.in);
        String element = scan.nextLine();
        array.add(element);
        
    }
    private static void RevFromList(ArrayList<String> array){
        try {
            array.remove(array.size()-1);
        } catch (Exception e) {
            System.out.println("В списке больше нет строк!");
        }
    }        
        
    

}
