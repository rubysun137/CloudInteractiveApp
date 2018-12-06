package com.ruby.cloudinteractiveapp.data;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.util.LruCache;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.net.ssl.HttpsURLConnection;

public class ImageManager {

    private static ImageManager mInstance;
    private LruCache<String, Bitmap> mLruCache;

    private ImageManager() {

        int maxMemory = (int) Runtime.getRuntime().maxMemory() / 1024;
        int cacheSize = maxMemory / 2;
        mLruCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getByteCount() / 1024;
            }
        };

    }

    public static ImageManager getInstance() {
        if (mInstance == null) {
            synchronized (ImageManager.class) {
                if (mInstance == null) {
                    mInstance = new ImageManager();
                }
            }
        }
        return mInstance;
    }

    public void set(ImageView imageView, String imageUrl) {
        Bitmap bitmap = mLruCache.get(imageUrl);

        if (bitmap == null) {
            AsyncTask asyncTask = new DownloadImageTask().executeOnExecutor(Executors.newCachedThreadPool(),imageUrl);
            ((DownloadImageTask) asyncTask).setImageView(imageView);
        } else {
            imageView.setImageBitmap(bitmap);
        }
    }

    private class DownloadImageTask extends AsyncTask<String, Integer, Bitmap> {

        private String mImageUrl;
        private ImageView mImageView;

        public void setImageView(ImageView imageView) {
            mImageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            mImageUrl = strings[0];
            Bitmap bitmap = getBitmapFromURL(mImageUrl);
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            Log.d("HI!!!!!!!!", "onPostExecute: " +bitmap);

            if (mImageUrl != null && bitmap != null) {
                mLruCache.put(mImageUrl,bitmap);
                if(mImageView.getTag() == mImageUrl) {
                    mImageView.setImageBitmap(bitmap);
                }
            }


        }
    }

    private Bitmap getBitmapFromURL(String urlStr) {
        Bitmap bitmap = null;
        try {
//            BitmapFactory.Options options = new BitmapFactory.Options();
//            options.inPreferredConfig = Bitmap.Config.RGB_565;
//            options.inSampleSize = 50;
//            InputStream is = (InputStream) new URL(url).getContent();
//            bitmap = BitmapFactory.decodeStream(is, null, options);
            URL url = new URL(urlStr);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            bitmap = BitmapFactory.decodeStream(input);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bitmap;
    }


}
