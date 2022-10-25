package com.example.shoestores.model

import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.shoestores.BR


import kotlinx.parcelize.Parcelize

@Parcelize
class Shoe : Parcelable, BaseObservable() {


    @get:Bindable
    var name: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

    @get:Bindable
    var company: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.company)
        }

    @get:Bindable
    var description: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.description)
        }

    @get:Bindable
    var size: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.description)
        }


    @get:Bindable
    var images: List<String> = mutableListOf()
        set(value) {
            field = value
            notifyPropertyChanged(BR.images)
        }

}
