import org.testng.annotations.Test;
import java.lang.reflect.*;

public class MyTestFramework {
    public static void main(String[] args) throws Exception {
        int passed = 0, failed = 0;
        ClassLoader classLoader=MyProgram.class.getClassLoader();
        Class aClass=classLoader.loadClass("com.lab12.MyProgram");
        System.out.println(aClass.getName());
        for (Method m : Class.forName(args[0]).getMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                try {
                    m.invoke(null);
                    passed++;
                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n",
                            m, ex.getCause());
                    failed++;
                }
            }
        }
        System.out.printf("Passed: %d, Failed %d%n", passed, failed);
    }
}