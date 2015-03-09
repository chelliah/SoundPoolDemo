package aron.soundpooldemo;

import java.util.ArrayList;
import android.app.ListActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;


public class MainActivity extends ListActivity {
    private ArrayList<sound> mSounds = null;
    private soundAdapter mAdapter = null;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
//create a simple list
        mSounds = new ArrayList<sound>();
        sound s = new sound();
        s.setDescription("Kick");
        s.setIconResourceId(R.drawable.kick);
        s.setSoundResourceId(R.raw.kick);
        mSounds.add(s);
        s = new sound();
        s.setDescription("Clap");
        s.setIconResourceId(R.drawable.clap);
        s.setSoundResourceId(R.raw.clap);
        mSounds.add(s);
        s = new sound();
        s.setDescription("Snare");
        s.setIconResourceId(R.drawable.snare);
        s.setSoundResourceId(R.raw.snare);
        mSounds.add(s);
        mAdapter = new soundAdapter(this, R.layout.list_row, mSounds);
        setListAdapter(mAdapter);
    }
    @Override
    public void onListItemClick(ListView parent, View v, int position, long id){
        sound s = mSounds.get(position);
        MediaPlayer mp = MediaPlayer.create(this, s.getSoundResourceId());
        mp.start();
    }
}
