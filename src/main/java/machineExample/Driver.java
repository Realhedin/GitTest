package machineExample;

/**
 * Created by dkorolev on 11/15/15.
 */
public class Driver {

    private String name;

    private String age;


    public Driver(String name, String age) {
        this.name = name;
        this.age = age;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
