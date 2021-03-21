package Shell;

public class NoItemFoundException extends Exception {
    public NoItemFoundException(){
        super("Your item was not found in the loaded Catalog!");
    }
}
