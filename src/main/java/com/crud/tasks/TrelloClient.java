package com.crud.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class TrelloClient {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TrelloConfig trelloConfig;

    @Autowired
    UrlFactory urlFactory;


    public List<TrelloBoardDto> getTrelloBoards() {
        try {

            TrelloBoardDto[] boardsResponse = restTemplate.getForObject(urlFactory.getTrelloBoardsUrl(), TrelloBoardDto[].class);
            return Arrays.asList(Optional.ofNullable(boardsResponse).orElse(new TrelloBoardDto[0]));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage());
            return new ArrayList<>();

        }

    }

    public CreatedTrelloCard createNewCard(TrelloCardDto trelloCardDto) {

        return restTemplate.postForObject(urlFactory.createNewCardUrl(trelloCardDto), null, CreatedTrelloCard.class);

    }

    private static final Logger LOGGER = LoggerFactory.getLogger(TrelloClient.class);


}