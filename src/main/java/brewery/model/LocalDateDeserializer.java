package brewery.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by mesar on 2/14/2020
 */
public class LocalDateDeserializer extends StdDeserializer<LocalDate> {

    public LocalDateDeserializer(Class<?> vc) {
        super(LocalDate.class);
    }

    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        return LocalDate.parse(jsonParser.readValueAs(String.class), DateTimeFormatter.BASIC_ISO_DATE);
    }
}
