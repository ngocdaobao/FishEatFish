package fisheater;

import java.net.URL;

import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class GameMusic {
    private boolean playing; 
    private String file = "fisheater/resources/sounds/gameMusic.wav";
    private Clip sound;
    
    public GameMusic() {
        playing = false;
        try {
            URL url = getClass().getClassLoader().getResource(file);
			sound = AudioSystem.getClip();
			sound.open(AudioSystem.getAudioInputStream(url));
		}
		catch (UnsupportedAudioFileException e1) {System.out.println(e1); }
		catch (IOException e2) {System.out.println(e2); }
		catch (LineUnavailableException e3) {System.out.println(e3); }
    }
    
    //Bắt đầu phát nhạc
    public void playSound() {
        sound.start();
        sound.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    //Kiểm tra đã phát nhạc chưa
    public boolean isPlaying() {
        return playing;
    }
    
    public void setPlaying() {
        if(sound.isActive()) {
            playing = true;
        }
        else {
            playing = false;
        }
    }
}
