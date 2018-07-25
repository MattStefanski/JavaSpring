package com.crud.tasks.controller;

import com.crud.tasks.CreatedTrelloCard;
import com.crud.tasks.TrelloBoardDto;
import com.crud.tasks.TrelloCardDto;
import com.crud.tasks.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

        @Autowired
        private TrelloClient trelloClient;

        @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
        public List<TrelloBoardDto> getTrelloBoards() {
            return trelloClient.getTrelloBoards();
        }

    @RequestMapping(method=RequestMethod.POST,value="createTrelloCard")
    public CreatedTrelloCard createdTrelloCard(@RequestBody TrelloCardDto trelloCardDto){
        return trelloClient.createNewCard(trelloCardDto);
    }

}

