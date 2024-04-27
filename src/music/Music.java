package music;

import java.net.URL;

import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public abstract class Music {
	protected String file; //Địa chỉ file nhạc
	protected Clip sound;
    
    public Music(String path) {
        file = path;
        try {
            URL url = getClass().getClassLoader().getResource(file);
			sound = AudioSystem.getClip();
			sound.open(AudioSystem.getAudioInputStream(url));
		}
		catch (UnsupportedAudioFileException e1) {System.out.println(e1); }
		catch (IOException e2) {System.out.println(e2); }
		catch (LineUnavailableException e3) {System.out.println(e3); }
    }
    
    //Phát nhạc
    public abstract void play();
}
