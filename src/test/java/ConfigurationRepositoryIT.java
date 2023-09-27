import com.viduc.billingcore.dto.components.SettingProfileDto;
import com.viduc.billingcore.repository.configuration.ConfigurationRepository;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.java.Log;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@Log
@ExtendWith(ArquillianExtension.class)
public class ConfigurationRepositoryIT {

    @Inject
    private ConfigurationRepository configurationRepository;

    @PersistenceContext(unitName = "factur")
    private EntityManager em;

    @Deployment
    public static WebArchive deploying() {
        return ShrinkWrap.create(WebArchive.class)
                .addPackages(true , "com.viduc.billingcore")
                .addAsResource("test-persistence.xml" , "META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE , "beans.xml");
    }

    //@Test
    public void testOne() {

        var settingProfile = SettingProfileDto.builder()
                                                .state(1)
                                                .configuration("catalogo ambiente de destino")
                                                .application("FACTUR")
                                                .module("FACE")
                                                .type("CONFIGURACION")
                                                .build();
        var result = configurationRepository.getConfiguration(em , settingProfile);
        log.info(result.toString());

    }

}
