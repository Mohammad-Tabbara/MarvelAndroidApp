package com.marvel.characters.framework.persistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.marvel.characters.Constants
import com.marvel.characters.domain.ILocalDatabase
import com.marvel.characters.framework.persistance.dao.FavoriteCharactersDao
import com.marvel.characters.framework.persistance.models.FavoriteCharacter



@Database(entities = [FavoriteCharacter::class],version = 1, exportSchema = false)
abstract class LocalDatabase : RoomDatabase(), ILocalDatabase{
    abstract override fun getFavoriteCharactersDao() : FavoriteCharactersDao

    companion object{
        fun newInstance(context: Context) = Room.databaseBuilder(context,LocalDatabase::class.java,Constants.LOCAL_DB)
            .addMigrations()
            .build()
    }
}