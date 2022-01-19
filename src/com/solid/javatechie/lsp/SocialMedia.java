package com.solid.javatechie.lsp;

public abstract class SocialMedia {

    // @Support whatsapp, facebook, instagram
    public abstract void chatWithFriend();

    // @Support Facebook, instagram
    public abstract void publishPost(Object Post);

    // @Support whatsapp, facebook, instagram
    public abstract void sendPhotosAndVideos();

    // @Support whatsapp, facebook
    public abstract void groupVideoCall(String... users);


}
