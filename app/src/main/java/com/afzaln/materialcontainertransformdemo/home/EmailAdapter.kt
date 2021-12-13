package com.afzaln.materialcontainertransformdemo.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.core.view.isVisible
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.afzaln.materialcontainertransformdemo.data.Email
import com.afzaln.materialcontainertransformdemo.data.EmailDiffCallback
import com.afzaln.materialcontainertransformdemo.databinding.ItemRowBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder

class EmailAdapter : ListAdapter<Email, EmailViewHolder>(EmailDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        return EmailViewHolder(
            ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class EmailViewHolder(
    @NonNull val binding: ItemRowBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(email: Email) {
        binding.run {
            senderTextView.text = email.senderPreview
            subjectTextView.text = email.subject
            bodyPreviewTextView.isVisible = email.hasBody
            bodyPreviewTextView.text = email.body
            Glide.with(senderProfileImageView.context)
                .load(email.sender.avatar)
                .circleCrop()
                .into(senderProfileImageView)
        }
    }
}
