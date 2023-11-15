package tn.iit.beans;

import org.springframework.stereotype.Component;

@Component
public class HelloBean {
    public String getMessage(String msg) {
        return "Hello Spring"+msg;
    }
}
