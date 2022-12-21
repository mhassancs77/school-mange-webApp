/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.schoolwebapp.dto;


public class SearchStudent {

    String searchCountry;
    String searchGender;
    int searchClass;

    public String getSearchCountry() {
        return searchCountry;
    }

    public void setSearchCountry(String searchCountry) {
        this.searchCountry = searchCountry;
    }

    public String getSearchGender() {
        return searchGender;
    }

    public void setSearchGender(String searchGender) {
        this.searchGender = searchGender;
    }

    public int getSearchClass() {
        return searchClass;
    }

    public void setSearchClass(int searchClass) {
        this.searchClass = searchClass;
    }

    

}
