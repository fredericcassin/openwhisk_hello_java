package com.airbus.openwhisk.test;

import com.google.gson.JsonObject;

public class Hello {
    public static JsonObject sayHello(String origin, JsonObject args) {
        String name = "stranger";
        if (args.has("name"))
            name = args.getAsJsonPrimitive("name").getAsString();
        JsonObject response = new JsonObject();
        response.addProperty("greeting", String.format("Hello %s from %s", name, origin));
        return response;
    }
}
