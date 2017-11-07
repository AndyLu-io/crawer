package java8;

/**
 * @Author : qingxiao
 * @Description:
 * @Date : Created in 下午12:05  2017/11/3
 */
public class Person {
    private String name;

    private Integer age;

    private String Adderss;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAdderss() {
        return Adderss;
    }

    public void setAdderss(String adderss) {
        Adderss = adderss;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", Adderss='" + Adderss + '\'' +
                '}';
    }
}
