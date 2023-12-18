import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import edu.miu.ijlal.foodiepal.R
import edu.miu.ijlal.foodiepal.blog.BlogAdapter
import edu.miu.ijlal.foodiepal.blog.BlogPost

class BlogFragment : Fragment() {

    private lateinit var blogRecyclerView: RecyclerView
    private lateinit var addBlogFab: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blog, container, false)

        blogRecyclerView = view.findViewById(R.id.blogRecyclerView)
        addBlogFab = view.findViewById(R.id.addBlogFab)

        setupRecyclerView()

        addBlogFab.setOnClickListener {
            // Handle FloatingActionButton click (add new blog post)
            // Implement your logic for adding a new blog post here
        }

        return view
    }

    private fun setupRecyclerView() {
        val blogPosts = getDummyBlogPosts() // Replace with your actual data source
        val adapter = BlogAdapter(blogPosts)
        blogRecyclerView.layoutManager = LinearLayoutManager(context)
        blogRecyclerView.adapter = adapter
    }

    private fun getDummyBlogPosts(): List<BlogPost> {
        // Replace with actual data retrieval logic or use hardcoded data for testing
        return listOf(
            BlogPost("Title 1", "Content of the blog post 1", "Author 1", "Date 1"),
            BlogPost("Title 2", "Content of the blog post 2", "Author 2", "Date 2"),
            BlogPost("Title 3", "Content of the blog post 3", "Author 3", "Date 3"),
            // Add more blog posts as needed
        )
    }
}
