package Shell;

public class InvalidCatalogException extends Exception{
    public InvalidCatalogException(){
        super("No catalog loaded! Please load one before!\n");
    }
}
