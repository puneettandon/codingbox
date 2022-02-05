package com.designpattern.techgranth.adapterdesignpattern;

public class AviPlayer implements AdvanceMediaPlayer{

    @Override
    public void playAdvanceFormat(AdvanceFormat advanceFormat) {
        System.out.println("Playing advance AVI format using Advance player"+advanceFormat.getFileToPlay()+"."+advanceFormat.getFormatToPlay()+" in resolution "+advanceFormat.getResolution());
    }
}
