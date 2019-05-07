package cn.zyx.converter;



import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期转换器
 */
public class DateConverter implements Converter<String,Date> {

    @Override
    public Date convert(String s) {
        if (s != null && !"".equals(s)){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                return sdf.parse(s);
            }catch (ParseException e){
                e.printStackTrace();
            }
        }

        return null;
    }
}
