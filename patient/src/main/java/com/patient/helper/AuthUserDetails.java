package com.patient.helper;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.util.*;
import java.util.stream.Collectors;

public class AuthUserDetails {

    //full Authentication
    public static Authentication getUserAuth() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (!(authentication instanceof OAuth2Authentication)) {
                return null;
            }
            OAuth2Authentication oauth2Authentication = (OAuth2Authentication) authentication;
            Authentication userAuth = oauth2Authentication.getUserAuthentication();
            System.out.println("Authentication: " + userAuth);
            return userAuth;
        } catch (Exception e) {
            System.out.println("Exception occurred!!!!");
            return null;
        }
    }

    //UserName
    public static Object getUserAuthPrincipal() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (!(authentication instanceof OAuth2Authentication)) {
                return null;
            }
            OAuth2Authentication oauth2Authentication = (OAuth2Authentication) authentication;
            Authentication userAuth = oauth2Authentication.getUserAuthentication();
            return userAuth.getPrincipal();
        } catch (Exception e) {
            System.out.println("Exception occurred!!!!");
            return null;
        }
    }

    //Roles, Permissions
    public static List<String> getUserAuthAuthorities() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (!(authentication instanceof OAuth2Authentication)) {
                return null;
            }
            OAuth2Authentication oauth2Authentication = (OAuth2Authentication) authentication;
            Authentication userAuth = oauth2Authentication.getUserAuthentication();
            return userAuth.getAuthorities().stream().map(a -> a.getAuthority()).collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Exception occurred!!!!");
            return null;
        }
    }
}
