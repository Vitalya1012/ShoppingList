package com.vitaliy.shoppinglist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vitaliy.shoppinglist.data.ShopListRepositoryImpl
import com.vitaliy.shoppinglist.data.ShopListRepositoryImpl.getShopList
import com.vitaliy.shoppinglist.domain.DeleteShopItemUseCase
import com.vitaliy.shoppinglist.domain.EditShopItemUseCase
import com.vitaliy.shoppinglist.domain.GetShopListUseCase
import com.vitaliy.shoppinglist.domain.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem){
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnabledState(shopItem: ShopItem){
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }

}