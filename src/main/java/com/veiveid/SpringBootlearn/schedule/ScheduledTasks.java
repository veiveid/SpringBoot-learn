package com.veiveid.SpringBootlearn.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(cron="*/5 * * * * *")
    public void reportCurrentTime() {
        //System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
}