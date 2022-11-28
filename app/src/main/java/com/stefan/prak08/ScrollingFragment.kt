package com.stefan.prak08

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.stefan.prak08.Api.Article
import com.stefan.prak08.databinding.ActivityScrollingBinding
import com.stefan.prak08.databinding.FragmentScrollingBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [ScrollingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ScrollingFragment : Fragment() {
    private lateinit var fragmentScrollingBinding: FragmentScrollingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
       fragmentScrollingBinding = FragmentScrollingBinding.inflate(inflater, container, false)

//        setContentView(fragmentScrollingbinding.root)

//        setSupportActionBar(findViewById(R.id.toolbar))
        return fragmentScrollingBinding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ScrollingFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(): ScrollingFragment{
            return ScrollingFragment()
        }
    }

    override fun onStart() {
    super.onStart()
    val news = activity?.intent?.getParcelableExtra<Article>("news")
    if (news != null) {
        fragmentScrollingBinding.toolbarLayout.title = news.title
        fragmentScrollingBinding.icContent.tvPublishedDate?.text = news.publishedAt
        fragmentScrollingBinding.icContent.tvAuthor?.text = news.author
        fragmentScrollingBinding.icContent.tvDescription?.text = news.description
        fragmentScrollingBinding.icContent.tvContent?.text = news.content
        fragmentScrollingBinding.icContent.tvUrl?.setOnClickListener {
            val webUrl = Uri.parse(news.url);
            //implicit intent
            val webIntent = Intent(Intent.ACTION_VIEW, webUrl);
                startActivity(webIntent)

        }
    }

}
}