package edu.brandeis.androidcg;

import android.content.Context;
import android.media.MediaPlayer;

public class Music {
	private static MediaPlayer player;

	/** Stop old song and start playing new one */
	public static void create(Context context, int resource)
	{
		//stop(context);
		player = MediaPlayer.create(context, resource);
		//mp.setLooping(true);
		//mp.start();
	}
	public static void setLooping(Context context, int resource)
	{
		player.setLooping(true);
	}
	public static void stop(Context context)
	{
		if(player != null)
		{
			player.stop();
			player.release();
			player = null;
		}
	}
	public static void pause(Context context)
	{
		player.pause();
	}
	public static void start(Context context)
	{
		player.start();
	}

}
