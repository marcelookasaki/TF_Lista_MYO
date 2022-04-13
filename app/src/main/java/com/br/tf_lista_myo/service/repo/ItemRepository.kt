package com.br.tf_lista_myo.service.repo

import android.annotation.SuppressLint
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

            /* Comando de insert */
            db.insert(DBConstants.ITEM.TABLE_NAME, null, value)
            true
        } catch (e: Exception) {
            false
        }
    }

    @SuppressLint("Range")
    fun get(id: Int) : ItemModel? {

        var item: ItemModel? = null

        return try {
            /* Conecta com a DB */
            val db = myItemDBHelper.readableDatabase

            /* Método para selecionar campos para retornar */
            val columns = arrayOf(DBConstants.ITEM.COLUMNS.ITEM, DBConstants.ITEM.COLUMNS.BOUGHT)

            /* Cláusula Where */
            val selection = DBConstants.ITEM.COLUMNS.ID + " = ?"
            val args = arrayOf(id.toString())

            /* Comando de update */
            val cursor = db.query(
                DBConstants.ITEM.TABLE_NAME,
                columns,
                selection,
                args,
                null,
                null,
                null
            )

            if (cursor != null && cursor.count > 0) {
                cursor.moveToFirst()

                val itemdb = cursor.getString(cursor.getColumnIndex(DBConstants.ITEM.COLUMNS.ITEM))
                val boughtdb = (cursor.getInt(cursor.getColumnIndex(DBConstants.ITEM.COLUMNS.BOUGHT)) == 1 )

                item = ItemModel(id, itemdb, boughtdb)
            }

            /* Fecha o cursor */
            cursor?.close()

            item
        } catch (e: Exception) {
            item
        }
    }

    @SuppressLint("Range")
    fun getAll(): List<ItemModel> {

        val list : MutableList<ItemModel> = ArrayList()

        return try {
            /* Conecta com a DB */
            val db = myItemDBHelper.readableDatabase

            /* Método para selecionar campos para retornar */
            val columns = arrayOf(
                DBConstants.ITEM.COLUMNS.ID,
                DBConstants.ITEM.COLUMNS.ITEM,
                DBConstants.ITEM.COLUMNS.BOUGHT
            )

            /* Comando de update */
            val cursor = db.query(
                DBConstants.ITEM.TABLE_NAME,
                columns,
                null,
                null,
                null,
                null,
                null
            )

            if (cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()){
                    val iddb = cursor.getInt(cursor.getColumnIndex(DBConstants.ITEM.COLUMNS.ID))
                    val itemdb = cursor.getString(cursor.getColumnIndex(DBConstants.ITEM.COLUMNS.ITEM))
                    val boughtdb = (cursor.getInt(cursor.getColumnIndex(DBConstants.ITEM.COLUMNS.BOUGHT)) == 1 )

                    val item = ItemModel(iddb, itemdb, boughtdb)
                    list.add(item)
                }


            }

            /* Fecha o cursor */
            cursor?.close()

            list
        } catch (e: Exception) {
            list
        }
    }

    @SuppressLint("Range")
    fun getBought(): List<ItemModel> {

        val list : MutableList<ItemModel> = ArrayList()

        return try {
            /* Conecta com a DB */
            val db = myItemDBHelper.readableDatabase

            val cursor = db.rawQuery("SELECT id, item, bought FROM Item WHERE bought = 1", null)

            if (cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()){
                    val iddb = cursor.getInt(cursor.getColumnIndex(DBConstants.ITEM.COLUMNS.ID))
                    val itemdb = cursor.getString(cursor.getColumnIndex(DBConstants.ITEM.COLUMNS.ITEM))
                    val boughtdb = (cursor.getInt(cursor.getColumnIndex(DBConstants.ITEM.COLUMNS.BOUGHT)) == 1 )

                    val item = ItemModel(iddb, itemdb, boughtdb)
                    list.add(item)
                }
            }
            /* Fecha o cursor */
            cursor?.close()

            list
        } catch (e: Exception) {
            list
        }
    }

    @SuppressLint("Range")
    fun getToBuy(): List<ItemModel> {

        val list : MutableList<ItemModel> = ArrayList()
        return try {
            /* Conecta com a DB */
            val db = myItemDBHelper.readableDatabase

            val cursor = db.rawQuery("SELECT id, item, bought FROM Item WHERE bought = 0", null)

            if (cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()){
                    val iddb = cursor.getInt(cursor.getColumnIndex(DBConstants.ITEM.COLUMNS.ID))
                    val itemdb = cursor.getString(cursor.getColumnIndex(DBConstants.ITEM.COLUMNS.ITEM))
                    val boughtdb = (cursor.getInt(cursor.getColumnIndex(DBConstants.ITEM.COLUMNS.BOUGHT)) == 1 )

                    val item = ItemModel(iddb, itemdb, boughtdb)
                    list.add(item)
                }
            }
            /* Fecha o cursor */
            cursor?.close()

            list
        } catch (e: Exception) {
            list
        }
    }

    fun update(item: ItemModel): Boolean {
        return try {
            /* Conecta com a DB */
            val db = myItemDBHelper.writableDatabase

            /* Método para inserir valores */
            val value = ContentValues()
            value.put(DBConstants.ITEM.COLUMNS.ITEM, item.item)
            value.put(DBConstants.ITEM.COLUMNS.BOUGHT, item.bought)

            /* Cláusula Where */
            val selection = DBConstants.ITEM.COLUMNS.ID + " = ?"
            val args = arrayOf(item.id.toString())

            /* Comando de update */
            db.update(DBConstants.ITEM.TABLE_NAME, value, selection, args)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun delete(id: Int): Boolean {
        return try {
            /* Conecta com a DB */
            val db = myItemDBHelper.writableDatabase

            /* Cláusula Where */
            val selection = DBConstants.ITEM.COLUMNS.ID + " = ?"
            val args = arrayOf(id.toString())

            /* Comando de delete */
            db.delete(DBConstants.ITEM.TABLE_NAME, selection, args)
            true
        } catch (e: Exception) {
            false
        }
    }
}