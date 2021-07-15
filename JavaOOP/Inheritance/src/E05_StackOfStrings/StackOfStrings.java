package E05_StackOfStrings;

import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String str) {
        data.add(0, str);
    }

    public String pop() {
        String str = data.get(0);
        data.remove(0);
        return str;
    }

    public String peek() {
        return data.get(0);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}
