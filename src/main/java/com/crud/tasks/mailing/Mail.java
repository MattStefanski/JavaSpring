package com.crud.tasks.domain;



import lombok.Getter;

@Getter
public class Mail {

    private String mailTo;
    private String subject;
    private String message;
    private String toCC=null;


    public Mail(String mailTo, String subject, String message) {
        this.mailTo = mailTo;
        this.subject = subject;
        this.message = message;
    }

    public void setToCC(String toCC) {
        this.toCC = toCC;
    }
}
