package Demo;

public class ClassLoaderTest {

    public ClassLoaderTest() {
        System.out.println(this.getClass().getClassLoader().toString());
    }

    public static void main(String[] args) {
        new ClassLoaderTest();
    }
}
