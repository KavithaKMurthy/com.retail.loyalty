package com.retail.loyalty;

import com.retail.loyalty.SpringBootMainApplication;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootMainApplication.class)
public class ApplicationTest {
    @Test
    public void main()
    {
        SpringBootMainApplication.main(new String[]{});
    }
}
