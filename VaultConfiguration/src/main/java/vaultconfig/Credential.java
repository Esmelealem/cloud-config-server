package vaultconfig;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("credential")
public class Credential {
    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;
}
