package music;

import javax.sound.sampled.Clip;

public class LoopMusic extends Music{
	public LoopMusic(String path, double v) {
		super(path, v);
	}

	public void play() {
		if (!isPlaying()) {
			sound.setFramePosition(0);
			sound.start();
			sound.loop(Clip.LOOP_CONTINUOUSLY);
		}
	}
	
	public void stop() {
		if (isPlaying())
			sound.stop();
	}
	
	public boolean isPlaying() {
        return sound.isActive();
    }
}
