import com.airbus.openwhisk.test.Hello;
import com.google.gson.JsonObject;

public class Class2 {
    public static JsonObject main(JsonObject args) {
        return Hello.sayHello(Class2.class.getSimpleName(), args);
    }
}
