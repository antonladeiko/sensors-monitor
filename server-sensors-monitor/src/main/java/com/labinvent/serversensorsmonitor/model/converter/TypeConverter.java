package com.labinvent.serversensorsmonitor.model.converter;

import com.labinvent.serversensorsmonitor.model.enums.Type;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class TypeConverter implements AttributeConverter<Type, String> {

    @Override
    public String convertToDatabaseColumn(Type type) {
        if (type == null){
            return null;
        }

        return type.getType();
    }

    @Override
    public Type convertToEntityAttribute(String type) {
        if (type == null) {
            return null;
        }

        return Stream.of(Type.values())
                .filter(t -> t.name().equals(type.toUpperCase()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
