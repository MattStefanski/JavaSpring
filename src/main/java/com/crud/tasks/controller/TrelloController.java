package com.crud.tasks.controller;

import com.crud.tasks.CreatedTrelloCard;
import com.crud.tasks.TrelloBoardDto;
import com.crud.tasks.TrelloCardDto;
import com.crud.tasks.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

        @Autowired
        private TrelloClient trelloClient;
        @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
        public void getTrelloBoards() {


            String KODILLA="Kodilla";
            List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

            trelloBoards.stream()
                    .filter(t->t.getId()!=null)
                    .filter(t->t.getName().contains(KODILLA))
                    .forEach(trelloBoardDto -> System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName()));


            System.out.println("This board contains lists: ");


            trelloBoards.forEach(trelloBoardDto -> {

                System.out.println(trelloBoardDto.getName() + " - " + trelloBoardDto.getId());

                System.out.println("This board contains lists: ");

                trelloBoardDto.getLists().forEach(trelloList ->
                        System.out.println(trelloList.getName() + " - " + trelloList.getId() + " - " + trelloList.isClosed()));

            });

        }

        @RequestMapping(method=RequestMethod.POST,value="createTrelloCard")
        public CreatedTrelloCard createdTrelloCard(@RequestParam TrelloCardDto trelloCardDto){
            return trelloClient.createNewCard(trelloCardDto);
        }
}

