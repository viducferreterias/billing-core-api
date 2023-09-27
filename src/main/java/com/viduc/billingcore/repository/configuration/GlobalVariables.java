package com.viduc.billingcore.repository.configuration;

import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApplicationScoped
public class GlobalVariables {

    private String token;

    /*public void setToken(String value) {
        token = value;
    }*/

    /*public String getTokenValue() {
        return token;
    }*/

}
