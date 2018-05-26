import java.util.ArrayList;
import java.util.List;

public class Method implements IMethod{
    private String name = "Method";
    private List<Variable> variables;

    public Method(){
        variables = new ArrayList<>();
    }

    public void addComponent(Variable variable){
        variables.add(variable);
    }

    public void removeComponent(Variable variable){
        variables.remove(variable);
    }

    public String getName() {
        return name;
    }

    @Override
    public String getCount() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(name);
        for(Variable variable: variables){
            stringBuffer.append(variable.getCount());
        }
        return stringBuffer.toString();
    }

    public void count(){
        int variableCount = variables.size();
        System.out.println("This method has " + String.valueOf(variableCount) + " variables");
    }
}
