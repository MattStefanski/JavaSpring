package com.crud.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class TrelloClient {

    @Value("${trello.api.endpoint.prod}")
    private String trelloApiEndpoint;

    @Value("${trello.app.key}")
    private String trelloAppKey;

    @Value("${trello.app.token}")
    private String trelloToken;


    @Autowired
    private RestTemplate restTemplate;


    private URI buildUri(){
        URI url = UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + "/members/5b578f2cc23c72329b98d5b0/boards")
                .queryParam("key", trelloAppKey)
                .queryParam("token", trelloToken)
                .queryParam("fields", "name,id").build().encode().toUri();
        return url;
    }

    public List<TrelloBoardDto> getTrelloBoards(){


        TrelloBoardDto[] list=restTemplate.getForObject(this.buildUri(),TrelloBoardDto[].class);


        return Arrays.asList(Optional.ofNullable(list).orElse(new TrelloBoardDto[0]));


    }


}
