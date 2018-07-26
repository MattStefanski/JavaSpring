package com.crud.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
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


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    UrlFactory urlFactory;


    public List<TrelloBoardDto> getTrelloBoards() {
        TrelloBoardDto[] list;
        try {
            list = restTemplate.getForObject(urlFactory.getTrelloBoardsUrl(), TrelloBoardDto[].class);

        } catch (RestClientException e) {
            list = null;
            LOGGER.error(e.getMessage());

        }

        return Arrays.asList(Optional.ofNullable(list).orElse(new TrelloBoardDto[0]));


    }

    public CreatedTrelloCard createNewCard(TrelloCardDto trelloCardDto) {

        return restTemplate.postForObject(urlFactory.createNewCardUrl(trelloCardDto), null, CreatedTrelloCard.class);
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(TrelloClient.class);


}
