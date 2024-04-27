package music;

public class SoundEffect extends Music {

	public SoundEffect(String path) {
		super(path);
	}

	public void play() {
		sound.start();
	}

}
