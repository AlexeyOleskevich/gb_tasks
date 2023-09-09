import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Map<String, Set<String>> contacts = new HashMap<>();
        PhoneBook book = new PhoneBook(contacts);
        Scanner sc = new Scanner(System.in);

        while (true) {
            String inputLine = sc.nextLine();
            String[] parts = inputLine.split(" ");
            String command = parts[0];
            if (command.equals("EXIT")) break;
            switch (command) {
                case "LIST": {
                    System.out.println(book.getContactsList());
                    break;
                }
                case "ADD": {
                    String name = parts[1];
                    String phone = getPhoneNumber(inputLine);
                    book.addContact(name, phone);
                    break;
                }
                case "GET": {
                    String name = parts[1];
                    System.out.println(book.getPhonesByName(name) == null ?
                            " Не найдена запись с фамилией \"" + name + "\""
                            : book.getPhonesByName(name));
                    break;
                }
                case "REMOVE": {
                    String name = parts[1];
                    boolean hasRemoved = book.removePhonesByName(name);
                    if (!hasRemoved) {
                        System.out.printf("Не найдена запись с фамилией \"%s\"", name);
                    }
                    break;
                }
            }
        }
    }

    private static String getPhoneNumber(String input) {
        String[] parts = input.split(" ");
        StringBuilder numberBuilder = new StringBuilder();
        for (int i = 2; i < parts.length; i++) {
            numberBuilder.append(parts[i]).append(" ");
        }
        String number = numberBuilder.toString().trim();
        return number;
    }
}

class PhoneBook {
    private Map<String, Set<String>> contacts;

    public PhoneBook(Map<String, Set<String>> contacts) {
        this.contacts = contacts;
    }

    public void addContact(String name, String phoneNumber) {
        if (!contacts.containsKey(name)) {
            contacts.put(name, new HashSet<String>());
        }
        contacts.get(name).add(phoneNumber);
    }

    public Set<String> getPhonesByName(String name) {
        return contacts.get(name);
    }

    public boolean removePhonesByName(String name) {
        return contacts.remove(name) != null;
    }

    public String getContactsList() {
        StringBuilder list = new StringBuilder();
        for (Map.Entry<String, Set<String>> entry : contacts.entrySet()) {
            list.append(entry.getKey()).append(" = ").append(entry.getValue()).append("\n");
        }
        return list.toString();
    }
}
