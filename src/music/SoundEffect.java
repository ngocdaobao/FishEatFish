package music;

public class SoundEffect extends Music {

	public SoundEffect(String path, double v) {
		super(path, v);
	}

	public void play() {
		sound.start();
	}

}