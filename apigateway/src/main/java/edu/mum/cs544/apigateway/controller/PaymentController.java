package edu.mum.cs544.apigateway.controller;

import edu.mum.cs544.apigateway.domain.PaymentDetail;
import edu.mum.cs544.apigateway.service.PaymentService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/payment")
public class PaymentController {
    private final String base = "/payment";

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/")
    public String pay(Model model){
        model.addAttribute("amount",100.0);
        model.addAttribute("payView","/payment/pay");
        return "payenable";
    }

    @GetMapping("/pay")
    public RedirectView payNow(){//@ModelAttribute("amount") String amount
//        System.out.println("---"+amount);
        String url = paymentService.makePayment("10");
        System.out.println(url);
        RedirectView redir = new RedirectView();
        redir.setUrl(url);
        return redir;
    }
    @GetMapping("/cancel")
    public String cancelled(){

        return "pay_cancel";
    }

    @GetMapping("/success")
    public String success(@RequestParam String paymentId, @RequestParam String token, @RequestParam String PayerID, Model model){
        System.out.println("Payment ID:"+paymentId);
        model.addAttribute("paymentId",paymentId);
        model.addAttribute("token",token);
        model.addAttribute("PayerID",PayerID);

        try {
            PaymentDetail pd = paymentService.logTransaction(paymentId,token,PayerID);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "pay_success";
    }


}
