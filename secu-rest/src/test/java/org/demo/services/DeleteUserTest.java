package org.demo.services;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;


public class DeleteUserTest extends UserRestTest {

    @Test
    public void deleteUserWorksOK() {
        RestTemplate template = new RestTemplate();
        template.delete(url + "/3");

        ResponseEntity<List> resultList = template.getForEntity(url, List.class);
        assertNotNull(resultList);
        assertNotNull(resultList.getBody());
        assertThat(resultList.getBody().size(), is(2));

        assertThat(((Map) resultList.getBody().get(0)).entrySet().toArray()[1].toString(), is("name=Mert Caliskan"));
        assertThat(((Map) resultList.getBody().get(1)).entrySet().toArray()[1].toString(), is("name=Kenan Sevindik"));
    }
}
