import React, { useState } from 'react';
import '../styles/EditJobModal.css';

const EditJobModal = ({ job, onClose, onSave }) => {
  const [editedJob, setEditedJob] = useState({
    postProfile: job.postProfile,
    postDescription: job.postDescription,
    reqExperience: job.reqExperience,
    techStack: job.techStack.join(', ')
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setEditedJob(prev => ({
      ...prev,
      [name]: value
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const updatedJob = {
      ...job,
      ...editedJob,
      techStack: editedJob.techStack.split(',').map(tech => tech.trim())
    };
    onSave(updatedJob);
    onClose();
  };

  return (
    <div className="modal-overlay">
      <div className="modal-content">
        <h2>Edit Job</h2>
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label>Profile:</label>
            <input
              type="text"
              name="postProfile"
              value={editedJob.postProfile}
              onChange={handleChange}
            />
          </div>
          <div className="form-group">
            <label>Description:</label>
            <textarea
              name="postDescription"
              value={editedJob.postDescription}
              onChange={handleChange}
            />
          </div>
          <div className="form-group">
            <label>Required Experience (years):</label>
            <input
              type="number"
              name="reqExperience"
              value={editedJob.reqExperience}
              onChange={handleChange}
            />
          </div>
          <div className="form-group">
            <label>Tech Stack (comma-separated):</label>
            <input
              type="text"
              name="techStack"
              value={editedJob.techStack}
              onChange={handleChange}
            />
          </div>
          <div className="modal-buttons">
            <button type="submit">Save</button>
            <button type="button" onClick={onClose}>Cancel</button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default EditJobModal;