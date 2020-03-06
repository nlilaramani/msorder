/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecomm.orderservice.controller;

/**
 *
 * @author 212616565
 */
public class OrderController_Security {
    @RestController
    public class MessageOfTheDayController {
        @GetMapping("/mod")
        @PreAuthorize("#oauth2.hasScope('custom_scope')")
        public String getMessageOfTheDay(Principal principal) {
            return "The message of the day is boring for user: " + principal.getName();
        }
    }
}
