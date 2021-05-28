import java.io.File;
import java.lang.reflect.InvocationTargetException;

public class Main {


    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String path="D:\\PA\\lab12";
        Solution.readFileRecursive(new File(path),path);
    }
}
