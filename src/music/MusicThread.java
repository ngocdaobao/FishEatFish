package music;

import java.util.ArrayList;

import javax.sound.sampled.Clip;

public class MusicThread {
	private String file;
	private double volume;
	private ArrayList<Music> arr = new ArrayList<Music>();
	public MusicThread(String path, double v) {
		file = path;
		volume = v;
		arr.add(new Music(file, volume));
	}
	public void play() {
		boolean notPlay = true;
    	for(int i=0; i<arr.size() && notPlay; i++) {
    		if (!arr.get(i).isPlaying()) {
    			arr.get(i).play();
    			notPlay = false;
    		}
    	}
    	if (notPlay) {
			arr.add(new Music(file, volume));
			arr.get(arr.size()-1).play();
		}
    }
}
