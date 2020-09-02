package com.akashk.todoapp.di

import android.content.Context
import androidx.room.Room
import com.akashk.todoapp.database.TaskDao
import com.akashk.todoapp.database.TasksDatabase
import com.akashk.todoapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Provides
    fun providesDatabaseName(): String {
        return Constants.DATABASE_NAME
    }

    @Provides
    fun providesDatabase(
        @ApplicationContext context: Context,
        databaseName: String
    ): TasksDatabase {

        val database = Room.databaseBuilder(
            context,
            TasksDatabase::class.java,
            databaseName
        ).fallbackToDestructiveMigration()
            .build()

        return database
    }

    @Provides
    fun providesTasksDao(database: TasksDatabase): TaskDao {
        return database.getTaskDao()
    }
}