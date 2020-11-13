public class WrongCommandException extends Exception{
    private static final long serialVersionUID = 1L;

    @Override
    public String getMessage()
    {
        return "Input does not match the given options";
    }
}
