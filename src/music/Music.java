package music;

import java.net.URL;

import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public abstract class Music {
	protected String file; //Địa chỉ file nhạc
	protected Clip sound;
	protected FloatControl gain;
	protected double volume; //minVolume=0; maxVolume=1
    
    public Music(String path, double v) {
        file = path;
        volume = v;
        try {
            URL url = getClass().getClassLoader().getResource(file);
			sound = AudioSystem.getClip();
			sound.open(AudioSystem.getAudioInputStream(url));
			gain = (FloatControl) sound.getControl(FloatControl.Type.MASTER_GAIN);
			double max = Math.pow(10.0, gain.getMaximum()/20.0);
			double min = Math.pow(10.0, gain.getMinimum()/20.0);
			float val = (float) (20.0*Math.log10(min+(max-min)*volume));
			gain.setValue(val);
			System.out.println(gain.getValue());
		}
		catch (UnsupportedAudioFileException e1) {System.out.println(e1); }
		catch (IOException e2) {System.out.println(e2); }
		catch (LineUnavailableException e3) {System.out.println(e3); }
    }
    
    //Phát nhạc
    public abstract void play();
}