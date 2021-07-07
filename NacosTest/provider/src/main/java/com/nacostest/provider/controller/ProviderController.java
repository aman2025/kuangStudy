package com.nacostest.provider.controller;

        import org.springframework.beans.factory.annotation.Value;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {
    @Value("providerName")
    private String name;

    @GetMapping("/send")
    public String send(){
        return name;
    }
}
