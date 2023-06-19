package com.example.tastieer.di

import android.content.Context
import androidx.compose.ui.graphics.vector.RootGroupName
import androidx.room.Room
import com.example.tastieer.db.TastieerDAO
import com.example.tastieer.db.TastieerDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModuleDatabase{

    @Provides
    @Singleton
    fun provideDB(@ApplicationContext app:Context)= Room.databaseBuilder(
        app,TastieerDatabase::class.java,"TastieerDatabase").build()

    @Provides
    @Singleton
    fun provideDBAO( DB:TastieerDatabase):TastieerDAO{
        return DB.provideDAO()
    }

}