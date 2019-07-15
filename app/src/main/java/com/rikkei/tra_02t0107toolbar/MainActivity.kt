package com.rikkei.tra_02t0107toolbar

import android.graphics.drawable.Icon
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v7.widget.*
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.rikkei.tra_02t0107toolbar.adapter.PeopleAdapter
import com.rikkei.tra_02t0107toolbar.model.People
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.abs


@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity(), PeopleAdapter.PeopleOnclickListener {


    private var collapsingToolbar: CollapsingToolbarLayout? = null
    private var appBarLayout: AppBarLayout? = null
    private var collapsedMenu: Menu? = null
    private var appBarExpanded = false

    private var peopleAdapter: PeopleAdapter? = null
    private var peopleList = mutableListOf<People>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.anim_toolbar)

        setSupportActionBar(toolbar)
        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        appBarLayout = findViewById(R.id.appbar)
        collapsingToolbar = findViewById(R.id.collapsing_toolbar)
        collapsingToolbar?.apply { setTitle(R.string.android_desserts) }


        appBarLayout?.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->

            if (abs(verticalOffset) > 200) {
                appBarExpanded = false
                invalidateOptionsMenu()
            } else {
                appBarExpanded = true
                invalidateOptionsMenu()
            }
        })

        init()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        collapsedMenu = menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            R.id.action_settings -> return true
        }
        if (item?.title == "Add") {
            Toast.makeText(this, "clicked add", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)


    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        if (collapsedMenu != null
            && (!appBarExpanded || collapsedMenu?.size() != 1)) {
            //collapsed
            collapsedMenu?.add("Add")
                ?.setIcon(R.drawable.ic_action_add)
                ?.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        } else {
            //expanded
        }
        return super.onPrepareOptionsMenu(menu)

    }


    private fun init() {
        peopleAdapter = PeopleAdapter()
        peopleList.add(People("b14dccn155", "Vu Quoc Trong", 23))
        peopleList.add(People("b14dccn329", "Hoang anh", 20))
        peopleList.add(People("b14dccn030", "Hữu Thăng", 17))
        peopleList.add(People("b14dccn166", "Vu Dinh Nguyen", 26))
        peopleList.add(People("b14dccn195", "Vu Dinh Vu", 30))
        peopleList.add(People("b14dccn134", "Vu Quoc Trong", 23))
        peopleList.add(People("b14dccn155", "Vu Quoc Trong", 23))
        peopleList.add(People("b14dccn329", "Hoang anh", 20))
        peopleList.add(People("b14dccn030", "Hữu Thăng", 17))
        peopleList.add(People("b14dccn166", "Vu Dinh Nguyen", 26))
        peopleList.add(People("b14dccn195", "Vu Dinh Vu", 30))
        peopleList.add(People("b14dccn134", "Vu Quoc Trong", 23))
        peopleList.add(People("b14dccn155", "Vu Quoc Trong", 23))
        peopleList.add(People("b14dccn329", "Hoang anh", 20))
        peopleList.add(People("b14dccn030", "Hữu Thăng", 17))
        peopleList.add(People("b14dccn166", "Vu Dinh Nguyen", 26))
        peopleList.add(People("b14dccn195", "Vu Dinh Vu", 30))
        peopleList.add(People("b14dccn134", "Vu Quoc Trong", 23))

        peopleList.add(People("b14dccn155", "Vu Quoc Trong", 23))
        peopleList.add(People("b14dccn329", "Hoang anh", 20))
        peopleList.add(People("b14dccn030", "Hữu Thăng", 17))
        peopleList.add(People("b14dccn166", "Vu Dinh Nguyen", 26))
        peopleList.add(People("b14dccn195", "Vu Dinh Vu", 30))
        peopleList.add(People("b14dccn134", "Vu Quoc Trong", 23))
        peopleList.add(People("b14dccn155", "Vu Quoc Trong", 23))
        peopleList.add(People("b14dccn329", "Hoang anh", 20))
        peopleList.add(People("b14dccn030", "Hữu Thăng", 17))
        peopleList.add(People("b14dccn166", "Vu Dinh Nguyen", 26))
        peopleList.add(People("b14dccn195", "Vu Dinh Vu", 30))
        peopleList.add(People("b14dccn134", "Vu Quoc Trong", 23))
        peopleList.add(People("b14dccn155", "Vu Quoc Trong", 23))
        peopleList.add(People("b14dccn329", "Hoang anh", 20))
        peopleList.add(People("b14dccn030", "Hữu Thăng", 17))
        peopleList.add(People("b14dccn166", "Vu Dinh Nguyen", 26))
        peopleList.add(People("b14dccn195", "Vu Dinh Vu", 30))
        peopleList.add(People("b14dccn134", "Vu Quoc Trong", 23))



        peopleAdapter?.setListPeople(peopleList)
        peopleAdapter?.setPeopleOnclickListener(this)
        val mLayoutManager = LinearLayoutManager(applicationContext)
        val mGridLayoutManager = GridLayoutManager(this, 2)
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)
        scrollableview?.apply {
            layoutManager = mLayoutManager
            itemAnimator = DefaultItemAnimator()
            adapter = peopleAdapter
        }

    }

    override fun onClickItem(position: Int) {
        Toast.makeText(this, "Tên Là: " + peopleList[position].name, Toast.LENGTH_SHORT).show()
    }
}

