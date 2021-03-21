package callum.project.uni.rms.parent.mapper;

import java.sql.Date;
import java.time.LocalDate;

public class MapperUtils {

    public static LocalDate convertSqlDateToLocalDate(Date sqlDate) {
        return sqlDate == null ? null : sqlDate.toLocalDate();
    }

    public static Date convertLocalDateToSqlDate(LocalDate localDate) {
        return localDate == null ? null : Date.valueOf(localDate);
    }
}
