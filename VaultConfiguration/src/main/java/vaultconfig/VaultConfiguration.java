package vaultconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(Credential.class)
public class VaultConfiguration implements CommandLineRunner {

    private Credential credential;
    private Logger log= LoggerFactory.getLogger((VaultConfiguration.class));
    public VaultConfiguration(Credential credential) {
        this.credential = credential;
    }

    public static void main(String[] args) {
        SpringApplication.run(VaultConfiguration.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("User Credentials");
        log.info("User Name:"+credential.getUsername());
        log.info("Password:"+credential.getPassword());
    }
}
