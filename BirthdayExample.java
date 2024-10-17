
import java.io.*;
import java.util.*;
import ContainerFactory;

public class BirthdayExample {

    // This is a private and static hashmap to store the birthdays
    private static HashMap<String, String> birthdayMap = new HashMap<String, String>();

    // This code reads the JSON file
    // Students do not have to change this function
    public static JSONArray readJSONArrayFile(String fileName) {
        // JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        JSONArray birthdayArr = null;

        // Read JSON file
        try (FileReader reader = new FileReader(fileName)) {
            Object obj = jsonParser.parse(reader);
            birthdayArr = (JSONArray) obj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return birthdayArr;
    }

    // Students do not have to change this function
    public static void initializeMap(final String pathToFile) {
        JSONArray jsonData = readJSONArrayFile(pathToFile);
        // Loop over list
        String birthday, name;
        JSONObject obj;
        for (Integer i = 0; i < jsonData.size(); i++) {
            // Parse the object and pull out the name and birthday
            obj = (JSONObject) jsonData.get(i);
            birthday = (String) obj.get("birthday");
            name = (String) obj.get("name");
            // Add the name and birthday into a hashmap
            birthdayMap.put(name, birthday);
            // Print the names and birthdays
            System.out.println("name = " + name);
            System.out.println("birthday = " + birthday);
        }
    }

    public static void main(final String[] args) {
        String pathToFile = "C:\\Users\\Braga\\OneDrive\\Desktop\\java\\jkl\\birthday.json";
        // Initialize the hash map
        initializeMap(pathToFile);
        // Read user input from keyboard
        System.out.println("Reading user input into a string");
        // Get user input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a name: ");
        String name = input.nextLine();
        // Print user input
        System.out.println("name = " + name);
        // Check if name exists in the birthday map
        if (birthdayMap.containsKey(name)) {
            String birthday = birthdayMap.get(name);
            System.out.println("Birthday of " + name + " is: " + birthday);
        } else {
            System.out.println("No birthday found for " + name);
        }
        // Close the scanner
        input.close();
    }
}

