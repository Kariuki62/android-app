import android.content.Context;
import android.widget.ArrayAdapter;

public class booksArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mBooks;

public  booksArrayAdapter (Context mContext,int resource, String[] mBooks){
    super(mContext,resource);
    this.mContext = mContext;
    this.mBooks = mBooks;
}
    @Override
    public Object getItem(int position) {
        String books = mBooks[position];
        return String.format("%s \nServes great: %s", books);
    }
    @Override
    public int getCount() {
        return mBooks.length;
    }

}