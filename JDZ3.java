import java.util.ArrayList;
import java.util.Random;


// Пусть дан произвольный список целых чисел.

// 1) Найти максимальное значение
// 2) Найти минимальное значение
// 3) Найти среднее значение
// 4) Нужно удалить из него чётные числа

public class JDZ3 {
    public static void main(String[] args) {
        ArrayList<Integer> userList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            userList.add(rand.nextInt(100));
        }
        Integer max = 0;
        Integer min = 100;
        for (int i = 0; i < userList.size(); i++) {
            if(userList.get(i)>max) max = userList.get(i);
            if(userList.get(i)<min) min = userList.get(i);
        }
        int sum = 0;
        double average = 0.0;
        for (int i = 0; i < userList.size(); i++) {
            sum += userList.get(i);
        }
        average = (double)sum/userList.size();
        System.out.println(userList);
        for (int i = 0; i < userList.size()-1; i++) {
            Integer temp = 0;
            for (int j = 0; j < userList.size()-1; j++) {
                if(userList.get(j)>userList.get(j+1)){
                    temp = userList.get(j);
                    userList.set(j, userList.get(j+1));
                    userList.set(j+1, temp);
                }
            }
        }
        Integer aver = userList.get(userList.size()/2);
        System.out.println(userList);
        for (int i = userList.size(); i-- > 0;) {
            if(userList.get(i)%2 == 0) userList.remove(i);
        }
        System.out.println("Максимальное число: " + max);
        System.out.println("Минимальное число: " + min);
        System.out.println("Среднее арифметическое: " + average);
        System.out.println("Средний элемент списка: " + aver);
        System.out.println("Список без чётных чисел: " + userList);

    }
}