package org.demo.services;

import java.util.List;
import java.util.Map;

import org.demo.model.User;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class AddUserTest extends UserRestTest {

    @Test
    public void addUserWorksOK() {
        RestTemplate template = new RestTemplate();
        User user = new User(3, "Funda Bayulu");
        ResponseEntity<Void> resultSave = template.postForEntity(url, user, Void.class);
        assertNotNull(resultSave);

        ResponseEntity<List> resultList = template.getForEntity(url, List.class);
        assertNotNull(resultList);
        assertNotNull(resultList.getBody());
        assertThat(resultList.getBody().size(), is(3));

        assertThat(((Map) resultList.getBody().get(0)).entrySet().toArray()[1].toString(), is("name=Mert Caliskan"));
        assertThat(((Map) resultList.getBody().get(1)).entrySet().toArray()[1].toString(), is("name=Kenan Sevindik"));
        assertThat(((Map) resultList.getBody().get(2)).entrySet().toArray()[1].toString(), is("name=Funda Bayulu"));
    }
}
