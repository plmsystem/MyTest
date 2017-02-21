package com.example.controller;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.DemoApplication;

@RunWith(SpringJUnit4ClassRunner.class)	
@SpringBootTest(classes=DemoApplication.class)
@WebAppConfiguration
public class PersonControllerTest {

}
