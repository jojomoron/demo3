package com.example.demo;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ApplicationLoader implements CommandLineRunner {

	//測Retry
	@Autowired
    private BookService bookService;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			bookService.getBook();
        } catch (Exception e) {
            e.printStackTrace();
        }

	}
	
	//測Cache
//	@Autowired
//    private TimeService timeService;
//
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        for(int i = 0 ; i < 30 ; i++){
//            System.out.println(sdf.format(timeService.getTime()));
//            Thread.sleep(1000);
//        }
//    }

}
