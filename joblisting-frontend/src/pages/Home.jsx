import { useEffect, useState } from 'react';
import { getAllPosts } from '../api';

export default function Home() {
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    getAllPosts()
      .then((res) => setPosts(res.data))
      .catch((err) => console.error("Error fetching posts:", err));
  }, []);

  return (
    <div className="min-h-screen bg-zinc-900 text-white p-6">
      <h1 className="text-3xl font-bold mb-8 text-center">All Job Listings</h1>
      <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
        {posts.map((post, index) => (
          <div
            key={index}
            className="bg-zinc-800 p-5 rounded-xl shadow-md hover:shadow-lg transition"
          >
            <h2 className="text-xl font-bold">{post.profile}</h2>
            <p className="text-sm text-gray-400 mb-2">{post.description || "No description provided."}</p>
            <p className="mb-1"><strong>Experience:</strong> {post.experience || 0} years</p>
            <p>
              <strong>Technologies:</strong>{" "}
              {Array.isArray(post.technologies) ? post.technologies.join(", ") : "Not specified"}
            </p>
          </div>
        ))}
      </div>
    </div>
  );
}
