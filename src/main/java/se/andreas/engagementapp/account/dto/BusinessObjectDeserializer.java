package se.andreas.engagementapp.account.dto;

import jakarta.json.bind.serializer.DeserializationContext;
import jakarta.json.bind.serializer.JsonbDeserializer;
import jakarta.json.stream.JsonParser;

import java.lang.reflect.Type;

public class BusinessObjectDeserializer implements JsonbDeserializer<BusinessObject> {
    @Override
    public BusinessObject deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Type type) {
        jsonParser.next();
        String className = jsonParser.getString();
        jsonParser.next();

        try {
            return deserializationContext.deserialize(Class.forName("se.andreas.engagementapp.account.dto." + className).asSubclass(BusinessObject.class), jsonParser);
        } catch (ClassNotFoundException e) {
            System.err.println("Could not serialize class: " + e.getMessage());
            jsonParser.getObject();
        }
        return null;
    }
}
