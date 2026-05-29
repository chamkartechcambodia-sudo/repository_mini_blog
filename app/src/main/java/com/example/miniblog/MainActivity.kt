package com.example.miniblog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * The single screen of MiniBlog.
 *
 * Starter (00): just shows the layout — an (empty) list and a Refresh button.
 *
 * TODO (Step 1 — branch 01-no-repository):
 *   • create the PostViewModel (via `by viewModels()`),
 *   • set up the RecyclerView with PostAdapter,
 *   • observe viewModel.posts and hand them to the adapter,
 *   • call viewModel.refresh() when the Refresh button is tapped.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // TODO (Step 1): wire up ViewModel + RecyclerView + Refresh button here.
    }
}
