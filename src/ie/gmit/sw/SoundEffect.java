package ie.gmit.sw;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Handles the playing and loading of sound effects in game
 * @author Eddie Eldridge
 * @version 1.0
 */
public enum SoundEffect
{
	VICTORY("./resources/sfx/victory.wav"), // victory sound
	FAILURE("./resources/sfx/failure.wav"); // failure sound

	// Nested class for specifying volume
	public static enum Volume
	{
		MUTE, LOW, MEDIUM, HIGH
	}

	public static Volume volume = Volume.LOW;

	// Each sound effect has its own clip, loaded with its own sound file.
	private Clip clip;

	/**
	 * Constructor to construct each element of the enum with its own sound file.
	 * @param soundFileName is the soundeffect you wish to play
	 * @author Eddie Eldridge
	 * @version 1.0
	 */
	SoundEffect(String soundFileName)
	{
		try
		{			    
			// Use URL (instead of File) to read from disk and JAR.
			File dir = new File(soundFileName);	
			// Set up an audio input stream piped from the sound file.
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(dir);
			// Get a clip resource.
			clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioInputStream);
		} catch (UnsupportedAudioFileException e)
		{
			System.out.println("Unsupported file: " +  e);
		} catch (IOException e)
		{
			System.out.println("IOException: " +  e);
		} catch (LineUnavailableException e)
		{
			System.out.println("LineUnavailableException: " +  e);
		}
	}

	/**
	 * Play or Re-play the sound effect from the beginning, by rewinding.
	 * @author Eddie Eldridge
	 * @version 1.0
	 */
	public void play()
	{
		if (volume != Volume.MUTE)
		{
			if (clip.isRunning())
				clip.stop(); // Stop the player if it is still running
			clip.setFramePosition(0); // rewind to the beginning
			clip.start(); // Start playing
		}
	}

	/**
	 *  Optional static method to pre-load all the sound files.
	 * @author Eddie Eldridge
	 * @version 1.0
	 */
	static void init()
	{
		values(); // calls the constructor for all the elements
	}
}
