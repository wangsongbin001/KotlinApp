package com.wang.kotlinapp.biz.collect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.wang.common.BaseFragment
import com.wang.kotlinapp.R
import com.wang.kotlinapp.biz.collect.inner.ICollectPresenter
import com.wang.kotlinapp.biz.collect.inner.ICollectView
import com.wang.kotlinapp.database.Student
import kotlinx.android.synthetic.main.fragment_collect.*

class CollectFragment : BaseFragment<ICollectPresenter>(), ICollectView {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(activity, "收藏", Toast.LENGTH_SHORT).show()
        val root: View? = inflater.inflate(R.layout.fragment_collect, container, false)
        return root ?:   /* root null  就用后面的 */    super.onCreateView(
            inflater,
            container,
            savedInstanceState
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addData.setOnClickListener(onClickListener)
        clearData.setOnClickListener(onClickListener)
    }

    val onClickListener = View.OnClickListener {
        when (it.id) {
            R.id.addData -> {
                val names = arrayOf<String>(
                    "乔峰",
                    "段誉",
                    "虚竹",
                    "慕容复",
                    "张三",
                    "李四",
                    "王五",
                    "赵六",
                    "初七",
                    "杜子腾",
                    "王小二",
                    "李大奇"
                )
                val ages = arrayOf<Int>(
                    43,
                    24,
                    19,
                    83,
                    64,
                    21,
                    56,
                    32,
                    17,
                    32,
                    45,
                    14
                )
                for (index in names.indices) {
                    val stu = Student(names[index], ages[index])
                    presenter.insertStudents(stu)
                }
            }
            R.id.clearData -> {
                presenter.deleteAll()
            }
        }
    }

    override fun createP(): ICollectPresenter {
        return CollectPresenterImp(this)
    }

    override fun recycle() {
        presenter.unAttachView()
    }

    override fun createOK() {
        val students = presenter.queryStudents()
    }

    override fun showResultSuccess(result: List<Student>) {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val adapter = CollectAdapter()
        if (null != result) {
            adapter.allStudents = result
        }
        recyclerView.adapter = adapter
    }

    override fun showResult(action: Int, result: Boolean) {
        if (result) presenter.queryStudents()
    }
}