package com.crud.tasks.com.crud.task.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    private Long id;

    private String title;

    private String content;
}


