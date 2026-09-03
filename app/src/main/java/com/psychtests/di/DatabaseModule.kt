package com.psychtests.di

import android.content.Context
import androidx.room.Room
import com.psychtests.data.db.AppDatabase
import com.psychtests.data.db.TestResultDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "psychtests_database"
        ).build()

    @Provides
    fun provideTestResultDao(database: AppDatabase): TestResultDao =
        database.testResultDao()
}