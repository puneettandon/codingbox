package com.solid.javatechie.lsp;


// Whatsapp cannot be substituted of SocialMedia
// Does n't Support LSP
public class WhatsApp extends  SocialMedia{


    @Override
    public void chatWithFriend() {

    }

    @Override
    public void publishPost(Object Post) {
// not applicables
    }

    @Override
    public void sendPhotosAndVideos() {

    }

    @Override
    public void groupVideoCall(String... users) {

    }
}
