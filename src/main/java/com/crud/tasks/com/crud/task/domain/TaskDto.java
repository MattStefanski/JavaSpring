package com.crud.tasks.com.crud.task.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class TaskDto extends Task {

    private Long id;

    private String title;

    private String content;
}


