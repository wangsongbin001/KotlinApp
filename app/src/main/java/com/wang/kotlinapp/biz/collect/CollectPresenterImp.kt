package com.wang.kotlinapp.biz.collect

import com.wang.kotlinapp.biz.collect.inner.CollectRepository
import com.wang.kotlinapp.biz.collect.inner.ICollectPresenter
import com.wang.kotlinapp.biz.collect.inner.ICollectView
import com.wang.kotlinapp.database.Student

class CollectPresenterImp(var collectView: ICollectView?) : ICollectPresenter(),
    ICollectPresenter.OnCollectResponseListener, ICollectPresenter.OnCollectListener {

    var collectRepository: CollectRepository = CollectRepository()

    override fun insertStudents(vararg students: Student) {
        collectRepository.insertStudents(this, *students)
    }

    override fun queryStudents() {
        collectRepository.queryStudents(this)
    }

    override fun deleteAll() {
        collectRepository.deleteAll(this)
    }

    override fun unAttachView() {
        collectView = null
    }

    override fun showResultSuccess(result: List<Student>?) {
        collectView?.showResultSuccess(result ?: arrayListOf())
    }

    override fun showIUD(iudResult: Boolean) {
        collectView?.showResult(0, iudResult)
    }


}