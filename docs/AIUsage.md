ChatGPT was used to get the necessary text to add mockito to the project as it wasn't showing on the list of generatable
dependencies. The code offered was out of date though, and replaced with code from mvnrepository.com


Used to confirm there wasn't a better way to clear the screen then System.out.print("\033[H\033[2J");
System.out.flush();



me: if i passed an ArrayList into another class, is there any way to stop that class being able to change the data of that arraylist?

chatgpt:     Pass an Unmodifiable List: Instead of passing the original ArrayList, you can pass an unmodifiable view of the list using Collections.unmodifiableList() method. This prevents the other class from modifying the list.

java

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Main {
public static void main(String[] args) {
ArrayList<String> originalList = new ArrayList<>();
originalList.add("Item 1");
originalList.add("Item 2");

        OtherClass otherClass = new OtherClass(Collections.unmodifiableList(originalList));
        // Attempt to modify the list in the other class
        // otherClass.modifyList(); // This will throw UnsupportedOperationException
    }
}

class OtherClass {
private List<String> readOnlyList;

    public OtherClass(List<String> readOnlyList) {
        this.readOnlyList = readOnlyList;
    }
    
    public void modifyList() {
        // Attempting to modify the list will throw UnsupportedOperationException
        readOnlyList.add("New Item");
    }
}

    Defensive Copy: Instead of passing the original ArrayList, pass a copy of it to the other class. This way, any modifications made in the other class won't affect the original list.

java

import java.util.ArrayList;

public class Main {
public static void main(String[] args) {
ArrayList<String> originalList = new ArrayList<>();
originalList.add("Item 1");
originalList.add("Item 2");

        OtherClass otherClass = new OtherClass(new ArrayList<>(originalList));
        // Modifications in otherClass won't affect originalList
        // otherClass.modifyList(); // You can safely call this
    }
}

class OtherClass {
private ArrayList<String> internalList;

    public OtherClass(ArrayList<String> list) {
        this.internalList = list;
    }
    
    public void modifyList() {
        // You can modify the list here
        internalList.add("New Item");
    }
}

Both approaches have their pros and cons. Using an unmodifiable list is safer but if you need to modify the list within the original class, defensive copying might be more suitable. Choose the approach based on your specific requirements.

--
I went with the defensive programming technique and modified addressbook to return a new arraylist made up on the contacts instead of the straight contacts
