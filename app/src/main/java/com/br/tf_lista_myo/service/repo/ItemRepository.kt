package com.br.tf_lista_myo.service.repo

import com.br.tf_lista_myo.service.model.ItemModel

class ItemRepository {

    /* Create Read Update Delete */

    fun save(item: ItemModel) {

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