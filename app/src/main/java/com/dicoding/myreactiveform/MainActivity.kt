package com.dicoding.myreactiveform

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.dicoding.myreactiveform.databinding.ActivityMainBinding
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observable
import io.reactivex.functions.Function3
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.edPlace.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                lifecycleScope.launch {
                    viewModel.queryChannel.send(s.toString())
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

        viewModel.searchResult.observe(this, Observer {
            val placesName = arrayListOf<String?>()
            it.map { placeStream ->
                placesName.add(placeStream.placeName)
            }
            val adapter = ArrayAdapter(this@MainActivity, android.R.layout.select_dialog_item, placesName)
            adapter.notifyDataSetChanged()
            binding.edPlace.setAdapter(adapter)

        })
    }
}
