/***
 * Excerpted from "Hello, Android!",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/eband for more book information.
***/
package org.example.events;

import static android.provider.BaseColumns._ID;
import static org.example.events.Constants.TABLE_NAME;
import static org.example.events.Constants.NAME;
import static org.example.events.Constants.PRICE;
import static org.example.events.Constants.URL;

import android.app.ListActivity;
// ...

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.widget.SimpleCursorAdapter;
// ...



public class Events extends ListActivity {
   // ...
   
   private static String[] FROM = { _ID, NAME, PRICE,URL };
   private static String ORDER_BY = NAME + " DESC";
   
   private static int[] TO = { R.id.rowid, R.id.name, R.id.price ,R.id.url };
   
   private EventsData events;

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);
      events = new EventsData(this);
      try {
    	  //add items
         addEvent("T-SHIRT","$5.00","www.me.com");
         addEvent("PANTS","$10.00","www.you.com");
         addEvent("DRESS","$15.00","www.him.com");
         Cursor cursor = getEvents();
         showEvents(cursor);
      } finally {
         events.close();
      }
   }

   private void addEvent(String name, String price, String url) {
      // Insert a new record into the Events data source.
      // You would do something similar for delete and update.
      SQLiteDatabase db = events.getWritableDatabase();
      ContentValues values = new ContentValues();
      //add values to database
      values.put(NAME, name);
      values.put(PRICE, price);
      values.put(URL, url);
      db.insertOrThrow(TABLE_NAME, null, values);
   }

   private Cursor getEvents() {
      // Perform a managed query. The Activity will handle closing
      // and re-querying the cursor when needed.
      SQLiteDatabase db = events.getReadableDatabase();
     //query
      Cursor cursor = db.query(TABLE_NAME, FROM, null, null,null,
            null, ORDER_BY);
      startManagingCursor(cursor);
      return cursor;
   }

   
   private void showEvents(Cursor cursor) {
      // Set up data binding
      SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
            R.layout.item, cursor, FROM, TO);
      setListAdapter(adapter);
   }
   
   
}
