package InheritanceLAB.StackOfStrings;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {

    private List<String> data;

    public StackOfStrings(){
        this.data = new ArrayList<>();
    }

    public void push(String element){
        data.add(0, element);
    }

    public String pop(){
        return data.remove(0);
    }

    public String peek(){
        return data.get(0);
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }
}
