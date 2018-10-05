package util;

import com.model.dto.ConfigBean;
import com.util.LoadConfig;
import org.junit.Test;
import static org.junit.Assert.*;

public class loadConfig_Test {
    @Test
    public void loadParam_test() {
        LoadConfig param = LoadConfig.getInstance();
        ConfigBean configuration = param.getConfiguration();
        System.out.print("DB URL:"+configuration.getDBURL());
        System.out.print("DB Usuario:"+configuration.getDBUser());
        System.out.print("DB Password:"+configuration.getDBPassword());
        assertNotNull( param.getConfiguration());
    }

}
