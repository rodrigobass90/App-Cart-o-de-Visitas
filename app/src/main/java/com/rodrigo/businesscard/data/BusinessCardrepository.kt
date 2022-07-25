package com.rodrigo.businesscard.data

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BusinessCardrepository(private val dao: BusinessCardDao) [

fun insert(businessCard: BusinessCard) =runBlocking(this: CoroutineScope
    launch(Dispatchers.IO {this:CoroutineScope
        dao.insert(businessCard)

    }
}

fun getAll() =dao.getAll()

}