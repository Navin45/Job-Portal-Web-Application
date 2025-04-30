const JobCard = ({ job }) => (
  <div className="bg-zinc-800 p-6 rounded-2xl shadow-md hover:shadow-lg transition">
    <h2 className="text-xl font-semibold text-white">{job.profile}</h2>
    <p className="text-sm text-gray-400 mb-2">{job.desc || "No description provided."}</p>
    <div className="text-gray-300 text-sm">
      <span className="font-medium">Skills:</span>{" "}
      {Array.isArray(job.techStack) ? job.techStack.join(", ") : job.techStack || "Not specified"}
    </div>
  </div>
);

export default JobCard;
