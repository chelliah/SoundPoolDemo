package aron.soundpooldemo;

/**
 * Created by aronthomas on 3/8/15.
 */
public class sound {
    private String mDescription = "";
    private int mSoundResourceId = -1;
    private int mIconResourceId = -1;
    public void setDescription(String description) { mDescription = description; }
    public String getDescription() { return mDescription; }
    public void setSoundResourceId(int id) { mSoundResourceId = id; }
    public int getSoundResourceId() { return mSoundResourceId; }
    public void setIconResourceId(int id) { mIconResourceId = id; }
    public int getIconResourceId() { return mIconResourceId; }
}
