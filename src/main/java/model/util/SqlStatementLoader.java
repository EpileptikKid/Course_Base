package model.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class SqlStatementLoader {
    private static volatile SqlStatementLoader instance;
    private final Properties properties = new Properties();
    private static final String PROPERTIES_PATH = "db/sqlStatements.properties";

    public static SqlStatementLoader getInstance() {
        if (instance==null) {
            synchronized (SqlStatementLoader.class) {
                if (instance==null) {
                    instance = new SqlStatementLoader(PROPERTIES_PATH);
                }
            }
        }
        return instance;
    }

    private SqlStatementLoader(String propertiesPath) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (InputStream inputStream = loader.getResourceAsStream(propertiesPath)) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public String getSqlStatement(String propertyValue) {
        Optional<String> sqlOpt = Optional.ofNullable(properties.getProperty(propertyValue));
        return sqlOpt.orElseThrow(IllegalStateException::new);
    }
}
