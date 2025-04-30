import { Link } from 'react-router-dom';

export default function Navbar() {
  return (
    <nav className="flex justify-between items-center px-8 py-4 bg-blue-600 text-white shadow">
      <h1 className="text-lg font-bold">Job Portal</h1>
      <div className="space-x-4">
        <Link to="/" className="hover:underline">Home</Link>
        <Link to="/add" className="hover:underline">Add Job</Link>
        <Link to="/search" className="hover:underline">Search</Link>
      </div>
    </nav>
  );
}
