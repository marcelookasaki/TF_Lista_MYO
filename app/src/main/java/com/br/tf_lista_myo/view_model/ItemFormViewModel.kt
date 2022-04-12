package com.br.tf_lista_myo.view_model

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.tf_lista_myo.service.model.ItemModel
import com.br.tf_lista_myo.service.repo.ItemRepository

class ItemFormViewModel(application: Application) : AndroidViewModel(application){

    private val myContext = application.applicationContext
    private val myItemRepository : ItemRepository = ItemRepository.getInstance(myContext)


    /* Live data dos itens */
    private var mySaveItem = MutableLiveData<Boolean>()
    val saveItem: LiveData<Boolean> = mySaveItem

    fun save(item: String, bought: Boolean) {
        val item = ItemModel(item = item, bought = bought)
        myItemRepository.save(item)

    }
}