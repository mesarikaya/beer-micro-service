package com.mes.beermicroservice.web.mappers;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * Created by mesar on 2/12/2020
 */
@Component
public class DateMapper {

    public OffsetDateTime asOffsetDateTime(Timestamp ts){
        if(ts != null){
            LocalDateTime dateTime = ts.toLocalDateTime();
            return OffsetDateTime.of(dateTime.getYear(), dateTime.getMonthValue(), dateTime.getDayOfMonth(),
                    dateTime.getHour(), dateTime.getMinute(), dateTime.getSecond(), dateTime.getNano(), ZoneOffset.UTC);
        }else{
            return null;
        }
    }

    public Timestamp asTimestamp(OffsetDateTime offsetDateTime){
        if(offsetDateTime != null){
            return Timestamp.valueOf(offsetDateTime.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
        }else{
            return null;
        }
    }
}
