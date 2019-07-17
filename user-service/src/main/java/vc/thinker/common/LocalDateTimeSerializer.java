package vc.thinker.common;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * LocalDateTime 序列化成时间戳
 *
 * @author HeTongHao
 * @since 2019-07-15 18:23
 */
public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    public static final LocalDateTimeSerializer INSTANCE;

    static {
        INSTANCE = new LocalDateTimeSerializer();
    }

    private LocalDateTimeSerializer() {
    }

    /**
     * 当前时区偏移量
     */
    private static final ZoneOffset CURRENT_ZONE_OFFSET = ZoneOffset.ofHours(8);

    @Override
    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        //序列化为毫秒时间戳
        jsonGenerator.writeNumber(localDateTime.toInstant(CURRENT_ZONE_OFFSET).toEpochMilli());
    }
}
