import React from 'react';
import '../styles/JobsList.css';
import { useState, useEffect } from 'react';
import axios from 'axios';
import SearchBar from '../components/SearchBar';
import EditJobModal from '../components/EditJobModal';

const JobsList = () => {
  const [filteredJobs, setFilteredJobs] = useState([]);
  const [editingJob, setEditingJob] = useState(null);

  useEffect(() => {
    getAllJobs();
  }, []);

  const getAllJobs = async () => {
    const { data } = await axios.get("http://localhost:8080/jobs");
    setFilteredJobs(data);
  };

  const handleSearch = (searchTerm) => {
    const handleFiltering = async (keyword) => {
      const { data } = await axios.get(`http://localhost:8080/jobs/keyword/${keyword}`);
      setFilteredJobs(data);
    }
    
    if (!searchTerm) {
      getAllJobs();
      return;
    }

    handleFiltering(searchTerm);
  };

  const handleDelete = async (jobId) => {
    try {
      const { data } =await axios.delete(`http://localhost:8080/job/${jobId}`);
      console.log(data)
      getAllJobs();
    } catch (error) {
      if (error.response && error.response.status === 404) {
        alert('This job posting no longer exists.');
      } else {
        alert('An error occurred while deleting the job. Please try again.');
      }
      console.error('Error deleting job:', error);
      getAllJobs(); // Refresh the list to ensure UI is in sync with backend
    }
  };

  const handleEdit = (job) => {
    setEditingJob(job);
  };

  const handleSave = async (updatedJob) => {
    try {
      await axios.put(`http://localhost:8080/job`, updatedJob);
      getAllJobs();
    } catch (error) {
      console.error('Error updating job:', error);
    }
  };

  return (
    <div className="jobs-container">
      <h1 className="jobs-header">Job Openings</h1>
      <SearchBar onSearch={handleSearch} />
      <div className="jobs-list">
        {filteredJobs.map((job) => (
          <div key={job.id} className="job-card">
            <h2 className="job-profile">{job.postProfile}</h2>
            <p className="job-description">{job.postDescription}</p>
            <p className="job-experience">
              Required Experience: {job.reqExperience}+ years
            </p>
            <div className="tech-stack-container">
              <h4>Tech Stack:</h4>
              <div className="tech-stack">
                {job.techStack.map((tech, index) => (
                  <span key={index} className="tech-item">
                    {tech}
                  </span>
                ))}
              </div>
            </div>
            <div className="card-actions">
              <button className="edit-button" onClick={() => handleEdit(job)}>
                Edit
              </button>
              <button className="delete-button" onClick={() => handleDelete(job.id)}>
                Delete
              </button>
              <button className="apply-button">Apply Now</button>
            </div>
          </div>
        ))}
      </div>
      {editingJob && (
        <EditJobModal
          job={editingJob}
          onClose={() => setEditingJob(null)}
          onSave={handleSave}
        />
      )}
    </div>
  );
};

export default JobsList;