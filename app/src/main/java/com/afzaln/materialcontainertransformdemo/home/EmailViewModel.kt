package com.afzaln.materialcontainertransformdemo.home

import androidx.lifecycle.ViewModel
import com.afzaln.materialcontainertransformdemo.data.EmailStore
import com.afzaln.materialcontainertransformdemo.data.Mailbox

class EmailViewModel: ViewModel() {

    val emails = EmailStore.getEmails(Mailbox.INBOX)
}