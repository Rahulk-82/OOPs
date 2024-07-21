package OOPs.CustomException;

class ZeroDivisibilityException extends Exception{
    public ZeroDivisibilityException(String s) {
        super(s);
    }
}
public class Execution{

    public static void main(String []args){
        try{
            throw new ZeroDivisibilityException("Value is devided by 0");
        }
        catch(Exception ex){
            System.out.println("Catch exception");
            System.out.println(ex.getMessage());
        }
    }

}
