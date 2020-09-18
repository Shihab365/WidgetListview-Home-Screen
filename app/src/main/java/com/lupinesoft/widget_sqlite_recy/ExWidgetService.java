package com.lupinesoft.widget_sqlite_recy;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import java.util.ArrayList;

public class ExWidgetService extends RemoteViewsService {

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new ExWidgetItemFactory(getApplicationContext(), intent);
    }

    class ExWidgetItemFactory implements RemoteViewsFactory{

        private Context context;
        private int appWidgetId;
        DBStorage info_storage;

        SQLiteDBHelper sqLiteDBHelper = new SQLiteDBHelper(getApplicationContext());
        ArrayList<DBStorage> arrayList = new ArrayList<>();

        ExWidgetItemFactory(Context context, Intent intent){
            this.context = context;
            this.appWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
                    AppWidgetManager.INVALID_APPWIDGET_ID);
        }

        @Override
        public void onCreate() {

        }

        @Override
        public void onDataSetChanged() {

        }

        @Override
        public void onDestroy() {

        }

        @Override
        public int getCount() {
            arrayList = sqLiteDBHelper.displayInfo();  //Trick is here
            return arrayList.size();
        }

        @Override
        public RemoteViews getViewAt(int position) {

            info_storage = arrayList.get(position);

            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.list_sample);
            remoteViews.setTextViewText(R.id.list_nameID, info_storage.getName());
            remoteViews.setTextViewText(R.id.list_cgpaID, info_storage.getCgpa());

            Log.d("tag", ""+info_storage.getName());
            Log.d("tag", ""+info_storage.getCgpa());
            return remoteViews;
        }

        @Override
        public RemoteViews getLoadingView() {
            return null;
        }

        @Override
        public int getViewTypeCount() {
            return 1;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }
    }
}
