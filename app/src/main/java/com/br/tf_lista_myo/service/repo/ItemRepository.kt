package com.br.tf_lista_myo.service.repo

import android.content.ContentValues
import android.content.Context
import com.br.tf_lista_myo.service.constants.DBConstants
import com.br.tf_lista_myo.service.model.ItemModel

class ItemRepository private constructor(context: Context){

    /**
     * Singleton → método estático responsável por dar apenas
     * uma instância da classe ItemRepository
     **/

    private var myItemDBHelper: ItemDBHelper = ItemDBHelper(context)

    companion object {

        private lateinit var repositorio: ItemRepository

        fun getInstance(context: Context) : ItemRepository {

            if (!::repositorio.isInitialized ) {
                repositorio = ItemRepository(context)
            }
            return repositorio
        }
    }

    fun save(item: ItemModel): Boolean {
        return try {
            /* Conecta com a DB */
            val db = myItemDBHelper.writableDatabase

            /* Método para inserir valores */
            val value = ContentValues()
            value.put(DBConstants.ITEM.COLUMNS.ITEM, item.item)
            value.put(DBConstants.ITEM.COLUMNS.BOUGHT, item.bought)

            db.insert(DBConstants.ITEM.TABLE_NAME, null, value)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun getAll(): List<ItemModel> {

        val list : MutableList<ItemModel> = ArrayList()
        return list

    }

    fun getToBuy(): List<ItemModel> {

        val list : MutableList<ItemModel> = ArrayList()
        return list

    }

    fun getBought(): List<ItemModel> {

        val list : MutableList<ItemModel> = ArrayList()
        return list

    }

    fun update(item: ItemModel) {

    }

    fun delete(item: ItemModel) {

    }
}