package com.example.Simple.API;

import com.example.Simple.API.model.apoio.CustomPageImpl;
import com.example.Simple.API.model.entity.Pessoa;
import java.time.LocalDate;
import java.util.logging.Logger;
import org.hibernate.query.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SimpleApiApplicationTests {

    @Autowired
    private TestRestTemplate trt;

//    private static final Logger LOG = Logger.getLogger(SimpleApiApplicationTests.class.getName());
    /***
     * O mais indicado é que cada tese seja uma função diferente
     * com a sequência definida.
     * 
     */
    @Test
    void contextLoads() {

        Pessoa pessoa = new Pessoa(null, "Fulano da silva", LocalDate.now());

        ResponseEntity<? extends Pessoa> saveTest = trt.postForEntity("/pessoa/save", pessoa, pessoa.getClass());

        Assertions.assertEquals(saveTest.getStatusCode(), HttpStatus.OK);
        Assertions.assertNotNull(saveTest.getBody());

        //tive que implementar um model só pra iserir a page aparentemente o mapper não consegue lidar muito bem com interfaces ainda
        ResponseEntity<CustomPageImpl<Pessoa>> getByExampleTest = trt.exchange(
                "/pessoa/find_page_by_example",
                HttpMethod.POST,
                saveTest,
                new ParameterizedTypeReference<CustomPageImpl<Pessoa>>() {
        });

        Assertions.assertEquals(getByExampleTest.getStatusCode(), HttpStatus.OK);
        Assertions.assertNotNull(getByExampleTest.getBody());
        Assertions.assertEquals(getByExampleTest.getBody().hasContent(), true);

        Assertions.assertNotNull(saveTest.getBody().getId());
        Assertions.assertEquals(getByExampleTest.getBody().getContent().get(0).getId(), saveTest.getBody().getId());

        trt.delete("/pessoa/delete_by_id/" + saveTest.getBody().getId().toString());

        Pessoa deleteTestDTO = new Pessoa(saveTest.getBody().getId(), null, null);

        ResponseEntity<CustomPageImpl<Pessoa>> DeleteTest = trt.exchange(
                "/pessoa/find_page_by_example",
                HttpMethod.POST,
                saveTest,
                new ParameterizedTypeReference<CustomPageImpl<Pessoa>>() {
        });

        Assertions.assertEquals(DeleteTest.getStatusCode(), HttpStatus.OK);
        Assertions.assertNotNull(DeleteTest.getBody());
        Assertions.assertEquals(DeleteTest.getBody().hasContent(), false);
    }

}
