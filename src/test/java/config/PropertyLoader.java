package config;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;


@Slf4j
public class PropertyLoader
{
    private static PropertyLoader instance;
    private FileBasedConfiguration configuration;


    private PropertyLoader()
    {
        log.info("Loading properties file");
        Parameters params = new Parameters();
        FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
                new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                        .configure(params.properties()
                                .setFileName("application.properties"));
        try {
            configuration = builder.getConfiguration();
        } catch (ConfigurationException e)
        {
            e.printStackTrace();
        }
        log.info("Properties successfully loaded from file : {}",configuration.toString());
    }

    public static synchronized PropertyLoader getInstance()
    {
        if (instance == null) {
            instance = new PropertyLoader();
        }
        return instance;
    }

    public String getProperty(String key)
    {
        String value = (String) configuration.getProperty(key);
        log.info("Property : key = {} --> value = {}",key,value);
        return value;
    }
}
