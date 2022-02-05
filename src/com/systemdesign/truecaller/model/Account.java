package com.systemdesign.truecaller.model;

import com.systemdesign.truecaller.model.common.Contact;
import com.systemdesign.truecaller.model.common.PersonalInfo;
import com.systemdesign.truecaller.model.common.SocialInfo;
import com.systemdesign.truecaller.model.common.Tag;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

public abstract class Account {
    private String id;
    private String phoneNumber;
    private String userName;
    private String password;
    private LocalDateTime lastAccessed;
    private Tag tag;
    private Contact contact;
    private PersonalInfo personalInfo;
    private SocialInfo socialInfo;
    private Business business;
    private UserCategory userCategory;
    private Map<String, User> contacts;
   // private CountingBloomFilter<String> blockedContacts;
    private Set<String> blockedSet;
  //  private ContactTrie contactTrie;

    public Account() {
    }

    public Account(String phoneNumber,String firstName) {
        this.phoneNumber = phoneNumber;
        this.personalInfo = new PersonalInfo(firstName);
    }

    public Account(String phoneNumber,String firstName,String lastName) {
       this(phoneNumber,firstName);
       this.personalInfo.setLastName(lastName);
    }


}

