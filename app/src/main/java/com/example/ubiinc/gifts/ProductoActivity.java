package com.example.ubiinc.gifts;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;

import com.example.ubiinc.gifts.list.Item;
import com.example.ubiinc.gifts.list.ItemAdapter;
import com.example.ubiinc.gifts.response.Product;
import com.example.ubiinc.gifts.retrofill.RestClient;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ProductoActivity extends Activity {

    private String TAG = ProductoActivity.class.getSimpleName();
    private ListView listView;

    final List items = new ArrayList();
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);

        this.setContentView(R.layout.main);

        this.listView = (ListView) findViewById(R.id.listView);

        setProgressBarIndeterminateVisibility(true);
        progressDialog = ProgressDialog.show(ProductoActivity.this, "Products", "Loading!");

        RestClient.get().productList(new Callback<ArrayList<Product>>() {

            @Override
            public void success(ArrayList<Product> products, Response response) {
                for (int i = 0; i < products.size(); i++) {
                    addList(products.get(i).getPhoto(), products.get(i).getName(), products.get(i).getDetail());
                }
                loadListView();
            }

            @Override
            public void failure(RetrofitError error) {
                //Log.e(TAG, "error");
                loadListView();
            }
        });

        // Register a callback to be invoked when an item in this AdapterView
        // has been clicked
        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view,
                                    int position, long arg) {

                // Sets the visibility of the indeterminate progress bar in the
                // title
                setProgressBarIndeterminateVisibility(true);
                // Show progress dialog
                progressDialog = ProgressDialog.show(ProductoActivity.this,
                        "ProgressDialog", "Loading!");

                // Tells JavaScript to open windows automatically.
                webView.getSettings().setJavaScriptEnabled(true);
                // Sets our custom WebViewClient.
                webView.setWebViewClient(new myWebClient());
                // Loads the given URL
                Item item = (Item) listView.getAdapter().getItem(position);
                webView.loadUrl(item.getUrl());
            }
        });*/

    }

    private void loadListView() {
        this.listView.setAdapter(new ItemAdapter(this, items, progressDialog));
        setProgressBarIndeterminateVisibility(false);
    }

    private void addList(String url_image, String name, String detail){
        items.add(new Item(url_image, name, detail));
    }
}
