import { useState } from 'react';
import { searchPosts } from '../api';

export default function Search() {
  const [query, setQuery] = useState('');
  const [results, setResults] = useState([]);
  const [isLoading, setIsLoading] = useState(false);

  const handleSearch = async () => {
    if (!query.trim()) return;
    setIsLoading(true);
    try {
      const response = await searchPosts(query);
      setResults(response.data);
    } catch (err) {
      alert('Search failed.');
      console.error(err);
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <div className="max-w-3xl mx-auto mt-10 p-6 text-white">
      <div className="flex gap-4 mb-6">
        <input
          type="text"
          value={query}
          onChange={(e) => setQuery(e.target.value)}
          onKeyDown={(e) => e.key === 'Enter' && handleSearch()}
          placeholder="Search job title, technology..."
          className="flex-1 p-3 rounded bg-zinc-800 border border-zinc-700"
        />
        <button
          onClick={handleSearch}
          className="bg-blue-600 px-4 py-2 rounded hover:bg-blue-700"
        >
          Search
        </button>
      </div>

      {isLoading ? (
        <p className="text-center">Searching...</p>
      ) : results.length > 0 ? (
        <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
          {results.map((post, index) => (
            <div key={index} className="bg-zinc-800 p-5 rounded-lg shadow">
              <h2 className="text-xl font-bold">{post.profile}</h2>
              <p className="text-sm text-gray-400 mb-2">{post.description}</p>
              <p><strong>Experience:</strong> {post.experience} years</p>
              <p><strong>Technologies:</strong> {post.technologies.join(', ')}</p>
            </div>
          ))}
        </div>
      ) : (
        query && <p className="text-center text-gray-500">No results found.</p>
      )}
    </div>
  );
}
