package vc.thinker.common;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * 文本形式的时间戳,反序列化成LocalDateTime
 *
 * @author HeTongHao
 * @since 2019-07-15 18:23
 */
public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    public static final LocalDateTimeDeserializer INSTANCE;

    static {
        INSTANCE = new LocalDateTimeDeserializer();
    }

    private LocalDateTimeDeserializer() {
    }

    /**
     * 当前时区偏移量
     */
    private static final ZoneOffset CURRENT_ZONE_OFFSET = ZoneOffset.ofHours(8);

    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String value = jsonParser.getText();
        if (value.contains("-") || (value.contains(":"))) {
            return LocalDateTime.parse(value, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        }
        return Instant.ofEpochMilli(Long.valueOf(value)).atZone(CURRENT_ZONE_OFFSET).toLocalDateTime();
    }
}
