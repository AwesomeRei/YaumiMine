package id.its.yaumiapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Zachary on 4/10/2016.
 */
public class ProfileTargetAdapter extends BaseAdapter {
    private Context context;
    private final String[] mobileValues;
    private final String[] targetPercent;

    public ProfileTargetAdapter(Context context, String[] mobileValues, String[] targetPercent) {
        this.context = context;
        this.mobileValues = mobileValues;
        this.targetPercent = targetPercent;
    }

    @Override
    public int getCount() {
        return mobileValues.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null){
            gridView = new View(context);
            gridView = inflater.inflate(R.layout.grid_detail,null);

            TextView textView = (TextView) gridView.findViewById(R.id.targetDescription);
            textView.setText(mobileValues[position]);

            TextView textView2 = (TextView) gridView.findViewById(R.id.targetPercentage);
            textView2.setText(targetPercent[position]);

        }else {
            gridView = (View) convertView;
        }
        return gridView;
    }
}
