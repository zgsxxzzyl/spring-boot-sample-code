package com;

//@Component
public class CustomService {
    //    @Autowired
    private CustomProperties customProperties;

    public CustomService() {
        System.out.println("");
    }

    public String name() {
        return customProperties.getName();
    }
}
