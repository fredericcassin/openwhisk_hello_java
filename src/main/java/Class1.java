import com.airbus.openwhisk.test.Hello;
import com.google.gson.JsonObject;

public class Class1 {
    public static JsonObject main(JsonObject args) {
        return Hello.sayHello(Class1.class.getSimpleName(), args);
    }
}
