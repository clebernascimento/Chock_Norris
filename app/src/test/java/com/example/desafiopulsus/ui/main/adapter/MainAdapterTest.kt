package com.example.desafiopulsus.ui.main.adapter

import com.example.desafiopulsus.data.model.Joke
import junit.framework.TestCase

import org.junit.After
import org.junit.Assert
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class MainAdapterTest : TestCase() {

    private  lateinit var adapter : MainAdapter

    @Before
    public override fun setUp() {
    }

    @After
    public override fun tearDown() {
    }

    @Test
    fun testAdapter(){
        val list = ArrayList<Joke>()
        adapter = MainAdapter(list)
        Assert.assertEquals(0, adapter.itemCount)
    }
}