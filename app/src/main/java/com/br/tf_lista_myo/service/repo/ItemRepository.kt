package com.br.tf_lista_myo.service.repo

import android.content.Context
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
            return ItemRepository(context)

        }

    }

    fun save(item: ItemModel) {
        myItemDBHelper.writableDatabase
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