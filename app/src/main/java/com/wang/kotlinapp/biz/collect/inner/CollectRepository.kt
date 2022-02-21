package com.wang.kotlinapp.biz.collect.inner

import com.wang.kotlinapp.database.Student
import com.wang.kotlinapp.dataloacl.LocalRoomRequestManager

class CollectRepository {

    fun insertStudents(
        onCollectListener: ICollectPresenter.OnCollectListener,
        vararg students: Student
    ) {
        LocalRoomRequestManager.getInstance().insertStudents(*students)
        onCollectListener.showIUD(true)
    }

    fun deleteAll(onCollectListener: ICollectPresenter.OnCollectListener) {
        LocalRoomRequestManager.getInstance().deleteAll()
        onCollectListener.showIUD(true)
    }

    fun queryStudents(onCollectResponseListener: ICollectPresenter.OnCollectResponseListener) {
        val result = LocalRoomRequestManager.getInstance().queryStudents()
        onCollectResponseListener.showResultSuccess(result)
    }

}