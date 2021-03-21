package com.example.homeworkfirst.data

import com.example.homeworkfirst.R
import com.example.nestedrecyclerviewdemo.model.ChildModel
import com.example.nestedrecyclerviewdemo.model.ParentModel

object MovieDataSource {
    val parentModelArrayList= arrayListOf<ParentModel>(
            ParentModel("Category1"),
            ParentModel("Category2"),
            ParentModel("Category3"),
            ParentModel("Category4"),
            ParentModel("Category5"),
            ParentModel("Category6")
    )
    fun setUpChildArrayList(arrayList:ArrayList<ChildModel>, position: Int) {

        // added the first child row
        if (parentModelArrayList[position].movieCategory == "Category1") {
            arrayList.add(ChildModel(R.drawable.themartian, "Movie Name"))
            arrayList.add(ChildModel(R.drawable.moana, "Movie Name"))
            arrayList.add(ChildModel(R.drawable.mov2, "Movie Name"))
            arrayList.add(ChildModel(R.drawable.blackp, "Movie Name"))
            arrayList.add(ChildModel(R.drawable.moviedubbedinhindi2, "Movie Name"))
            arrayList.add(ChildModel(R.drawable.hollywood1, "Movie Name"))
        }

        // added in second child row
        if (parentModelArrayList[position].movieCategory == "Category2") {
            arrayList.add(ChildModel(R.drawable.moviedubbedinhindi2, "Movie Name"))
            arrayList.add(ChildModel(R.drawable.moviedubbedinhindi3, "Movie Name"))
            arrayList.add(ChildModel(R.drawable.moviedubbedinhindi1, "Movie Name"))
            arrayList.add(ChildModel(R.drawable.moviedubbedinhindi4, "Movie Name"))
            arrayList.add(ChildModel(R.drawable.moviedubbedinhindi5, "Movie Name"))
            arrayList.add(ChildModel(R.drawable.moviedubbedinhindi6, "Movie Name"))
        }

        // added in third child row
        if (parentModelArrayList[position].movieCategory== "Category3") {
            arrayList.add(ChildModel(R.drawable.hollywood6, "Movie Name"))
            arrayList.add(ChildModel(R.drawable.hollywood5, "Movie Name"))
            arrayList.add(ChildModel(R.drawable.hollywood4, "Movie Name"))
            arrayList.add(ChildModel(R.drawable.hollywood3, "Movie Name"))
            arrayList.add(ChildModel(R.drawable.hollywood2, "Movie Name"))
            arrayList.add(ChildModel(R.drawable.hollywood1, "Movie Name"))
        }

        // added in fourth child row
        if (parentModelArrayList[position].movieCategory=="Category4") {
            arrayList.add(ChildModel(R.drawable.bestofoscar6, "Movie Name"))
            arrayList.add(ChildModel(R.drawable.bestofoscar5, "Movie Name"))
            arrayList.add(ChildModel(R.drawable.bestofoscar4, "Movie Name"))
            arrayList.add(ChildModel(R.drawable.bestofoscar3, "Movie Name"))
            arrayList.add(ChildModel(R.drawable.bestofoscar2, "Movie Name"))
            arrayList.add(ChildModel(R.drawable.bestofoscar1, "Movie Name"))
        }

        // added in fifth child row
        if (parentModelArrayList[position].movieCategory=="Category5") {
            arrayList.add(ChildModel(R.drawable.moviedubbedinhindi4, "Movie Name"))
            arrayList.add(ChildModel(R.drawable.hollywood2, "Movie Name"))
            arrayList.add(ChildModel(R.drawable.bestofoscar4, "Movie Name"))
            arrayList.add(ChildModel(R.drawable.mov2, "Movie Name"))
            arrayList.add(ChildModel(R.drawable.hollywood1, "Movie Name"))
            arrayList.add(ChildModel(R.drawable.bestofoscar1, "Movie Name"))
        }

        // added in sixth child row
        if (parentModelArrayList[position].movieCategory=="Category6") {
            arrayList.add(ChildModel(R.drawable.hollywood5, "Movie Name"))
            arrayList.add(ChildModel(R.drawable.blackp, "Movie Name"))
            arrayList.add(ChildModel(R.drawable.bestofoscar4, "Movie Name"))
            arrayList.add(ChildModel(R.drawable.moviedubbedinhindi6, "Movie Name"))
            arrayList.add(ChildModel(R.drawable.hollywood1, "Movie Name"))
            arrayList.add(ChildModel(R.drawable.bestofoscar6, "Movie Name"))
        }
    }
}