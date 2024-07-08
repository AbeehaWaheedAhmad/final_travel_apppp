package com.example.final_travel_apppp;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "travelApp.db";

    // Booking table
    private static final String TABLE_BOOKINGS = "bookings";
    private static final String KEY_BOOKING_ID = "booking_id";
    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_FLIGHT_NAME = "flight_name";
    private static final String KEY_FLIGHT_DETAILS = "flight_details";
    private static final String KEY_FLIGHT_PRICE = "flight_price";

    // Favorite places table
    private static final String TABLE_FAVORITE_PLACES = "favorite_places";
    private static final String KEY_PLACE_ID = "place_id";
    private static final String KEY_PLACE_NAME = "place_name";
    private static final String KEY_PLACE_DESCRIPTION = "place_description";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_BOOKINGS_TABLE = "CREATE TABLE " + TABLE_BOOKINGS + "("
                + KEY_BOOKING_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_USER_ID + " TEXT,"
                + KEY_FLIGHT_NAME + " TEXT,"
                + KEY_FLIGHT_DETAILS + " TEXT,"
                + KEY_FLIGHT_PRICE + " TEXT" + ")";
        db.execSQL(CREATE_BOOKINGS_TABLE);

        String CREATE_FAVORITE_PLACES_TABLE = "CREATE TABLE " + TABLE_FAVORITE_PLACES + "("
                + KEY_PLACE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_PLACE_NAME + " TEXT,"
                + KEY_PLACE_DESCRIPTION + " TEXT" + ")";
        db.execSQL(CREATE_FAVORITE_PLACES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOKINGS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FAVORITE_PLACES);
        onCreate(db);
    }

    // Adding new booking
    public void addBooking(Booking booking) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_USER_ID, booking.getUserId());
        values.put(KEY_FLIGHT_NAME, booking.getFlightName());
        values.put(KEY_FLIGHT_DETAILS, booking.getFlightDetails());
        values.put(KEY_FLIGHT_PRICE, booking.getFlightPrice());
        db.insert(TABLE_BOOKINGS, null, values);
        db.close();
    }

    // Overloaded method for adding a new booking
    public void addBooking(String userId, String flightName, String flightDetails, String flightPrice) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_USER_ID, userId);
        values.put(KEY_FLIGHT_NAME, flightName);
        values.put(KEY_FLIGHT_DETAILS, flightDetails);
        values.put(KEY_FLIGHT_PRICE, flightPrice);
        db.insert(TABLE_BOOKINGS, null, values);
        db.close();
    }

    // Getting all bookings
    @SuppressLint("Range")
    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_BOOKINGS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Booking booking = new Booking();
                booking.setBookingId(cursor.getInt(cursor.getColumnIndex(KEY_BOOKING_ID)));
                booking.setUserId(cursor.getString(cursor.getColumnIndex(KEY_USER_ID)));
                booking.setFlightName(cursor.getString(cursor.getColumnIndex(KEY_FLIGHT_NAME)));
                booking.setFlightDetails(cursor.getString(cursor.getColumnIndex(KEY_FLIGHT_DETAILS)));
                booking.setFlightPrice(cursor.getString(cursor.getColumnIndex(KEY_FLIGHT_PRICE)));
                bookings.add(booking);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return bookings;
    }

    // Adding a favorite place
    public void addFavoritePlace(String placeName, String placeDescription) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PLACE_NAME, placeName);
        values.put(KEY_PLACE_DESCRIPTION, placeDescription);
        db.insert(TABLE_FAVORITE_PLACES, null, values);
        db.close();
    }

    // Getting all favorite places
    @SuppressLint("Range")
    public List<Place> getAllFavoritePlaces() {
        List<Place> places = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_FAVORITE_PLACES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Place place = new Place();
                place.setPlaceId(cursor.getInt(cursor.getColumnIndex(KEY_PLACE_ID)));
                place.setPlaceName(cursor.getString(cursor.getColumnIndex(KEY_PLACE_NAME)));
                place.setPlaceDescription(cursor.getString(cursor.getColumnIndex(KEY_PLACE_DESCRIPTION)));
                places.add(place);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return places;
    }
}
