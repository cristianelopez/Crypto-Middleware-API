package crypto.middleware.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import crypto.middleware.model.Account;

import java.io.IOException;

public class UserJsonSerializer extends JsonSerializer<Account> {

    @Override
    public void serialize(Account user, JsonGenerator jgen, SerializerProvider serializers) throws IOException {
        jgen.writeStartObject();


        jgen.writeNumberField("id", user.getId());
        jgen.writeStringField("name", user.getName());
        jgen.writeStringField("surname", user.getSurname());
        jgen.writeStringField("email", user.getEmail());
        jgen.writeStringField("address", user.getAddress());
        jgen.writeStringField("password", user.getPassword());
        jgen.writeStringField("cvu", user.getCvu());
        jgen.writeStringField("wallet", user.getWallet());
        jgen.writeStringField("score", user.getScore());
        jgen.writeObjectField("operationsNumber", user.getOperationsNumber());

        jgen.writeEndObject();
    }
}



