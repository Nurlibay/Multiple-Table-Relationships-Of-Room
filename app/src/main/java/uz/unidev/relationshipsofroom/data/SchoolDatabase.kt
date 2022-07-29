package uz.unidev.relationshipsofroom.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.unidev.relationshipsofroom.data.entities.Director
import uz.unidev.relationshipsofroom.data.entities.School
import uz.unidev.relationshipsofroom.data.entities.Student
import uz.unidev.relationshipsofroom.data.entities.Subject
import uz.unidev.relationshipsofroom.data.entities.relations.StudentSubjectCrossRef

/**
 *  Created by Nurlibay Koshkinbaev on 29/07/2022 11:46
 */

@Database(
    entities = [
        Subject::class,
        Student::class,
        School::class,
        Director::class,
        StudentSubjectCrossRef::class
    ],
    version = 1
)
abstract class SchoolDatabase : RoomDatabase() {

    abstract fun schoolDao(): SchoolDao

    companion object {

        @Volatile
        private var INSTANCE: SchoolDatabase? = null

        fun getInstance(context: Context): SchoolDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "school_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }

    }

}