package com.example.mvcloginappttc.model;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.mvcloginappttc.model.database.UserDao;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDataBase extends RoomDatabase {
    private static UserDataBase instance;
    private static final String db_name = "user.db";

    public abstract UserDao getUserDao();

    public static UserDataBase getDb(final Context context) {
        if (instance == null) {
            synchronized (UserDataBase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            UserDataBase.class, db_name)
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .setJournalMode(RoomDatabase.JournalMode.TRUNCATE)
                            .addCallback(new RoomDatabase.Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    new UserAsync(instance).execute();
                                }
                            }).build();
                }
            }
        }
        return instance;
    }

    private static class UserAsync extends AsyncTask<Void, Void, Void> {
        private final UserDao userDao;

        public UserAsync(UserDataBase instance) {
            userDao = instance.getUserDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            User user = new User("inoha19981@gmail.com", "inoha1998", "inoha");
            User user1 = new User("inoha19982@gmail.com", "inoha1998", "inoha2");
            User user2 = new User("inoha19983@gmail.com", "inoha1998", "inoha3");
            User user3 = new User("inoha19984@gmail.com", "inoha1998", "inoha4");
            User user4 = new User("inoha19985@gmail.com", "inoha1998", "inoha5");
            User user5 = new User("inoha19986@gmail.com", "inoha1998", "inoha6");

            userDao.insert(user,user1,user2,user3,user4,user5);
            return null;
        }
    }
}
