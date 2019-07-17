package vc.thinker.common;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

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
        return Instant.ofEpochMilli(Long.valueOf(jsonParser.getText())).atZone(CURRENT_ZONE_OFFSET).toLocalDateTime();
    }
}
