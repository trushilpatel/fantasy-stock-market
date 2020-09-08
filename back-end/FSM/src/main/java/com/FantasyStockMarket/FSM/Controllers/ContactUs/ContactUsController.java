package com.FantasyStockMarket.FSM.Controllers.ContactUs;

import com.FantasyStockMarket.FSM.Entity.ContactUs.ContactUs;
import com.FantasyStockMarket.FSM.Response.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/contact-us")
@CrossOrigin("http://localhost:8081")
public class ContactUsController {

    @Autowired
    private ContactUsServices contactUsServices;

    @GetMapping("")
    List<ContactUs> getAllContactUs() {
        return contactUsServices.getAllContactUs();
    }

    @PostMapping("")
    ContactUs saveContactUs(@RequestBody ContactUs contactUs) {
        return contactUsServices.saveContactUs(contactUs);
    }

    @DeleteMapping("")
    Message deleteContactUs(@RequestBody ContactUs contactUs) {
       return contactUsServices.deleteContactUs(contactUs);
    }
}
