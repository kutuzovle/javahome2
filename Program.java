
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        runAplication();
    }
    public static void runAplication() {
        Laptop laptop_1 = new Laptop();
        laptop_1.id = 0;
        laptop_1.name = "ASUS VivoBook PRO 15 M6500QH-HN034";
        laptop_1.price = 59_999.0;
        laptop_1.manufacturer = "ASUS";
        laptop_1.screenDiagonal = 15.6;
        laptop_1.ram = 8;
        laptop_1.gamingLaptop = true;
        laptop_1.processor = "AMD Ryzen 5 5600H";
        laptop_1.videoCard = "GeForce GTX 1650";
        laptop_1.memory = 512;
        laptop_1.OS = null;
        laptop_1.cores = 6;
        laptop_1.screenType = "IPS";
        laptop_1.processorManufacturer = "AMD";

        Laptop laptop_2 = new Laptop();
        laptop_2.id = 1;
        laptop_2.name = "Apple MacBook Air";
        laptop_2.price = 94_299.0;
        laptop_2.manufacturer = "Apple";
        laptop_2.screenDiagonal = 13.3;
        laptop_2.ram = 8;
        laptop_2.gamingLaptop = false;
        laptop_2.processor = "Apple M1";
        laptop_2.videoCard = "Apple M1 7-core";
        laptop_2.memory = 256;
        laptop_2.OS = "IOS";
        laptop_2.cores = 8;
        laptop_2.screenType = "IPS";
        laptop_2.processorManufacturer = "Apple";

        Laptop laptop_3 = new Laptop();
        laptop_3.id = 2;
        laptop_3.name = "MSI Modern 15 B12M-211RU";
        laptop_3.price = 48_999.0;
        laptop_3.manufacturer = "MSI";
        laptop_3.screenDiagonal = 15.6;
        laptop_3.ram = 8;
        laptop_3.gamingLaptop = false;
        laptop_3.processor = "Intel Core i3-1215U";
        laptop_3.videoCard = "Intel UHD Graphics";
        laptop_3.memory = 256;
        laptop_3.OS = "WINDOWS";
        laptop_3.cores = 6;
        laptop_3.screenType = "IPS";
        laptop_3.processorManufacturer = "Intel";

        Laptop laptop_4 = new Laptop();
        laptop_4.id = 3;
        laptop_4.name = "Maibenben M543";
        laptop_4.price = 36_999.0;
        laptop_4.manufacturer = "Maibenben";
        laptop_4.screenDiagonal = 15.6;
        laptop_4.ram = 8;
        laptop_4.gamingLaptop = false;
        laptop_4.processor = "AMD Ryzen 3 4300U";
        laptop_4.videoCard = "AMD Radeon Graphics";
        laptop_4.memory = 256;
        laptop_4.OS = "LINUX";
        laptop_4.cores = 4;
        laptop_4.screenType = "IPS";
        laptop_4.processorManufacturer = "AMD";

        List<Laptop> laptopList = new ArrayList<>();
        laptopList.add(laptop_1);
        laptopList.add(laptop_2);
        laptopList.add(laptop_3);
        laptopList.add(laptop_4);

        boolean run = true;
        while(run){
            System.out.println("Выберите параметр для фильтрации (Введите номер пункта меню)");
            System.out.println("1. Объём памяти");
            System.out.println("2. Цена");
            System.out.println("3. Операционная система");
            System.out.println("4. Назначение ноутбука (игровой или нет)");
            System.out.println("5. Диагональ");
            System.out.println("EXIT для выхода из приложения");
            Scanner scan = new Scanner(System.in);
            String userString = scan.nextLine();
            switch (userString) {
                case "1":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    laptopMemory(laptopList, scan);
                    break;
                case "2":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    laptopPrice(laptopList, scan);
                    break;
                case "3":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    laptopOS(laptopList, scan);              
                    break;
                case "4":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    laptopGaiming(laptopList, scan);
                    break;
                case "5":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    laptopDiagonal(laptopList, scan);
                    break;
                case "EXIT":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    scan.close();
                    run = false;
                    break;
                default:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();            
                    System.out.println("Выберите пункт меню");
                    break;
            }
        }
    }

    public static void laptopMemory(List<Laptop> array, Scanner sc) {
        System.out.println("Введите необходимый объём паямти");
        int mem = Integer.parseInt(sc.nextLine()); 

        for (var item : array) {
            if(mem <= item.memory){
                printLaptop(item);
            }
        }
        sc.nextLine();
    }
    public static void laptopOS(List<Laptop> array, Scanner sc){
        System.out.println("Введите необходимую ОС");
        String _os = sc.nextLine(); 

        for (var item : array) {
            if(item.OS != null && item.OS.equals(_os.toUpperCase())){
                printLaptop(item);
            }
        }
        sc.nextLine();
    }
    public static void laptopPrice(List<Laptop> array, Scanner sc){
        System.out.println("Введите желаемую цену");
        Double _price = Double.parseDouble(sc.nextLine()); 

        for (var item : array) {
            if(_price >= item.price){
                printLaptop(item);
            }
        }
        sc.nextLine();
    }
    public static void laptopGaiming(List<Laptop> array, Scanner sc){
        for (Laptop laptop : array) {
            if(laptop.gamingLaptop) printLaptop(laptop);
        }
        System.out.println();
        sc.nextLine();
    }
    public static void laptopDiagonal(List<Laptop> array, Scanner sc){
        System.out.println("Введите необходимую диагональ");
        Double _diagonal = Double.parseDouble(sc.nextLine()); 

        for (var item : array) {
            if(_diagonal <= item.screenDiagonal){
                printLaptop(item);
            }
        }
        sc.nextLine();
    }
    public static void printLaptop(Laptop laptop){
        System.out.println(String.format("Название: %s\nЦена: %1f\nОбъём оперативной памяти: %d\nДиагональ: %f\nОбъём памяти: %d\nОперационная система: %s", laptop.name, laptop.price, laptop.ram, laptop.screenDiagonal, laptop.memory, laptop.OS));
        System.out.println();
    }
}