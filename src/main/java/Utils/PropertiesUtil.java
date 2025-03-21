package Utils;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@UtilityClass
public final class PropertiesUtil {

    private static final Properties PROPERTIES = new Properties();
    public static String get(String key){
        return PROPERTIES.getProperty(key);
    }

    static{
        loadProperties();
    }

    @SneakyThrows
    private static void loadProperties() {
        try(var inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties")){
            PROPERTIES.load(inputStream);
        }
    }
}
