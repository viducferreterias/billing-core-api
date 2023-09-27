package repository.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.viduc.billingcore.dto.request.sales.DteRequestDto;
import com.viduc.billingcore.repository.configuration.DteApiRepository;
import jakarta.inject.Inject;
import lombok.extern.java.Log;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@Log
@ExtendWith(ArquillianExtension.class)
public class DteApiRepositoryIT {

    @Inject
    private DteApiRepository dteApiRepository;

    @Deployment
    public static WebArchive createDeployment() {
        WebArchive war = ShrinkWrap.create(WebArchive.class , "billing-core-test.war")
                .addPackages(true , "com.viduc.billingcore")
                .addAsResource("test-persistence.xml" , "META-INF/persistence.xml")
                //.addAsManifestResource(EmptyAsset.INSTANCE, "test-persistence.xml") ;
                .addAsManifestResource(EmptyAsset.INSTANCE , "beans.xml");

        log.info(war.toString(true));

        return war;
    }

    @Test
    @DisplayName("probando generador de dte")
    public void testSomething() throws Exception {

        //dteApiRepository.authenticate();

    }

}
