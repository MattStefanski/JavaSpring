package com.crud.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER=LoggerFactory.getLogger(TrelloClient.class);

    private URI buildUri(){
        URI url = UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + "/members/mateuszstefanski5/boards")
                .queryParam("key", trelloAppKey)
                .queryParam("token", trelloToken)
                .queryParam("fields", "name,id")
                .queryParam("lists","all")
                .build().encode().toUri();
        return url;
    }

    public List<TrelloBoardDto> getTrelloBoards(){
        TrelloBoardDto[] list;
        try {
                list = restTemplate.getForObject(this.buildUri(), TrelloBoardDto[].class);

        } catch (Exception e) {
                list=null;
                LOGGER.error(e.getMessage());

        }

        return Arrays.asList(Optional.ofNullable(list).orElse(new TrelloBoardDto[0]));


    }

    public CreatedTrelloCard createNewCard(TrelloCardDto trelloCardDto){
        URI url= UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint+"/cards")
                .queryParam("key",trelloAppKey)
                .queryParam("token",trelloToken)
                .queryParam("name",trelloCardDto.getName())
                .queryParam("desc",trelloCardDto.getDescription())
                .queryParam("pos",trelloCardDto.getPos())
                .queryParam("idList",trelloCardDto.getListId())
                .build().encode().toUri();
        System.out.println(url);

        System.out.println(url);
        return restTemplate.postForObject(url,null,CreatedTrelloCard.class);
    }


}
