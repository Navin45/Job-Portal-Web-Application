import { useState } from 'react';
import { addPost } from '../api';

export default function AddJob() {
  const [formData, setFormData] = useState({
    profile: '',
    desc: '',
    exp: '',
    techs: '',
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const payload = {
        profile: formData.profile,
        description: formData.desc,
        experience: parseInt(formData.exp),
        technologies: formData.techs.split(',').map(tech => tech.trim()),
      };
      await addPost(payload);
      alert('Job added successfully!');
    } catch (err) {
      alert('Error adding job');
      console.error(err);
    }
  };

  return (
    <div className="max-w-xl mx-auto mt-10 p-6 bg-zinc-800 text-white rounded-lg shadow-lg">
      <h2 className="text-2xl font-bold mb-4">Add New Job</h2>
      <form onSubmit={handleSubmit} className="space-y-4">
        <input
          name="profile"
          placeholder="Job Title"
          onChange={handleChange}
          className="w-full p-2 rounded bg-zinc-700"
        />
        <textarea
          name="desc"
          placeholder="Job Description"
          onChange={handleChange}
          className="w-full p-2 rounded bg-zinc-700"
        />
        <input
          name="exp"
          placeholder="Experience (years)"
          onChange={handleChange}
          type="number"
          className="w-full p-2 rounded bg-zinc-700"
        />
        <input
          name="techs"
          placeholder="Technologies (comma-separated)"
          onChange={handleChange}
          className="w-full p-2 rounded bg-zinc-700"
        />
        <button type="submit" className="bg-blue-600 px-4 py-2 rounded hover:bg-blue-700">
          Submit
        </button>
      </form>
    </div>
  );
}
