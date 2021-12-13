package com.afzaln.materialcontainertransformdemo.compose

import androidx.lifecycle.ViewModel
import com.afzaln.materialcontainertransformdemo.data.AccountStore

class ComposeViewModel : ViewModel() {

    val currentAccount = AccountStore.userAccounts

    init {
        AccountStore.setCurrentUserAccount(AccountStore.getDefaultUserAccount().id)
    }
}