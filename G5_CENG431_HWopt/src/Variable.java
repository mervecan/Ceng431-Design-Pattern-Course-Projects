public class Variable implements IMethod{
    public String name = "Variable";

    public Variable(){

    }

    public String getName() {
        return name;
    }

    @Override
    public String getCount() {
        return name;
    }
}
