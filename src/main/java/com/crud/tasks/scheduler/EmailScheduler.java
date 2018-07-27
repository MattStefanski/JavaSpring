package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.mailing.SimpleMailService;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {


    @Autowired
    private SimpleMailService simpleMailService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;

    private static final String SUBJECT="TASK: once a day email";

    @Scheduled(cron="0 0 10 * * *")
    public void sendInformationEmail(){
        long size=taskRepository.count();
        if(size==1) {
            simpleMailService.send(new Mail(adminConfig.getAdminMail(), SUBJECT,
                    "Currently in database you got: " + size + " task"));
        }else if(size==0){
            simpleMailService.send(new Mail(adminConfig.getAdminMail(), SUBJECT,
                    "Currently in database you don not hava any task"));
        }else {
            simpleMailService.send(new Mail(adminConfig.getAdminMail(), SUBJECT,
                    "Currently in database you got: " + size + " tasks"));
        }
    }

}
