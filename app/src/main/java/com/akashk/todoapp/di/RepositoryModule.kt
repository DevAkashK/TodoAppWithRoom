package com.akashk.todoapp.di

import com.akashk.todoapp.database.TaskDao
import com.akashk.todoapp.repositories.TasksRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Provides
    fun providesTaskRepository(taskDao: TaskDao): TasksRepository {
        return TasksRepository(taskDao)
    }
}