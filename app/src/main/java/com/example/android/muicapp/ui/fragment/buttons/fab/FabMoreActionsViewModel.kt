package com.example.android.muicapp.ui.fragment.buttons.fab


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.muicapp.models.Person
import javax.inject.Inject

class FabMoreActionsViewModel @Inject constructor() : ViewModel() {

    val personsList = MutableLiveData<List<Person>>()

    fun fetchPersons() {
        val pList = mutableListOf<Person>()
        pList.add(
            Person(
                name = "Rosemarie J. Porter",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt",
                photo = "https://static.beautyinsider.ru/2018/10/Last_warm_days-32-2.jpg"
            )
        )
        pList.add(
            Person(
                name = "Beulah C. Terry",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt",
                photo = "https://www.unicef.org/montenegro/sites/unicef.org.montenegro/files/styles/hero_desktop/public/Nadja%20mlada%20reporterka%20UNICEFova%20volonterka.jpg?itok=vcOwP46I"
            )
        )
        pList.add(
            Person(
                name = "Joseph S. Halter",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt",
                photo = "https://upload.wikimedia.org/wikipedia/commons/4/48/Outdoors-man-portrait_%28cropped%29.jpg"
            )
        )
        pList.add(
            Person(
                name = "Jack B. Hill",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt",
                photo = "https://jooinn.com/images/man-19.jpg"
            )
        )
        pList.add(
            Person(
                name = "Candance J. Halliday",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt",
                photo = "https://images.unsplash.com/photo-1544005313-94ddf0286df2?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80"
            )
        )
        pList.add(
            Person(
                name = "Mildred J. Baskin",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt",
                photo = "https://images.pexels.com/photos/1845534/pexels-photo-1845534.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"
            )
        )
        pList.add(
            Person(
                name = "Cody L. Durham",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt",
                photo = "https://urszulakozak.com/wp-content/uploads/2016/07/Urszula-Kozak-Portrait-Ottawa-113.jpg"
            )
        )
        pList.add(
            Person(
                name = "Nathan V. McCarty",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt",
                photo = "https://images.unsplash.com/photo-1500648767791-00dcc994a43e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80"
            )
        )
        pList.add(
            Person(
                name = "Louis S. Tate",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt",
                photo = "https://lh3.googleusercontent.com/proxy/p82fzhrF2QOXqWw3HHXNaB65-MVtbzyo0uH6VweHW3MGFdTg2sZDvi5VgnZEmcr8F7YZddg7cp-RVg_Tu7-GC3ws14ws0gMWetYwX7YVZSpGYAylPkSqG5VPHuWUCiY"
            )
        )
        pList.add(
            Person(
                name = "Tracy K. Taylor",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt",
                photo = "https://images.iphonephotographyschool.com/24755/portrait-photography.jpg"
            )
        )
        pList.add(
            Person(
                name = "Betty A. Ewart",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt",
                photo = "https://images.unsplash.com/photo-1579591919791-0e3737ae3808?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80"
            )
        )
        personsList.postValue(pList)
    }
}