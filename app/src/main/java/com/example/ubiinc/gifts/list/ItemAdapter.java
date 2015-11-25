package com.example.ubiinc.gifts.list;

/**
 * Created by ubiinc on 24/11/15.
 */

import java.io.InputStream;
import java.util.List;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ubiinc.gifts.ProductoActivity;
import com.example.ubiinc.gifts.R;

public class ItemAdapter extends BaseAdapter {

    private Context context;
    private List<Item> items;
    private ProgressDialog progressDialog;

    public ItemAdapter(Context context, List<Item> items, ProgressDialog progressDialog) {
        this.context = context;
        this.items = items;
        this.progressDialog = progressDialog;
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Object getItem(int position) {
        return this.items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;

        if (convertView == null) {
            // Create a new view into the list.
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.list_item, parent, false);
        }

        // Set data into the view.
        ImageView ivItem = (ImageView) rowView.findViewById(R.id.ivItem);
        TextView tvTitle = (TextView) rowView.findViewById(R.id.tvTitle);
        TextView tvDescription = (TextView) rowView.findViewById(R.id.tvDescription);

        Item item = this.items.get(position);
        tvTitle.setText(item.getTitle());
        tvDescription.setText(item.getDescription());
        new ImageDownloader(ivItem, progressDialog).execute(item.getImage());

        return rowView;
    }

}

class ImageDownloader extends AsyncTask<String, Void, Bitmap> {
    ImageView bmImage;
    ProgressDialog progressDialog;

    public ImageDownloader(ImageView bmImage, ProgressDialog progressDialog) {
        this.bmImage = bmImage;
        this.progressDialog = progressDialog;
    }

    protected Bitmap doInBackground(String... urls) {
        String url = urls[0];
        Bitmap mIcon = null;
        try {
            InputStream in = new java.net.URL(url).openStream();
            mIcon = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
        }
        return mIcon;
    }

    protected void onPostExecute(Bitmap result) {
        bmImage.setImageBitmap(result);
        progressDialog.dismiss();
    }
}