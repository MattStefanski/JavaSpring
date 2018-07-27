package com.crud.tasks.trello;

import com.crud.tasks.TrelloBoardDto;
import com.crud.tasks.TrelloClient;
import com.crud.tasks.mailing.SimpleMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrelloService {


    @Autowired
    private TrelloClient trelloClient;


    @Autowired
    private SimpleMailService simpleMailService;

    public List<TrelloBoardDto> fetchTrelloBoards(){
        return trelloClient.getTrelloBoards();
    }



}
