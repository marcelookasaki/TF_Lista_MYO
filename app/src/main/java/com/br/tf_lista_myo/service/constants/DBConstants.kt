package com.br.tf_lista_myo.service.constants

/**
 * Todas as constantes utilizadas no banco de dados, Tabelas, Colunas
 **/

class DBConstants private constructor() {

    /**
     * Tabelas disponíveis no banco de dados com suas colunas
     **/

    object ITEM {
        const val TABLE_NAME = "Item"

        object COLUMNS {
            const val ID = "id"
            const val ITEM = "item"
            const val BOUGHT = "bought"
        }
    }
}