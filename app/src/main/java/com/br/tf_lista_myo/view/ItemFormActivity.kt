package com.br.tf_lista_myo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.br.tf_lista_myo.R
import com.br.tf_lista_myo.databinding.ActivityItemFormBinding
import com.br.tf_lista_myo.view_model.ItemFormViewModel

/* Binding */
private lateinit var binding: ActivityItemFormBinding
/* ViewModel */
private lateinit var myViewModel: ItemFormViewModel

class ItemFormActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myViewModel = ViewModelProvider(this).get(ItemFormViewModel::class.java)

        setListeners()
        observe()
    }

    /* Ao clicar em salvar item */
    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.buttonSave) {

            val item = binding.editItem.text.toString()
            val bought = binding.radioButtonBought.isChecked

            myViewModel.save(item, bought)
        }
    }

    /* Ao clicar */
    private fun setListeners() {
        binding.buttonSave.setOnClickListener(this)
    }

    /* Observador */
    private fun observe() {
        myViewModel.saveItem.observe(this, Observer {

            if (it) {
                Toast.makeText(applicationContext, "Sucesso!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(applicationContext, "Falha!", Toast.LENGTH_LONG).show()
            }

        })
    }

}