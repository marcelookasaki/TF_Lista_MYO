package com.br.tf_lista_myo.service.repo

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.br.tf_lista_myo.service.constants.DBConstants

class ItemDBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VESION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_ITEM)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }


    /* Constantes para evitar hardcode */
    companion object {

        private const val DATABASE_VESION = 1
        private const val DATABASE_NAME = "itens.db"

        private const val CREATE_TABLE_ITEM =
            ("create table" + DBConstants.ITEM.TABLE_NAME + " ("
                    + DBConstants.ITEM.COLUMNS.ID + " integer primary key autoincrement, "
                    + DBConstants.ITEM.COLUMNS.ITEM + " text, "
                    + DBConstants.ITEM.COLUMNS.BOUGHT + " integer);")
    }

}