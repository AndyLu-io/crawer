package baseDemo;

public class ClassLoaderTest {

    public ClassLoaderTest() {
        Class<? extends ClassLoaderTest> aClass = this.getClass();
        ClassLoader classLoader = aClass.getClassLoader();
        ClassLoader parent = classLoader.getParent();
        String name = aClass.getName();
        System.out.println(name + ":" + parent);
    }


    public static void main(String[] args) {
        new ClassLoaderTest();
    }
}
