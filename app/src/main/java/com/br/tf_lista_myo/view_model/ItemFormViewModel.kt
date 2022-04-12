package com.br.tf_lista_myo.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.tf_lista_myo.service.model.ItemModel
import com.br.tf_lista_myo.service.repo.ItemRepository

class ItemFormViewModel : ViewModel() {

    private val myItemRepository : ItemRepository = ItemRepository()

    /* Live data dos itens */
    private var mySaveItem = MutableLiveData<Boolean>()
    val saveItem: LiveData<Boolean> = mySaveItem

    fun save(item: String, bought: Boolean) {
        val item = ItemModel(item, bought)
        myItemRepository.save(item)

    }
}