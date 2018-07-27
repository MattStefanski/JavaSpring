package com.crud.tasks.trello.service;


import com.crud.tasks.CreatedTrelloCard;
import com.crud.tasks.TrelloBoardDto;
import com.crud.tasks.TrelloCardDto;
import com.crud.tasks.TrelloClient;
import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.mailing.SimpleMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrelloService {

    @Autowired
    private TrelloClient trelloClient;

    @Autowired
    private SimpleMailService simpleMailService;

    @Autowired
    private AdminConfig adminConfig;


    public List<TrelloBoardDto> fetchTrelloBoards() {
        return trelloClient.getTrelloBoards();
    }


    public CreatedTrelloCard createdTrelloCard(final TrelloCardDto trelloCardDto) {
       CreatedTrelloCard newCard = trelloClient.createNewCard(trelloCardDto);
       Optional.ofNullable(newCard).ifPresent(card->simpleMailService.send(new Mail(adminConfig.getAdminMail(),"Tasks: New Trello Card",
               "New Card "+card.getName()+" has been createn on your Trello account")));
       return newCard;
    }

}
