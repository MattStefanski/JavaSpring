package com.crud.tasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TasksApplicationTests {



	@Autowired
	TrelloClient trelloClient;

	@Test
	public void test(){




		trelloClient.createNewCard(new TrelloCardDto("dass","adsada","top","5b1811b2dcda9547822ea5c1"));

	}

	@Test
	public void contextLoads() {
	}

}
