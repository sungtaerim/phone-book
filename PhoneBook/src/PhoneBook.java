import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class PhoneBook {

    static TreeMap<String, String> phoneBook = new TreeMap<>();

    static void newSign(String sign) {
        if (sign.equals("LIST")) {
            print();
        }
        else if (Character.isDigit(sign.charAt(0))) {
            if (isNumber(sign)) {
                isNumberNew(sign);
            } else {
                System.out.println("Неверный формат ввода");
            }
        } else {
            if (isName(sign)) {
                isNameNew(sign);
            } else {
                System.out.println("Неверный формат ввода");
            }
        }
    }

    static void print(){
        if (phoneBook.isEmpty()) {
            System.out.println("В записной книге ещё нет записей");
        } else {
            Map<String,String> result = new LinkedHashMap<>();
            Stream <Map.Entry<String,String>> st = phoneBook.entrySet().stream();

            st.sorted(Map.Entry.comparingByValue())
                    .forEach(e ->result.put(e.getKey(),e.getValue()));

            Set<Map.Entry<String, String>> entries = result.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                System.out.println(entry.getValue() + " - " + entry.getKey());
            }
        }
    }

    static boolean isNumber(String phoneNumber) {
        return Pattern.compile("\\d{4,11}").matcher(phoneNumber).matches();
    }

    static boolean isName(String name) {
        return Pattern.compile("([А-Я][а-я]+)").matcher(name).matches();
    }

    static void isNumberNew(String phoneNumber) {
        if (phoneBook.containsKey(phoneNumber)) {
            System.out.println(phoneBook.get(phoneNumber) + " - " + phoneNumber);
        } else {
            System.out.println("Такого номера нет в телефонной книге." +
                    "\nВведите имя абонента для номера “" + phoneNumber + "”:");
            String name = (new Scanner(System.in)).next();
            if (isName(name)) {
                phoneBook.put(phoneNumber, name);
                System.out.println("Контакт “" + name + "“ добавлен");
            }
        }
    }

    static void isNameNew(String name) {
        if (phoneBook.containsValue(name)) {
            Set<String> keys = new HashSet<>();
            for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                if (entry.getValue().equals(name)) {
                    keys.add(entry.getKey());
                }
            }
            System.out.println(name + " - " + keys);

        } else {
            System.out.println("Такого имени в телефонной книге нет." +
                    "\nВведите номер телефона для абонента “" + name + "”:");
            String phoneNumber = (new Scanner(System.in)).next();
            if (isNumber(phoneNumber)) {
                phoneBook.put(phoneNumber, name);
                System.out.println("Контакт “" + name + "“ добавлен");
            }
        }
    }
}
