/***
 * Excerpted from "Hello, Android!",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/eband for more book information.
***/
package org.example.events;

import android.provider.BaseColumns;

public interface Constants extends BaseColumns {
   public static final String TABLE_NAME = "items";

   // Columns in the Events database
   //name
   public static final String NAME = "name";
   //price
   public static final String PRICE = "price";
   //url
   public static final String URL = "link";
}
