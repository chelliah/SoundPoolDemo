package aron.soundpooldemo;

/*
Code created from William Francis tutorial at http://www.techrepublic.com/blog/software-engineer/create-your-own-android-sound-board/
 */

import java.util.ArrayList;
import android.app.ListActivity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;


public class MainActivity extends ListActivity {
    private ArrayList<sound> mSounds = null;
    private soundAdapter mAdapter = null;
    private SoundPool mp;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mp = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);

//create a simple list
        mSounds = new ArrayList<sound>();
        sound s = new sound();
        s.setDescription("Kick");
        s.setIconResourceId(R.drawable.kick);
        s.setSoundResourceId(mp.load(this,R.raw.kick,1));

        mSounds.add(s);
        s = new sound();
        s.setDescription("Clap");
        s.setIconResourceId(R.drawable.clap);
        s.setSoundResourceId(mp.load(this,R.raw.clap,1));

        mSounds.add(s);
        s = new sound();
        s.setDescription("Snare");
        s.setIconResourceId(R.drawable.snare);
        s.setSoundResourceId(mp.load(this,R.raw.snare,1));


        mSounds.add(s);
        mAdapter = new soundAdapter(this, R.layout.list_row, mSounds);
        setListAdapter(mAdapter);


    }
    @Override
    public void onListItemClick(ListView parent, View v, int position, long id){
        sound s = mSounds.get(position);
        /*MediaPlayer mp = MediaPlayer.create(this, s.getSoundResourceId());

         */
        mp.play(s.getSoundResourceId(),1,1,1,0,1);
    }
}
