package com.designpattern.techgranth.strategydesginpattern;

public class VideoPlayerMain {

    public static void main(String[] args) {

        Resolution phoneResolution = new Resolution480p();
        Device phoneDevice = new Phone();

        VideoPlayer videoPlayer1 = new PhoneVideoPlayer(phoneDevice,phoneResolution);
        videoPlayer1.display();

        Resolution tvResolution = new Resolution1080p();
        Device tvDevice = new TV();

        VideoPlayer videoPlayer2  = new PhoneVideoPlayer(tvDevice,tvResolution);
        videoPlayer2.display();
    }
}
