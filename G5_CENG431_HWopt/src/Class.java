import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class Class {
    private String name = "Class";
    private List<IMethod> methods_and_variables;

    public Class(){
        methods_and_variables = new ArrayList<>();
    }

    public void addComponent(IMethod method){
        methods_and_variables.add(method);
    }

    public void removeComponent(IMethod method){
        methods_and_variables.remove(method);
    }

    public String getName() {
        return name;
    }

    public void count(){
        StringBuilder stringBuilder = new StringBuilder();
        for(IMethod m: methods_and_variables){
            stringBuilder.append(m.getCount());
        }
        String components = stringBuilder.toString();
        int methodCount = StringUtils.countMatches(components, "Method");
        int variableCount = StringUtils.countMatches(components, "Variable");
        System.out.println("This class has " + String.valueOf(methodCount) + " methods and " + String.valueOf(variableCount) + " variables");
    }
}